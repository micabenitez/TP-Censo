package logica;

import java.util.ArrayList;
import json.CensistasJSON;
import json.GrafoJSON;

public class Instancia { 
	private Grafo g;  // radio censal
	private ArrayList<Censista> censistas;
	
	public Instancia(Grafo grafo, ArrayList<Censista> censistas) {
		if(grafo == null || censistas == null) {
			throw new NullPointerException();
		}
		g = grafo;
		this.censistas = censistas;
	}
	
	public Instancia(GrafoJSON radioCensal, CensistasJSON censistas) {
		if(radioCensal == null || censistas == null) {
			throw new NullPointerException();
		}
		g = new Grafo(radioCensal);
		this.censistas = censistas.getCensistas();
	}
	
	public ArrayList<String> getManzanas() {
		ArrayList<String> manzanas = new ArrayList<String>();
		for(String s : g.getVertices()) {
			manzanas.add(s);
		}
		return manzanas;
	}

	public ArrayList<Censista> getCensistas() {
		return censistas;
	}
	
	public Grafo getGrafo() {
		return g;
	}
}
