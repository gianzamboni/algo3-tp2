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
		
		for (Integer i = 0; i < floors+1; i++)
			this.floors[i] = new Floor(i);
		
		LineParser.parseExercise1(line, this.floors);
	}


	public Integer getMaxDistanceToLastFloor() {
		
		// Cada floor tiene una lista
		// Copiar esas listas termina siendo de orden cuadratico.
		// asi podemos correr varias veces el metodo.
		//Floor[] _floors = new Floor[this.floors.length];
 		//System.arraycopy(this.floors, 0, _floors, 0, this.floors.length);
 		
		
		// recorremos cada piso del edificio
		for(Floor floor : floors){
			// Si el piso es alcanzable desde el 0
			if (floor.isReachable()){
				// Recorremos sus pisos adyacentes (superiores)
				for(Integer nextFloor : floor.getAdjacentFloors()){
					// la distancia desde aqui al siguiente, es moverse + 1
					Integer distance = floor.getMaxDistanceToLowLevel() + 1;
					// si mejoro la distancia la seteo.
					if(distance > floors[nextFloor].getMaxDistanceToLowLevel()) {
						floors[nextFloor].setMaxDistanceToLowLevel(distance);
					}
					
					// marco el piso como alcanzable desde 0.
					floors[nextFloor].setReachable(true);
				}
			}
		}
		
		
		Integer res = floors[floorNumber].getMaxDistanceToLowLevel();
		
		
		// reseteamos los valores para poder ejecutarlo varias veces seguidas.
		// O(N)
		for(Floor floor : floors){
			floor.setReachable(false);
			floor.setMaxDistanceToLowLevel(0);
		}
		
		floors[0].setReachable(true);
		return res;
		
	}

}
