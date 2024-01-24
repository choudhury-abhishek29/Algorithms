package prep.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfIslands 
{
	public static void numIslands(char[][] grid) 
	{
		int rows = grid.length;
		int cols = grid[0].length;
		int numOfIslands = 0;
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				numOfIslands+=callBFS(grid, i, j);				
			}
		}
		
		System.out.println("Number of Islands : "+numOfIslands);
		
    }
	
	public static int callBFS(char[][] grid, int i, int j)
	{
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0' || grid[i][j]=='v')
			return 0;
		else
		{
			grid[i][j]='v';
			callBFS(grid, i-1, j);
			callBFS(grid, i+1, j);
			callBFS(grid, i, j-1);
			callBFS(grid, i, j+1);
			return 1;
		}
		
	}
	
	public static void main(String args[])
	{
		char[][] landscape = new char[][] {
											{'1','1','1','1','0'},
											{'1','1','0','0','0'},
											{'1','1','0','0','0'},
											{'0','0','0','1','1'}
										};
										
		NumberOfIslands.numIslands(landscape);
		
	}

}
