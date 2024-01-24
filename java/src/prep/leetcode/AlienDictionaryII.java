package prep.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import jdk.internal.util.xml.impl.Pair;


public class AlienDictionaryII {
	private final static int IN_PATH = 1;
	private final static int VISITED = 2;
	public String alienOrder(String[] words) 
	{
		Map<Character, List<Character>> adj_list = new HashMap<Character, List<Character>>();
		
        for(String word : words)
        {
        	for(int i=0;i<word.length();i++)
        		adj_list.put(word.charAt(i), new ArrayList<Character>());
        }
        
        for(int i=1; i<words.length;i++)
        {
        	Pair<Character, Character> diff = getDifference(words[i-1], words[i]);
        	
        	if(diff!=null)
        		adj_list.get(diff.getKey()).add(diff.getValue());
        	else if(words[i-1].length() > words[i].length())
        		return "";
        }
        
        StringBuilder sb = new StringBuilder();
        int[] state = new int[26];
        
        for(Character letter : adj_list.keySet())
        {
        	if(!addLetter(letter, adj_list, sb, state))
        		return "";
        }
    }
	
	public boolean addLetter(Character letter, Map<Character, List<Character>>adj_list, StringBuilder sb, int[] state)
	{
		int index = letter-'a';
		
		if(state[index]==IN_PATH)
			return false;
		
		if(state[index]==VISITED)
			return true;
		
		state[index] = IN_PATH;
		
		for(Character neighbor : adj_list.get(letter))
			if(!addLetter(neighbor, adj_list, sb, state))
				return false;
		
		state[index]=VISITED;
		sb.append(letter);
		return true;
	}
	
	public Pair<Character, Character> getDifference(String word1, String word2)
	{
		int length = Math.min(word1.length(), word2.length());
		for(int i=0;i<length;i++)
		{
			if(word1.charAt(i) != word2.charAt(i))
				return new Pair<>(word1.charAt(i), word2.charAt(i));
		}
		return null;
	}
	
	

	public static void main(String[] args) {
		AlienDictionaryII adii = new AlienDictionaryII();
		System.out.println(adii.alienOrder(new String[] {"wrt","wrf","er","ett","rftt"}));
		

	}

}
