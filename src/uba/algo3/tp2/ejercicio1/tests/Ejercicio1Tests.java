package uba.algo3.tp2.ejercicio1.tests;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uba.algo3.tp2.ejercicio1.Ejercicio1;

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
}
