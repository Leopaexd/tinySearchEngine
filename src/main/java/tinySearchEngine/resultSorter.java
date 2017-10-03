package tinySearchEngine;

import java.util.Collections;
import java.util.List;
import se.kth.id1020.util.Document;

public class resultSorter {
	//Sorts the list of search results for Tiny Search Engine
	
	static List<Document> sort (String property, String direction, List<Document> results, List<Integer> occurence, List<Integer> count){
		//Sorts the list of results based on chosen criteria, default is descending popularity
		System.out.println("Sorted by: " + direction + " " + property);
		int R = results.size()-2;
		boolean swapped = true;
		while (R >= 0 && swapped == true) {
			swapped = false;
			for (int i = 0; i <= R; i++) {
				if (Compare(i,i+1, results, property,direction, occurence, count) < 0) {
					swapped = true;
					Collections.swap(results, i, i+1);
				}
			}
		R--;
		}	
		return results;
	}

	static int Compare (int item1, int item2, List<Document> results, String property, String direction, List<Integer> occurence, List<Integer> count) {
		//Compares two results based on chosen property and direction
		int comparison = 0;
		if (property.equalsIgnoreCase("popularity")) comparison = results.get(item1).popularity - results.get(item2).popularity;
		if (property.equalsIgnoreCase("occurence")) comparison = occurence.get(item2) - occurence.get(item1);
		if (property.equalsIgnoreCase("count")) comparison = count.get(item1) - count.get(item2);
		if (direction.equalsIgnoreCase("ascending")) comparison = -comparison; //change direction
		return comparison;
	}
}
