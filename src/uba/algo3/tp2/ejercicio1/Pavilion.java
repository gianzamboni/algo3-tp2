package uba.algo3.tp2.ejercicio1;

import uba.algo3.utils.LineParser;

public class Pavilion {
	
	private Integer floors;
	private Node[] portals;
	
	public Integer getFloors() {
		return floors;
	}


	public void setFloors(Integer floors) {
		this.floors = floors;
	}


	public Node[] getPortals() {
		return portals;
	}


	public void setPortals(Node[] portals) {
		this.portals = portals;
	}
	
	public Pavilion(Integer floors, String line) {
		this.floors = floors;
		this.portals = new Node[floors+1];
		LineParser.parseExercise1(line, this.portals);
	}


	public Integer getMaxDistanceToLastFloor() {
		
		for(int i = 0; i <= floors; i++){
			if(portals[i] != null){
				for(Integer nodeId : portals[i].getAdjacencyNodes()){
					Integer distance = portals[i].getMaxDistanceToLowLevel() + 1;
					if(distance > portals[nodeId].getMaxDistanceToLowLevel()) {
						portals[nodeId].setMaxDistanceToLowLevel(distance);
					}
				}	
			}
		}
		
		return portals[floors].getMaxDistanceToLowLevel();
		
	}

}
