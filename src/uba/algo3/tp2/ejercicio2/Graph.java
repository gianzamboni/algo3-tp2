package uba.algo3.tp2.ejercicio2;

import java.util.LinkedList;
import java.util.List;

public class Graph {
	private List<Integer>[] edgesByNode;

	public List<Integer>[] getNodos() {
		return edgesByNode;
	}

	public void setNodos(List<Integer>[] nodos) {
		this.edgesByNode = nodos;
	}

	@SuppressWarnings("unchecked")
	public Graph(Integer k){
		this.edgesByNode = (LinkedList<Integer>[]) new LinkedList[k];
		for(int i = 0; i < k; i++){
			this.edgesByNode[i] = new LinkedList<Integer>();
		}
		
	}
	public Graph(List<Integer>[] nodos) {
		this.edgesByNode = nodos;
	}
	
	

}
