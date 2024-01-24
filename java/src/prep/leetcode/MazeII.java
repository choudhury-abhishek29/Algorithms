package prep.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MazeII 
{
	private int[][] directions = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int rows=maze.length;
        int cols=maze[0].length;

        int[][] distance = new int[rows][cols];
        for(int i=0;i<rows;i++)
            Arrays.fill(distance[i], Integer.MAX_VALUE);

        boolean[][] visited = new boolean[rows][cols];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        pq.offer(new int[]{start[0], start[1], 0});

        while(!pq.isEmpty())
        {
            int size = pq.size();
            for(int i=0;i<size;i++)
            {
                int[] curr = pq.poll();
                int curr_dist = curr[2];
                visited[curr[0]][curr[1]]=true;

                if(curr[0]==destination[0] && curr[1]==destination[1])
                    return curr_dist;

                for(int[] dir : directions)
                {
                    int x=curr[0];
                    int y=curr[1];
                    int curr_steps=0;

                    while(x+dir[0]>=0 && x+dir[0]<rows && y+dir[1]>=0 && y+dir[1]<cols && maze[x+dir[0]][y+dir[1]]==0)
                    {
                        x += dir[0];
                        y += dir[1];
                        curr_steps++;
                    }

                    if(curr_dist + curr_steps < distance[x][y])
                    {
                        distance[x][y]=curr_dist+curr_steps;
                        pq.offer(new int[]{x,y,distance[x][y]});
                    }
                }
            }
        }
        return -1;
    }
	
	public static void main(String[] args)
	{
		
		MazeII m = new MazeII();
		int[][] maze = new int[][] {
										{0,0,1,0,0},
										{0,0,0,0,0},
										{0,0,0,1,0},
										{1,1,0,1,1},
										{0,0,0,0,0}
									};
		
		System.out.println(m.shortestDistance(maze, new int[] {0,4}, new int[] {4,4}));
		
	}

}
