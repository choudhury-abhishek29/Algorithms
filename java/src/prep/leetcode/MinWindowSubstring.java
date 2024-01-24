package prep.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindowSubstring 
{
	Map<Character, Integer> check = new HashMap<Character,Integer>();
	
	public String minWindow(String s, String t) 
    {
        if(s == null || s.length() < t.length() || s.length() == 0)
        {
            return "";
        }
        
        populateCheck(t);
        
        // mapCounter = 0 denotes condition is satiffied and we got solution
        int total = check.size();
        
        int n = s.length();
        int left = 0, right = 0;  // two pointers
        int start = 0, maxLen = 0;
        for(right = 0; right < n; right++)
        {
            char curr_char = s.charAt(right);
            if(check.containsKey(curr_char))
            {
                check.put(curr_char, check.get(curr_char)-1);
                if(check.get(curr_char) == 0)
                    total--;
                
                // got soltion
                if(total == 0)
                {
                    // finding better solution by shifting left pointer
                    while(left < n && total == 0)
                    {
                        char left_char = s.charAt(left);
                        if(check.containsKey(left_char))
                        {
                            check.put(left_char, check.get(left_char)+1);
                            if(check.get(left_char) > 0)
                                total++;
                        }
                        left++;
                    }
                    // getting best solution
                    if(maxLen > right-left+2 || maxLen == 0)
                    {
                        maxLen = (right-left) + 2;
                        start = left-1;
                    }
                }
            }
        }
        return s.substring(start, start+maxLen);
    }

    public void populateCheck(String t)
    {
        for(char c : t.toCharArray())
            check.put(c, check.getOrDefault(c, 0)+1);
    }
    
    public int getSum(Map<Character, Integer> check)
    {
    	return check.values().stream()
    			.mapToInt(Integer::intValue)
    			.sum();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinWindowSubstring mws = new MinWindowSubstring();
		System.out.println(mws.minWindow("aa", "aa"));
//		System.out.println(mws.minWindow("ADOBECODEBANC", "ABC"));
				

	}

}
