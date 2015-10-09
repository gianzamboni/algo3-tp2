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
	
	private BufferedReader archivo;
	

	public Pavilion getPavilion(Integer idx)
	{
		return pavilions.get(idx);
	}
	
	public void closeFile() throws IOException
	{
		archivo.close();
	}
	
	String fileName;
	
	public Pavilion nextPavilion() throws IOException
	{
		String line = archivo.readLine();
		
		if (line == null)
			return null;
		
		String line1=  archivo.readLine();
		
		if (line1 == null)
			return null;
		
		Integer[] parametros = Utils.parseArray(line);
		//						          cantidadPisos   longitud
		Pavilion edificio = new Pavilion(parametros[0]+1, parametros[1]);

		Integer i = 0;
		Integer k = line1.indexOf(";", i);
		
		while(k != -1)
		{
			String portal = line1.substring(i,k);
			
			Integer[] parametrosPortal = Utils.parseArray(portal);
			Portal p = new Portal(parametrosPortal[0], parametrosPortal[1], parametrosPortal[2], parametrosPortal[3]);
			edificio.setPortal(p);
			
			i = k+2;
			k = line1.indexOf(";", i);
		}
		// ultimo caso
		String portal = line1.substring(i);
		Integer[] parametrosPortal = Utils.parseArray(portal);
		Portal p = new Portal(parametrosPortal[0], parametrosPortal[1], parametrosPortal[2], parametrosPortal[3]);
		edificio.setPortal(p);
					
		return edificio;
		
	}
	public Ejercicio2(String fileName) throws IOException 
	{
		pavilions = new LinkedList<Pavilion>();
		
		this.fileName = fileName;
		this.pavilions = new LinkedList<Pavilion>();
		
		archivo = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( fileName + ".in") ) );
		
		/*
		// datos del edificio
		String line;
		// portales
		String line1;
		
		// Leemos de a dos lineas.
		while((line = is.readLine()) != null) {
			line1 = is.readLine();
			
			Integer[] parametros = Utils.parseArray(line);
			//						          cantidadPisos   longitud
			Pavilion edificio = new Pavilion(parametros[0]+1, parametros[1]);

			Integer i = 0;
			Integer k = line1.indexOf(";", i);
			
			while(k != -1)
			{
				String portal = line1.substring(i,k);
				
				Integer[] parametrosPortal = Utils.parseArray(portal);
				Portal p = new Portal(parametrosPortal[0], parametrosPortal[1], parametrosPortal[2], parametrosPortal[3]);
				edificio.setPortal(p);
				
				i = k+2;
				k = line1.indexOf(";", i);
			}
			// ultimo caso
			String portal = line1.substring(i);
			Integer[] parametrosPortal = Utils.parseArray(portal);
			Portal p = new Portal(parametrosPortal[0], parametrosPortal[1], parametrosPortal[2], parametrosPortal[3]);
			edificio.setPortal(p);
			
			//System.out.println(portal);
			
			pavilions.add(edificio);
		}
		
		is.close();*/
	}

	public final int solve( ) {
		return 0;
	}
	
	public Integer run(Integer idx)
	{
		return pavilions.get(idx).maxDistance();
	}
}