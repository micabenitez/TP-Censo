package tests;

import java.util.ArrayList;
import org.junit.Test;

import logica.Censista;
import logica.Grafo;
import logica.Instancia;

public class InstanciaTest {
	@SuppressWarnings("unused")
	private Instancia instancia;

	@Test (expected = NullPointerException.class)
	public void listaNullTest() {
		instancia = new Instancia(null, new ArrayList<Censista>());
	}

	@Test (expected = NullPointerException.class)
	public void grafoNullTest() {
		instancia = new Instancia(new Grafo(), null);
	}
}
