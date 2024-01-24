package prep.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TwoSumWithDuplicates 
{
	public static int[][] twoSum(int[] nums, int target) 
    {

       List<int[]> res = new ArrayList<int[]>();
		
		HashMap<Integer, Integer> diff = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++)
		{
			int complement = target-nums[i];
			System.out.println(nums[i]);
			if(diff.containsKey(complement) && diff.getOrDefault(complement,0)>0)
			{
				res.add(new int[]{nums[i], complement});
				System.out.println("Add ["+nums[i]+","+complement+"] to res");
				diff.put(complement, diff.get(complement)-1);
			}
			else
			{
				int val = diff.getOrDefault(nums[i],0);
				diff.put(nums[i], val+1);
			}
			
			System.out.println(diff);
			System.out.println("--------------------------");
		}
		
		return res.toArray(new int[res.size()][]);
		
		
    }
	
	public static void main(String[] args)
	{
		int[][] res = TwoSumWithDuplicates.twoSum(new int[] {1,2,3,4,5,3,2,4,5,1,3,6}, 11);
		
		for(int[] i : res)
		{
			System.out.println("["+i[0]+","+i[1]+"]");
		}
	}

}
