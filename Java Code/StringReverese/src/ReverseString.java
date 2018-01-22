import java.util.Scanner;

public class ReverseString {

	public static String revers(String str){ //reverse the string with swapping the characters 
		char temp;
		char[] ch = str.toCharArray();
		String rstr = null;
		int strLength = str.length();
		int x = 0;
		int y = strLength - 1;
		
		while(x < y){				// reverse the string 
			temp = ch[y];
			ch[y] = ch[x];
			ch[x] = temp;
			x++;
			y--;
		}
		rstr = new String(ch);
		
		return rstr;
	}
	 public static String reverseRecurssion(String str){
		 
		 if(str.length() < 1)
			 return str;
		 
		 return str.charAt(str.length() - 1) + reverseRecurssion(str.substring(0, str.length()-1));  //reverse the string with recursion 
	 }
	
	 public static String checkPrime(int a){
		 if(a == 2 || a == 3){
			 return a + "is prime number";
		 }else if(a %2 == 0 || a%3 == 0 || a == 1){
			 return a + "is not prime number";
		 }else 
			 return a + "is prime number";
	 } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next(); // input string
		//System.out.println("Reverse string of (with recursion)"+str+" is "+reverseRecurssion(str)); // (with recursion)
		
		//System.out.println("Reverse string of (without recursion)"+str+" is "+revers(str)); // without recursion
		
		
		//int x = sc.nextInt();// input the number
		
		//System.out.println(checkPrime(x));
		StringBuilder st = new StringBuilder(str);
		st.de
		char[] c= str.toCharArray();
		System.out.println((char)((int) c[0]));
	
		}
	}

