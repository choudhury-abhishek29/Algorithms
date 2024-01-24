package prep.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	private final String data;
	private Boolean visited;
	private List<Vertex> neighbors = new ArrayList();
	
	public Vertex(String data)
	{
		this.data = data;
		visited=false;
		
	}
	
	public String getData() {
		return data;
	}

	public Boolean getVisited() {
		return visited;
	}

	public void setVisited(Boolean visited) {
		this.visited = visited;
	}

	public List<Vertex> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Vertex> neighbors) {
		this.neighbors = neighbors;
	}
	
}
