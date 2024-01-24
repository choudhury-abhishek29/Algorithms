package prep.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codec 
{
	public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for(String str : strs)
        {
            sb.append(str);
            sb.append("=");
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
    	String[] strs = s.split("=",-1);
        return Arrays.asList(strs).subList(0,strs.length-1);
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strs = new ArrayList<String>();
		strs.add("Hello");
		strs.add("World");
		Codec c = new Codec();
		String code = c.encode(strs);
		System.out.println(c.decode(code));

	}

}
