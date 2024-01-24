package prep.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SearchSuggestion {
	
//	class TrieNode{
//		char c;
//		TrieNode[] children;
//		boolean isWord;
//		
//		public TrieNode(char c) {
//			this.c = c;
//            this.children = new TrieNode[26];
//		}
//		
//	}
//	
//	private void insert(String product, TrieNode root) {
//		TrieNode node = root;
//		for(int i=0;i<product.length();i++) {
//			char c = product.charAt(i);
//			if(node.children[c-'a']==null)
//				node.children[c-'a'] = new TrieNode(c);
//			node = node.children[c-'a'];
//		}
//		node.isWord = true;
//	}
//	
//	private TrieNode buildTrieNode(String[] products) {
//		TrieNode root = new TrieNode(' ');
//		for(String product : products)
//			insert(product, root);
//		
//		return root;
//	}
//	
//	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
//		List<List<String>> res = new ArrayList<List<String>>();
//		TrieNode root = buildTrieNode(products);
//		
//		for(int i=1; i<=searchWord.length(); i++) {
//			res.add(findTopThree(root, searchWord.substring(0,i)));
//		}
//		return res;
//    }
//	
//	private List<String> findTopThree(TrieNode root, String search){
//		List<String> topThree = new ArrayList<>();
//		TrieNode node = root;
//		for(char c : search.toCharArray()) {
//			if(node.children[c-'a'] == null)
//				return topThree;
//			else
//				node = node.children[c-'a'];
//		}
//		if(node.isWord)
//			topThree.add(search);
//		
//		for(TrieNode child : node.children) {
//			if(child!=null) {
//				List<String> thisResult = dfs(child, search, new ArrayList());
//				topThree.addAll(thisResult);
//				if(topThree.size()>=3)
//					return topThree.subList(0, 3);
//			}
//		}
//		return topThree;
//	}
//	
//	private List<String> dfs(TrieNode root, String word, List<String> result) {
//		if(root.isWord) {
//			result.add(word+root.c);
//			if(result.size()>=3)
//				return result;
//		}
//		
//		for(TrieNode child : root.children)
//			if(child!=null)
//				dfs(child, word+root.c, result);
//		
//		return result;	
//	}
	
	 public List<List<String>> suggestedProducts(String[] products, String searchWord) {
	     PriorityQueue<String> priority = new PriorityQueue<>(3, (s1, s2) -> s1.compareTo(s2));
	     List<List<String>> list = new ArrayList<>();
	
	     for (int i = 1; i <= searchWord.length(); i++) {
	         String temp = searchWord.substring(0, i);
	         for (String s : products) {
	             if (s.startsWith(temp)) {
	                 priority.offer(s);
	             }
	         }
	         List<String> temp_list = new ArrayList<>();
	         for (int j = 0; j < 3; j++) {
	             if (priority.peek() != null) {
	                 temp_list.add(priority.poll());
	             }
	         }
	         priority.clear();
	         list.add(temp_list);
	     }
	     return list;
	 }

	public static void main(String[] args) {
		SearchSuggestion ss = new SearchSuggestion();
		System.out.println(ss.suggestedProducts(new String[] {"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
//		System.out.println("mouse".compareTo("mouse"));

	}

}
