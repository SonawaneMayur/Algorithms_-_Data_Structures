/**
 * 
 */
package com.mayur.ksat;

//import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
//import java.awt.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Mayur
 *
 */
public class KSat {

	/**
	 * @param args
	 */
	static Random rand = new Random();
	static HashSet<Integer> set = new HashSet<Integer>();
	static BitSet resultCls =new BitSet();
	
	 //------------------------- creating objects for the KSAT
	static class Variables{
		static int varCount;
		static BitSet varBits;
		BitSet nvarBits;
		 
		

		public Variables(int n){
			varCount = n;
			varBits = new BitSet(n);   // creates the variables 
			 
			
		}
		
		public int getVarCnt(){
			return varCount;
		}
		
		public void setVar(int x){
			
			this.varBits.set(x);
		}
		
		public BitSet getVarBits(){
			return this.varBits;
		}
		
		public BitSet getNegVar(){
			return this.nvarBits;
		}
		
		public BitSet createNVar(BitSet bs){
			 nvarBits = new BitSet();  // creates the another set of variables to store its negation
		     nvarBits = (BitSet) varBits.clone();
		     
		     nvarBits.flip(1, varBits.length());
			
			return nvarBits;
		}
	}
	
	class Clause{
		int[] cls;
		
		public Clause(int noLit){
			 cls = new int[noLit];
			
		}
		
		public void setCls(int position, int literal){
			cls[position] = literal;
			
		}
		
		public int[] getCls(){
			return cls;
			
		}
		
		//public 
		
		
		
	}
	 static class Predicate{
		 //Object[] predicate;
		 int[][] predicate;
		 int bitInt;
		 
		public Predicate(int clsCnt, int litCnt, String[] litarr, int noOfVar){
			
			 predicate = new int[clsCnt][litCnt];		// 2 X 2 array to store Clauses and literals
			int z=0;
			for(int i = 0; i < clsCnt; i++){
				for(int j = 0; j < litCnt; j++){
					bitInt = Integer.parseInt(litarr[z]);//rand.nextInt(2 * noOfVar - 1)+1;
					z= z+1;
					predicate[i][j] = bitInt;
				}
			}
		     
		    
		}
		
		/*
		public void addCls(int clsNo, Clause cls){
			predicate[clsNo] = cls;
			
		}
		*/
		public int[][] getPredicate(){
			
			return this.predicate;
		}
		
		public void displayPrdicate(int clsCnt, int litCnt, int[][] pred){
			System.out.println("Predicate: "); // displays the Clauses and Literals 
			 for(int i = 0; i < clsCnt; i++){
				 if(i >0)
					 System.out.print(" /\\ ");
				 
				 System.out.print(" ( ");
					for(int j = 0; j < litCnt; j++){
						 if(j >0)
							 System.out.print(" V ");
						System.out.print(pred[i][j]);
					}
					System.out.print(" ) ");
				}
		}
		
		public void KSAT(BitSet vB, int noOfVar, int clsCnt, int litCnt, int[][] pred){
			int[][] bits2 = pred;
			 BitSet temp = new BitSet();                    // 
			 for(int i = 0; i < clsCnt; i++){
				 temp.clear();
					for(int j = 0; j < litCnt; j++){
						if(bits2[i][j] > noOfVar){
							int a = bits2[i][j] % noOfVar;
							if(!vB.get(a))
								temp.set(bits2[i][j]);
						}else{
						  if(vB.get(bits2[i][j]))
							 temp.set(bits2[i][j]);
						}
					}
					
					if(temp.isEmpty()){		//if no bit in temp is true
						
						
						System.out.println( " Clause "+(i+1)+" is false");
						
						int k =0;
						while(k < litCnt && set.contains(bits2[i][k] % noOfVar )){		// set contains the integer which is already flipped
							k= k+1;
						}
						//if(k > litCnt && )
						if(k < litCnt ){
							int x=	bits2[i][k] % noOfVar;
							set.add(x);				// added to set to get to know that this bit is changed
							
							if(x == 0){ x =noOfVar;}   // to consider the value of 20 % 10 == 0
							
							vB.flip(x);
							//nvB.flip(x);
						}else{
							System.out.println(" PREDICATE FAILED - { Variables : "+( bits2[i][k-1] % noOfVar )+" & "+ bits2[i][k-1]+" already flipped }");
							break;
						}
						
						i = -1;
					}else{
						resultCls.set(i);
					}
					
					//System.out.println();
				}
		     
			 if(!resultCls.isEmpty()){
				 System.out.println("The result of Clause is:");
				 System.out.println(resultCls);
			 }
			 
			 System.out.println("Final pattern in varBits: ");
		     System.out.println(vB);
		     System.out.println("Final pattern in varBits with negation: ");
		     vB.flip(1, noOfVar +1);
		     System.out.println(vB);
		     
		     System.out.println("The number of nodes changed :" + set.size());
		     if(set.size() > 0){
		    	 System.out.println("The Nodes changed :");
		     	for(int s : set){
		     		System.out.print(" { "+ s +" } ");
		     	}
		     }
		    
			
		}
		
	}
	 
	 
	 //----------End---------------------
	
