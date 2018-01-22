
public class MergeString {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "aaaaaa";
		String b = "bbbbbb";
		
		char[] aa = a.toCharArray();
		char[] bb = b.toCharArray();
		int aLength = aa.length;
		int bLength = bb.length;
		
		StringBuffer sb = new StringBuffer();
		int i,j,k; i= 0; j= 0; k =0;
		
		while ( i < aLength + bLength){
			if(j < aLength){
				sb.append(aa[i]);
				j++;
			}
			
			if(k < bLength){
				sb.append(bb[i]);
				k++;
			}
				
			}
		System.out.println("Merge String" + sb);
	}
	

}
