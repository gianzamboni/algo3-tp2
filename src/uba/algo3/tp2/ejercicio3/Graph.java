package uba.algo3.tp2.ejercicio3;

import java.util.LinkedList;
import java.util.List;

public class Graph {
	private List<Edge> edges;

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> e) {
		this.edges = e;
	}
	
	public void addEdge(Edge a)
	{
		edges.add(a);
	}
	
	public boolean hasEdge(Edge a)
	{
		return edges.contains(a);
	}
	
	// nos importa que tengan las mismas aristas pero en el mismo orden
	// la complejidad de la comparación sera O(M)
	// igual para el contexto del problema jamas comparamos grafos
	// solo en los tests.
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
		
		for (Edge a : edges)
		{
			if (!otherGraph.hasEdge(a))
				return false;
		}
		
		return true;	
	}
	
	@SuppressWarnings("unchecked")
	public Graph(){
		edges = new LinkedList<Edge>();
	}

	public Graph(List<Edge> lista){
		this.edges = lista;
	}
			
	Integer kruskal()
	{
		return 0;
	}
}
