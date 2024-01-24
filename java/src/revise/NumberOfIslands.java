package revise;

public class NumberOfIslands 
{
	public static int numIslands(char[][] grid) 
	{
		int numIslands=0;
		for(int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid[0].length;j++)
			{
				if(grid[i][j]=='1')
					numIslands+=callBFS(grid, i, j);
					
			}
		}
		return numIslands;
	}
	
	public static int callBFS(char[][] grid, int i, int j)
	{
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0')
			return 0;
		else
		{
			grid[i][j]='0';
			callBFS(grid, i+1, j);
			callBFS(grid, i-1, j);
			callBFS(grid, i, j+1);
			callBFS(grid, i, j-1);
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
										
		System.out.println(NumberOfIslands.numIslands(landscape));
		
	}
}
