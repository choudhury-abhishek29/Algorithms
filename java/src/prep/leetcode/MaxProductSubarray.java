package prep.leetcode;

public class MaxProductSubarray {
	public static int maxProduct(int[] nums) {
        int min=nums[0];
		int max=nums[0];
        int result=nums[0];
        
        for(int i=1;i<nums.length;i++)
        {
        	int tempMax = Math.max(nums[i]*max, Math.max(nums[i], nums[i]*min));
        	min = Math.min(nums[i]*max, Math.min(nums[i], nums[i]*min));
        	max=tempMax;
        	result = Math.max(max, result);
        }
        
        return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println(maxProduct(new int[] {0,-4,-3,-2}));
	}
        
        
        

}
