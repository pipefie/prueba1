package prueba1;
import java.util.*;
import java.util.Map.Entry;

public class HighScores {
	Map<String, Integer> mapaScores = new HashMap<>();
	public HighScores(Map<String, Integer> mapaScores) {
		super();
		this.mapaScores = mapaScores;
	}
	
	public void addUsuario(String n){
		mapaScores.put(n, null);
	}
	public void addHighScore (String n, int score){
		mapaScores.put(n, score);
	}
	public int getHighScore(String n){
		if (mapaScores.containsKey(n)){
			return mapaScores.get(n);
		}
		else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return "HighScores [" + mapaScores + "]";
	}
	
	
	public ArrayList<String> getMejoresUsuarios(){
		
		List<Entry<String, Integer>> mejoresUsuarios = new ArrayList<>(mapaScores.entrySet());
		mejoresUsuarios.sort(Entry.comparingByValue());
		ArrayList<String> listamejores= new ArrayList<String>();
		for (Entry<String, Integer> usuario: mejoresUsuarios){
			listamejores.add(usuario.getKey());
		}
		return listamejores;	
		 
	 }
	

}
