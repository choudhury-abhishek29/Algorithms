package prep.leetcode;

public class ArithmeticSlices 
{
	public static int numberOfArithmeticSlices(int[] nums) 
    {
        int res=0;
        int dp=0;
        for(int i=2; i<nums.length;i++)
        {
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2])
            {
                dp=1+dp;
                res+=dp;
            }
            else
                dp=0;
        }
        return res;
    }
	
	public static void main(String args[])
	{
		int[] nums = new int[] {1,2,3,7,8,9};
		System.out.println(ArithmeticSlices.numberOfArithmeticSlices(nums));
	}

}
