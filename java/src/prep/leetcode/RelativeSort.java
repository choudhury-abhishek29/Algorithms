package prep.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RelativeSort {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> remaining = new PriorityQueue<Integer>();
        int[] result = new int[arr1.length];
        int ptr=0;
        for(int n : arr1)
            count.put(n, count.getOrDefault(n,0)+1);
        
        for(int n : arr2)
        {
            int times = count.get(n);
            while(times!=0)
            {
                result[ptr++]=n;
                times--;
            }
            count.remove(n);
        }
        
        if(count.size()>0)
        {
            for(Map.Entry<Integer, Integer> entry : count.entrySet())
                remaining.add((int)entry.getKey());
        }
        
        while(!remaining.isEmpty())
        {
            int key = (int)remaining.poll();
            int times = count.get(key);
            while(times!=0)
            {
                result[ptr++]=key;
                times--;
            }
            count.remove(key);
        }
        
        return result;
    }
	
	public static void main(String[] args)
	{
		RelativeSort rs = new RelativeSort();
		int[] res = rs.relativeSortArray(new int[] {2,3,1,3,2,4,6,7,9,2,19}, 
				new int[] {2,1,4,3,9,6});
		//2,2,2,1,4,3,3,9,6,7,19
		for(int n : res)
			System.out.print(n+" ");
	}

}
