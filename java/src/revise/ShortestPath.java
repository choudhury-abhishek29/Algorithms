package revise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPath {
	public List<List<Integer>> findPath(char[][] landscape)
	{
		int rows = landscape.length;
		int cols = landscape[0].length;
		List<List<Integer>> path = new ArrayList<List<Integer>>();
		Queue<List<Integer>> q = new LinkedList<List<Integer>>();
		q.offer(Arrays.asList(0,0));
		int[][] directions = new int[][] {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
		
		while(!q.isEmpty())
		{
			int size=q.size();
			
			for(int i=0;i<size;i++)
			{
				List<Integer> curr = q.poll();
				for(int[] dir : directions)
				{
					int x=curr.get(0)+dir[0];
					int y=curr.get(1)+dir[1];
					if(x>=0 && x<rows && y>=0 && y<cols && landscape[x][y]=='0')
					{
						path.add(Arrays.asList(x,y));
						q.offer(Arrays.asList(x,y));
						landscape[curr.get(0)][curr.get(1)]='1';
					}
					
				}
			}
		}
		
		return path;
	}

	public static void main(String args[])
	{
		ShortestPath sp = new ShortestPath();
		char[][] landscape = new char[][] {
											{'0','0','1','1','1'},
											{'1','0','0','1','1'},
											{'1','1','0','1','1'},
											{'1','1','0','0','0'}
										};
		
		for(List<Integer> node : sp.findPath(landscape))
		{
			System.out.println("["+node.get(0)+","+node.get(1)+"]");
		}
//		System.out.println(sp.findPath(landscape));
		
	}

}
