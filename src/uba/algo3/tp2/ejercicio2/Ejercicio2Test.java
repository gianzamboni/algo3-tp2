package uba.algo3.tp2.ejercicio2;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.LinkedList;

import org.junit.Test;

public class Ejercicio2Test {

	void runCorridas(Integer iterations, Pavilion p)
 	{	
 		for (int i = 0; i < iterations; i++)
 			p.maxDistance();
 	}
	
	
	@Test 
	public void testSinIntencionalidad() throws IOException {
		Ejercicio2 ej = new Ejercicio2("Tp2Ej2SinIntencionalidad");
		
		Integer maxSize = 500;
		Integer initialSize = 100;
		Integer step = 50;
		Integer iterations = 400;
		
		System.out.println("Sin Intencionalidad");
		
		long time = 0;
		for (Integer n = initialSize; n <= maxSize; n = n + step)
		{
			// contiene lista de aristas del input.
			Pavilion pabellon = ej.nextPavilion();			
			
			runCorridas(iterations, pabellon);
			
			time = System.currentTimeMillis();
			
			runCorridas(iterations, pabellon);
			
			Double delta = ((System.currentTimeMillis() - time) / iterations.doubleValue());
			
			Integer L = pabellon.getFloorLength();
			Integer N = pabellon.getFloorNumber()-1;
			Integer P = pabellon.getPortales().size();
			
			// asi es mas facil graficar ya en matlab.
			Integer complexity = N*L + P;
			
			Double con = (delta).doubleValue()/ complexity;
			
			System.out.println(n + "," + delta + "," + complexity +  "," + con);
		}
		
		ej.closeFile();
	}
	
	@Test 
	public void testMejorCaso() throws IOException {
		Ejercicio2 ej = new Ejercicio2("Tp2Ej2MejorCaso");
		
		Integer maxSize = 500;
		Integer initialSize = 100;
		Integer step = 50;
		Integer iterations = 400;
		
		System.out.println("Mejor caso");
		
		long time = 0;
		for (Integer n = initialSize; n <= maxSize; n = n + step)
		{
			// contiene lista de aristas del input.
			Pavilion pabellon = ej.nextPavilion();			
			
			runCorridas(iterations, pabellon);
			
			time = System.currentTimeMillis();
			
			runCorridas(iterations, pabellon);
			
			Double delta = ((System.currentTimeMillis() - time) / iterations.doubleValue());
			
			Integer L = pabellon.getFloorLength();
			Integer N = pabellon.getFloorNumber()-1;
			Integer P = pabellon.getPortales().size();
			
			// asi es mas facil graficar ya en matlab.
			Integer complexity = N*L + P;
			
			Double con = (delta).doubleValue()/ complexity;
			
			System.out.println(n + "," + delta + "," + complexity +  "," + con);
		}
		
		ej.closeFile();
	}
	
	@Test 
	public void testPeorCaso() throws IOException {
		Ejercicio2 ej = new Ejercicio2("Tp2Ej2PeorCaso");
		
		Integer maxSize = 500;
		Integer initialSize = 100;
		Integer step = 50;
		Integer iterations = 400;
		
		System.out.println("Peor caso");
		
		long time = 0;
		for (Integer n = initialSize; n <= maxSize; n = n + step)
		{
			// contiene lista de aristas del input.
			Pavilion pabellon = ej.nextPavilion();			
			
			runCorridas(iterations, pabellon);
			
			time = System.currentTimeMillis();
			
			runCorridas(iterations, pabellon);
			
			Double delta = ((System.currentTimeMillis() - time) / iterations.doubleValue());
			
			Integer L = pabellon.getFloorLength();
			Integer N = pabellon.getFloorNumber()-1;
			Integer P = pabellon.getPortales().size();
			
			// asi es mas facil graficar ya en matlab.
			Integer complexity = N*L + P;
			
			Double con = (delta).doubleValue()/ complexity;
			
			System.out.println(n + "," + delta + "," + complexity +  "," + con);
		}
		
		ej.closeFile();
	}
	

	@Test
	public void testVerificacion() throws IOException {
		Ejercicio2 ej = new Ejercicio2("Tp2Ej2Verificacion");
		
		Pavilion p = ej.nextPavilion();
		assertEquals((Integer)12, p.maxDistance());
		p = ej.nextPavilion();
		assertEquals((Integer)2, p.maxDistance());
		p = ej.nextPavilion();
		assertEquals((Integer)6, p.maxDistance());
		
		ej.closeFile();
		
	}
	@Test
	public void testCatedra() throws IOException {

		Ejercicio2 ej = new Ejercicio2("Tp2Ej2");
		Pavilion p = ej.nextPavilion();
		assertEquals((Integer)21, p.maxDistance());
		p = ej.nextPavilion();
		assertEquals((Integer)18, p.maxDistance());
		p = ej.nextPavilion();
		assertEquals((Integer)17, p.maxDistance());
		
		ej.closeFile();
		
	}
}
