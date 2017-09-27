package tinySearchEngine;

import se.kth.id1020.util.Word;
import se.kth.id1020.util.Attributes;
import java.util.ArrayList;

public class entry implements Comparable<entry> {
//Entries are placed in the search engine index. Each entry has a reference to a Word and to
//an arraylist containing attributes associated with that word.
	
	ArrayList<Attributes> attributeList = new ArrayList<Attributes>(); //List of attributes
	Word word; //The stored word
	
	public entry(Word newWord) {
		//Constructor
		word = newWord;
	}
	
	public void addAttribute(Attributes newAttribute) {
		//adds a new attribute to the list
		attributeList.add(newAttribute);
	}
	
	public int compareTo(entry comparison) {
		//When entries are compared, comparison is made between the string representation of the entries' words
		return this.word.word.compareTo(comparison.word.word);
	}
}
