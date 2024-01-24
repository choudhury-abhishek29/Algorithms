package prep.leetcode;

import java.util.HashSet;

public class LongestConsecutiveSequence 
{
	public static int longestConsecutive(int[] nums) 
	{
		int max_length=0;
		HashSet<Integer> nums_set = new HashSet<Integer>();
		for(int i : nums)
			nums_set.add(i);
		
		for(int i=0;i<nums.length;i++)
		{
			int current_seq_len=1;
			int current_num=nums[i];
			/*
			 * Look for the number smaller than the current number. 
			 * If it doesn't exist, then it is the smallest number in the series and then try 
			 * looking for the next in the series
			 * */
			if(!nums_set.contains(current_num-1))
			{
				while(nums_set.contains(current_num+1))
				{
					current_num+=1;
					current_seq_len+=1;
				}
				
			}
			max_length = Math.max(max_length, current_seq_len);
			
		}
		return max_length;
    }

	public static void main(String[] args)
	{
		System.out.println(longestConsecutive(new int[] {100,4,200,1,3,2}));
	}

}
