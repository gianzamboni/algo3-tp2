package uba.algo3.tp2.ejercicio1;

import uba.algo3.utils.LineParser;

public class Pavilion {
	
	private Integer floorNumber;
	private Floor[] portals;
	
	public Integer getFloorNumber() {
		return floorNumber;
	}


	public void setFloorNumber(Integer floors) {
		this.floorNumber = floors;
	}


	public Floor[] getFloors() {
		return portals;
	}


	public void setFloors(Floor[] portals) {
		this.portals = portals;
	}
	
	public Pavilion(Integer floors, String line) {
		this.floorNumber = floors;
		this.portals = new Floor[floors+1];
		LineParser.parseExercise1(line, this.portals);
	}


	public Integer getMaxDistanceToLastFloor() {
		
		for(int i = 0; i <= floorNumber; i++){
			if(portals[i] != null){
				for(Integer nodeId : portals[i].getAdjacencyNodes()){
					Integer distance = portals[i].getMaxDistanceToLowLevel() + 1;
					if(distance > portals[nodeId].getMaxDistanceToLowLevel()) {
						portals[nodeId].setMaxDistanceToLowLevel(distance);
					}
				}	
			}
		}
		
		return portals[floorNumber].getMaxDistanceToLowLevel();
		
	}

}
