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
		Node[] nodes = new Node[floors];
		LineParser.parseExercise1(line, nodes);
	}


	public Integer getMaxDistanceToLastFloor() {
		
		for(int i = 0; i < floors; i++){
			if(portals[i] != null){
				for(Integer nodeId : portals[i].getAdjacencyNodes()){
					portals[nodeId].setMaxDistanceToLowLevel(portals[i].getMaxDistanceToLowLevel() + 1);
				}	
			}
		}
		
		return portals[floors-1].getMaxDistanceToLowLevel();
		
	}

}
