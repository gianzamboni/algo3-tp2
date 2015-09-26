package uba.algo3.tp2.ejercicio3;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Pavilion {
	
	private ArrayList<Edge> aristas;
	private Set<Integer> nodos;
	
	public boolean hasEdge(Edge e)
	{
		return aristas.contains(e);
	}
	
	public void addEdge(Edge e)
	{
		aristas.add(e);
		
		// a lo sumo n es igual a 2m.
		// "Cada vertice es una interseccion o un extremo donde termina un pasillo"
		// O(log n)
		nodos.add(e.nodo1());
		nodos.add(e.nodo2());
	}
	
	public ArrayList<Edge> getAristas() {
		return aristas;
	}

	public void setAristas(ArrayList<Edge> aristas) {
		this.aristas = aristas;
	}

	public Set<Integer> getNodos() {
		return nodos;
	}

	public void setNodos(Set<Integer> nodos) {
		this.nodos = nodos;
	}


	public Pavilion()
	{
		// nos sirve para ir contando las intersecciones.
		nodos = new TreeSet<Integer>();
		aristas = new ArrayList<Edge>();
	}
	
	public Graph toGraph() 
	{
		Graph grafo = new Graph(aristas, nodos.size());
		return grafo;
	}

	@Override
	public boolean equals(Object other){
		if(other == null){
			return false;
		} 
		else if(other == this){
			return true;
		} 
		else if (!(other instanceof Pavilion)) {
			return false;
		}
		
		Pavilion otherGraph = (Pavilion) other;

		if (otherGraph.getAristas().size() != getAristas().size())
			return false;
		
		if (otherGraph.getNodos().size() != getNodos().size())
			return false;
		
		for (Edge a : aristas)
		{
			if (!otherGraph.hasEdge(a))
				return false;
		}
		
		return true;
		
	}
}
