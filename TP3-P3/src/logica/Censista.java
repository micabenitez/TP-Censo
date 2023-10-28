package logica;

import java.util.ArrayList;

public class Censista {
	private String nombre;
	public ArrayList<Vertice> manzanas;
	private int cantManzanas;
	private String imagen;
	
	public Censista(String n, String img) {
		verificarNombre(n);
		verificarFoto(img);
		
		nombre = n;
		manzanas = new ArrayList<Vertice>();
		cantManzanas = 0;
		imagen = img;
	}

	private void verificarNombre(String n) {
		if(n.length() == 0) {
			throw new IllegalArgumentException("Ingrese un nombre");
		}
	}

	private void verificarFoto(String img) {
		if(img.length() == 0) {
			throw new IllegalArgumentException("Ingrese una foto");
		}
	}
	
	public int getCantManzanas() {
		return cantManzanas;
	}
	
	public void agregarManzana(String m) {
		if(m.length()==0) {
			throw new IllegalArgumentException("El nombre de la manzana no puede ser nulo");
		}
		manzanas.add(new Vertice(m));
		cantManzanas++;
	}
	
	public boolean verificarManzana(Vertice m, Grafo g) {
		if(g.getVecinosDeVertice(m.getNombre()).size()==0) {
			return true;
		}
		
		boolean esVecino = false;
		for(Vertice v : manzanas) {
			esVecino = esVecino || g.esVecino(v.getNombre(), m.getNombre());
		}
		return esVecino;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return nombre;
	}

	public String getManzanas() {
		StringBuilder st = new StringBuilder();
		for(Vertice v : manzanas) {
			st.append(v +", ");
		}
		return st.toString();
	}
	
	public String getFoto() {
		return imagen;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if(getClass() != o.getClass() || o == null) {
			return false;
		}
		Censista otro = (Censista) o;
		return otro.getNombre().equals(nombre);
	}

}


