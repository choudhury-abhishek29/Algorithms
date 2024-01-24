package prep.leetcode.studyPlan;

import java.util.HashMap;

public class BinarySearch 
{
	public static int search(int[] nums, int target) 
	{
		int left=0;
		int right=nums.length-1;
		
		while(left<=right)
		{
			int mid = (left+right)/2;
			
			if(nums[mid]==target)
				return mid;
			else if(nums[mid]<target)
				left=mid+1;
			else
				right=mid-1;
		}
		
        return -1;
    }
	
	public static void main(String args[])
	{
		System.out.println(BinarySearch.search(new int[] {2,5,6,8,9,11}, 12));
	}

}
