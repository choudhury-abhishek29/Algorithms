package prep.leetcode;

public class MaxSumSubarray {
	public static int maxSubArray(int[] nums) {
		int maxSum=nums[0];
        int currSum=0;
        for(int n : nums)
        {
        	currSum=Math.max(n, currSum+n);
        	maxSum=Math.max(maxSum, currSum);
        }
        
        return maxSum;
    }
	
	public static void main(String[] args)
	{
		System.out.println(maxSubArray(new int[] {-2, -3, 4, -1, -2, 1, 5, -3}));
	}

}