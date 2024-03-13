package com.rs.typeahead;

import java.util.Iterator;
import java.util.Map;

public class Util {

public static void print(TrieNode rootNode,int level, StringBuilder sequence) {
	
    if(rootNode.isCompleteWord()){
        sequence = sequence.insert(level, rootNode.getAlphabet());
        System.out.println(sequence.toString());
    }

    Map<Character, TrieNode> children = rootNode.getChildren();
    Iterator<Character> iterator = children.keySet().iterator();
    while (iterator.hasNext()) {
        char character = iterator.next();
        sequence = sequence.insert(level, character); 
        print(children.get(character), level+1, sequence);
        sequence.deleteCharAt(level);
    }
}

}
