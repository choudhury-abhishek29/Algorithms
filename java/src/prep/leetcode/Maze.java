package prep.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {
	
	public boolean hasPath(int[][] maze, Integer[] start, Integer[] destination) 
	{
		int rows=maze.length;
		int cols=maze[0].length;
		boolean[][] visited = new boolean[rows][cols];
		int[][] directions = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
		Queue<Integer[]> q = new LinkedList<Integer[]>();
		q.offer(start);
		
		visited[start[0]][start[1]]=true;
		
		while(!q.isEmpty())
		{
			Integer[] curr = q.poll();
			
			if(curr[0]==destination[0] && curr[1]==destination[1])
				return true;
			else
			{
				for(int[] d : directions)
				{
					int x=d[0]+curr[0];
					int y=d[1]+curr[1];
					while(x>=0 && x<maze.length && y>=0 && y<maze[0].length && maze[x][y]==0)
					{
						x+=d[0];
						y+=d[1];
					}
					x-=d[0];
					y-=d[1];
					
					if(!visited[x][y])
					{
						q.offer(new Integer[] {x,y});
						visited[x][y]=true;
						
					}
				}
			}
		}
		
		
		return false;
    }
	
	
	public static void main(String[] args)
	{
		
		Maze m = new Maze();
		int[][] maze = new int[][] {
										{0,0,1,0,0},
										{0,0,0,0,0},
										{0,0,0,1,0},
										{1,1,0,1,1},
										{0,0,0,0,0}
									};
		
		System.out.println(m.hasPath(maze, new Integer[] {0,4}, new Integer[] {3,2}));
		
	}

}
