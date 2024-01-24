package prep.leetcode;

import java.util.HashSet;

public class MorseCodeRepresentation {
	public int uniqueMorseRepresentations(String[] words) 
	{
		HashSet<String> uniqueQuotes = new HashSet<String>();
		String[] MORSE = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		
		for(String word : words)
		{
			StringBuilder strb = new StringBuilder();
			
			for(char c : word.toCharArray())
			{
				strb.append(MORSE[c-'a']);
			}
			uniqueQuotes.add(strb.toString());
		}
		return uniqueQuotes.size();
    }

	public static void main(String[] args) {
		MorseCodeRepresentation mcr = new MorseCodeRepresentation();
		System.out.println(mcr.uniqueMorseRepresentations(new String[] {"gin","zen","gig","msg"}));

	}

}
