package prep.leetcode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumSortedArray {

	public static int[] twoSum(int[] nums, int target) 
	{
		int a=0;
		int b=nums.length-1;
		
		while(a<b)
		{
			int sum = nums[a]+nums[b];
			
			if(sum>target)
				b-=1;
			else if(sum<target)
				a+=1;
			else
				return new int[] {a+1,b+1};
			
		}
		
		return new int[] {a+1,b+1};
        
    }

	public static void main(String[] args) 
	{
		int[] res = twoSum(new int[] {0,1,2,9,11,15}, 9);
		for(int x : res)
        {
        	System.out.print(x+"\t");
        }
		
		

	}

}
