package uba.algo3.tp2.ejercicio1;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Ejercicio1Tests {
	
	private long time;
	
	@Before
    public void before() {
	   time = System.currentTimeMillis();
    }
 
	@After
	public void after() {
		System.out.println( System.currentTimeMillis() - time );
	}
	
 	void runCorridas(Integer testIdx, Integer iterations, Ejercicio1 ej)
 	{	
 		for (int i = 0; i < iterations; i++)
 			ej.run(testIdx);
 	}
 	
	@Test
	public void testCatedra() throws IOException {
		
		Ejercicio1 ej = new Ejercicio1("Tp2Ej1Catedra");
		ej.solve();

		BufferedReader is = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( ej.getFileName() + ".out") ) );
	    String line;

	    line = is.readLine();
	    assertEquals("1", line);
	    line = is.readLine();
	    assertEquals("2", line);
	     
	    is.close();
	    
	}
	
	
	@Test
	public void testPeorCaso() throws IOException {
		Ejercicio1 ej = new Ejercicio1("Tp2Ej1PeorCaso");
		
		Integer maxSize = 2000;
		Integer initialSize = 100;
		Integer step = 100;
		
		Integer instanceId = 0;
		
		System.out.println("Peor caso");
		
		long time = 0;
		for (Integer n = initialSize; n <= maxSize; n = n + step)
		{
			time = System.currentTimeMillis();
			
			runCorridas(instanceId, 2000, ej);
			
			Double delta = ((System.currentTimeMillis() - time) / 2000.0);
			
			System.out.println(n + "," + delta);
			
			instanceId = instanceId + 1;
		}
	}
	
	@Test
	public void testMejorCaso() throws IOException {
		Ejercicio1 ej = new Ejercicio1("Tp2Ej1MejorCaso");
		
		Integer maxSize = 2000;
		Integer initialSize = 100;
		Integer step = 100;
		
		Integer instanceId = 0;
		
		System.out.println("Mejor caso");
		
		long time = 0;
		for (Integer n = initialSize; n <= maxSize; n = n + step)
		{
			time = System.currentTimeMillis();
			
			runCorridas(instanceId, 2000, ej);
			
			Double delta = ((System.currentTimeMillis() - time) / 2000.0);
			
			System.out.println(n + "," + delta);
			
			instanceId = instanceId + 1;
		}
	}
	
	@Test
	public void testSinIntencionalidad() throws IOException {
		Ejercicio1 ej = new Ejercicio1("Tp2Ej1SinIntencionalidad");
		
		Integer maxSize = 2000;
		Integer initialSize = 100;
		Integer step = 100;
		
		Integer instanceId = 0;
		
		System.out.println("Sin Intencionalidad");
		
		long time = 0;
		for (Integer n = initialSize; n <= maxSize; n = n + step)
		{
			time = System.currentTimeMillis();
			
			runCorridas(instanceId, 2000, ej);
			
			Double delta = ((System.currentTimeMillis() - time) / 2000.0);
			
			System.out.println(n + "," + delta);
			
			instanceId = instanceId + 1;
		}
	}
	
	
}
