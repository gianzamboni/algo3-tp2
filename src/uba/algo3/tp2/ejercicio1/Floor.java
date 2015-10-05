package uba.algo3.tp2.ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class Floor {
	
	private Integer id;
	// a que otros pisos puedo ir desde aqui
	private List<Integer> adjacencyNodes;
	// cantidad maxima de portales que puedo tomar para llegar aqui
	private Integer maxDistanceToLowLevel;
	// indica si el piso es alcanzanble desde el piso 0
	private boolean reachable;
	
	public Floor(Integer id){
		this.id = id;
		this.adjacencyNodes = new LinkedList<Integer>();
		this.maxDistanceToLowLevel = 0;
		
		if (id == 0)
			this.reachable = true;
	}
	
	public boolean isReachable() {
		return reachable;
	}

	public void setReachable(boolean reachable) {
		this.reachable = reachable;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Integer> getAdjacentFloors() {
		return adjacencyNodes;
	}

	public void setAdjacentFloors(List<Integer> adjacencyNodes) {
		this.adjacencyNodes = adjacencyNodes;
	}

	public Integer getMaxDistanceToLowLevel() {
		return maxDistanceToLowLevel;
	}

	public void setMaxDistanceToLowLevel(Integer maxDistanceToLowLevel) {
		this.maxDistanceToLowLevel = maxDistanceToLowLevel;
	}

	public void addAdjacentFloor(Integer nodeId){
		this.adjacencyNodes.add(nodeId);
	}
	
	@Override
	public String toString(){
		StringBuilder result = new StringBuilder();
	    result.append("Node[ ");
	    result.append("Id=" + this.id + "; ");
	    result.append("AdyacencyNode=" + this.adjacencyNodes + "; ");
	    result.append("MaxDistanceToLowLevel=" + this.maxDistanceToLowLevel + " ");
	    result.append("]");

	    return result.toString();
	}
	
	@Override
	public boolean equals(Object other){
		if(other == null){
			return false;
		} 
		else if(other == this){
			return true;
		} 
		else if (!(other instanceof Floor)) {
			return false;
		}
		
		Floor otherNode = (Floor) other;
		return this.id.equals(otherNode.getId()) 
				&& this.adjacencyNodes.equals(otherNode.getAdjacentFloors()) 
				&& this.maxDistanceToLowLevel.equals(otherNode.getMaxDistanceToLowLevel()); 
		
	}
	
}
