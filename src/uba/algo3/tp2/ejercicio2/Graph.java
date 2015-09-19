package uba.algo3.tp2.ejercicio2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

	public Graph(LinkedList<Integer>[] lista){
		this.edgesByNode = lista;
	}
	
	public Graph(List<Integer>[] nodos) {
		this.edgesByNode = nodos;
	}
	//Retorna el arreglo con todas las distacias minimas de todos los nodos empezando por el nodo 0
	public Integer[] BFS(){
		Integer[] distancias = new Integer[edgesByNode.length]; 
		Queue<Integer> cola = new LinkedList<Integer>(); //En la cola se guarda el index de cada nodo del grafo
		for(int i =1;i<distancias.length ; i++){
			distancias[i]=-1;
			//Inicializamos el arreglo con un valor de distancia "Infinito" para saber cuáles fueron calculados
		}
		distancias[0]=0;//el inicial es 0
		cola.add(0);
		while(!cola.isEmpty()){//Mientras haya vecinos sigo recorriendo
			int nodo = cola.poll();
			int dist = distancias[nodo] + 1;
			for(Integer vecino : edgesByNode[nodo])//recorro los vecinos del nodo en el grafo
			{
				if(distancias[vecino] == -1){//sino calcule la distancia, la calculo y lo encolo
					cola.add(vecino);
					distancias[vecino]=dist;
				}
			}
		}
		
		return distancias;
	}
	

}
