package uba.algo3.tp2.ejercicio2;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class PavilionTest {

	@Test
	public void testPab1() {
		
		Portal p1 = new Portal(0, 10, 10, 1);
		Pavilion pab1 = new Pavilion(11, 10);
		pab1.setPortal(p1);
		
		Graph actual = pab1.toGraph();
		Graph exp = new Graph(11*10 + 1);
		for(int i = 1; i < 11*10 ; i++) // lleno las posiciones conectadas caminando
		{
			if(i % 10 != 0)
			{	
				exp.addEdge(i-1, i);
			}
		}
		
		exp.addEdge(10, 11*10);
		exp.addEdge(101, 11*10);

		assertEquals(exp, actual);
	}
	
	@Test
	public void testPab2(){

		/*Portal p2 = new Portal(0, 1, 1, 2);
		Portal p3 = new Portal(1, 2, 3, 1);
		Portal p4 = new Portal(2, 3, 4, 0);
		Portal p5 = new Portal(3, 4, 2, 1);
		Pavilion pab2 = new Pavilion(5,4);
		LinkedList<Portal> portalesPab2 = new LinkedList<Portal>();
		portalesPab2.add(p2);
		portalesPab2.add(p3);
		portalesPab2.add(p4);
		portalesPab2.add(p5);
		pab2.setPortales(portalesPab2);
		*/
	}
	
	@Test
	public void testPab3(){

		/*Portal p6 = new Portal(0, 2, 2, 3);
		Portal p7 = new Portal(2, 4, 3, 2);
		Portal p8 = new Portal(3, 1, 4, 5);
		Portal p9 = new Portal(4, 3, 5, 2);
		Pavilion pab3 = new Pavilion(6,5);
		LinkedList<Portal> portalesPab3 = new LinkedList<Portal>();
		portalesPab3.add(p6);
		portalesPab3.add(p7);
		portalesPab3.add(p8);
		portalesPab3.add(p9);
		pab3.setPortales(portalesPab3);
		*/
	}

}
