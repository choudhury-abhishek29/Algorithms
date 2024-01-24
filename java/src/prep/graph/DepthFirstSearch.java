package prep.graph;

import java.util.Arrays;
import java.util.Stack;

public class DepthFirstSearch<E> {
	public void traverse(Vertex start)
	{
		Stack<Vertex> stk = (Stack<Vertex>) new Stack<E>();
		stk.push(start);
		
		while(!stk.isEmpty())
		{
			Vertex current = stk.pop();
			System.out.println(current.getData());
			
				current.setVisited(true);
				for(Vertex n : current.getNeighbors())
				{
					if(!n.getVisited())
						stk.push(n);
					
				}
					
				
		}
		
	}
	
	public static void main(String[] args)
	{
		Vertex v0 = new Vertex("0");
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Vertex v6 = new Vertex("6");
		v0.setNeighbors(Arrays.asList(v1, v5, v6));
		v1.setNeighbors(Arrays.asList(v3, v4, v5));
		v4.setNeighbors(Arrays.asList(v2, v6));
		v6.setNeighbors(Arrays.asList(v0));
		
		DepthFirstSearch<String> dfs = new DepthFirstSearch<String>();
		dfs.traverse(v0);
	}

}
