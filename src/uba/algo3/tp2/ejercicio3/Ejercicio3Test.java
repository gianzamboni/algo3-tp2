package uba.algo3.tp2.ejercicio3;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uba.algo3.tp2.ejercicio2.Ejercicio2;
import uba.algo3.tp2.ejercicio2.Pavilion;

public class Ejercicio3Test {

	@Test 
	public void testCreandoMejorCaso() throws IOException {
		BufferedWriter os = new BufferedWriter( new FileWriter( getClass().getResource( "" ).getPath() + "Tp2Ej3MejorCaso.in") );
		for(Integer M = 1000; M <= 30000; M +=1000)
		{
			for(int j = 1; j < M; j++)
			{
				os.append(j + " " + (j + 1) + " " + (M-j+1) + ";" );
			}
			os.append(M + " " + (M + 1) + " " + 1);
			os.newLine();
			
		}
		os.close();
	}
	
	private long time;
	
	@Before
    public void before() {
	   time = System.currentTimeMillis();
    }
   
   @After
    public void after() {
	   System.out.println( System.currentTimeMillis() - time );
   	}
	
	@Test 
	public void testMejorCaso() throws IOException {
		Ejercicio3 ej = new Ejercicio3("Tp2Ej3MejorCaso");
		
		
		System.out.println("Mejor caso");
		
		long time = 0;
		/*for (Integer n = initialSize; n <= maxSize; n = n + step)
		{
			time = System.currentTimeMillis();
			
			runCorridas(instanceId, 2000, ej);
			
			Double delta = ((System.currentTimeMillis() - time) / 2000.0);
			
			System.out.println(n + "," + delta);
			
			instanceId = instanceId + 1;
		}*/
		
		
		
	}
	

}
