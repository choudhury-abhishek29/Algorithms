package prep.leetcode.studyPlan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SquaresOfSortedArray {
	public static int[] sortedSquares(int[] nums) 
    {
		int[] out = new int[nums.length];
		int i=0;
		int j=nums.length-1;
		int k=nums.length-1;
		
		while(i<=j)
		{
			if(Math.abs(nums[i])>Math.abs(nums[j]))
			{
				out[k]=nums[i]*nums[i];
				i++;
			}
			else
			{
				out[k]=nums[j]*nums[j];
				j--;
			}
			k--;
		}
		
		return out;
        
    }

	public static void main(String[] args) 
	{
		int[] out = SquaresOfSortedArray.sortedSquares(new int[] {-7,-3,2,3,11});
		for(int i : out)
		{
			System.out.print(i+"\t");
		}

	}

}
