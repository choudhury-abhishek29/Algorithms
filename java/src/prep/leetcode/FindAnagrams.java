package prep.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
	public List<Integer> findAnagrams(String s, String p)
	{
		List<Integer> result = new ArrayList<Integer>();
		int[] char_count = new int[26];
		for(char c : p.toCharArray())
			char_count[c-'a']++;
		
		int right=0;
		int left=0;
		int count=p.length();
		
		while(right<s.length())
		{
			if(char_count[s.charAt(right++)-'a']-- >= 1)
			{
//				char_count[s.charAt(right)-'a']--;
//				right++;
				count--;
			}
			
			if(count==0)result.add(left);
			
			if(right-left==p.length() && char_count[s.charAt(left++)-'a']++ >= 0)
			{
//				char_count[s.charAt(left)-'a']++;
//				left++;
				count++;
			}
			
		}
		
		
		return result;		
	}

	public static void main(String[] args) {
		FindAnagrams fa = new FindAnagrams();
		System.out.println(fa.findAnagrams("cbaebabacd", "abc"));

	}

}
