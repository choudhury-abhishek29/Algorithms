package prep.leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharacterSubstrings {
	public int getUniqueCharSubstringCount(String s) {
		int count=0;
		int left=0;
		Set<Character> set = new HashSet<Character>(); 
		
		for(int right=0; right<s.length(); right++) {
			if(set.contains(s.charAt(right))) {
				count++;
				left = right;
				set.clear();
			}
//			else
//			{
				set.add(s.charAt(right));
//			}
		}
		return count+1;
	}

	public static void main(String[] args) {
		UniqueCharacterSubstrings ucs = new UniqueCharacterSubstrings();
		System.out.println(ucs.getUniqueCharSubstringCount("codingisfun"));

	}

}
