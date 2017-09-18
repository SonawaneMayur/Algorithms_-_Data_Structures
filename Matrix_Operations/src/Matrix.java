import java.util.Date;
import java.util.Random;
import java.util.Scanner;

class MatrixOperation{
	int arow, brow = 0;
	int acol, bcol = 0;
	int c[][];
	
	/*void checkSize(int a[][]){
		row = a.length;
		col = a[0].length;
		
		
	}*/
	void addMatrices(int a[][], int b[][]){
		 long addcount = 0;
		
		arow = a.length;
		acol = a[0].length;
		
		brow = b.length;
		bcol = b[0].length;
		
		if(arow == brow && acol == bcol ){
			c = new int[arow][acol];
			
		}else{
			System.out.println("This opertion is invalid");
			return;
		}
		
		System.out.println("The result of addition is : ");
		addcount++;
		for(int i= 0; i < arow ; i++){
			addcount++;
			addcount++;
			for(int j=0; j < bcol; j++){
				addcount++;
				c[i][j] = a[i][j] + b[i][j];
				addcount++;
				addcount++;
				//System.out.print("["+c[i][j]+"]");
				addcount++;
			}
			//System.out.println();
			addcount++;
		}
		addcount = addcount + 2;
		System.out.println("The operations performed in addition is  : "+ addcount);
		
	}
	
	void subtractMatrices(int a[][], int b[][]){
		long subCount = 0;
		
		arow = a.length;
		acol = a[0].length;
		
		brow = b.length;
		bcol = b[0].length;
		
		if(arow == brow && acol == bcol ){
			c = new int[arow][acol]; 
			
		}else{
			System.out.println("This opertion is invalid");
			return;
		}
		
		System.out.println("The result of substraction is : ");
		subCount++;
		for(int i= 0; i < arow ; i++){
			subCount++;
			subCount++;
			for(int j=0; j < bcol; j++){
				subCount++;
				c[i][j] = a[i][j] - b[i][j];
				subCount++;
				subCount++;
				//System.out.print("["+c[i][j]+"]");
				subCount++;
			}
			//System.out.println();
			subCount++;
		}
		
		subCount = subCount + 2;
		System.out.println("The operations performed in substraction is  : "+ subCount);
		
		
	}
	
	public int[][] multiplyMatrices(int a[][], int b[][]){
		
		long multCount = 0;
		arow = a.length;
		acol = a[0].length;
		
		brow = b.length;
		bcol = b[0].length;
		
		if( acol == brow ){
			c = new int[arow][bcol]; 
			
		}else{
			System.out.println("This opertion is invalid");
			return null ;
		}
		
		//System.out.println("The result of multiplication is : ");
		multCount++;
		for(int i= 0; i < arow ; i++){
			multCount++;
			multCount++;
			for(int j=0; j < bcol; j++){
				multCount++;
				multCount++;
				for(int k = 0; k < acol; k++){
					multCount++;
					
					c[i][j] += (a[i][k] * b[k][j]);	
					multCount++;
					multCount++;
					multCount++;
					
					multCount++;
					
				}
				//System.out.print("["+c[i][j]+"]");
				multCount++;
			}
			//System.out.println();
			multCount++;
		}
		multCount = multCount + 3;
		System.out.println("The operations performed in normal multiplication is  : "+ multCount);
		return c;
		
	}
	
public int[][] smultiplyMatrices(int a[][], int b[][]){
		
		//int multCount = 0;
		arow = a.length;
		acol = a[0].length;
		
		brow = b.length;
		bcol = b[0].length;
		
		if( acol == brow ){
			c = new int[arow][bcol]; 
			
		}else{
			System.out.println("This opertion is invalid");
			return null ;
		}
		
		//System.out.println("The result of multiplication is : ");
		//multCount++;
		for(int i= 0; i < arow ; i++){
			//multCount++;
			//multCount++;
			for(int j=0; j < bcol; j++){
				//multCount++;
				//multCount++;
				for(int k = 0; k < acol; k++){
					//multCount++;
					
					c[i][j] += (a[i][k] * b[k][j]);	
					/*multCount++;
					multCount++;
					
					multCount++;*/
					
				}
				//System.out.print("["+c[i][j]+"]");
				//multCount++;
			}
			//System.out.println();
			//multCount++;
		}
		//multCount = multCount + 3;
		//System.out.println("The operations performed in normal multiplication is  : "+ multCount);
		return c;
		
	}
	
	 public int [][] strassen(int [][] a, int [][] b)
		{
		 	if(a[0].length == b.length){
			int n = a.length;
			int [][] result = new int[n][n];

			if((n%2 != 0 ) && (n !=1))
			{
				int[][] a1, b1, c1;
				int n1 = n+1;
				a1 = new int[n1][n1];
				b1 = new int[n1][n1];
				c1 = new int[n1][n1];

				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++)
					{
						a1[i][j] =a[i][j];
						b1[i][j] =b[i][j];
					}
				c1 = strassen(a1, b1);
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++)
						result[i][j] =c1[i][j];
				return result;
			}

