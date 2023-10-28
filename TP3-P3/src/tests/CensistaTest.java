package tests;

import org.junit.Before;
import org.junit.Test;

import logica.Censista;

public class CensistaTest {
	private Censista c;
	
	@Before
	public void test() {
		c = new Censista("Mora", "foto.jpg");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarNombreVacio() {
		c.agregarManzana("");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void nombreVacio() {
		 c = new Censista("","");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void fotoVacia() {
		 c = new Censista("","");
	}
	
	
}

