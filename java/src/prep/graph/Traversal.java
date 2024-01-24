package prep.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal 
{
	public static void dfsIter(HashMap<String, String[]> adjacencyList, String start)
	{
		Stack<String> stk = new Stack<String>();
		stk.push(start);
		
		while(!stk.isEmpty())
		{
			String current = stk.pop();
			System.out.println(current);
			for(String neighbour : adjacencyList.get(current))
			{
				stk.push(neighbour);
			}
		}
	}
	
	public static void dfsRec(HashMap<String, String[]> adjacencyList, String start)
	{
		System.out.println(start);
		for(String neighbour : adjacencyList.get(start))
		{
			dfsRec(adjacencyList, neighbour);
		}
		
	}
	
	public static void bfsIter(HashMap<String, String[]> adjacencyList, String start)
	{
		Queue<String> que = new LinkedList<String>();
		que.add(start);
		 
		while(!que.isEmpty())
		{
			String current = que.remove();
			System.out.println(current);
			for(String neighbor : adjacencyList.get(current))
			{
				que.add(neighbor);
			}
		}
	}
	
	public static Boolean hasPathRec(HashMap<String, String[]> graph, String source, String dest)
	{
		Boolean result=false;
		
		if(source==dest)
			result=true;
		
		for(String neighbour : graph.get(source))
		{
			if(hasPathRec(graph, neighbour, dest))
				result=true;
		}
		
		return result;
	} 
	
	public static Boolean hasPathBfs(HashMap<String, String[]> graph, String source, String dest)
	{
//		Boolean result=false;
		Queue<String> que = new LinkedList<String>();
		que.add(source);
		
		while(!que.isEmpty())
		{
			String curr = que.remove();
			if(curr==dest)
				return true;
			
			for(String n : graph.get(curr))
			{
				que.add(n);
			}
			
		}
		return false;
	}
	
	public static void main(String args[])
	{
		HashMap<String, String[]> adjacencyList = new HashMap<String, String[]>();
		adjacencyList.put("a", new String[] {"b","c"});
		adjacencyList.put("b", new String[] {"d"});
		adjacencyList.put("c", new String[] {"e"});
		adjacencyList.put("d", new String[] {"f"});
		adjacencyList.put("e", new String[] {});
		adjacencyList.put("f", new String[] {});
		
//		Traversal.dfsIter(adjacencyList, "a");
//		System.out.println("------------");
		Traversal.dfsIter(adjacencyList, "a");
//		System.out.println("------------");
//		Traversal.bfsIter(adjacencyList, "a");
		
//		adjacencyList.put("f", new String[] {"g","i"});
//		adjacencyList.put("g", new String[] {"h"});
//		adjacencyList.put("h", new String[] {});
//		adjacencyList.put("i", new String[] {"g","k"});
//		adjacencyList.put("j", new String[] {"i"});
//		adjacencyList.put("k", new String[] {});
//		System.out.println(Traversal.hasPathRec(adjacencyList, "f", "h"));
//		System.out.println(Traversal.hasPathBfs(adjacencyList, "f", "h"));
		
		
		
	}
}
