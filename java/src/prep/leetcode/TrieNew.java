package prep.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TrieNode{
	HashMap<Character, TrieNode> children;
	boolean isWord;
	
	public TrieNode() {
		this.children = new HashMap<Character, TrieNode>();
		this.isWord = false;
	}
}



public class TrieNew {
	TrieNode tn;
	
	public TrieNew() {
        this.tn = new TrieNode();
    }
    
    
	
	public void insert(String word) {
        TrieNode curr = tn;
        for(char c : word.toCharArray()) {
        	if(!curr.children.containsKey(c))
        		curr.children.put(c, new TrieNode());
        	curr = curr.children.get(c);
        }
        curr.isWord=true;
        System.out.println("Word added");
        
    }
      
    public boolean search(String word) {
      TrieNode curr = tn;
      for(char c : word.toCharArray()) {
    	  if(!curr.children.containsKey(c))
    		  return false;
    	  curr = curr.children.get(c);
      }
      
      return curr.isWord;
    }
    
    
    public boolean startsWith(String prefix) {
    	TrieNode curr = tn;
        for(char c : prefix.toCharArray()) {
      	  if(!curr.children.containsKey(c))
      		  return false;
      	  curr = curr.children.get(c);
        }
        
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrieNew tn = new TrieNew();
		tn.insert("APPLE");
		tn.insert("APP");
		tn.insert("BALL");
		
		System.out.println(tn.search("BA"));
		System.out.println(tn.startsWith("BA"));
		
//		HashSet<TrieNode> tr_set = new HashSet<TrieNode>();
//		TrieNode n1 = new TrieNode('A');
//		TrieNode n2 = new TrieNode('A');
//		TrieNode n3 = new TrieNode('C');
//		
//		tr_set.add(n1);
//		System.out.println(tr_set);
//		
//		System.out.println(tr_set.contains('A'));
		
		
		
		
	}

}
