package prep.leetcode;

import java.util.HashMap;

public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> compMap = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length-1;i++)
		{
			int complement = target - nums[i];
			if(compMap.containsKey(complement))
				return new int[] {compMap.get(complement),i};
			
			compMap.put(nums[i], i);
		}
		return new int[2];
        
    }
	
	public static void main(String[] args)
	{
		int[] x = twoSum(new int[] {5,1,9,2,7,11,15}, 9);
		for(int i : x)
			System.out.println(i);
		
	}

}
