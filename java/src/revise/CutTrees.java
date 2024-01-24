package revise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CutTrees {
	public int cutOffTree(List<List<Integer>> forest) {
        int rows = forest.size();
        int cols = forest.get(0).size();
        int steps=0;
        int[][] forr = new int[rows][cols];
        int min_val=Integer.MAX_VALUE;
        int[] start = new int[2];
        for(int i=0;i<rows;i++)
        	for(int j=0;j<cols;j++)
        	{
        		min_val = Math.min(min_val, forest.get(i).get(j));
        		forr[i][j]=forest.get(i).get(j);
        	}
        
        System.out.println("min_val : "+min_val);
        int trees = 0;
        for(List<Integer> row: forest)
            for(int cell : row)
                if(cell!=0 && cell!=1)
                    trees++;
        
        Queue<List<Integer>> q = new LinkedList<List<Integer>>();
        q.add(Arrays.asList(0,0));
        
        int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};

        while(!q.isEmpty())
        {
        	int size = q.size();
        	for(int i=0;i<size;i++)
        	{
        		List<Integer> curr = q.poll();
        		for(int[] d : directions)
        		{
        			int x = curr.get(0)+d[0];
        			int y = curr.get(1)+d[1];
        			
        			if(x>=0 && x<rows && y>=0 && y<cols && forr[x][y]!=0 && forr[x][y]!=1)
        			{
        				if(forr[curr.get(0)][curr.get(1)]<forr[x][y])
        				{
        					q.add(Arrays.asList(x,y));
        					forr[curr.get(0)][curr.get(1)]=1;
        					steps++;
        					trees--;
        				}	
        				
        			}
        		}
        	}
        }
        return trees==0?steps:-1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CutTrees ct = new CutTrees();
//		Input: forest = [[1,2,3],[0,0,4],[7,6,5]]
//				Output: 6
//		System.out.println(ct.cutOffTree(Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(0,0,4), Arrays.asList(7,6,5))));
		
//		Input: forest = [[2,3,4],[0,0,5],[8,7,6]]
//				Output: 6
		System.out.println(ct.cutOffTree(Arrays.asList(	 Arrays.asList(54581641,64080174,24346381,69107959), 
														 Arrays.asList(86374198,61363882,68783324,79706116), 
														 Arrays.asList(668150,92178815,89819108,94701471),
														 Arrays.asList(83920491,22724204,46281641,47531096),
														 Arrays.asList(89078499,18904913,25462145,60813308)
													 )));
	}

}
