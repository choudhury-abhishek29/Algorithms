package prep.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums, int total) {
		List<List<Integer>> outList = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		
		for(int i=0;i<nums.length-2;i++)
		{
			if(i==0 || (i>0 && nums[i]!=nums[i-1]))
			{
				int target = total-nums[i];
				int low=i+1;
				int high=nums.length-1;
				while(low<high)
				{
					if(nums[low]+nums[high]==target)
					{
						outList.add(Arrays.asList(nums[i],nums[low],nums[high]));
						while(low<high && nums[low]==nums[low+1])low++;
						while(low<high && nums[high]==nums[high-1])high--;
						low++;
						high--;
					}
					else if(nums[low]+nums[high]<target)
						low++;
					else
						high--;
				}
			}
		}
		return outList;
    }
	
	
	public static void main(String[] args)
	{
		System.out.println(threeSum(new int[] {-3,3,4,-3,1,2}, 0));
	}

}
