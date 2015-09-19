package uba.algo3.tp2.ejercicio2;
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
