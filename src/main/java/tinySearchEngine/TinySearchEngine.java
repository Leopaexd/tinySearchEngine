package tinySearchEngine;

import java.util.ArrayList;
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
		
		if (index.size()==0) {
			entry newEntry = new entry(word, attr);
			index.add(newEntry);
			return;
		}
		
		System.out.println("Index size: " + index.size());
		int i = 1;
		
		if (index.size() <= 2) {
			i = index.size()-1;
		}
		
		int comparison = index.get(i).word.word.compareTo(word.word);	
		
		//While-loop that iterates through all entries in the index part from the right
		while (comparison != 0 && i > 0) { 	
			if (comparison > 0 || i >= index.size()-1) {	//new word should be to the left
				if (index.get(i-1).word.word.compareTo(word.word) < 0) { //right spot for new word
					index.add(i, new entry(word, attr));
					return;
				} 
				else i--;
				}	else {//new word should be to the right		
					i = i*4;
					if (i > index.size()-1) i = index.size()-1; //prevent i from getting to large
				}
			
			comparison = index.get(i).word.word.compareTo(word.word);
		}
		
		if (index.get(i).word.word.compareTo(word.word) == 0) {
			index.get(i).addAttribute(attr);
			return;
		} 
		
		if (i == 0) {
			index.add(i, new entry(word, attr));
			return;
		}

		if (index.size() == 40100) for (entry entry: index) System.out.println(entry.word.word);
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
