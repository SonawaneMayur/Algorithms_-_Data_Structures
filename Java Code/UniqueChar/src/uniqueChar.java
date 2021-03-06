
public class uniqueChar {

	public static void main(String args[]){
		String str = "ba";
		if(isUniqueChar(str)){
			System.out.println("unique");
		}else
			System.out.println("Not unique char");
		
	}
	
	public static boolean isUniqueChar1(String str){
		boolean[] char_set = new boolean[256];
		
		for(int i=0;i < str.length(); i++){
			int val = str.charAt(i);
			
			if(char_set[val]) return false;
			
			char_set[val] = true;
			
		}
		
		return true;
	}
	
	public static boolean isUniqueChar(String str){
		int checker = 0;
 		for(int i = 0; i< str.length(); i++){
			int val = str.charAt(i);
			if((checker & (1 << val)) > 0){
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
}
