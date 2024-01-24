package prep.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        HashSet<String> word_set = new HashSet<String>();
        for(String word : wordList)
            word_set.add(word);

        if(!word_set.contains(endWord)) return 0;
        
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        int level=1;

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                String curr_word = q.poll();
                char[] curr_word_chars = curr_word.toCharArray();
                for(int j=0;j<curr_word_chars.length;j++)
                {
                    char original_char = curr_word_chars[j];
                    for(char c='a'; c<='z';c++)
                    {
                        if(curr_word_chars[j]==c) continue;
                        curr_word_chars[j]=c;
                        String new_word = String.valueOf(curr_word_chars);
                        if(new_word.equals(endWord)) return level+1;
                        if(word_set.contains(new_word))
                        {
                            q.add(new_word);
                            word_set.remove(new_word);
                        }
                    }
                    curr_word_chars[j]=original_char;
                }
            }
            level++;
        }
        return 0;
    }

	public static void main(String[] args) {
		WordLadder wl = new WordLadder();
		System.out.println(wl.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));

	}

}
