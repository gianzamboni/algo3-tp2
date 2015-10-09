package uba.algo3.tp2.ejercicio2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pavilion {
	
	private Integer floorLength;
	private Integer floorNumber;
	private List<Portal> portales;
	

	public Integer getFloorLength() {
		return floorLength;
	}
	public void setFloorLength(Integer floorLength) {
		this.floorLength = floorLength;
	}
	public Integer getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}
	public List<Portal> getPortales() {
		return portales;
	}
	public void setPortales(List<Portal> portales) {
		this.portales = portales;
	}

	public void setPortal(Portal p)
	{
		this.portales.add(p);
	}
	
	public Pavilion(Integer floors, Integer length)
	{
		setFloorLength(length);
		setFloorNumber(floors);
		portales = new LinkedList<Portal>();
	}
	
	public Integer maxDistance()
	{
		ArrayList<Integer> distances = toGraph().BFS();
		
		return distances.get(floorNumber*(floorLength+1)-1);
	}
	
	public Graph toGraph() // O(N*L + P)
	{
		// Creamos un grafo con todas las baldosas posibles pero sin las conexiones
		Graph res = new Graph(floorNumber*(floorLength + 1) + portales.size()); // O(N*L + P)
		for(int i = 1; i < floorNumber*(floorLength + 1); i++) // lleno las posiciones conectadas caminando
		{
			if(i % (floorLength + 1) != 0)
			{	
				res.addEdge(i-1, i);
			}
		}
		int i = floorNumber*(floorLength + 1);
		for(Portal portal : portales ) // lleno las posiciones conectadas por los portales. O(P)
		{
			Integer inicio = portal.getFloorA()*(floorLength+1) + portal.getMetersA();
			Integer fin = portal.getFloorB()*(floorLength+1) + portal.getMetersB();
			
			res.addEdge(inicio, i);
			res.addEdge(fin, i);
			i++;
		}
				
		return res;

	}
	
	@Override
	public String toString(){
		StringBuilder result = new StringBuilder();
	    result.append("Pavilion[ ");
	    result.append("#Pisos = " + this.floorNumber + "; ");
	    result.append("Longitud pisos = " + this.portales.toString() + " ");
	    result.append("]");
	    result.append("\n");

	    return result.toString();
	}
	
	@Override
	public boolean equals(Object other){
		if(other == null){
			return false;
		} 
		else if(other == this){
			return true;
		} 
		else if (!(other instanceof Pavilion)) {
			return false;
		}
		
		Pavilion otherNode = (Pavilion) other;
		return this.floorLength.equals(otherNode.getFloorLength()) 
				&& this.portales.equals(otherNode.getPortales()) 
				&& this.floorNumber.equals(otherNode.getFloorNumber()); 
		
	}
}
