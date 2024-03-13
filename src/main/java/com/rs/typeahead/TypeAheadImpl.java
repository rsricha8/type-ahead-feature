package com.rs.typeahead;

import java.util.*;

public class TypeAheadImpl {
	
    private HashMap<String,List<String>> cache = new HashMap<String,List<String>>();
    private List<String> allWords = new ArrayList<String>();

    
    public List<String> typeAhead(TrieNode rootNode,String usrInput){
    	if (this.cache.containsKey(usrInput)) {
    		System.out.println("Value found in cache.");
			return cache.get(usrInput);
		}
		else {
			List<String> suggestions = getTypeAheadSuggestions(usrInput, rootNode);
			cache.put(usrInput, suggestions);
			return suggestions;
		}
	
    }
    
	
    public List<String> getTypeAheadSuggestions(String word, TrieNode rootNode){
        TrieNode current = rootNode;
        for (int i = 0; i < word.length(); i++) {
            Map<Character,TrieNode> children = current.getChildren();
            char c = word.charAt(i);
            if(children.containsKey(c)){
                current = children.get(c);
            }
            else{
                return List.of();
            }
        }

        if(current.isCompleteWord() && current!=null){
            this.allWords.add(word);
        }
        else{
        	convertToList(current, word.length(),  new StringBuilder(word));
        }
        
        return this.allWords;
    }
    
  
    public void convertToList(TrieNode rootNode,int level, StringBuilder sequence) {
        	
            if(rootNode.isCompleteWord()){
                sequence = sequence.insert(level, rootNode.getAlphabet());
                this.allWords.add(sequence.toString());
            }

            Map<Character, TrieNode> children = rootNode.getChildren();
            Iterator<Character> iterator = children.keySet().iterator();
            while (iterator.hasNext()) {
                char character = iterator.next();
                sequence = sequence.insert(level, character); 
                convertToList(children.get(character), level+1, sequence);
                sequence.deleteCharAt(level);
            }
        }
    
    
    
    

}
