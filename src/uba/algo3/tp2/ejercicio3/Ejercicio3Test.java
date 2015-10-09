package uba.algo3.tp2.ejercicio3;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Ejercicio3Test {

	@Test 
	public void testCreandoVerificacion() throws IOException {
		BufferedWriter os = new BufferedWriter( new FileWriter( getClass().getResource( "" ).getPath() + "Tp2Ej3Verificacion.in") );
		// Creo casos de grafos k3 concatenados
		for(Integer M = 30 ; M<=1500 ; M +=30) //50 casos
		{
			//conecto el 0 con el 1 con peso M
			os.append(0 + " " + 1 + " " + M + "; " );
			for(int nodo = 1; nodo < (M*2)/3 - 1; nodo++)
			{
				
				if(nodo % 2 == 0 ) //formo el ciclo
				{	
					os.append((nodo - 2) + " " + nodo + " " + M + "; ");
					os.append(nodo + " " + (nodo + 1) + " " + M + "; ");
				}
				else
					os.append(nodo + " " + (nodo + 1) + " " + 1 + "; ");
			}
			os.append((M*2/3 -1) + " " + (M*2/3) + " " + 1);
			os.newLine();
		}
		// Creo casos de arboles
		for(Integer M = 30 ; M<=1500 ; M +=30) //50 casos
		{
			for(int nodo = 0; nodo < M-1; nodo++)
			{
				os.append(nodo + " " + (nodo + 1) + " " + M + "; ");
			}
			os.append((M-1) + " " + M + " " + M);
			os.newLine();
		}
		
		os.close();
		
	}
	
	@Test 
	public void testCreandoMejorCaso() throws IOException {
		BufferedWriter os = new BufferedWriter( new FileWriter( getClass().getResource( "" ).getPath() + "Tp2Ej3MejorCaso.in") );
		for(Integer M = 1000; M <= 30000; M +=1000)
		{

		int actual = 0; // numero del vertice que agregue por ultima vez. Actual + 1 corresponde a la cantidad de vertices
		int anterior = 0;
		int aristas = 0;

		
		while(aristas != M)
		{
			if( aristas == (actual+1)*(actual)/2) // si el grafo hasta el momento es completo
			{
				actual++; // agrego un nuevo vertice
				anterior = 0; // reseteo el anterior
			}
			else
			{
				if(anterior==0)
					os.append(anterior + " " + actual + " " + M );
				else
					os.append(anterior + " " + actual + " " + 1 );
				
				if(aristas != M-1) // si agregue la ultima arista, no imprimo el ;
					os.append("; ");
				aristas++;
				anterior++;
				
			}
		}
		os.newLine();
		}
		os.close();
		
	}
	
	@Test 
	public void testCreandoPeorCaso() throws IOException {
		BufferedWriter os = new BufferedWriter( new FileWriter( getClass().getResource( "" ).getPath() + "Tp2Ej3PeorCaso.in") );
		for(Integer M = 1000; M <= 30000; M +=1000)
		{
			
			int actual = 0; // numero del vertice que agregue por ultima vez. Actual + 1 corresponde a la cantidad de vertices
			int anterior = 0;
			int aristas = 0;
			int peso = M;
			
			while(aristas != M)
			{
				if( aristas == (actual+1)*(actual)/2) // si el grafo hasta el momento es completo
				{
					actual++; // agrego un nuevo vertice
					anterior = 0; // reseteo el anterior
				}
				else
				{
					os.append(anterior + " " + actual + " " + peso );
					if(aristas != M-1) // si agregue la ultima arista, no imprimo el ;
						os.append("; ");
					aristas++;
					anterior++;
					peso--;
				}
			}
			os.newLine();
			
		}
		os.close();
	}
	
	@Test 
	public void testCreandoCasoPromedio() throws IOException {
		Random rand = new Random();
		BufferedWriter os = new BufferedWriter( new FileWriter( getClass().getResource( "" ).getPath() + "Tp2Ej3CasoPromedio.in") );
		for(Integer M = 1000; M <= 30000; M +=1000)
		{

		int actual = 0; // numero del vertice que agregue por ultima vez. Actual + 1 corresponde a la cantidad de vertices
		int anterior = 0;
		int aristas = 0;

		
		while(aristas != M)
		{
			if( aristas == (actual+1)*(actual)/2) // si el grafo hasta el momento es completo
			{
				actual++; // agrego un nuevo vertice
				anterior = 0; // reseteo el anterior
			}
			else
			{
				
				os.append(anterior + " " + actual + " " + rand.nextInt(M) );
				
				if(aristas != M-1) // si agregue la ultima arista, no imprimo el ;
					os.append("; ");
				aristas++;
				anterior++;
				
			}
		}
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
	   //System.out.println( System.currentTimeMillis() - time );
   	}
	
	void runCorridas(Integer testIdx, Integer iterations, Ejercicio3 ej)
	{	
		for (int i = 0; i < iterations; i++)
		{
			ej.run(testIdx);
			
			ej.run(testIdx);	
		}
	}
	
	@Test 
	public void testMejorCaso() throws IOException {
		Ejercicio3 ej = new Ejercicio3("Tp2Ej3MejorCaso");
		
		Integer maxSize = 30000;
		Integer initialSize = 1000;
		Integer step = 1000;
		Integer instanceId = 0;
		
		System.out.println("Mejor caso");
		
		
		long time = 0;
		for (Integer n = initialSize; n <= maxSize; n = n + step)
		{
			time = System.currentTimeMillis();
			
			runCorridas(instanceId, 2000, ej);
			
			Double delta = ((System.currentTimeMillis() - time) / 2000.0);
			
			//System.out.println(n + "," + delta);
			double complejidad = delta / n * Math.log(n); 
			System.out.println(n + " , " + delta + " , " + complejidad);
			System.out.println(n + ","  + delta + "," + complejidad);
			
			instanceId = instanceId + 1;
		}
		
		
	}
	
	
	@Test 
	public void testPeorCaso() throws IOException {
		Ejercicio3 ej = new Ejercicio3("Tp2Ej3PeorCaso");
		
		Integer maxSize = 30000;
		Integer initialSize = 1000;
		Integer step = 1000;
		Integer instanceId = 0;
		
		System.out.println("Peor caso");
		
		
		long time = 0;
		for (Integer n = initialSize; n <= maxSize; n = n + step)
		{
			time = System.currentTimeMillis();
			
			runCorridas(instanceId, 2000, ej);
			
			Double delta = ((System.currentTimeMillis() - time) / 2000.0);
			
			//System.out.println(n + "," + delta);
			double complejidad = delta / n * Math.log(n); 
			System.out.println(n + " , " + delta + " , " + complejidad);
			System.out.println(n + ","  + delta + "," + complejidad);
			instanceId = instanceId + 1;
		}
	}
	
	@Test 
	public void testCasoPromedio() throws IOException {
		Ejercicio3 ej = new Ejercicio3("Tp2Ej3CasoPromedio");
		
		Integer maxSize = 30000;
		Integer initialSize = 1000;
		Integer step = 1000;
		Integer instanceId = 0;
		
		System.out.println("Caso Promedio");
		
		
		long time = 0;
		for (Integer n = initialSize; n <= maxSize; n = n + step)
		{
			time = System.currentTimeMillis();
			
			runCorridas(instanceId, 2000, ej);
			
			Double delta = ((System.currentTimeMillis() - time) / 2000.0);
			
			//System.out.println(n + "," + delta);
			double complejidad = delta / n * Math.log(n); 
			System.out.println(n + " , " + delta + " , " + complejidad);
			System.out.println(n + "," + delta + "," + complejidad);
			
			instanceId = instanceId + 1;
		}
		
		
	}
	

	@Test 
	public void testVerificacion() throws IOException {
		Ejercicio3 ej = new Ejercicio3("Tp2Ej3Verificacion");
		
		System.out.println("Verificacion");
		int M=30;
		for(Integer i = 0; i < 50; i++)
		{
			int res = ej.run(i);
			assertEquals(M/3 -1, res);
			M+=30;
		}
		for(Integer i = 50; i < 100; i++)
		{
			int res = ej.run(i);
			assertEquals(0, res);
		}
	}
	
	@Test 
	public void testEjercicioDeCatedra() throws IOException {
		Ejercicio3 ej = new Ejercicio3("Tp2Ej3");
		System.out.println(ej.run(0));
		System.out.println(ej.run(1));
	}
	
}
