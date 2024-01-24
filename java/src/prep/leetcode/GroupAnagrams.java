package prep.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String, List<String>> ana_map = new HashMap<String, List<String>>();
		
		for(String s : strs)
		{
			char[] temp = s.toCharArray();
			Arrays.sort(temp);
			String sorted_str = String.valueOf(temp);
			
			if(!ana_map.containsKey(sorted_str))
			{
				List<String> ana_list = new ArrayList<String>();
				ana_list.add(s);
				ana_map.put(sorted_str, ana_list);
			}
			else
			{
				List<String> ana_group = ana_map.get(sorted_str);
				ana_group.add(s);
				ana_map.put(sorted_str, ana_group);
			}			
		}
		
		for(String key : ana_map.keySet())
			result.add(ana_map.get(key));
		
		return result;
    }

	public static void main(String[] args) {
		String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
		GroupAnagrams ga = new GroupAnagrams();
		List<List<String>> result = ga.groupAnagrams(strs);
		System.out.println(result);

	}

}
