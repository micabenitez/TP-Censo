package logica;

import java.util.ArrayList;

public class Solucion {
	 private ArrayList<Censista> asignaciones;
	 
	 public Solucion(){
		asignaciones = new ArrayList<Censista>();
	 }
	
	 public void agregarCensista(Censista c) {
		if(!asignaciones.contains(c))
			asignaciones.add(c);
	 }
	  
	 @SuppressWarnings("unchecked")
	public ArrayList<Censista> getCensistas(){
		 return (ArrayList<Censista>) asignaciones.clone();
	 }
	 
	 @Override
	 public String toString() {
		 return asignaciones.toString();
	 }

	public int getCantCensistas() {
		return asignaciones.size();
	}
}
