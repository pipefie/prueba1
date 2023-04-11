package prueba1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class SortingHM {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, Double> usuariosScores = new HashMap<String, Double>();
		usuariosScores.put("nick-1", 9.1);
		usuariosScores.put("nick-2", 5.5);
		usuariosScores.put("nick-3", 10.0);
		usuariosScores.put("nick-4", 7.8);
		usuariosScores.put("nick-5", 4.2);
		usuariosScores.put("nick-6", 8.5);
		usuariosScores.put("nick-7", 8.0);
		System.out.println("HashMap antes de ordenar ");
		System.out.println(usuariosScores);
		
		System.out.println("Lista ordenada por values del map usando el sort");
		List<Entry<String, Double>> list = new ArrayList<>(usuariosScores.entrySet());
		list.sort(Entry.comparingByValue());
		System.out.println(list);
//
		Stream<Map.Entry<String, Double>> sorted = usuariosScores.entrySet().stream()
				.sorted(Map.Entry.comparingByValue());
		System.out.println("Ordenar por values del map usando el sorted");
		sorted.forEach(System.out::println);
//
		System.out.println("Ordenar por values del map usando el sort con Comparator");
		Collections.sort(list, new Comparator<Object>() {
			@SuppressWarnings("unchecked")
			public int compare(Object o1, Object o2) {
				return ((Comparable<Double>) ((Map.Entry<String, Double>) (o1)).getValue())
						.compareTo(((Map.Entry<String, Double>) (o2)).getValue());
			}
		});

		Map<String, Double> result = new LinkedHashMap<String, Double>();
		for (Iterator<Entry<String, Double>> it = list.iterator(); it.hasNext();) {
			Map.Entry<String, Double> entry = (Map.Entry<String, Double>) it.next();
			result.put(entry.getKey(), entry.getValue());
		}
		System.out.println(result);

		System.out.println("Ordenar por values un TreeSet con Comparator");
		@SuppressWarnings("rawtypes")
		Set set = new TreeSet<>(new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
                return  o1.getValue().compareTo(o2.getValue()) > 0 ? 1 : -1;
            }
        });
		set.addAll(usuariosScores.entrySet());
		System.out.println(set);
	}

}