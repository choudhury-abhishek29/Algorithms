package prep.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		HashSet<String> set = new HashSet<String>(wordDict);
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] seen = new boolean[s.length()+1];
		q.add(0);
		
		while(!q.isEmpty()) {
			int start = q.poll();
			
			if(start==s.length())
				return true;
			
			for(int end=start+1; end<=s.length(); end++) {
				if(seen[end]) continue;
				
				if(set.contains(s.substring(start, end))) {
					q.add(end);
					seen[end] = true;
				}
			}
		}
        return false;
    } 

	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		System.out.println(wb.wordBreak("cars", List.of("car","ca","rs")));
	}

}
