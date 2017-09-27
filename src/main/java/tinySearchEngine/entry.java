package tinySearchEngine;

import se.kth.id1020.util.Word;
import se.kth.id1020.util.Attributes;
import java.util.ArrayList;

public class entry {
//Entries are placed in the search engine index. Each entry is a linked list and has a reference to a Word and to
//an arraylist containing attributes associated with that word. Each entry also provides a link to the next, or to null.
	
	entry link; //Variable containing the reference to the next entry.
	ArrayList<Attributes> attributeList = new ArrayList<Attributes>(); //List of attributes
	Word word; //The stored word
	
	public entry(Word newWord) {
		//Constructor
		word = newWord;
	}
	
	public void setLink(entry next) {
		//Method to change to what entry and existing entry links
		link = next;
	}
	
	public void addAttribute(Attributes newAttribute) {
		//adds a new attribute to the list
		attributeList.add(newAttribute);
	}
	
}
