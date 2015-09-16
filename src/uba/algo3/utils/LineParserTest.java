package uba.algo3.utils;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import uba.algo3.tp2.ejercicio1.Node;

public class LineParserTest {

	@Test
	public void onePortalTest() {
		String line = "0 10";
		Node[] nodes = new Node[11];
		
		LineParser.parseExercise1(line, nodes);
		
		List<Integer> expectedAdjancecyList = new LinkedList<Integer>();
		expectedAdjancecyList.add(10);
		
		assertEquals(Integer.valueOf(0), nodes[0].getId());
		assertEquals(expectedAdjancecyList, nodes[0].getAdjacencyNodes());
		assertEquals(Integer.valueOf(10), nodes[10].getId());
		assertEquals(true, nodes[10].getAdjacencyNodes().isEmpty());
		
		for(int i=1; i <10;i++){
			assertEquals(nodes[i], null);
		}
	}
	
	@Test
	public void manyPortalsTest(){
		String line = "0 5; 1 6; 1 7; 5 9";
		Node[] nodes = new Node[10];
		
		LineParser.parseExercise1(line, nodes);
		
		List<Integer> expectedAdjancecyList0 = new LinkedList<Integer>();
		expectedAdjancecyList0.add(5);
		
		List<Integer> expectedAdjancecyList1 = new LinkedList<Integer>();
		expectedAdjancecyList1.add(6);
		expectedAdjancecyList1.add(7);
		
		List<Integer> expectedAdjancecyList5 = new LinkedList<Integer>();
		expectedAdjancecyList5.add(9);
		
		assertEquals(Integer.valueOf(0), nodes[0].getId());
		assertEquals(expectedAdjancecyList0, nodes[0].getAdjacencyNodes());
		
		assertEquals(Integer.valueOf(1), nodes[1].getId());
		assertEquals(expectedAdjancecyList1, nodes[1].getAdjacencyNodes());
		
		
		assertEquals(Integer.valueOf(5),nodes[5].getId());
		assertEquals(expectedAdjancecyList5, nodes[5].getAdjacencyNodes());
		
		assertEquals(Integer.valueOf(6), nodes[6].getId());
		assertEquals(true, nodes[6].getAdjacencyNodes().isEmpty());
		

		assertEquals(nodes[7].getId(), Integer.valueOf(7));
		assertEquals(nodes[7].getAdjacencyNodes().isEmpty(), true);
		

		assertEquals(nodes[9].getId(), Integer.valueOf(9));
		assertEquals(nodes[9].getAdjacencyNodes().isEmpty(), true);
		
		for(int i=1; i <10;i++){
			if(i != 0 && i != 1 && i != 5 && i != 6 && i != 7 && i != 9){
				assertEquals(nodes[i], null);
			}
		}
		
	}

}
