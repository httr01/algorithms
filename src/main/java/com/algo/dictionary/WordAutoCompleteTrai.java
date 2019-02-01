package com.algo.dictionary;
import java.util.*;
/***Implement Trai
 * how would you implement the autocomplete search given a dictionary of all words
 * **/

import org.junit.Test;
public class WordAutoCompleteTrai {
	 public class Node{
		char value;
		Map<Character, Node> map =  new HashMap<>();
		public Node(char c) {
			this.value=c;
		}
	 }

	Node rootNode= new Node('*');
	public List<String>    getAllWords(Node currNode) {
		if  (currNode ==  null || currNode.value == '^')  return null;
		List<String> allWords = new ArrayList<>();
		
		Iterator<Character> keysItr = currNode.map.keySet().iterator();
		while (keysItr.hasNext()){
			Node nextNode = currNode.map.get(keysItr.next());
			List<String> allWordsFromChildNode =  getAllWords(nextNode);
			if (allWordsFromChildNode !=  null)
				 
				for (String word:allWordsFromChildNode )
					allWords.add( currNode.value+ word);
			else
				allWords.add( currNode.value+"");
		}//while
		return allWords;
	}
	
	public List<String>  getAll(final Node root, String prefix){
			Node currNode =root;
		// Traverse Trai and Reach till last char in prefix
		for (Character c: prefix.toCharArray()) {
			currNode = get(currNode,c);
			if (currNode ==  null) return null;
		}//for
		
		List<String> allSuffix = getAllWords(currNode);
		List<String>  finalPossibleOptions = new ArrayList<>();;
		if (allSuffix!= null){
			for (String suffix:allSuffix ) {
				finalPossibleOptions.add(prefix.substring(0, prefix.length()-1)+suffix);
			}//for
		}else {
			finalPossibleOptions.add(prefix);
			
		}//if

		return finalPossibleOptions;
	}
	public Node get(Node currNode, char givenChar){
		if (currNode ==  null)  return null;
		return currNode.map.get(givenChar);
	}

	public Node   addCharInNode(Node rootNode, char charToAdd) {
		Node node   = null;
		if (rootNode != null)  {
			Node existsObj = rootNode.map.get(charToAdd);
			if (existsObj==  null ) {
				node   = new Node(charToAdd);
				rootNode.map.put(new Character(charToAdd),node);
			}else node= existsObj;	
		}//
		return node;
}
	public WordAutoCompleteTrai() {
		
	}
	public void setWords (String[] words ){
		for (String word: words){
			Node currNode = rootNode;
			 for (char c:word.toCharArray()) {
				currNode = addCharInNode(currNode,c);
			 }
			 addCharInNode(currNode,'^'); //  end Character
		}//for

	}// WordAutoCompleteTrai

	public List<String>	 autoComplete(String prefix) {
		List<String>	 allPossibleWords=    getAll(rootNode,prefix);
		return allPossibleWords;
		 
	}
	
	@Test
	public void test_1() {
		String[] words = {"CAT","CAB", "CRAP", "CRAIG", "BED", "BEAR"};
		WordAutoCompleteTrai algo = new WordAutoCompleteTrai( );
		algo.setWords(words);
		List<String> possibleOptionsWords = algo.autoComplete("CRA");
		System.out.println(possibleOptionsWords);
		
	}
	 
	
	@Test
	public void test_2() {
		String[] words = {"AMAZON","AMAZING", "AMAEND" };
		WordAutoCompleteTrai algo = new WordAutoCompleteTrai( );
		algo.setWords(words);
		List<String> possibleOptionsWords = algo.autoComplete("AMAZ");
		System.out.println(possibleOptionsWords);
		
	}
	

}
