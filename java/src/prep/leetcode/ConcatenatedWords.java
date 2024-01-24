package prep.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ConcatenatedWords 
{
	public static List<String> findAllConcatenatedWordsInADict(String[] words) 
	{
		List<String> result = new ArrayList<String>();
		HashSet<String> words_set = new HashSet<>(Arrays.asList(words));
		
		for(String word : words)
		{
			if(canFormWord(word, words_set))
				result.add(word);
		}
		
		return result;
	        
	}
	
	public static Boolean canFormWord(String word, HashSet<String> words_set)
	{
		for(int i=1;i<word.length();i++)
		{
			String left = word.substring(0, i);
			String right = word.substring(i);
			if(words_set.contains(left))
			{
				if(words_set.contains(right) || canFormWord(right, words_set))
					return true;
			}
		}
		
		return false;
	}
	
	public static void main(String args[])
	{
		String[] words = new String[] {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
		List<String> result = ConcatenatedWords.findAllConcatenatedWordsInADict(words);
		for(String r : result)
		{
			System.out.println(r);
			System.out.println("-----");
		}
		
	}
	
	
	
	

}
