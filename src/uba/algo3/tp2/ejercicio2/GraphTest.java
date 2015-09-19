package uba.algo3.tp2.ejercicio2;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class GraphTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testBFS() {
		List<Integer>[] adyacencias = (LinkedList<Integer>[]) new LinkedList[11];
		for(int i = 0; i < 11; i++){
			adyacencias[i] = new LinkedList<Integer>();
		}
		
		adyacencias[0].add(1);
		adyacencias[0].add(2);
		adyacencias[0].add(3);
		
		adyacencias[1].add(0);
		adyacencias[1].add(4);
		
		adyacencias[2].add(0);
		adyacencias[2].add(8);
		
		adyacencias[3].add(0);
		adyacencias[3].add(5);
		adyacencias[3].add(6);
		
		adyacencias[4].add(5);
		adyacencias[4].add(1);
		
		adyacencias[5].add(3);
		adyacencias[5].add(4);
		
		adyacencias[6].add(9);
		adyacencias[6].add(7);
		adyacencias[6].add(3);
		
		adyacencias[7].add(8);
		adyacencias[7].add(6);
		
		adyacencias[8].add(10);
		adyacencias[8].add(2);
		
		adyacencias[9].add(10);
		adyacencias[9].add(6);
		
		adyacencias[10].add(8);
		adyacencias[10].add(9);
		
		Graph grafo = new Graph(adyacencias);
		
		Integer[] res = grafo.BFS();
		Integer[] distancias = {0,1,1,1,2,2,2,3,2,3,3};
		assertEquals(res, distancias);
	}

}
