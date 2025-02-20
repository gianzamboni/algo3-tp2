package uba.algo3.tp2.ejercicio3;

import uba.algo3.tp2.ejercicio2.Portal;

public class Edge implements Comparable<Edge> {

   private int _nod1;
   private int _nod2;
   private int _peso;

   public Edge( int n1, int n2, int p ) {
      this._nod1 = n1;
      this._nod2 = n2;
      this._peso = p;
   }

   public final int peso() {
      return _peso;
   }

   public final int nodo1() {
      return _nod1;
   }

   public final int nodo2() {
      return _nod2;
   }

   public boolean lessThan( Edge ar ) {
      if (peso() != ar.peso()) {
         return peso() < ar.peso();
      }
      if (nodo1() != ar.nodo1()) {
         return nodo1() < ar.nodo1();
      }
      return nodo2() < ar.nodo2();
   }

   public int compareTo( Edge otherInstance ) {
      if (lessThan( otherInstance )) {
         return -1;
      } else if (otherInstance.lessThan( this )) {
         return 1;
      }

      return 0;
   }
   
	@Override
	public boolean equals(Object other){
		if(other == null){
			return false;
		} 
		else if(other == this){
			return true;
		} 
		else if (!(other instanceof Edge)) {
			return false;
		}
		
		Edge otherNode = (Edge) other;
		return this._nod1 == otherNode.nodo1() 
				&& this._nod2 == otherNode.nodo2() 
				&& this._peso == otherNode.peso();
		
	}

}