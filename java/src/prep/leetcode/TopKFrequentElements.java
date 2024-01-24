package prep.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;


class MyComparator implements java.util.Comparator<Map.Entry<Integer, Integer>>{

	@Override
	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
		return o2.getValue()-o1.getValue();
	}
	
}
public class TopKFrequentElements {
	
	
	public int[] topKFrequent(int[] nums, int k) {
		int[] result = new int[k];
        Map<Integer, Integer>freqMap = new HashMap<Integer, Integer>();
        for(int n : nums)
            freqMap.put(n, freqMap.getOrDefault(n,0)+1);
   

    PriorityQueue<Map.Entry<Integer,Integer>> maxFreq = new PriorityQueue<>(new MyComparator());

    for(Map.Entry<Integer, Integer> entry : freqMap.entrySet())
        maxFreq.add(entry);
    
    for(int i=0;i<k;i++)
    	result[i]=maxFreq.poll().getKey();
    
    return result;
    }

	public static void main(String[] args) {
		TopKFrequentElements tke = new TopKFrequentElements();
		int[] res = tke.topKFrequent(new int[] {1,1,1,2,2,3,3,3}, 2);
		for(int n : res)
			System.out.println(n);

	}

}
