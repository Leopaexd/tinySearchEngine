package tinySearchEngine;

import java.util.ArrayList;
import java.util.List;

import se.kth.id1020.TinySearchEngineBase;
import se.kth.id1020.util.Attributes;
import se.kth.id1020.util.Document;
import se.kth.id1020.util.Word;

public class TinySearchEngine implements TinySearchEngineBase{
	entry index;
	int indexSize = 0;
	
	public TinySearchEngine() { 
		//Constructor that creates an empty index where entries can be inserted
		
	}
	
	public void insert (Word word, Attributes attr) {
		//Insertion
		entry newEntry = new entry(word);
		newEntry.setLink(index); //TODO DUBBELKOLLA ATT DET FUNKAR
		index = newEntry;
		indexSize++;
	}
	
	//Search
	public List<Document> search (String query) {
		//Find word matching query in the linked list
		entry current = index;
		List<Document> results = new ArrayList<Document>();
		for (int i = 0; i < indexSize; i++) {
			if (current.word.word == query) {
				for (Attributes item : current.attributeList) {
					results.add(item.document);
				}
				return results; //Returns list of documents containing word matching query
			} else {
				current = current.link;
			}
		}
		return results; //Returns empty list if nothing found
	}
}
