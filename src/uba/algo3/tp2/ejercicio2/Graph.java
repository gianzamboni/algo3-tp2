package uba.algo3.tp2.ejercicio2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
	//private List<Integer>[] edgesByNode;
	private ArrayList<List<Integer>> edgesByNode;
	
	public ArrayList<List<Integer>> getEdgesByNode() {
		return edgesByNode;

	}

	public void setEdgesByNode(ArrayList<List<Integer>> e) {
		this.edgesByNode = e;
	}
	
	public void addEdge(Integer from, Integer to)
	{
		edgesOf(from).add(to);
		edgesOf(to).add(from);
	}
	
	public List<Integer> edgesOf(Integer n)
	{
		return edgesByNode.get(n);
	}
	
	/*@Override
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
		
		Graph otherNode = (Graph) other;
		boolean res = edgesByNode[0].equals(otherNode.getEdgesByNode()[0]);
		for(int i = 1; i < edgesByNode.length; i++)
			res = res && edgesByNode[i].equals(otherNode.getEdgesByNode()[i]);
		return res;
		
	}*/

	
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
	public Graph(Integer k){
		this.edgesByNode = new ArrayList<List<Integer>>(k);
		for(int i = 0; i < k; i++){
			this.edgesByNode.add(i, new LinkedList<Integer>());
		}
		
	}

	public Graph(ArrayList<List<Integer>> lista){
		this.edgesByNode = lista;
	}
	
	//public Graph(List<Integer>[] nodos) {
	//	this.edgesByNode = nodos;
	//}
	
	// Retorna el arreglo con todas las distacias minimas de todos los nodos empezando por el nodo 0
	public ArrayList<Integer> BFS(){
		
		ArrayList<Integer> distancias = new ArrayList<Integer>(edgesByNode.size());

		Queue<Integer> cola = new LinkedList<Integer>(); //En la cola se guarda el index de cada nodo del grafo
		
		// O(#nodos)
		for(int i =0;i< edgesByNode.size() ; i++){
			distancias.add(i,-1);
			//Inicializamos el arreglo con un valor de distancia "Infinito" para saber cuáles fueron calculados
		}
		
		distancias.set(0, 0);//el inicial es 0
		cola.add(0);
		
		// El ciclo no pushea dos veces el mismo nodo
		// O(#nodos)
		while(!cola.isEmpty()){//Mientras haya vecinos sigo recorriendo
			int nodo = cola.poll();
			int dist = distancias.get(nodo) + 1;
			
			// O(#nodos)
			for(Integer vecino : edgesOf(nodo))//recorro los vecinos del nodo en el grafo
			{
				if(distancias.get(vecino) == -1){//sino calcule la distancia, la calculo y lo encolo
					cola.add(vecino);
					distancias.set(vecino, dist);
				}
			}
		}
		
		return distancias;
	}
	

}
