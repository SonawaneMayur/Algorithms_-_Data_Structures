import java.util.Scanner;

public class EmptyPalindrome {
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		if(str.length()< 1){
			System.out.println("String is Empty");
		}else{
			if(isPalindrome(str))
				System.out.println(1);
			else
				System.out.println(2);
		}
		
	}

	private static boolean isPalindrome(String str) {

		int x =0;
		int y = str.length() - 1;
		
		while(x < y){
			if(x == y){
				if(str.charAt(x) == str.charAt(y)){
					x++;
					y--;
				}else return false;
			}else return false;
		}
		 return true;
	}

}
