package prep.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CustomSort {
	public String customSortString(String order, String s) {
        HashMap<Character, Integer>word_count=new HashMap<Character,Integer>();
        char[] s_arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : s_arr)
        {
            word_count.put(c, word_count.getOrDefault(c,0)+1);
        }
        
        for(char c : order.toCharArray())
        {
        	if(word_count.containsKey(c))
			{
        		for(int i=0;i<word_count.get(c);i++)
                    sb.append(c);
                
                word_count.remove(c);
			}
        	
            
        }
        
        for(Map.Entry e : word_count.entrySet())
        {
            char key = (char) e.getKey();
            for(int i=0;i<word_count.get(key);i++)
                sb.append(key);
        }
        
        return sb.toString();
        
    }
	
	public static void main(String[] a)
	{
		CustomSort cs = new CustomSort();
		System.out.println(cs.customSortString("cbafg", "abcd"));
	}

}
