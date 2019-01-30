package com.algo.string;

import org.junit.Assert;
import org.junit.Test;

public class StringMatching {
	/**
	 * An example of the string-matching problem, where we want to find all occurrences of
the pattern  abaa in the text  abcabaabcabac. The pattern occurs only once in the text,
at shift s D 3, which we call a valid shift.*/
	public int findCountOFMatchingString(String subString,  String paragraph) {
		// return " count of  all occurrences of subString in paragraph" 
		
		return count(subString,paragraph );
		 
		
	}
	//12.15 - 23
	private int count(String subString,  String paragraph ) {
		int count = 0;
		if ( paragraph== null || subString ==  null || paragraph.length() ==0 || subString.length() > paragraph.length())
			return 0;
		for (int i = 0 ;i <=paragraph.length()-subString.length() ; ++i){
			if (subString.charAt(0) == paragraph.charAt(i)) {
				// possible match
				if (isMatching(subString,paragraph,i)) 
					++count;
			}//if	
		}//for
		return count;
	}//count
	private boolean isMatching(String subString,  String paragraph, int index){
		boolean isMatching = false;
		int i =0;
		for ( i =0 ;i<subString.length() && index<paragraph.length(); ++i) {
			if (subString.charAt(i) != paragraph.charAt(index++))
				return false;
		}	
		if (i>=subString.length())
				isMatching = true;
		return isMatching;
	
	}//isMatching
	
	@Test
	public void test_0() {
		StringMatching algo =  new StringMatching();
		String paragraph = "seaatseaside";
		Assert.assertEquals(2, algo.findCountOFMatchingString("sea", paragraph));
		
	}
	
	@Test
	public void test_1() {
		StringMatching algo =  new StringMatching();
		String paragraph = "abcabaabcabac";
		Assert.assertEquals(1, algo.findCountOFMatchingString("abaa", paragraph));
		
	}
	@Test
	public void test_2() {
		StringMatching algo =  new StringMatching();
		String paragraph = "sea";
		Assert.assertEquals(1, algo.findCountOFMatchingString("sea", paragraph));
		
	}
	
	@Test
	public void test_3() {
		StringMatching algo =  new StringMatching();
		String paragraph = "se";
		Assert.assertEquals(0, algo.findCountOFMatchingString("sea", paragraph));
		
	}
	@Test
	public void test_4() {
		StringMatching algo =  new StringMatching();
		String paragraph = "sease";
		Assert.assertEquals(1, algo.findCountOFMatchingString("sea", paragraph));
		
	}
	@Test
	public void test_5() {
		StringMatching algo =  new StringMatching();
		String paragraph = "seseaase";
		Assert.assertEquals(1, algo.findCountOFMatchingString("sea", paragraph));
		
	}
	
	@Test
	public void test_6() {
		StringMatching algo =  new StringMatching();
		String paragraph = "sesese";
		Assert.assertEquals(0, algo.findCountOFMatchingString("sea", paragraph));
		
	}
}
