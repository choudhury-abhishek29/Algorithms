package prep.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class RearrangeWordsInSentence {
	public static String arrangeWords(String text) {
//        String[] words = text.split(" ");
//        words[0] = words[0].toLowerCase();
//        Arrays.sort(words, Comparator.comparingInt(String::length));
//        words[0] = words[0].substring(0, 1).toUpperCase() + words[0].substring(1);
//        return String.join(" ", words);
		
		String sorted = Arrays.stream((Character.toLowerCase(text.charAt(0))+text.substring(1)).split(" "))
								.sorted(Comparator.comparing(String::length))
								.collect(Collectors.joining(" "));
		return Character.toUpperCase(sorted.charAt(0))+sorted.substring(1);
    }

	public static void main(String[] args) 
	{
		System.out.println(arrangeWords("This is no good"));

	}

}
