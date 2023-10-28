package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import logica.Grafo;

public class GrafoTest {
	private Grafo g;
	
	@Before
	public void instancia() {
		g = new Grafo();
		
		g.agregarVertice("1");
		g.agregarVertice("2");
		g.agregarVertice("3");
		g.agregarVertice("4");
		
		g.agregarArista("1", "2");
		g.agregarArista("1", "4");
		g.agregarArista("2", "3");
		g.agregarArista("3", "4");
		g.agregarArista("3", "1");
	
	}

	@Test (expected = IllegalArgumentException.class)
	public void agregarVerticeNuloTest() {
		g.agregarVertice("");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarAristaInvalidaTest() {
		g.agregarArista("","");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarLoopTest() {
		g.agregarArista("1","1");
	}
	
	@Test 
	public void agregarAristaTest() {
		g.agregarVertice("5");
		g.agregarArista("1","5");
		
		assertTrue(g.existeArista("1","5"));
		assertTrue(g.existeArista("5","1"));
	}
	
}
