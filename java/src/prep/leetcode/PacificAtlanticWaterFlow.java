package prep.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
	public static List<List<Integer>> pacificAtlantic(int[][] heights) {
		int rows = heights.length;
		int cols = heights[0].length;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		boolean[][] pacific = new boolean[rows][cols];
		boolean[][] atlantic = new boolean[rows][cols];
		
		for(int col=0;col<cols;col++)
		{
			dfsRec(0, col, rows, cols, pacific, heights[0][col], heights);
			dfsRec(rows-1, col, rows, cols, atlantic, heights[rows-1][col], heights);
		}
		
		for(int row=0;row<rows;row++)
		{
			dfsRec(row, 0, rows, cols, pacific, heights[row][0], heights);
			dfsRec(row, cols-1, rows, cols, atlantic, heights[row][cols-1], heights);
		}
		
		for(int row=0;row<rows;row++)
		{
			for(int col=0;col<cols;col++)
			{
				if(pacific[row][col] && atlantic[row][col])
					result.add(Arrays.asList(row, col));
			}
		}
		
		return result;
        
    }
	
	public static void dfsRec(int row, int col, int rows, int cols, boolean[][] visited, int prevHeight, int[][] heights)
	{
		if(row<0 || row>=rows || col<0 || col>=cols || visited[row][col] || prevHeight>heights[row][col])
			return;
		else
		{
			visited[row][col]=true;
			dfsRec(row-1, col, rows, cols, visited, heights[row][col], heights);
			dfsRec(row+1, col, rows, cols, visited, heights[row][col], heights);
			dfsRec(row, col-1, rows, cols, visited, heights[row][col], heights);
			dfsRec(row, col+1, rows, cols, visited, heights[row][col], heights);
		}
	}
	
	public static void main(String[] args)
	{
		int[][] heights = new int[][] {
										{1,2,2,3,5},
										{3,2,3,4,4},
										{2,4,5,3,1},
										{6,7,1,4,5},
										{5,1,1,2,4} 
									};
		List<List<Integer>> result = pacificAtlantic(heights);
		System.out.println(result);
	}

}
