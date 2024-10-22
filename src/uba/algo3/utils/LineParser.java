package uba.algo3.utils;

import uba.algo3.tp2.ejercicio1.Floor;

public class LineParser {
	public static void parseExercise1(String line, Floor[] nodes){
		String[] tuples = line.split("; ");
		
		for(String tuple : tuples) {
			String[] portals = tuple.split(" ");
			int firstPortalId = Integer.parseInt(portals[0]);
			int secondPortalId = Integer.parseInt(portals[1]);
					
			nodes[firstPortalId].addAdjacentFloor(secondPortalId);
		}
	}
	
}
