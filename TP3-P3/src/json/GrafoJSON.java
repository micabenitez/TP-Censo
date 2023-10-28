package json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import logica.Vertice;

public class GrafoJSON {
	private Map<String, ArrayList<Vertice>> grafo;
	
	public GrafoJSON() {
		grafo = new HashMap<String, ArrayList<Vertice>>();
	}
	
	public static GrafoJSON leerJSON(String archivo) {
		Gson gson = new Gson();
		GrafoJSON ret = null;
		try {
			BufferedReader buffer= new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(buffer, GrafoJSON.class);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ret;
	}
	
	@Override
	public String toString() {
		StringBuilder st = new StringBuilder();
		for(String s : grafo.keySet()) {
			st.append("N° de Manzana: " + s + "\t Vecinos: "+ grafo.get(s).toString()).append("\n");
		}
		return st.toString();
	}	
	
	public Map<String, ArrayList<Vertice>> getGrafo() {
		return grafo;
	}
}
