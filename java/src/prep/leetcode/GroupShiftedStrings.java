package prep.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> map = new  HashMap<String, ArrayList<String>>();
        
        for(String str : strings)
        {
            StringBuffer shift = new StringBuffer();
            int diff=0;
            for(int i=1;i<str.length();i++)
            {
                diff = getDistance(str.charAt(i-1),str.charAt(i));
                shift.append(diff+",");
            }
            
            if(map.containsKey(shift.toString()))
            {
            	ArrayList<String> group = map.get(shift.toString());
            	group.add(str);
            	map.put(shift.toString(), group);
            }
            else
            {
            	ArrayList<String> group = new ArrayList<String>();
            	group.add(str);
            	map.put(shift.toString(), group);
            }
        }
        
        for(String key : map.keySet())
        	res.add(map.get(key));
        
        return res;
    }
	
	public int getDistance(char prev, char curr)
	{
		int prev_val = prev-'a'+1;
		int curr_val = curr-'a'+1;
		
		return curr_val<prev_val ? prev_val-curr_val : (26-curr_val)+prev_val;
		
	}

	public static void main(String[] args) {
		GroupShiftedStrings gss = new GroupShiftedStrings();
		System.out.println(gss.groupStrings(new String[] {"cba","la"}));

	}

}
