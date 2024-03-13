package com.rs.typeahead;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;


public class TypeAheadImplTest {
	
	TrieNode testNode;
	DictionaryBuilder dictBuild;
	List<String> emptyDictionary = List.of();
	List<String> dict1 = List.of("table", "top", "tom", "tap");
	
	@BeforeEach
	public void setup() {
		 testNode = new TrieNode();
		 dictBuild = new DictionaryBuilder();
		 
	}

	@Test
	public void testZeroSuggestionsForEmptyDictionary() {
		 
		 dictBuild.insertAll(testNode, emptyDictionary);
		 
		 TypeAheadImpl impl = new TypeAheadImpl();
		 List<String> suggestions = impl.typeAhead(testNode, "abc");
		 
		 assertTrue(suggestions.size()==0);	 
		 
	}
	
	@Test
	public void testZeroSuggestionsforWordNotFound() {

		 dictBuild.insertAll(testNode, dict1);
		 
		 TypeAheadImpl impl = new TypeAheadImpl();
		 List<String> suggestions = impl.typeAhead(testNode, "abc");
		 
		 assertTrue(suggestions.size()==0);	 
		 
	}
	
	@Test
	public void testSuggestionsForCompleteWord() {
		 
		 dictBuild.insertAll(testNode, dict1);
		 
		 TypeAheadImpl impl = new TypeAheadImpl();
		 List<String> suggestions = impl.typeAhead(testNode, "table");
		 
		 suggestions.forEach(System.out::println);
		 assertEquals(1,suggestions.size());
		 
	}
	
	@Test
	public void testSuggestions() {
		 
		 dictBuild.insertAll(testNode, dict1);
		 
		 TypeAheadImpl impl = new TypeAheadImpl();
		 List<String> suggestions = impl.typeAhead(testNode, "to");
		 
		 suggestions.forEach(System.out::println);
		 assertEquals(2,suggestions.size());
		 
	}

}
