package uba.algo3.tp2.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import uba.algo3.utils.Utils;



public class Ejercicio3 {

	List<Pavilion> pavilions;
	public List<Pavilion> getPavilions() {
		return pavilions;
	}

	public Pavilion getPavilion(Integer idx)
	{
		return pavilions.get(idx);
	}
	
	String fileName;
	
	public Ejercicio3(String fileName) throws IOException 
	{
		pavilions = new LinkedList<Pavilion>();
		
		this.fileName = fileName;
		this.pavilions = new LinkedList<Pavilion>();
		
		BufferedReader is = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( fileName + ".in") ) );
		
		// datos del edificio
		String line;
		
		while((line = is.readLine()) != null) {
			
			String[] pasillos  = line.split("; ");
			
			Pavilion edificio = new Pavilion();
			
			
			// en total m log m
			for (String pasillo : pasillos)
			{
				Integer[] parametros = Utils.parseArray(pasillo);
				Edge e = new Edge(parametros[0], parametros[1], parametros[2]);
				
				// log m
				edificio.addEdge(e);
			}
			
			pavilions.add(edificio);
		}
		
		is.close();
	}

	public final int solve( ) {
		return 0;
	}
	
	public Integer run(Integer idx)
	{
		return pavilions.get(idx).sacarCiclos();
	}
}
