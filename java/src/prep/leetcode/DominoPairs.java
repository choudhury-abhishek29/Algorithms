package prep.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DominoPairs {
	
	public int numEquivDominoPairs(int[][] dominoes) {
		int pairs=0;
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();

        for(int[] d : dominoes)
        {
            int low = Math.min(d[0], d[1]);
            int high = Math.max(d[0], d[1]);
            int key = high*10+low;

            if(count.containsKey(key))
            {
                count.put(key,count.get(key)+1);
                pairs+=count.get(key);
            }
            else
                count.put(key,0);

        }
        return pairs;
    }

	public static void main(String[] args) {
		DominoPairs dps = new DominoPairs();
		System.out.println(dps.numEquivDominoPairs(new int[][] {{1,2},{1,2},{1,1},{1,2},{2,2}}));

	}

}
