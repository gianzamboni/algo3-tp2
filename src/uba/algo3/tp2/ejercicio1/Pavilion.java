package uba.algo3.tp2.ejercicio1;

import uba.algo3.utils.LineParser;

public class Pavilion {
	
	private Integer floorNumber;
	private Floor[] floors;
	
	public Integer getFloorNumber() {
		return floorNumber;
	}


	public void setFloorNumber(Integer floors) {
		this.floorNumber = floors;
	}


	public Floor[] getFloors() {
		return floors;
	}


	public void setFloors(Floor[] portals) {
		this.floors = portals;
	}
	
	public Pavilion(Integer floors, String line) {
		this.floorNumber = floors;
		this.floors = new Floor[floors+1];
		LineParser.parseExercise1(line, this.floors);
	}


	public Integer getMaxDistanceToLastFloor() {
		
		for(int i = 0; i <= floorNumber; i++){
			if(floors[i] != null){
				for(Integer nodeId : floors[i].getAdjacencyNodes()){
					Integer distance = floors[i].getMaxDistanceToLowLevel() + 1;
					if(distance > floors[nodeId].getMaxDistanceToLowLevel()) {
						floors[nodeId].setMaxDistanceToLowLevel(distance);
					}
				}	
			}
		}
		
		return floors[floorNumber].getMaxDistanceToLowLevel();
		
	}

}