			if(n == 1)
			{
				result[0][0] = a[0][0] * b[0][0];
			}else
			{
				int [][] A11 = new int[n/2][n/2];
				int [][] A12 = new int[n/2][n/2];
				int [][] A21 = new int[n/2][n/2];
				int [][] A22 = new int[n/2][n/2];

				int [][] B11 = new int[n/2][n/2];
				int [][] B12 = new int[n/2][n/2];
				int [][] B21 = new int[n/2][n/2];
				int [][] B22 = new int[n/2][n/2];

				divide(a, A11, 0 , 0);
				divide(a, A12, 0 , n/2);
				divide(a, A21, n/2, 0);
				divide(a, A22, n/2, n/2);

				divide(b, B11, 0 , 0);
				divide(b, B12, 0 , n/2);
				divide(b, B21, n/2, 0);
				divide(b, B22, n/2, n/2);

				int [][] P1 = strassen(add(A11, A22), add(B11, B22));
				int [][] P2 = strassen(add(A21, A22), B11);
				int [][] P3 = strassen(A11, sub(B12, B22));
				int [][] P4 = strassen(A22, sub(B21, B11));
				int [][] P5 = strassen(add(A11, A12), B22);
				int [][] P6 = strassen(sub(A21, A11), add(B11, B12));
				int [][] P7 = strassen(sub(A12, A22), add(B21, B22));

				int [][] C11 = add(sub(add(P1, P4), P5), P7);
				int [][] C12 = add(P3, P5);
				int [][] C21 = add(P2, P4);
				int [][] C22 = add(sub(add(P1, P3), P2), P6);

				copy(C11, result, 0 , 0);
				copy(C12, result, 0 , n/2);
				copy(C21, result, n/2, 0);
				copy(C22, result, n/2, n/2);
			}
			return result;
		}else{
			System.out.println("The matrix multiplication is Invalid");
			return null;
		}
		}
	 
	 public int [][] strassenN(int [][] a, int [][] b)
		{
		 	if(a[0].length == b.length){
			int n = a.length ;
			int [][] result = new int[n][n];

			if((n%2 != 0 ) && (n !=1))
			{
				int[][] a1, b1, c1;
				int n1 = n+1;
				a1 = new int[n1][n1];
				b1 = new int[n1][n1];
				c1 = new int[n1][n1];

				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++)
					{
						a1[i][j] =a[i][j];
						b1[i][j] =b[i][j];
					}
				c1 = strassen(a1, b1);
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++)
						result[i][j] =c1[i][j];
				return result;
			}

			if(n == 1)
			{
				result[0][0] = a[0][0] * b[0][0];
			}
			else if(n <= 8){
				//System.out.println("");
				result = smultiplyMatrices(a,b);
			}
			else
			{
				int [][] A11 = new int[n/2][n/2];
				int [][] A12 = new int[n/2][n/2];
				int [][] A21 = new int[n/2][n/2];
				int [][] A22 = new int[n/2][n/2];

				int [][] B11 = new int[n/2][n/2];
				int [][] B12 = new int[n/2][n/2];
				int [][] B21 = new int[n/2][n/2];
				int [][] B22 = new int[n/2][n/2];

				divide(a, A11, 0 , 0);
				divide(a, A12, 0 , n/2);
				divide(a, A21, n/2, 0);
				divide(a, A22, n/2, n/2);

				divide(b, B11, 0 , 0);
				divide(b, B12, 0 , n/2);
				divide(b, B21, n/2, 0);
				divide(b, B22, n/2, n/2);

				int [][] P1 = strassen(add(A11, A22), add(B11, B22));
				int [][] P2 = strassen(add(A21, A22), B11);
				int [][] P3 = strassen(A11, sub(B12, B22));
				int [][] P4 = strassen(A22, sub(B21, B11));
				int [][] P5 = strassen(add(A11, A12), B22);
				int [][] P6 = strassen(sub(A21, A11), add(B11, B12));
				int [][] P7 = strassen(sub(A12, A22), add(B21, B22));

				int [][] C11 = add(sub(add(P1, P4), P5), P7);
				int [][] C12 = add(P3, P5);
				int [][] C21 = add(P2, P4);
				int [][] C22 = add(sub(add(P1, P3), P2), P6);

				copy(C11, result, 0 , 0);
				copy(C12, result, 0 , n/2);
				copy(C21, result, n/2, 0);
				copy(C22, result, n/2, n/2);
			}
			return result;
		}else{
			System.out.println("The matrix multiplication is Invalid");
			return null;
		}
		}
	 
	 public static void divide(int[][] p1, int[][] c1, int iB, int jB)
		{
			for(int i1 = 0, i2=iB; i1<c1.length; i1++, i2++)
				for(int j1 = 0, j2=jB; j1<c1.length; j1++, j2++)
				{
					c1[i1][j1] = p1[i2][j2];
				}
		}

		public static void copy(int[][] c1, int[][] p1, int iB, int jB)
		{
			for(int i1 = 0, i2=iB; i1<c1.length; i1++, i2++)
				for(int j1 = 0, j2=jB; j1<c1.length; j1++, j2++)
				{
					p1[i2][j2] = c1[i1][j1];
				}
		}
		
		public static int [][] add(int [][] A, int [][] B)
		{
			int n = A.length;

			int [][] result = new int[n][n];

			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
				result[i][j] = A[i][j] + B[i][j];

			return result;
		}

		public static int [][] sub(int [][] A, int [][] B)
		{
			int n = A.length;

			int [][] result = new int[n][n];

			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
				result[i][j] = A[i][j] - B[i][j];

			return result;
		}
	
} 
public class Matrix {
	
