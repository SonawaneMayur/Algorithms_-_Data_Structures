import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class LongestPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";//"dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		String[] byn = s.split("\n");
		String t = "\t";
		int position;
		int highest= 0;
		LinkedHashMap<Integer,String > hs = new LinkedHashMap<Integer, String>();
		StringBuilder  sa = new StringBuilder ();
		for(int counter=byn.length; counter > 0;counter--){
			String[] c = byn[counter -1].split(t);
			position = c.length;
			
			
			//if(position > highest){
			if(!hs.containsKey(position)){
				//highest = position;
				hs.put(position, c[position -1]);
			}
		}
		//int idx = h.indexOf(key);
		
		 //ArrayList<Integer> keys = new ArrayList<Integer>(hs.keySet());
		for (Integer cnt: hs.keySet()){

           // String key =cnt.toString();
            String value = hs.get(cnt).toString(); 
            StringBuffer strbuf;

            
            //System.out.println(value + " " + value); 
            if(cnt > 1)
            	strbuf = new StringBuffer("/"+value);
            else
            	strbuf = new StringBuffer(value);
            
            sa = sa.insert(0, strbuf);
		} 
		
		System.out.println(sa); 	
		System.out.println(sa.length());
	}

}
