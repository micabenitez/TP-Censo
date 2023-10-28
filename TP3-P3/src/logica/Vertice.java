package logica;

public class Vertice {
	private String nombre;
	
	public Vertice(String n) {
		if(n.length() == 0) {
			throw new IllegalArgumentException("Ingrese un nombre");
		}
		nombre = n;
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public boolean equals(Object otro) {
		if(otro == null)
			return false;
		
		if(otro.getClass() != getClass())
			return false;
		
		Vertice v = (Vertice) otro;
		if(nombre.equals(v.getNombre())){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
