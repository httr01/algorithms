package com.algo.string;

import org.junit.Assert;
import org.junit.Test;

public class AddSpaceBetweenWords {
	
	public String addSpaces(String paragraph , String[] dictionary) {
		paragraph = paragraph.trim();
		StringBuffer finalParagraph =  new StringBuffer();
		StringBuffer currWord =  new StringBuffer();
		for (int i=0 ;i < paragraph.length() ;++i) {
			char  currChar = paragraph.charAt(i);
			currWord.append(currChar);
			if (isInDictionary(currWord.toString(),dictionary) ) {
				finalParagraph.append(currWord.toString()).append(" ");
				currWord =  new StringBuffer();
			} 
			
			
		}//for
		finalParagraph.append(currWord.toString());
		return finalParagraph.toString().trim();
	}
	
	private boolean isInDictionary(String word,String[] dictionary) {
		for (int i = 0 ; i < dictionary.length; ++i) 
			if (word.equalsIgnoreCase(dictionary[i]))  return true;
		return false;
	}
	@Test
	public void test_1(){
		AddSpaceBetweenWords algo = new AddSpaceBetweenWords();
		String[] dictionary = {"warm"};
		Assert.assertEquals("warm water", algo.addSpaces("warmwater", dictionary));
	}
	
	@Test
	public void test_2(){
		AddSpaceBetweenWords algo = new AddSpaceBetweenWords();
		String[] dictionary = {"warm", "water", "jug"};
		Assert.assertEquals("warm water jug", algo.addSpaces("warmwaterjug", dictionary));
	}
	
	
	@Test
	public void test_3(){
		AddSpaceBetweenWords algo = new AddSpaceBetweenWords();
		String[] dictionary = {"warm", "jug"};
		Assert.assertEquals("warm water jug", algo.addSpaces("warmwaterjug", dictionary));
	}
}



