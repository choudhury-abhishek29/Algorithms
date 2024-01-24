package prep.leetcode;

import java.util.HashSet;
import java.util.Set;


/*
 * Time Complexity : O(mXn)
 * Space complexity : O(mXn)
 */
public class NumberOfDistinctIslands {
	public int numDistinctIslands(int[][] grid) 
	{
		int rows = grid.length;
		int cols = grid[0].length;
		Set<String> uniqueIslands = new HashSet<String>();
		StringBuffer islandStr = new StringBuffer();
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				if(grid[i][j]==1)
				{
					islandStr.append('X');
					String islandRep = callDfs(grid, i, j, islandStr);
					System.out.println("island : "+islandRep);
					uniqueIslands.add(islandRep);
					islandStr.delete(0, islandStr.length());
				}
			}
		}
		return uniqueIslands.size();
    }
	
	public String callDfs(int[][] grid, int x, int y, StringBuffer islandStr)
	{
		
		
		if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]==0)
			islandStr.append('O');
		else
		{
			grid[x][y]=0;
			islandStr.append('U');
			callDfs(grid, x-1, y, islandStr);
			
			islandStr.append('D');
			callDfs(grid, x+1, y, islandStr);
			
			islandStr.append('L');
			callDfs(grid, x, y-1, islandStr);
			
			islandStr.append('R');
			callDfs(grid, x, y+1, islandStr);
		}
		
		return islandStr.toString();
	}

	public static void main(String[] args) 
	{
		NumberOfDistinctIslands ndi = new NumberOfDistinctIslands();
		int[][] grid = new int[][] {
										{1,1,0,1,1},
										{1,0,0,0,0},
										{0,0,0,0,1},
										{1,1,0,1,1}
									};
		System.out.println(ndi.numDistinctIslands(grid));
		

	}

}
