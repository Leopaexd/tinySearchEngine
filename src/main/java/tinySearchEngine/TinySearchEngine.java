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
		entry newEntry = new entry(word);
		newEntry.addAttribute(attr);
		index.add(null); //Adds an empty element to the index
		//While-loop that iterates through all entries in the index from the right, all entries larger
		//than the new entry is moved one step to the right
		int i = index.size()-1;
		while (index.get(i).compareTo(newEntry) > 0) {
			index.set(i+1, index.get(i)); //Moves element to the right
			i--;
		}
		index.set(i, newEntry); //inserts new entry at the right place in the index, keeping it in order
	}
	
	//Search
	public List<Document> search (String query) {
		//Find word matching query in the linked list
		List<Document> results = new ArrayList<Document>();
		
		return results; 
	}
}
