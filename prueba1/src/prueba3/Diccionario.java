package prueba3;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Diccionario {
	Map<String, ArrayList<String>> diccionario = new TreeMap<>();
		
	public Diccionario(Map<String, ArrayList<String>> diccionario) {
		super();
		this.diccionario = diccionario;
	}
	public void addEntrada (String palabra, ArrayList<String> definiciones){
		diccionario.put(palabra, definiciones);
	}

	public void addDef (String palabra, String def){
		if (diccionario.containsKey(palabra)){
			diccionario.get(palabra).add(def);
		}
		else 
			System.out.println("no se encuntra la palabra en el diccionario");
	}
	public void quitaDef (String palabra, String def){
		if (diccionario.containsKey(palabra)){
			diccionario.get(palabra).remove(def);
		}
	}
	public ArrayList<String> getDefs (String palabra){
		if (diccionario.containsKey(palabra)){
			return diccionario.get(palabra);
			}
		else
			return null;
	}
	public ArrayList<String> getPalabras(){
		ArrayList<String> palabrasOrdenadas = new ArrayList<>();
		for (Entry<String, ArrayList<String>> palabras : diccionario.entrySet()){
			palabrasOrdenadas.add(palabras.getKey());
		}
		return palabrasOrdenadas;
	}
	public Map<String, ArrayList<String>> getDiccionario (){
		return diccionario;
	}

	public static void main(String[] args) {
		TreeMap<String, ArrayList<String>> diccionario1 = new TreeMap<>();
		Diccionario midiccionario = new Diccionario(diccionario1);
		ArrayList<String> defabandonar = new ArrayList<>();
		ArrayList<String> defencontrar = new ArrayList<>();
		ArrayList<String> defayudar = new ArrayList<>();
		defabandonar.add("Dejar solo, sin atención, sin cuidados a una persona, un animal o una cosa.");
		defabandonar.add("Dejar de hacer algo, o dejar de estar en un lugar.");
		defabandonar.add("Dejar de estar con alguien, como una pareja o un amigo");
		defayudar.add("def-1");
		defayudar.add("def-2");
		defayudar.add("def-3");
		defencontrar.add("def-1");
		defencontrar.add("def-2");
		defencontrar.add("def-3");
		midiccionario.addEntrada("a¡'bandonar", defabandonar);
		midiccionario.addEntrada("encontar", defencontrar);
		midiccionario.addEntrada("ayudar", defayudar);
		
		System.out.println("diccionario antes de ordenar");
		for (Entry<String, ArrayList<String>> palabras : midiccionario.getDiccionario().entrySet()){
			System.out.println("Palabra: "+palabras.getKey()+" definiciones: "+palabras.getValue());
		}
		
		System.out.println("palabras ordenadas");
		System.out.println(midiccionario.getPalabras());
		
		
		

	}

}
