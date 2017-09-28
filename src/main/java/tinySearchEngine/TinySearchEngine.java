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
		int i = index.size()-1;
		System.out.println(i);
		
		while (index.get(i).word.word.compareTo(word.word) < 0 && i < index.size()/2) i=i*2; 
		//if the new word should be to the right of the word at index i, i is multiplied by two, so that the
		//insert method does not have to iterate over each entry
		
		//While-loop that iterates through all entries in the index part from the right
		while (index.get(i).word.word.compareTo(word.word) > 0 && i < 0) {
			if (index.get(i).word.word.compareTo(word.word) == 0) {
				index.get(i).addAttribute(attr);
				return;
			} else {
			i--;
			}
		}
		entry newEntry = new entry(word, attr);
		index.add(i, newEntry); //inserts new entry at the right place in the index, keeping it in order, 
								//shifting subsequent entries to the right
	}
	
	//Search
	public List<Document> search (String query) {
		//Find word matching query in the linked list
		List<Document> results = new ArrayList<Document>();
		
		return results; 
	}
}
