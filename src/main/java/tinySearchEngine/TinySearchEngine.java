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
	
	public TinySearchEngine() { 
		//Constructor that creates an empty index where entries can be inserted
	}
	
	public void insert (Word word, Attributes attr) {
		//Insertion
		//System.out.println("Index size: " + index.size());
		
		entry newEntry = new entry(word, attr);
		int point = Collections.binarySearch(index, newEntry);
		if (point >= 0) {
			index.get(point).addAttribute(attr);
		} else {
			index.add(-(point+1), newEntry);
		}
		
		if (index.size() == 5000) for (entry entry: index) System.out.println(entry.word.word);
		
	}
	
	//Search
	public List<Document> search (String query) {
		//Find word matching query in the linked list using binary search
		List<Document> results = new ArrayList<Document>();
		for (int i = 0; i < 25; i++) System.out.println(index.get(i).word.word);
		int high = index.size()-1;
		int low = 0;
		
		while (high >= low) {
			int i = low + (high - low)/2;
			int comparison = index.get(i).word.word.compareTo(query);
			if (comparison > 0) low = i+1; //word is in the right half
			else if (comparison < 0) high = i-1; //word is in the left half
			else if (comparison == 0) {
				for (Attributes attribute: index.get(i).attributeList) results.add(attribute.document);
			} 
		}
		return results;
	}
}
