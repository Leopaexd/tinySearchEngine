package tinySearchEngine;

import java.util.Collections;
import java.util.List;
import se.kth.id1020.util.Document;

public class resultSorter {
	//Sorts the list of search results for Tiny Search Engine
	
	static List<Document> sort (String property, String direction, List<Document> results, List<Integer> occurence){
		//Sorts the list of results based on chosen criteria, default is descending popularity
		int R = results.size()-2;
		boolean swapped = true;
		while (R >= 0 && swapped == true) {
			swapped = false;
			for (int i = 0; i <= R; i++) {
				if (Compare(results.get(i),results.get(i+1),"","") < 0) {
					swapped = true;
					Collections.swap(results, i, i+1);
				}
			}
		R--;
		}	
		return results;
	}

	static int Compare (Document item1, Document item2, String property, String direction) {
		int comparison = 0;
		property = "popularity";
		if (property.equalsIgnoreCase("popularity")) comparison = item1.popularity - item2.popularity;
		return comparison;
	}
}
