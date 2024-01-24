package prep.leetcode;

public class SortColors {
 public int[] sortColors(int[] nums) 
 {
	 if(nums.length<=1)
		 return nums;
	 
	 int start = 0;
	 int end = nums.length-1;
	 int index=0;
	 
	 while(index<=end && start<end)
	 {
		 if(nums[index]==0)
		 {
			 nums[index]=nums[start];
			 nums[start]=0;
			 index++;
			 start++;
		 } 
		 else if(nums[index]==2)
		 {
			 nums[index]=nums[end];
			 nums[end]=2;
			 end--;
		 }
		 else
			 index++;
	 }
	 
	 return nums;
 }
 
 public static void main(String[] args)
 {
	 SortColors sc = new SortColors();
	 int[] res = sc.sortColors(new int[] {1,0,2,1,0,2});
	 for(int r : res)
		 System.out.print(r+" ");
 }

}
