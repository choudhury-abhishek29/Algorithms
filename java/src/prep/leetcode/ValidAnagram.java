package prep.leetcode;

import java.util.HashMap;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        HashMap<Character, Integer> char_count = new HashMap<Character, Integer>();

        for(char c : s.toCharArray())
            char_count.put(c, char_count.getOrDefault(c,0)+1);

        for(char c : t.toCharArray())
        {
            if(char_count.containsKey(c))
                char_count.put(c, char_count.get(c)-1);
            else
                return false;
        }

        for(int count : char_count.values())
            if(count!=0) return false;

        return true;
    }

	public static void main(String[] args) {
		ValidAnagram va = new ValidAnagram();
		System.out.println(va.isAnagram("anagram", "nagaram"));

	}

}
