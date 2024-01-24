package prep.leetcode;

public class MissingNumber {
	public static int missingNumber(int[] nums) {
		//standard looping and sum
		int sumAll = 0;
		for(int i:nums)
			sumAll+=i;
		int n = nums.length;
		int sumArr = n*(n+1)/2;
		
		return sumArr-sumAll;
		
		
		//xor method
//		int xorAll = nums.length;
//		for(int i=0;i<nums.length;i++)
//		{
//			xorAll^=i^nums[i];
//		}
//		
//		return xorAll;
		
        
    }
	
	public static void main(String[] args)
	{
		System.out.println(missingNumber(new int[] {0,1}));
	}
}
