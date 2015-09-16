package uba.algo3.utils.tests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import uba.algo3.tp2.ejercicio1.Node;
import uba.algo3.utils.LineParser;

public class LineParserTest {

	@Test
	public void onePortalTest() {
		String line = "0 10";
		Node[] expectedNodesArray = new Node[11];
		expectedNodesArray[0] = new Node(0);
		expectedNodesArray[0].addAdjacencyNode(10);
		expectedNodesArray[10] = new Node(10);
		
		Node[] nodes = new Node[11];
		LineParser.parseExercise1(line, nodes);
		
		assertArrayEquals(expectedNodesArray, nodes);

	}
	
	@Test
	public void manyPortalsTest(){
		String line = "0 5; 1 6; 1 7; 5 9";
		
		Node[] expectedNodesArray = new Node[10];
		expectedNodesArray[0] = new Node(0);
		expectedNodesArray[0].addAdjacencyNode(5);
		expectedNodesArray[1] = new Node(1);
		expectedNodesArray[1].addAdjacencyNode(6);
		expectedNodesArray[1].addAdjacencyNode(7);
		expectedNodesArray[5] = new Node(5);
		expectedNodesArray[5].addAdjacencyNode(9);
		expectedNodesArray[6] = new Node(6);
		expectedNodesArray[7] = new Node(7);
		expectedNodesArray[9] = new Node(9);
		
		Node[] nodes = new Node[10];
		LineParser.parseExercise1(line, nodes);
		
		assertArrayEquals(expectedNodesArray, nodes);
	}

}
