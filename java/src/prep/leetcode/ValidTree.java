package prep.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ValidTree {
	public boolean validTree(int n, int[][] edges) {
        // initialize adjacency list
        List<List<Integer>> adjList = new ArrayList<List<Integer>>(n);
        
        // initialize vertices
        for (int i = 0; i < n; i++)
            adjList.add(i, new ArrayList<Integer>());
        
        // add edges    
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        boolean[] visited = new boolean[n];
        
        // make sure there's no cycle
        if (hasCycle(adjList, 0, visited, -1))
            return false;
        
        // make sure all vertices are connected
        for (int i = 0; i < n; i++) {
            if (!visited[i]) 
                return false;
        }
        
        return true;
    }
    
    // check if an undirected graph has cycle started from vertex u
    boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, int parent) {
        visited[u] = true;
        
        for (int i = 0; i < adjList.get(u).size(); i++) {
            int v = adjList.get(u).get(i);
            
            if ((visited[v] && parent != v) || (!visited[v] && hasCycle(adjList, v, visited, u)))
                return true;
        }
        
        return false;
    }

	public static void main(String[] args) {
		ValidTree vt = new ValidTree();
		System.out.println(vt.validTree(5, new int[][] {{0,1},{0,2},{0,3},{1,4}}));
//		System.out.println(vt.validTree(5, new int[][] {{0,1},{1,2},{2,3},{1,3},{1,4}}));

	}

}
