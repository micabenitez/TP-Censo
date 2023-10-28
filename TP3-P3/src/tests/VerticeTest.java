package tests;

import org.junit.Test;

import logica.Vertice;

public class VerticeTest {

	@Test (expected = IllegalArgumentException.class)
	public void nombreNuloTest() {
		@SuppressWarnings("unused")
		Vertice v = new Vertice("");
	}

}
