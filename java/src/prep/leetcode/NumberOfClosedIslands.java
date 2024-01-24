package prep.leetcode;

/*
 * Time Complexity : O(mXn)
 * Space complexity : O(mXn)
 * */
public class NumberOfClosedIslands 
{
	public int closedIsland(int[][] grid) 
	{
		int islands = 0;
		int rows = grid.length;
		int cols = grid[0].length;
		
		for(int i=1;i<rows-1;i++)
		{
			for(int j=1;j<cols-1;j++)
			{
				if(grid[i][j]==0 && getClosedIslands(grid, i, j))
					islands++;
			}
		}
		return islands;
    }
	
	public boolean getClosedIslands(int[][] grid, int x, int y)
	{
		if(grid[x][y]==1 || grid[x][y]==2)
			return true;
		
		if(x==0 || x==grid.length-1 || y==0 || y==grid[0].length-1)
			return false;
        
		grid[x][y]=2;
		boolean left = getClosedIslands(grid,x, y-1);
		boolean right = getClosedIslands(grid,x, y+1);
	    boolean up = getClosedIslands(grid,x-1, y);
	    boolean down = getClosedIslands(grid,x+1, y);
	      
	    return left && right && up && down;
	}
	
	public static void main(String[] args)
	{
		NumberOfClosedIslands ci = new NumberOfClosedIslands();
		int[][] grid = new int[][] {
			{1,1,1,1,1,1,1,0},
	        {1,0,0,0,0,1,1,0},
	        {1,0,1,0,1,1,1,0},
	        {1,0,0,0,0,1,0,1},
	        {1,1,1,1,1,1,1,0}
		};
		
		System.out.println(ci.closedIsland(grid));
		
	}
}


