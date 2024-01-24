package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {
	public static List<List<String>> groupAnagrams(String[] strs) {
	    List<List<String>> result = new ArrayList<List<String>>();
	    HashMap<String, List<String>>ana_map = new HashMap<String, List<String>>();
	    
	    for(String str : strs)
	    {
	      // System.out.println("str : "+str);
	      char[] tmp = str.toCharArray();
	      Arrays.sort(tmp);
	      String sorted_str = String.valueOf(tmp);
	      if(ana_map.containsKey(sorted_str))
	      {
	        // aet : ['eat','tea']
	        List<String> existing_list = ana_map.get(sorted_str);
	        existing_list.add(str);
	        ana_map.put(sorted_str, existing_list);
	      }
	      else
	      {
	        List<String> ana_list = new ArrayList<>();
	        ana_list.add(str);
	        ana_map.put(sorted_str, ana_list);
	      }
	    }   
	    
	    return new ArrayList<>(ana_map.values());
	  }

	public static void main(String[] args) {
//	    String[] test1 = new String[]{ "eat","tea","tan","ate","nat","bat" }; 
//	    String[] test2 = new String[]{ "" }; 
//	    String[] test3 = new String[]{ "eat" }; 
//	    System.out.println(groupAnagrams(test1));
//	    System.out.println(groupAnagrams(test2));
//	    System.out.println(groupAnagrams(test3));
		
//		String a = "sfast";
//		String b = "astes";
//		String c = "sfastest";
//		System.out.println(c.indexOf(a));
//		System.out.println(c.indexOf(b));
		
		List<String> ls = new ArrayList<String>();
		ls.add("One");
		ls.add("One");
		ls.add("One");
		ls.add("One");
		ls.add("One");
		String res = String.join(", ", ls);
		System.out.println(res);
	  }

}