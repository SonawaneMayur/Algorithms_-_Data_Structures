
public class AnagramsString {
	public static void main(String args[]){ 
	String str1 = "abcdefgh";
	String str2 = "efgh";
	
	if(anagram(str1 , str2)){
		System.out.println("String ae anagram");
	}
}
	public boolean anagram(String str1, String str2){
		return sort(str1) == sort(str2);
		
	}
}
