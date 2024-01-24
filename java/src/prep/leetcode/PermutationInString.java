package prep.leetcode;

import java.util.HashSet;
import java.util.Set;

public class PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
		int[] s1_count = new int[26];
		
		for(char c  : s1.toCharArray())
			s1_count[c-'a']++;
		
		int left=0;
		int right=0;
		int count=s1.length();
		
		while(right<s2.length())
		{
			if(s1_count[s2.charAt(right++)-'a']-- >= 1)
				count--;
			
			if(count == 0)
				return true;
			
			if(right-left == s1.length() && s1_count[s2.charAt(left++)-'a']++ >= 0)
				count++;
			
		}
		
		return false;
    }

	public static void main(String[] args) {
//		PermutationInString pis = new PermutationInString();
//		System.out.println(pis.checkInclusion("aob", "eidboaoo"));
		
		

	}

}
