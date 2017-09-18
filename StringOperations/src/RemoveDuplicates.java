
public class RemoveDuplicates {
	
	public static void main(String args[]){
		char[] str = {'a','a','b','b','c','c','a'};
		System.out.println(removeDuplicates(str));
	}
	
	public static String removeDuplicates(char[] str){
		//char[] ch = str.toCharArray();
		if(str == null) return "null";
		
		if(str.length < 2) return String.valueOf(str);
		int i,j;
		boolean[] hit = new boolean[256];
		for(j = 0; j< 256; j++){
			hit[j] = false;
		}
		int tail = 1;
	
		for(i = 1; i < str.length; ++i){
			if(!hit[str[i]]){
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
				
			}
		}
		str[tail] = 0;
		/*for(i = 1; i < str.length ; i++){
			for(j = 0; j < tail ; j++){
 				if(str[i] == str[j]){
 					str[i] = str[i+1];
 				++tail;
					break;
 				}
			}
		if(j == tail){
			str[tail] = str[j];
			tail++;
		}
		}*/
		//str[tail] = 0;
		return new String(str);
	}

}
