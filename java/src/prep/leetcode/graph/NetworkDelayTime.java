package prep.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, ArrayList<Integer[]>> graph = new HashMap<Integer, ArrayList<Integer[]>>();
        for(int[] t : times)
        {
        	int source = t[0];
        	int dest = t[1];
        	int time = t[2];
        	
        	ArrayList<Integer[]> nbrs;
        	if(graph.containsKey(source))
        		nbrs = graph.get(source);
        	else
        		nbrs = new ArrayList<Integer[]>();
        	
        	nbrs.add(new Integer[] {dest, time});
    		graph.put(source, nbrs);
        }
        
        int minTime = Integer.MAX_VALUE;
        HashSet<Integer> visited = new HashSet<Integer>();
        Queue<Integer[]> minQue = new PriorityQueue<Integer[]>((a,b)->a[1]-b[1]);
        minQue.add(new Integer[] {k,0});
        
        while(!minQue.isEmpty())
        {
            Integer[] curr = minQue.poll();
            int currVal = curr[0], currTime = curr[1];
            
            if(visited.contains(currVal)) 
            	continue;
            
            minTime = currTime;
            visited.add(currVal);
            if(!graph.containsKey(currVal)) 
            	continue;
            
            for(Integer[] node : graph.get(currVal)){
                int nodeVal = node[0], nodeTime = node[1];
                minQue.add(new Integer[]{nodeVal, currTime + nodeTime });
            }
        }
        
        return visited.size()==n?minTime:-1;
    }

	public static void main(String[] args) {
		NetworkDelayTime ndt = new NetworkDelayTime();
//		int[][] times = new int[][] {{2,1,1},{2,3,1},{3,4,1}};
		int[][] times = new int[][] {{1,2,1},{2,3,2},{1,3,4}};
		System.out.println(ndt.networkDelayTime(times, 3, 1));

	}

}
