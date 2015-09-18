package uba.algo3.utils.tests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import uba.algo3.tp2.ejercicio1.Floor;
import uba.algo3.utils.LineParser;

public class LineParserTest {

	@Test
	public void onePortalTest() {
		String line = "0 10";
		Floor[] expectedNodesArray = new Floor[11];
		expectedNodesArray[0] = new Floor(0);
		expectedNodesArray[0].addAdjacencyNode(10);
		expectedNodesArray[10] = new Floor(10);
		
		Floor[] nodes = new Floor[11];
		LineParser.parseExercise1(line, nodes);
		
		assertArrayEquals(expectedNodesArray, nodes);

	}
	
	@Test
	public void manyPortalsTest(){
		String line = "0 5; 1 6; 1 7; 5 9";
		
		Floor[] expectedNodesArray = new Floor[10];
		expectedNodesArray[0] = new Floor(0);
		expectedNodesArray[0].addAdjacencyNode(5);
		expectedNodesArray[1] = new Floor(1);
		expectedNodesArray[1].addAdjacencyNode(6);
		expectedNodesArray[1].addAdjacencyNode(7);
		expectedNodesArray[5] = new Floor(5);
		expectedNodesArray[5].addAdjacencyNode(9);
		expectedNodesArray[6] = new Floor(6);
		expectedNodesArray[7] = new Floor(7);
		expectedNodesArray[9] = new Floor(9);
		
		Floor[] nodes = new Floor[10];
		LineParser.parseExercise1(line, nodes);
		
		assertArrayEquals(expectedNodesArray, nodes);
	}

}
