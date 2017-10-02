package tinySearchEngine;

import se.kth.id1020.util.Word;
import se.kth.id1020.util.Attributes;
import java.util.ArrayList;

public class entry implements Comparable<entry> {
//Entries are placed in the search engine index. Each entry has a reference to a Word and to
//an arraylist containing attributes associated with that word.
	
	ArrayList<Attributes> attributeList = new ArrayList<Attributes>(); //List of attributes
	ArrayList<Integer> count = new ArrayList<Integer>(); //parallel list of word count for each document
	Word word; //The stored word
	
	public entry(Word newWord, Attributes newAttribute) {
		//Constructor
		word = newWord;
		addAttribute (newAttribute);
	}
	
	public void addAttribute(Attributes newAttribute) {
		//adds a new attribute to the list
		for (int i = 0; i < attributeList.size(); i++) {
			if (attributeList.get(i).document.name.equalsIgnoreCase(newAttribute.document.name)) {
				count.set(i, count.get(i)+1); //If the entry already has an attribute for a document, increase
				//count instead of adding new attribute.
				return;
			}
		}
		attributeList.add(newAttribute);
		count.add(1);		
	}
	
	public int compareTo(entry comparison) {
		//When entries are compared, comparison is made between the string representation of the entries' words
		return this.word.word.compareToIgnoreCase(comparison.word.word);
	}
}
