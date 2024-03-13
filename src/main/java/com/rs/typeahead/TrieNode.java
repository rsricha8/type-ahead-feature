package com.rs.typeahead;

import java.util.*;

class TrieNode{

    private char alphabet;
    private Map<Character,TrieNode> children = new HashMap<>();
    private boolean completeWord = false;

	public char getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(char alphabet) {
		this.alphabet = alphabet;
	}

	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}

	public boolean isCompleteWord() {
		return completeWord;
	}

	public void setCompleteWord(boolean completeWord) {
		this.completeWord = completeWord;
	}
    
    

}