	public static void kSat(BitSet vB, String[] litarr, int noOfVariables, int clsCnt, int litCnt ){
		int bitInt;
		HashSet<Integer> set = new HashSet<Integer>();      // HashSet is created to store the flip bits
			
		int noOfVar = noOfVariables;
		/*
		if(vB.length() > nvB.length()){
				noOfVar = vB.length() - 1;
		}else {noOfVar = nvB.length() - 1;}
		*/
		BitSet resultCls =new BitSet();
		
		//BitSet bits2 = new BitSet(clsCnt * litCnt);
		//BitSet clsResult = new BitSet(litCnt);
		int[][] bits2 = new int[clsCnt][litCnt];		// 2 X 2 array to store Clauses and literals
		int z=0;
		for(int i = 0; i < clsCnt; i++){
			for(int j = 0; j < litCnt; j++){
				bitInt = Integer.parseInt(litarr[z]);//rand.nextInt(2 * noOfVar - 1)+1;
				z= z+1;
				bits2[i][j] = bitInt;
			}
		}
		
		 System.out.println("Pattern of Clause X Literals: "); // displays the Clauses and Literals 
		 for(int i = 0; i < clsCnt; i++){
			 if(i >0)
				 System.out.print(" /\\ ");
			 
			 System.out.print(" ( ");
				for(int j = 0; j < litCnt; j++){
					 if(j >0)
						 System.out.print(" V ");
					System.out.print(bits2[i][j]);
				}
				System.out.print(" ) ");
			}
		 System.out.println();
	     
		 
		 BitSet temp = new BitSet();                    // 
		 for(int i = 0; i < clsCnt; i++){
			 temp.clear();
				for(int j = 0; j < litCnt; j++){
					if(bits2[i][j] > noOfVar){
						int a = bits2[i][j] % noOfVar;
						if(!vB.get(a))
							temp.set(bits2[i][j]);
					}else{
					  if(vB.get(bits2[i][j]))
						 temp.set(bits2[i][j]);
					}
				}
				
				if(temp.isEmpty()){		//if no bit in temp is true
					
					
					System.out.println( " Clause "+(i+1)+" is false");
					
					int k =0;
					while(k < litCnt && set.contains(bits2[i][k] % noOfVar )){		// set contains the integer which is already flipped
						k= k+1;
					}
					if(k < litCnt ){
						int x=	bits2[i][k] % noOfVar;
						set.add(x);				// added to set to get to know that this bit is changed
						
						if(x == 0){ x =noOfVar;}   // to consider the value of 20 % 10 == 0
						
						vB.flip(x);
						//nvB.flip(x);
					}else{
						System.out.println(" PREDICATE FAILED - { Variables : "+( bits2[i][k-1] % noOfVar )+" & "+ bits2[i][k-1]+" already flipped }");
						break;
					}
					
					i = -1;
				}else{
					resultCls.set(i);
				}
				
				//System.out.println();
			}
	     
		 if(!resultCls.isEmpty()){
			 System.out.println("The result of Clause is:");
			 System.out.println(resultCls);
		 }
		 
		 System.out.println("Final pattern in varBits: ");
	     System.out.println(vB);
	     System.out.println("Final pattern in varBits with negation: ");
	     vB.flip(1, noOfVar +1);
	     System.out.println(vB);
	     
	     System.out.println("The number of nodes changed :" + set.size());
	     if(set.size() > 0){
	    	 System.out.println("The Nodes changed :");
	     	for(int s : set){
	     		System.out.print(" { "+ s +" } ");
	     	}
	     }
	     //System.out.println("value at 0th "+bits2.get(10));
	     
	    // return solution(bits2, );
	}
	
	public static boolean checkCls(BitSet vB, BitSet nvB, BitSet temp){
		BitSet temp1 = (BitSet) temp.clone();
		temp.and(vB);
		temp1.and(nvB);
		if(!temp.isEmpty() || !temp1.isEmpty())
			return true;
			else return false;
		
		
	}
	
	public static List<String> readFile(String path){
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("ksat.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        String str;

        List<String> list = new ArrayList<String>();
        try {
			while((str = in.readLine()) != null){
			    list.add(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated
			//catch block
			e.printStackTrace();
		}
        
        return list;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		List list = KSat.readFile("ksat.txt"); // read data from the text file provided
		/*
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("ksat.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        String str;

        List<String> list = new ArrayList<String>();
        try {
			while((str = in.readLine()) != null){
			    list.add(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated
			//catch block
			e.printStackTrace();
		}
		*/
        //String[] stringArr = list.toArray(new String[0]);
        
		int noOfVariables = Integer.parseInt((String) list.get(0)); //Integer.parseInt(stringArr[0]);//10; //sc.nextInt();  // read first line as a no of variables 
		
		//int[] vArray = new int[noOfVariables];
		
		
		int noOfClause = Integer.parseInt((String) list.get(1)); //sc.nextInt(); // read second line as a no of clause
		int literals = 3; // sc.nextInt();
		
		String[] litArray = (((String) list.get(2)).split(" ")); 
		
		Variables vbb = new Variables(noOfVariables);		// create variables array
		
		 BitSet varBits = vbb.getVarBits();//new BitSet(noOfVariables); // variables array
				 
	     
	     System.out.println("Initial pattern in varBits: ");
	     System.out.println(varBits);
	     System.out.println(varBits.length());
	     
	     
	     BitSet nvarBits = new BitSet();
	     nvarBits = (BitSet) varBits.clone();
	     
	     nvarBits.flip(1, noOfVariables);
	     
	     System.out.println("Initial pattern in nvarBits: ");
	     System.out.println(nvarBits);
	     System.out.println(nvarBits.length());
	    
	  // kSat(varBits,litArray, noOfVariables, noOfClause, literals);
		
	   Predicate pred = new Predicate(noOfClause, literals, litArray, noOfVariables);
	   
	   pred.displayPrdicate(noOfClause, literals, pred.getPredicate());
	   
	   pred.KSAT(varBits, noOfVariables, noOfClause, literals, pred.getPredicate());
		

	}

	

}
