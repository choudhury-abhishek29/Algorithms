package revise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public static int[][] merge(int[][] intervals) {
		if(intervals.length<=1)
			return intervals;
		
		List<int[]> result = new ArrayList<int[]>();
		Arrays.sort(intervals, (a1, a2)->Integer.compare(a1[0], a2[0]));
		int[] current_int = intervals[0];
		result.add(current_int);
		
		for(int[] interval : intervals)
		{
			int left1 = current_int[0];
			int right1 = current_int[1];
			int left2 = interval[0];
			int right2 = interval[1];
			
			if(left2<=right1)
			{
				current_int[1]=Math.max(right1, right2);
			}
			else
			{
				current_int=interval;
				result.add(current_int);
//				result.add(intervals[i+1]);
			}

			
			
		}
		return result.toArray(new int[result.size()][]);
    }
	
	public static void main(String args[])
	{
		int[][] intervals = {{1,4},{3,6}};
		int[][] result = merge(intervals);
		
		for(int n[] : result)
		{
			System.out.print("["+n[0]+","+n[1]+"]");
		}
		
		
		
	}
}
