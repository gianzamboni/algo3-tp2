package uba.algo3.tp2.ejercicio3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	private ArrayList<Edge> edges;

	private Integer nodos;

	public Integer getNodos() {
		return nodos;
	}

	public void setNodos(Integer nodos) {
		this.nodos = nodos;
	}
	
	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge> e) {
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
	public Graph(Integer m, Integer nodos){
		this.edges = new ArrayList<Edge>(m);
		this.nodos = nodos;
	}

	public Graph(ArrayList<Edge> lista, Integer nodos){
		//El grafo se vuelve totalmente independiente del pabelló
		this.edges = new ArrayList<Edge>(lista.size());
		for (Integer i = 0; i < lista.size(); i++)
			edges.add(new Edge(lista.get(i).nodo1(),lista.get(i).nodo2(), lista.get(i).peso()));

		this.nodos = nodos;
	}
			
	public Integer kruskal()
	{
		ArrayList<Edge> E = edges;
		List<Edge> T = new LinkedList<Edge>();
		
		//ordeno aristas
		Collections.sort(E, Collections.reverseOrder()); //O(MlogM)
		
		int i = 0;
		  
		int costo = 0;
		// crear n componentes conexas (una para cada nodo)
		UnionFind componentes = new UnionFind(nodos); //O(nodos)

		while ( T.size() < nodos -1 )
		{
			Edge e = E.get(i);
			if(!componentes.isSameSet(e.nodo1(), e.nodo2())) 
			{ // si no pertenecen a la misma componente conexa
				T.add(e); //O(1)
				componentes.unionSet(e.nodo1(), e.nodo2());
				costo = costo + e.peso();
			} 
			i++;
		}
	
		return costo;

	}
}
