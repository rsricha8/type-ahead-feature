package com.rs.typeahead;

import java.util.List;
import java.util.Map;

class DictionaryBuilder{
	
	public TrieNode insertAll(TrieNode rootNode, List<String> list){
		
		TrieNode curr = rootNode;
		for (String word:list) {
			insertWord(curr, word);
		}
		return curr;
        
    }

    private void insertWord(TrieNode rootNode, String word){
    	
        TrieNode current = rootNode;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Map<Character,TrieNode> children = current.getChildren();
            if(children.containsKey(c)){
                current = children.get(c);
            }
            else{
                TrieNode trieNode = new TrieNode();
                children.put(c, trieNode);
                current = children.get(c);
            }
        }
        current.setCompleteWord(true);
    }
}
