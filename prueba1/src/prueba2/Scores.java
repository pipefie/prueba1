package prueba2;
import java.util.*;
import java.util.Map.Entry;
public class Scores {
	Map<String,ArrayList<Integer>> mapaScores = new TreeMap<>();
	
	public Scores(Map<String, ArrayList<Integer>> mapaScores) {
		super();
		this.mapaScores = mapaScores;
	}
	public void addUsuario(String n){
		mapaScores.put(n, null);
	}
	public void addNuevo(String n, ArrayList<Integer> lista){
		mapaScores.put(n, lista);
	}
	public void addScore(String n, int score){
		if (mapaScores.containsKey(n)){
			mapaScores.get(n).add(score);
		}
		else
			System.out.println("el nick "+ n + " no se encuentra");

	}
	public ArrayList<Integer> getScores(String n){
		if (mapaScores.containsKey(n)){
			return mapaScores.get(n);
		}
		else
			return null;

	}
	public Map<String,ArrayList<Integer>> getMap(){
		return mapaScores;
	}
	
	public static class PartidasComparator implements Comparator<Map.Entry<String, ArrayList<Integer>>>{
		@Override
		public int compare(Entry<String, ArrayList<Integer>> o1, Entry<String, ArrayList<Integer>> o2) {
			if (o1.getValue().size() == o2.getValue().size()){
				return 0;
			}
			else if (o1.getValue().size()>o2.getValue().size()){
				return 1;
			}
			else
				return -1;
		}
		
	}
	public ArrayList<String> getUsuariosFieles (){
		ArrayList<Entry<String, ArrayList<Integer>>> mapaOrdenado = new ArrayList<>(mapaScores.entrySet());
		mapaOrdenado.sort(new PartidasComparator());
		ArrayList<String> usuariosFieles = new ArrayList<>();
		for (Entry<String, ArrayList<Integer>> usuario: mapaOrdenado){
			usuariosFieles.add(usuario.getKey());
		}
		return usuariosFieles;
		
	}
	public float media (ArrayList<Integer> listascores){
		float suma=0;
		for (int i=0; i<listascores.size();i++){
			suma+=listascores.get(i);		
			}
		float media=suma/listascores.size();
		return media;
	}
	
	public TreeMap<String, Float> getPromedios(){
		TreeMap<String, Float> mapapromedios = new TreeMap<>();
		for (Entry<String, ArrayList<Integer>> usuarios : mapaScores.entrySet()){
			mapapromedios.put(usuarios.getKey(), media(usuarios.getValue()));
		}
		return mapapromedios;
		
	}
	public static void main(String[] args) {
		Map<String, ArrayList<Integer>> scores = new TreeMap<String, ArrayList<Integer>>();
		Scores mapascores = new Scores(scores);
		ArrayList<Integer> scoresnick1 = new ArrayList<>();
		scoresnick1.add(15);
		scoresnick1.add(20);
		scoresnick1.add(30);
		scoresnick1.add(10);
		ArrayList<Integer> scoresnick2 = new ArrayList<>();
		scoresnick2.add(14);
		scoresnick2.add(12);
		scoresnick2.add(40);
		ArrayList<Integer> scoresnick3 = new ArrayList<>();
		scoresnick3.add(21);
		scoresnick3.add(35);
		scoresnick3.add(45);
		scoresnick3.add(50);
		scoresnick3.add(20);
		mapascores.addNuevo("nick-1", scoresnick1);
		mapascores.addNuevo("nick-2", scoresnick2);
		mapascores.addNuevo("nick-3", scoresnick3);
		
		for (Map.Entry<String, ArrayList<Integer>> usuarios : mapascores.getMap().entrySet()){
			System.out.println("usuario: "+usuarios.getKey()+" con scores: "+mapascores.getScores(usuarios.getKey()));
		}
		
		System.out.println("usuarios ordenados por fidelidad (partidas jugadas) ascendente");
		System.out.println(mapascores.getUsuariosFieles());
		
		for (Map.Entry<String, Float> usuarios : mapascores.getPromedios().entrySet()){
			System.out.println("usuario: "+usuarios.getKey()+" con promedio de score: "+usuarios.getValue());
		}
		
		
		
	}
}
