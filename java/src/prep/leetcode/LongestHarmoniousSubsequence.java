package prep.leetcode;

import java.util.Arrays;

public class LongestHarmoniousSubsequence {
	public int findLHS(int[] nums) 
	{
		Arrays.sort(nums);
		int longestLhs = 0;
		int left=0;
		int right=1;
		
		while(right<nums.length)
		{
			int diff = nums[right]-nums[left];
			
			if(diff==1)
				longestLhs = Math.max(longestLhs, right-left+1);
			
			if(diff<=1)
				right++;
			else
				left++;
		}
		return longestLhs;

    }

	public static void main(String[] args) {
		LongestHarmoniousSubsequence lhs = new LongestHarmoniousSubsequence();
		int[] sequence = new int[] {1,3,2,2,5,2,3,7};
		System.out.println(lhs.findLHS(sequence));
	}

}
