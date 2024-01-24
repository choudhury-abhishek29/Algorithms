package prep.leetcode;

import java.util.HashMap;

public class SubarraySumToK {

	public int findSubArray(int[] nums, int k) 
	{
		int count=0;
		int sum=0;
		HashMap<Integer, Integer> sum_map = new HashMap<Integer, Integer>();
		sum_map.put(0, 1);
		for(int i=0;i<nums.length;i++)
		{
			sum+=nums[i];
			
			if(sum_map.containsKey(sum-k))
				count+=sum_map.get(sum-k);
			
			sum_map.put(sum, sum_map.getOrDefault(sum, 0)+1);
		}
		
		return count;
        
    }
	public static void main(String[] args) {
		SubarraySumToK stk = new SubarraySumToK();
		System.out.println(stk.findSubArray(new int[] {3,4,7,2,-3,1,4,2}, 7));

	}

}
