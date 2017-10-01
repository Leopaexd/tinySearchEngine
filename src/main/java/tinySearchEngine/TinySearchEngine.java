package tinySearchEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import se.kth.id1020.TinySearchEngineBase;
import se.kth.id1020.util.Attributes;
import se.kth.id1020.util.Document;
import se.kth.id1020.util.Word;

public class TinySearchEngine implements TinySearchEngineBase{
	ArrayList<entry> index = new ArrayList<entry>();
	
	public void insert (Word word, Attributes attr) {
		//Create an entry for every new word and place it at the correct place in the index by using binary search.
		//If word is already in index, add new attribute to word.
		if (word.word.compareToIgnoreCase("A") < 0) return; //Prevents numbers from being placed as words in the index
		entry newEntry = new entry(word, attr);
		int point = Collections.binarySearch(index, newEntry);
		if (point >= 0) index.get(point).addAttribute(attr);
		else index.add(-(point+1), newEntry);
	}
	
	//Search
	public List<Document> search (String rawQuery) {
		//Find word matching query in the index using binary search and add all documents where the word
		//is found to list 'results' and return the list
		List<Document> results = new ArrayList<Document>();
		
		String[] parsedQuery = rawQuery.split(" ");
		int queryEnd = parsedQuery.length;
		for (int k = 0; k < parsedQuery.length; k++) {
			if (parsedQuery[k].compareToIgnoreCase("orderby") == 0) queryEnd = k; //determines where the search terms stop
		}
		
		for (int j = 0; j < queryEnd; j++) {
		//binary search
		int high = index.size()-1;
		int low = 0;	
		while (high >= low) {
			int i = low + (high - low)/2;
			int comparison = index.get(i).word.word.compareToIgnoreCase(parsedQuery[j]);
			if (comparison < 0) low = i+1; //word is in the right half
			else if (comparison > 0) high = i-1; //word is in the left half 
			else if (comparison == 0) {
				for (Attributes attribute : index.get(i).attributeList) {
					if (results.contains(attribute.document) == false) results.add(attribute.document); 
				} //prevent the same document from being listed multiple times
				break;
			} 
		}
		}
		return results;
		
	}
}
