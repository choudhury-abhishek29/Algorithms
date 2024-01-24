package prep.leetcode;

public class MaxAreaIsland 
{
	public static int maxAreaOfIsland(char[][] grid) 
	{
		int max_area=0;
		for(int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid[i].length;j++)
			{
				if(grid[i][j]=='1')
				{
					max_area=Math.max(max_area, callBFS(grid,i,j));
				}
			}
		}
		
		return max_area;
		
        
    }
	
	public static int callBFS(char[][] grid, int i, int j)
	{
		
		if(i<0||i>=grid.length||j<0||j>=grid[i].length||grid[i][j]=='0')
			return 0;
		else
		{
			grid[i][j]='0';
			return 1+callBFS(grid,i+1,j)+callBFS(grid,i-1,j)+callBFS(grid,i,j-1)+callBFS(grid,i,j+1);
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
										
		System.out.println(MaxAreaIsland.maxAreaOfIsland(landscape));
		
	}

}
