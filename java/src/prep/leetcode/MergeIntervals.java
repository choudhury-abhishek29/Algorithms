package prep.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals 
{
//	public static int[][] merge(int[][] intervals) 
//	{
//		if(intervals.length<=1)
//			return intervals;
//		
//		List<int[]> result = new ArrayList<int[]>();
//		int i=0;
//		Arrays.sort(intervals, (a1, a2)->Integer.compare(a1[0], a2[0]));
//		while(i<intervals.length-1)
//		{
//			int[] temp = operate(intervals[i], intervals[i+1]);
//			if(temp!=null)
//			{
//				result.add(temp) ;
//			}
//			else
//			{
//				result.add(intervals[i]);
//				result.add(intervals[i+1]);
//			}
//
//			i+=2;
//				
//		}
//		
//		return result.toArray(new int[result.size()][]);
//    }
//	
//	public static int[] operate(int[] a, int[] b)
//	{
//		int[] res = null;
//		if(a[1]>=b[0])
//			res = new int[]{a[0], Math.max(a[1], b[1])};
//		
//		return res;
//	}
	
	public static int[][] merge(int[][] intervals) 
	{
		if(intervals.length<=1)
			return intervals;
		
		List<int[]> result = new ArrayList<int[]>();
		Arrays.sort(intervals, (a1, a2)->Integer.compare(a1[0], a2[0]));
		int[] current_interval = intervals[0];
		result.add(current_interval);
		
		for(int[] interval:intervals)
		{
			int current_start = current_interval[0];
			int current_end = current_interval[1];
			int next_start = interval[0];
			int next_end = interval[1];
			
			if(current_end>=next_start)
				current_interval[1]=Math.max(current_end, next_end);
			else
			{
				current_interval=interval;
				result.add(current_interval);
			}
		}
		
		return result.toArray(new int[result.size()][]);
		
	}
	
	public static void main(String args[])
	{
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//		int[][] intervals = {{1,3},{0,4}};
		int[][] result = MergeIntervals.merge(intervals);
		
		for(int n[] : result)
		{
			System.out.print("["+n[0]+","+n[1]+"]");
		}
		
		
		
	}

}
