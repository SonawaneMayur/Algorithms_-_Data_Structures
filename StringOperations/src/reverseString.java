
public class reverseString {

	public static void main(String args[]){
		
		String str = "ab cd";
		System.out.println(revers(str));
	}
	public static String revers(String str){
		char temp;
		char[] ch = str.toCharArray();
		String rstr = null;
		int strLength = str.length();
		int x = 0;
		int y = strLength - 1;
		
		while(x < y){
			temp = ch[y];
			ch[y] = ch[x];
			ch[x] = temp;
			x++;
			y--;
		}
		rstr = new String(ch);
		
		return rstr;
	}
}