	int matrix[][];
	int matrix_B[][];
	int matrix_C[][];
	int n; // number of row
	int m; // number of columns
	int x; // matrix data is in the range of x and y, where (x <= y)
	int y;
	public Scanner sc = new Scanner(System.in);
	
	Random random = new Random();
	
	public int[][] create(){
		
		System.out.println("Matrix creation");
		
		System.out.println("Enter the number of rows : ");
		n = sc.nextInt();
		
		System.out.println("Enter the number of columns : ");
		m = sc.nextInt();
		
		matrix = new int[n][m];
		do{
			
			System.out.println("Define the range of data in matrix");
			System.out.println("Enter the Lower limit : ");
			x = sc.nextInt();
		
			System.out.println("Enter the Upper limit : ");
			y = sc.nextInt();
		
			if(x>= y)
				System.out.println("the Lower limit should be smaller than Upper limit, Please reenter the limits : ");
		
		}while(x >= y);  // it will break when x < y
		
		for(int i= 0; i < n ; i++){
			for(int j=0; j < m; j++){
				matrix[i][j] = random.nextInt((y - x) + 1) + x;
				//matrix_B[i][j] = random.nextInt((y - x) + 1) + x;
				
			}
		}
		return matrix;
	
		//return matrix_A[][];
	}
	
	public void display(int matrix[][]){
		
		for(int k= 0; k < matrix.length ; k++){
			for(int l=0; l < matrix[0].length; l++){
				System.out.print("["+matrix[k][l] +"]");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matrix m = new Matrix();
		//int a[][];
		//int b[][];
		MatrixOperation mo = new MatrixOperation();
		java.util.Date date= new java.util.Date();
		long date1, date2;
		
		int a[][] = m.create();
		int b[][] = m.create();

		System.out.println("The matrix a is :");
		m.display(a);
		
		System.out.println("The matrix b is :");
		m.display(b);
		do{
		System.out.println("Select he choice - Addition : 1 /n Substraction : 2 /n Multiplication : 3");
		
		switch(m.sc.nextInt()){
		
		case(1): System.out.println(":Addition:");
				 mo.addMatrices(a, b);
				 break;
				 
		case(2): System.out.println(":Substracion:");
				 mo.subtractMatrices(a, b);
				 break;
			 
		case(3): System.out.println(":Multiplicaion:");
					long start_time = System.nanoTime();
					
				 int[][] c =mo.multiplyMatrices(a, b);
				 if(c != null){
					 System.out.println("The result of multiplication is : ");
					 m.display(c);
				 }
				 long end_time = System.nanoTime();
				 double diff = (end_time - start_time)/1e6;
				 
				 
				 System.out.println("Time required for Normal multiplication: "+ diff);
				// m.display(matrix);
				break;
				 
		case(4):System.out.println(":Strassen Multiplicaion:");
				long start_time1 = System.nanoTime();
				
				int[][] s = mo.strassen(a, b);
				if(s != null){
					System.out.println("The result of multiplication by Stressen is : ");
					m.display(s);
				}
				long end_time1 = System.nanoTime();
				double diff1 = (end_time1 - start_time1)/1e6;
				
				System.out.println("Time required for strassen multiplication: "+ diff1);
				break;
				
		case(5):System.out.println(":StrassenN Multiplicaion:");
		        long start_time2 = System.nanoTime();
		        
		        int[][] sn = mo.strassenN(a, b);
		        if(sn != null){
		        	System.out.println("The result of multiplication by StressenN is : ");
		        	m.display(sn);
		        }
		        long end_time2 = System.nanoTime();
		        double diff2 = (end_time2 - start_time2)/1e6;
		        
		        System.out.println("Time required for StrassenN multiplication: "+ diff2);
		        break;
		        
		default: //break;
		
			
		}
		}while(m.sc.nextInt()!=0);
		
		
		
	}

}
