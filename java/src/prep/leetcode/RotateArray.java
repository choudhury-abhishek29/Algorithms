package prep.leetcode;

public class RotateArray {
	public static void rotate(int[] nums, int k) {
        k = k%nums.length;
        rev(nums,0,nums.length-1);
        rev(nums,0,k-1);
        rev(nums,k,nums.length-1);
        
        for(int i : nums)
        {
        	System.out.print(i+"\t");
        }
    }
    
    public static void rev(int[] nums, int start, int end)
    {
        while(start<end)
        {
            int temp = nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

	public static void main(String[] args) 
	{
		RotateArray.rotate(new int[] {1,2,3,4,5,6,7}, 3);

	}

}
