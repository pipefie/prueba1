package prueba1;
import prueba1.HighScores;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Map<String, Integer> mapaHighscores = new HashMap<String, Integer>();
		
		HighScores mapaH = new HighScores(mapaHighscores);
		mapaH.addHighScore("nick_1", 10);
		mapaH.addHighScore("nick_2",50);
		mapaH.addHighScore("nick_3", 5);
		mapaH.addHighScore("nick_4", 16);
		mapaH.addHighScore("nick_5", 60);
		
		System.out.println("lista antes de ordenar");
		System.out.println(mapaH.toString());
		
		System.out.println("lista de nombres ordenada de menor a mayor score");
		System.out.println(mapaH.getMejoresUsuarios());
		
	}

}
