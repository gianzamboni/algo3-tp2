package uba.algo3.utils;

import uba.algo3.tp2.ejercicio1.Node;

public class LineParser {
	public static void parseExercise1(String line, Node[] nodes){
		String[] tuples = line.split("; ");
		for(String tuple : tuples) {
			String[] portals = tuple.split(" ");
			int firstPortalId = Integer.parseInt(portals[0]);
			int secondPortalId = Integer.parseInt(portals[1]);
			
			if(nodes[firstPortalId] == null){
				nodes[firstPortalId] = new Node(firstPortalId);
			}
			
			if(nodes[secondPortalId] == null){
				nodes[secondPortalId] = new Node(secondPortalId);
			}
			
			nodes[firstPortalId].addAdjacencyNode(secondPortalId);
		}
	}
	
}
