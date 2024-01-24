package prep.leetcode;

public class MaxConsecutiveOne {
	public int findMaxConsecutiveOnes(int[] nums) 
	{
        int zero_count=0;
        int left=0;
        int right=0;
        int maxLength=Integer.MIN_VALUE;

        while(right<nums.length)
        {
        	if(nums[right]==0)zero_count++;
        	while(zero_count==2)
        	{
        		if(nums[left]==0)
        			zero_count--;
        		left++;
        	}
        	maxLength=Math.max(maxLength, right-left+1);
        	right++;
        	
        }
        
        return maxLength;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxConsecutiveOne mo = new MaxConsecutiveOne();
		System.out.println(mo.findMaxConsecutiveOnes(new int[] {1,0,1,1,0}));

	}

}
