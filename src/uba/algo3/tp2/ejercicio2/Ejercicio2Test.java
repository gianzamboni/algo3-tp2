package uba.algo3.tp2.ejercicio2;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.LinkedList;

import org.junit.Test;

import uba.algo3.tp2.ejercicio1.Ejercicio1;

public class Ejercicio2Test {

	void runCorridas(Integer testIdx, Integer iterations, Pavilion p)
 	{	
 		for (int i = 0; i < iterations; i++)
 			p.maxDistance();
 	}
	
	
	@Test 
	public void testPeorCaso() throws IOException {
		System.out.println("Memoria: " + java.lang.Runtime.getRuntime().maxMemory());
		Ejercicio2 ej = new Ejercicio2("Tp2Ej2PeorCaso");
		
		/*System.out.println("Imprimiendo caracteristicas:");
		for (Pavilion p : ej.getPavilions())
		{
			System.out.println("N: " + (p.getFloorNumber()-1));
			System.out.println("L: " + (p.getFloorLength()));
			System.out.println("P: " + (p.getPortales().size()));
		}*/
		
		Integer maxSize = 500;
		Integer initialSize = 100;
		Integer step = 50;
		Integer iterations = 400;
		Integer instanceId = 0;
		
		System.out.println("Peor caso");
		
		long time = 0;
		for (Integer n = initialSize; n <= maxSize; n = n + step)
		{
			// contiene lista de aristas del input.
			Pavilion pabellon = ej.nextPavilion();
			// Crear el grafo directamente del input es un poco problematico por no saber la cantidad portales total.
			// Se podría acotar pero tampoco es una buena solución.
			// toGraph cumple con la complejidad del ejercicio, pero al involucrar muchos pedidos de memoria
			// es dificil medir el tiempo de ejecución con nuestro modelo de complejidad.
			
			pabellon.toGraph(); // creamos grafo en O(N*L+P) 
			//System.gc();
			runCorridas(instanceId, iterations, pabellon);
			
			time = System.currentTimeMillis();
			
			runCorridas(instanceId, iterations, pabellon);
			
			Double delta = ((System.currentTimeMillis() - time) / iterations.doubleValue());
			
			Integer L = pabellon.getFloorLength();
			Integer N = pabellon.getFloorNumber()-1;
			Integer P = pabellon.getPortalNumber();
			
			// asi es mas facil graficar ya en matlab.
			Integer complexity = N*L + P;
			
			Double con = (delta).doubleValue()/ complexity;
			
			System.out.println(n + "," + delta + "," + complexity +  "," + con);
			
			// sugerimos correr el garbage collector para borrarlo asi no interfiere 
			// en la proxima medición
			//System.gc();
			
			instanceId = instanceId + 1;
		}
		
		ej.closeFile();
	}
	
	@Test
	public void test() throws IOException {
		Ejercicio2 ej = new Ejercicio2("Tp2Ej2");
		Portal p1 = new Portal(0, 10, 10, 1);
		Pavilion pab1 = new Pavilion(11, 10);
		pab1.setPortal(p1);
		
		Portal p2 = new Portal(0, 1, 1, 2);
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
		
		Portal p6 = new Portal(0, 2, 2, 3);
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
		
		LinkedList<Pavilion> ciudad = new LinkedList<Pavilion>();
		ciudad.add(pab1);
		ciudad.add(pab2);
		ciudad.add(pab3);
		assertEquals(ciudad, ej.getPavilions());
		
	}

	/*@Test
	public void testCatedra() throws IOException {

		Ejercicio2 ej = new Ejercicio2("Tp2Ej2");
		assertEquals((Integer)21, ej.run(0));
		assertEquals((Integer)18, ej.run(1));
		assertEquals((Integer)17, ej.run(2));
	}*/
}
