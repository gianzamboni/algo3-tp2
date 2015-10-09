package uba.algo3.tp2.ejercicio2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class GraphTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testBFS() {
		ArrayList<List<Integer>> adyacencias = new ArrayList<List<Integer>>(11);
		for(int i = 0; i < 11; i++){
			adyacencias.add(i,new LinkedList<Integer>());
		}
		
		adyacencias.get(0).add(1);
		adyacencias.get(0).add(2);
		adyacencias.get(0).add(3);
		
		adyacencias.get(1).add(0);
		adyacencias.get(1).add(4);
		
		adyacencias.get(2).add(0);
		adyacencias.get(2).add(8);
		
		adyacencias.get(3).add(0);
		adyacencias.get(3).add(5);
		adyacencias.get(3).add(6);
		
		adyacencias.get(4).add(5);
		adyacencias.get(4).add(1);
		
		adyacencias.get(5).add(3);
		adyacencias.get(5).add(4);
		
		adyacencias.get(6).add(9);
		adyacencias.get(6).add(7);
		adyacencias.get(6).add(3);
		
		adyacencias.get(7).add(8);
		adyacencias.get(7).add(6);
		
		adyacencias.get(8).add(10);
		adyacencias.get(8).add(2);
		
		adyacencias.get(9).add(10);
		adyacencias.get(9).add(6);
		
		adyacencias.get(10).add(8);
		adyacencias.get(10).add(9);
		
		Graph grafo = new Graph(adyacencias);
		
		ArrayList<Integer> res = grafo.BFS();
		Integer[] distancias = {0,1,1,1,2,2,2,3,2,3,3};
		assertEquals(res, distancias);
	}

}
