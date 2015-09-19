package uba.algo3.tp2.ejercicio2;



public class Portal {

	private Integer floorA;
	private Integer floorB;
	private Integer metersA;
	private Integer metersB;
	
	public Integer getFloorA() {
		return floorA;
	}
	public void setFloorA(Integer floorA) {
		this.floorA = floorA;
	}
	public Integer getFloorB() {
		return floorB;
	}
	public void setFloorB(Integer floorB) {
		this.floorB = floorB;
	}
	public Integer getMetersA() {
		return metersA;
	}
	public void setMetersA(Integer metersA) {
		this.metersA = metersA;
	}
	public Integer getMetersB() {
		return metersB;
	}
	public void setMetersB(Integer metersB) {
		this.metersB = metersB;
	}

	public Portal(Integer pisoA, Integer metrosA, Integer pisoB, Integer metrosB)
	{
		setFloorA(pisoA);
		setFloorB(pisoB);
		setMetersA(metrosA);
		setMetersB(metrosB);
	}
	
	@Override
	public String toString(){
		StringBuilder result = new StringBuilder();
	    result.append("Portal[ ");
	    result.append("FloorA = " + this.floorA + "; ");
	    result.append("MetersA = " + this.metersA + "; ");
	    result.append("FloorB = " + this.floorB + " ");
	    result.append("MetersB = " + this.metersB + "; ");
	    result.append("]");

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
		else if (!(other instanceof Portal)) {
			return false;
		}
		
		Portal otherNode = (Portal) other;
		return this.floorA.equals(otherNode.getFloorA()) 
				&& this.floorB.equals(otherNode.getFloorB()) 
				&& this.metersA.equals(otherNode.getMetersA())
				&& this.metersB.equals(otherNode.getMetersB()); 
		
	}
	
}
