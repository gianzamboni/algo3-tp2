package uba.algo3.tp2.ejercicio3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
	private List<Arista> edges;

	public List<Arista> getEdges() {
		return edges;
	}

	public void setEdges(List<Arista> e) {
		this.edges = e;
	}
	
	public void addEdge(Arista a)
	{
		edges.add(a);
	}
	
	public boolean hasEdge(Arista a)
	{
		return edges.contains(a);
	}
	
	// nos importa que tengan las mismas aristas pero en el mismo orden
	@Override
	public boolean equals(Object other){
		if(other == null){
			return false;
		} 
		else if(other == this){
			return true;
		} 
		else if (!(other instanceof Graph)) {
			return false;
		}
		
		Graph otherGraph = (Graph) other;
		
		if (otherGraph.getEdges().size() != edges.size())
			return false;
		
		for (Arista a : edges)
		{
			if (!otherGraph.hasEdge(a))
				return false;
		}
		
		return true;	
	}

	
	/*@Override
	public String toString(){
		StringBuilder result = new StringBuilder();
	    result.append("Graph[\n");
	    for(int i = 0; i < edgesByNode.length; i++){
	    	result.append("\tNode = " + i + "; ");
	    	result.append("Adjacency nodes = " + this.edgesByNode[i].toString());
	    	result.append("\n");
	    	
	    }
	    result.append("]");
	    result.append("\n");

	    return result.toString();
	}*/
	
	@SuppressWarnings("unchecked")
	public Graph(){
		edges = new LinkedList<Arista>();
	}

	public Graph(List<Arista> lista){
		this.edges = lista;
	}
	
		
	Integer kruskal()
	{
		return 0;
	}
}
