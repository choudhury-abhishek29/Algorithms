package prep.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair
{
    int val = 0;
    int time = 0;
    Pair(int val,int time)
    {
        this.val = val;
        this.time = time;
    }
}

public class InformTime 
{	
	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);
        for(int i = 0;i<n;i++)
        {
            ArrayList<Integer> arr = new ArrayList<>();
            graph.add(arr);
        }
        int source = headID;
        for(int i = 0;i<n;i++)
        {
            if(manager[i]!=-1)
            {
                graph.get(manager[i]).add(i);
            }
        }
        
        int result = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(source,informTime[source]));
        while(queue.size() > 0)
        {
            Pair curr = queue.poll();
            for(int item : graph.get(curr.val))
            {
                queue.add(new Pair(item,curr.time+informTime[item]));
                result = Math.max(result,curr.time+informTime[item]);
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		InformTime it = new InformTime();
		System.out.println(it.numOfMinutes(11, 4, new int[] {5,9,6,10,-1,8,9,1,9,3,4}, new int[] {0,213,0,253,686,170,975,0,261,309,337}));
		//expected : 2560
	}

}
