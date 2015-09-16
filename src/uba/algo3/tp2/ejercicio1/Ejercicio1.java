package uba.algo3.tp2.ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Ejercicio1 {

	private String fileName;
	private List<Pavilion> pavilions;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<Pavilion> getPavilions() {
		return pavilions;
	}

	public void setPavilions(List<Pavilion> pavilions) {
		this.pavilions = pavilions;
	}
	
	public Ejercicio1(String fileName) throws IOException {
		
		this.fileName = fileName;
		this.pavilions = new LinkedList<Pavilion>();
		
		BufferedReader is = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( fileName + ".in") ) );
		
		String line;
		
		while((line = is.readLine()) != null) {
			Integer floors = Integer.getInteger(line); 
			line = is.readLine();
			Pavilion pavilion = new Pavilion(floors, line);
			pavilions.add(pavilion);
		}
		
		is.close();
	};

	public String run(Integer idxPavilion)
	{
		Pavilion pavilion = pavilions.get(idxPavilion);
		Integer maxDistance = pavilion.getMaxDistanceToLastFloor(); // backtracking
		return maxDistance.toString();
	}
	
	public void solve() throws IOException
	{		
		String path = getClass().getResource( "" ).getPath() + this.fileName +".out";
		
		BufferedWriter os = new BufferedWriter( new FileWriter( path ) );
		
		for (Integer i = 0; i < pavilions.size(); i++){
		    os.append( run(i) ).append( '\n' );
		}
		    
		os.close();
	}
	
}
