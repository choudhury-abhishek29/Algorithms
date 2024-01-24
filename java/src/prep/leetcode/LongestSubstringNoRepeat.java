package prep.leetcode;

import java.util.HashSet;

public class LongestSubstringNoRepeat 
{
	public static int lengthOfLongestSubstring(String s) 
	{
		int left=0;
		int right=0;
		int max=0;
		HashSet<Character> sub = new HashSet<Character>();
		
		while(right<s.length())
		{
			if(!sub.contains(s.charAt(right)))
			{
				sub.add(s.charAt(right));
				right++;
				max=Math.max(sub.size(), max);
			}
			else
			{
				sub.remove(s.charAt(left));
				left++;
			}
		}
		
		return max;
    }
	
	public static void main(String args[])
	{
		String sample = "abcdabcbb";
		System.out.println(LongestSubstringNoRepeat.lengthOfLongestSubstring(sample));
	}

}
