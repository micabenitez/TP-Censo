package json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import com.google.gson.Gson;

import logica.Censista;

public class CensistasJSON {
	private ArrayList<Censista> censistas;
	
	public CensistasJSON() {
		censistas = new ArrayList<Censista>();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Censista> getCensistas(){
		return (ArrayList<Censista>) censistas.clone();
	}
	
	public static CensistasJSON leerJSON(String archivo) {
		Gson gson = new Gson();
		CensistasJSON ret = null;
		try {
			BufferedReader buffer= new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(buffer, CensistasJSON.class);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ret;
	}
	
	@Override
	public String toString() {
		StringBuilder st = new StringBuilder();
		for(Censista s : censistas) {
			st.append(s.getNombre()).append("\n");
		}
		return st.toString();
	}
	
}
