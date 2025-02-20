package uba.algo3.tp2.tallerkruskal;

import java.util.ArrayList;

public class UnionFind {

   private ArrayList<Integer> _parent = new ArrayList<Integer>();
   private ArrayList<Integer> _rank = new ArrayList<Integer>();


   public UnionFind( int n ) {
      // Crea un bosque de n nodos.
      // Cada nodo tiene rank 0 al principio.
      // Cada nodo es su propio padre el principio.
	   
	   
	  for (Integer i = 0; i < n; i++){
		  _parent.add(i, i);
		  _rank.add(i,0);
	  }
	  
   }

   public final int findSet( int i ) {
      // Si el padre es el mismo nodo, devuelvo ese nodo.
      // Si no, llamo recursivamente hacia el padre, y actualizo el padre del
      // nodo.
	   
	   if (_parent.get(i) == i)
		   return i;
	   
	   _parent.set(i, findSet(_parent.get(i)));
	   
	   return _parent.get(i);

   }

   public final boolean isSameSet( int i, int j ) {
      // Devuelve si 2 nodos pertenecen o no al mismo conjunto.
	   return findSet(i) == findSet(j);
   }

   public final void unionSet( int i, int j ) {
      // Si no pertenecen ya al mismo conjunto, los uno.
      // El que tenga menor rank pasara a formar parte del que tenga mayor rank.
      // Si ambos tienen igual rank es lo mismo cual uno a cual, pero debo
      // aumentar el rank del que sea el padre.
	   int seti = findSet(i);
	   int setj = findSet(j);
	   
	   if( _rank.get(seti) < _rank.get(setj) )
		   _parent.set(seti, setj);
	   else
	   {
		   _parent.set(setj, seti);
	   		if( _rank.get(seti) == _rank.get(setj))
	   			_rank.set(seti, _rank.get(seti) + 1);
	   }		
	   /*if (!isSameSet(i, j))
	   {
		   int max = _rank.get(i) >= _rank.get(j) ? i : j;
		   int min = max == i ? j : i;
		   
		   // aumento el rango en uno
		   _rank.set(max, _rank.get(max)+1);
		   _parent.set(min, max);
	   }*/
   }
}
