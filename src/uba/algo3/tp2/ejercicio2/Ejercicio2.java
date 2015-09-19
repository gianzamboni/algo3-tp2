package uba.algo3.tp2.ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import uba.algo3.utils.Utils;


public class Ejercicio2 {

	List<Pavilion> pavilions;
	public List<Pavilion> getPavilions() {
		return pavilions;
	}

	String fileName;
	
	public Ejercicio2(String fileName) throws IOException 
	{
		pavilions = new LinkedList<Pavilion>();
		
		this.fileName = fileName;
		this.pavilions = new LinkedList<Pavilion>();
		
		BufferedReader is = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( fileName + ".in") ) );
		
		// datos del edificio
		String line;
		// portales
		String line1;
		
		// Leemos de a dos lineas.
		while((line = is.readLine()) != null) {
			line1 = is.readLine();
			
			Integer[] parametros = Utils.parseArray(line);
			String[] portales  = line1.split("; ");
			
			//						          cantidadPisos   longitud
			Pavilion edificio = new Pavilion(parametros[0]+1, parametros[1]);
			
			for (String portal : portales)
			{
				// pisoA metrosA pisoB metrosB
				Integer[] parametrosPortal = Utils.parseArray(portal);
				Portal p = new Portal(parametrosPortal[0], parametrosPortal[1], parametrosPortal[2], parametrosPortal[3]);
				edificio.setPortal(p);
			}
			
			
			pavilions.add(edificio);
		}
		
		is.close();
	}

	public final int solve( ) {
		return 0;
	}
}