package logica;

import java.util.*;

import json.GrafoJSON;

public class Grafo {
	private Map<String, ArrayList<Vertice>> grafo;
	
	public Grafo() {
		grafo = new HashMap<String,ArrayList<Vertice>>();	
	}
	
	public Grafo(GrafoJSON g) {
		grafo = new HashMap<String,ArrayList<Vertice>>();	
		grafo.putAll(g.getGrafo());	
	}
	
	public void agregarVertice(String m) {
		if(m.length() == 0) {
			throw new IllegalArgumentException("El nombre no puede ser nulo");
		}
		
		if(!existeVertice(m))
			grafo.put(m, new ArrayList<Vertice>());
	}
	
	public void agregarArista(String origen, String destino) {
		verificarVertice(origen, destino);
		
		if(!existeArista(origen, destino))
			grafo.get(origen).add(new Vertice(destino));
			grafo.get(destino).add(new Vertice(origen));
	}
	
	public boolean existeVertice(String s) {
		return grafo.containsKey(s);
	}
	
	public boolean existeArista(String a, String b) {
		return grafo.get(a).contains(new Vertice(b));
	}
	
	private void verificarVertice(String a, String b) {
		if(a.equals(b))
			throw new IllegalArgumentException("No se permiten loops!");
	}
	
	public Set<String> getVertices(){
		return grafo.keySet();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Vertice> getVecinosDeVertice(String s){
		return (ArrayList<Vertice>) grafo.get(s).clone();
	}
	
	
	public boolean esVecino(String a, String otro) {
		return grafo.get(a).contains(new Vertice(otro));
	}

	@Override
	public String toString() {
		StringBuilder st = new StringBuilder();
		for(String s : grafo.keySet()) {
			st.append("N° de Manzana: " + s + " Vecinos: "+ grafo.get(s).toString()).append("\n");
		}
		return st.toString();
	}	
	
	public int tamano() {
		return grafo.size();
	}
}
