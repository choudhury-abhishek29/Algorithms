package test;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectedProvinces {
	public int findCircleNum(int[][] grid) {
        boolean[] visited = new boolean[grid.length];
        int c=0;
        for(int i=0;i<grid.length;i++) {
            if(!visited[i]) {
                bfs(i,grid,visited);
                c++;
            }
        }
        return c;
    }

    private void bfs(int s,int[][] grid,boolean[] visited) {
        visited[s]=true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()) {
            int j = queue.poll();
            for(int i=0;i<grid[j].length;i++) {
                if(!visited[i] && grid[j][i]==1) {
                    visited[i]=true;
                    queue.add(i);
                }
            }
        }
    }
    
    public static void main(String[] args)
    {
    	ConnectedProvinces cp = new ConnectedProvinces();
    	int[][] provinces = new int[][] {
    		 {1,0,0,1},
	    	 {0,1,1,0},
	    	 {0,1,1,1},
	    	 {1,0,1,1}
    	};
    	
    	System.out.println(cp.findCircleNum(provinces));
    }

}
