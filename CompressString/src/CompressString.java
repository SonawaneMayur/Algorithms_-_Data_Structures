
public class CompressString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "aaabbccccc";
		String as = new String();
		char[] cs = s.toCharArray();
		int i=0;
		int count = 0;
		int start = 0;
		while(i < cs.length){
			
			//System.out.println(cs[i]);
			//System.out.println(s.lastIndexOf(cs[i]) + 1);
			count =  s.lastIndexOf(cs[i]) - s.indexOf(cs[i]);
			as = as + cs[i] + String.valueOf(count);
			i = s.lastIndexOf(cs[i]) + 1;
		}
		
		System.out.println(as);
		
	}

}
