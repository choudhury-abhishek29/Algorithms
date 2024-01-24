package prep.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
	private static int time = 0;
	private static int fresh = 0;
//	
	public static int orangesRotting(int[][] grid)
	{
		Queue<int[]> rotten = new LinkedList<int[]>();
		int rows = grid.length;
		int cols = grid[0].length;
		int[][] directions = new int[][] {{-1,0},{1,0},{0,-1},{0,1}}; 
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				if(grid[i][j]==1)
					fresh++;
				if(grid[i][j]==2)
					rotten.add(new int[] {i, j});
			}
		}
		
		while(!rotten.isEmpty() && fresh>0)
		{
			int size=rotten.size();
			for(int m=0;m<size;m++)
			{
				int[] p = rotten.poll();
				int i=p[0]; 
				int j=p[1];
				//check surroundings for rotten orange
				for(int[] dir : directions)
				{
					int x=i+dir[0];
					int y=j+dir[1];
					if(x>-1 && x<grid.length && y>-1 && y<grid[0].length && grid[x][y]==1)
					{
						rotten.add(new int[] {x,y});
						grid[x][y]=2;
						fresh--;
					}
				}
			}
			time++;
		}
		
		
		return (fresh==0)?time:-1;
		
	
	
		
	}

	public static void main(String[] args) {
		int[][] grid = new int[][] {
										{2,1,1},
										{1,1,1},
										{0,1,2}
									};
		System.out.println(orangesRotting(grid));

	}

}
