package com.rs.typeahead;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

class Application {


	public static void main(String[] args) {
		
		DictionaryBuilder dictBuilder = new DictionaryBuilder();
		
		System.out.println("Fetching the input for dictionary..");
		List<String> inputList = readInputList();
    	System.out.println("Completed successfully. Total words fetched: "+ inputList.size());

    	
    	System.out.println("Starting insertion");
    	TrieNode root = dictBuilder.insertAll(new TrieNode(), inputList);
    	System.out.println("Insertion Completed.");
        
    	//System.out.println("Printing the dictionary from Trie Node now..");
        //Util.print(root,0,new StringBuilder(""));
    	
    	try (Scanner usrInputScan = new Scanner(System.in)) {
			System.out.println("Enter the search word: ");
			String usrInput = usrInputScan.nextLine();
			
			System.out.println("Printing typeahead for:" + usrInput);
			TypeAheadImpl ta = new TypeAheadImpl();
			ta.typeAhead(root, usrInput)
				.forEach(System.out::println);
		}
		
	}

    
	private static List<String> readInputList() {
		
		//Smaller list
		//List<String> inputList = Arrays.asList(new String[]{"tom", "table", "top", "tank"}); 

		List<String> inputList = new ArrayList<String>();

		try {
			 URL englishList = new URL("https://raw.githubusercontent.com/dwyl/english-words/master/words_alpha.txt");
			 BufferedReader in = new BufferedReader(
				        new InputStreamReader(englishList.openStream()));
			 String inputLine;
		        while ((inputLine = in.readLine()) != null)
		            inputList.add(inputLine);
		        in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputList;
	}

}
