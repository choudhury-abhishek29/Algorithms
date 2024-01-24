package revise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class MostPopularWord 
{
	public String mostCommonWord(String paragraph, String[] banned) 
	{
        String[] words = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        HashMap<String, Integer>word_count = new HashMap<String, Integer>();
        PriorityQueue<Map.Entry<String, Integer>>popular_word = new PriorityQueue<Map.Entry<String, Integer>>((a,b)->b.getValue()-a.getValue());
            
        Set<String> banned_words = new HashSet<String>();
        for(String n : banned)
            banned_words.add(n);
        
        for(String word : words)
        {
            if(!banned_words.contains(word))
                word_count.put(word, word_count.getOrDefault(word, 0)+1);
        }
        
        for(Map.Entry<String, Integer> e : word_count.entrySet())
            popular_word.add(e);
        
        return popular_word.poll().getKey();
    }

	public static void main(String[] args) {
		MostPopularWord mpw = new MostPopularWord();
		System.out.println(mpw.mostCommonWord("a, a, a, a, b,b,b,c, c", new String[] {"a"}));

	}

}
