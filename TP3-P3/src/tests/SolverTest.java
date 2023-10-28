package tests;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

import logica.Censista;
import logica.Grafo;
import logica.Instancia;
import logica.Solucion;
import logica.Solver;

public class SolverTest {
	private Solver solver;
	private Solucion sol;
	
	private Instancia instancia() {
		Grafo grafo = new Grafo();
		
		grafo.agregarVertice("1");
		grafo.agregarVertice("2");
		grafo.agregarVertice("3");
		grafo.agregarVertice("4");
		grafo.agregarVertice("5");
		grafo.agregarVertice("6");
		grafo.agregarVertice("7");
		grafo.agregarVertice("8");
		grafo.agregarVertice("9");

		grafo.agregarArista("1", "2"); 
		grafo.agregarArista("1", "6");
		grafo.agregarArista("2", "3");
		grafo.agregarArista("2", "7");
		grafo.agregarArista("3", "4");
		grafo.agregarArista("3", "8");
		grafo.agregarArista("4", "5");
		grafo.agregarArista("4", "9");
		grafo.agregarArista("6", "7");
		grafo.agregarArista("7", "8");
		grafo.agregarArista("8", "9");
	
		ArrayList<Censista> censistas = new ArrayList<Censista>();
		censistas.add(new Censista("Homero","f"));
		censistas.add(new Censista("Lisa","f"));
		censistas.add(new Censista("Bart","f"));
		censistas.add(new Censista("Marge","f"));
		censistas.add(new Censista("Mora","f"));
		censistas.add(new Censista("Micaela","f"));
		censistas.add(new Censista("Yamila","f"));
		
		Instancia ejemplo = new Instancia(grafo, censistas);
		return ejemplo;
	}
	
	private Instancia soloUnaManzana() {
		Grafo grafo = new Grafo();
		grafo.agregarVertice("1");
		
		ArrayList<Censista> censistas = new ArrayList<Censista>();
		censistas.add(new Censista("Homero","f"));

		Instancia ejemplo = new Instancia(grafo, censistas);
		return ejemplo;
	}
	
	private Instancia ningunaManzana() {
		Grafo grafo = new Grafo();
		
		ArrayList<Censista> censistas = new ArrayList<Censista>();
		censistas.add(new Censista("Homero","f"));

		Instancia ejemplo = new Instancia(grafo, censistas);
		return ejemplo;
	}
	
	@Test
	public void soloUnaManzanaACensarTest() {
		solver = new Solver(soloUnaManzana());
		sol = solver.resolver();
		
		assertEquals(1, sol.getCantCensistas());
	}
	
	@Test
	public void solverTest() {
		solver = new Solver(instancia());
		sol = solver.resolver();
		
		assertEquals(3, sol.getCantCensistas());
	}
	
	@Test(expected = NullPointerException.class)
	public void instanciaNullTest() {
		solver = new Solver(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ningunaManzanaTest() {
		solver = new Solver(ningunaManzana());
		sol = solver.resolver();
	}

	@Test(expected = IllegalArgumentException.class)
	public void ningunCensistaTest() {
		solver = new Solver(ningunCensista());
		sol = solver.resolver();
	}
	
	private Instancia ningunCensista() {
		Grafo grafo = new Grafo();
		grafo.agregarVertice("1");

		Instancia ejemplo = new Instancia(grafo,  new ArrayList<Censista>());
		return ejemplo;
	}

}
