package logica;

import java.util.ArrayList;

public class Solver {
	private Instancia  _instancia;
	private ArrayList<String> mAsignadas, manzanas;
	private ArrayList<Censista> censistas;
	
	public Solver(Instancia instancia) {
		if(instancia == null) {
			throw new NullPointerException();
		}
		_instancia = instancia;
	}
	
	/**
	* Asigna tres manzanas a cada censista para minimizar la
	*	cantidad de censistas anotados.
	*/
	public Solucion resolver(){
		Solucion sol = new Solucion();
		
		manzanas = _instancia.getManzanas();
		censistas = _instancia.getCensistas();
		mAsignadas = new ArrayList<String>();
		
		verificarInstancia();
		
		int indiceCensista = 0;
		Censista c;
		
		// asigno la primer manzana al primer censista
		asignarOrigen(indiceCensista);
		
		if(manzanas.size()==1) {
			sol.agregarCensista(censistas.get(indiceCensista));
		}
		
		for (int i = 0; i < manzanas.size(); i++) {

			if(manzanasDisponibles().size() != 0) {
				c = censistas.get(indiceCensista); 
				
				if(asignarManzanas(c)) {
					sol.agregarCensista(c);
					indiceCensista++;
				}
			}
		}
		return sol;
	}

	private void verificarInstancia() {
		if(manzanas == null || censistas == null) {
			throw new NullPointerException();
		}
		
		if(censistas.size()==0 || manzanas.size()==0) {
			throw new IllegalArgumentException();
		}
	}

	private void asignarOrigen(int indiceCensista) {
		Censista c = censistas.get(indiceCensista);
		c.agregarManzana(manzanas.get(0));
		mAsignadas.add(manzanas.get(0));
	}
	
	/**
	* Verifica que la manzana pasada por parametro sea vecina de algunas de las manzanas que tiene
	* asignada el censista
	*/
	private boolean verificarManzana(Censista c, String v, Grafo g) {
		return c.verificarManzana(new Vertice(v), g);
	}
	
	private boolean asignarManzanas(Censista c) {
		for (String m : manzanasDisponibles()) {
			
			if(c.getCantManzanas() == 0) {
				c.agregarManzana(m);
				mAsignadas.add(m);
			}
			if(verificarManzana(c, m, _instancia.getGrafo()) && c.getCantManzanas() < 3){ 
				c.agregarManzana(m);
				mAsignadas.add(m);
			}
		}
		return c.getCantManzanas()<=3;
	}
	
	/**
	* Devuelve un ArrayList de strings con las manzanas no asignadas
	*/
	private ArrayList<String> manzanasDisponibles() {
		ArrayList<String> disponibles = new ArrayList<String>();
		for(String m : manzanas) {
			if(!mAsignadas.contains(m))
				disponibles.add(m);
		}
		return disponibles;
	}
}
