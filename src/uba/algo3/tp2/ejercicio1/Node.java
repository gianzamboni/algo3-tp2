package uba.algo3.tp2.ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class Node {
	
	private Integer id;
	private List<Integer> adjacencyNodes;
	private Integer maxDistanceToLowLevel;
	
	public Node(Integer id){
		this.id = id;
		this.adjacencyNodes = new LinkedList<Integer>();
		this.maxDistanceToLowLevel = 0;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Integer> getAdjacencyNodes() {
		return adjacencyNodes;
	}

	public void setAdjacencyNodes(List<Integer> adjacencyNodes) {
		this.adjacencyNodes = adjacencyNodes;
	}

	public Integer getMaxDistanceToLowLevel() {
		return maxDistanceToLowLevel;
	}

	public void setMaxDistanceToLowLevel(Integer maxDistanceToLowLevel) {
		this.maxDistanceToLowLevel = maxDistanceToLowLevel;
	}

	public void addAdjacencyNode(Integer nodeId){
		this.adjacencyNodes.add(nodeId);
	}
	
	
}
