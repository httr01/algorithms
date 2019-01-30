package com.algo.string;

import org.junit.Assert;
import org.junit.Test;

public class PrefixPostfix {
	/**Find  longest prefix from A which is also suffix of B.
	 * Example "atention", "rotate" 
	 * ate : is largest such prefix**/
	public String findLongestPrePostfix(String A, String B) {
		if (A ==  null || B== null || A.length() ==0 || B.length()==0 )	
			return null;
		int foundStartingIndexInB = B.indexOf(A.charAt(0), 0 );
		while(foundStartingIndexInB>=0) {
			String bSubStr = B.substring(foundStartingIndexInB,B.length());
			if (A.startsWith(bSubStr)) {
				return bSubStr;
			}else {
				foundStartingIndexInB = B.indexOf(A.charAt(0), foundStartingIndexInB );
			}	
		}//while

		return null;	

	}
	/** Find largest matching prefix in A and B string. **/
	public String findLongestPrefix(String A, String B) {
		if (A ==  null || B== null || A.length() ==0 || B.length() ==0)	
			return null;

		int length = A.length() < B.length() ? A.length():B.length();
		int i=0;
		for (i=0 ;i< length; ++i) {
			if (A.charAt(i) != B.charAt(i)) {
				break;
			}
		}	//for
		return A.substring(0,i);

	}
	
	@Test
	public void test_longestPrefix_1() {
		
		PrefixPostfix algo =  new PrefixPostfix();
		Assert.assertEquals("SA", algo.findLongestPrefix("SAM", "SAND"));
	}
	@Test
	public void test_longestPrefix_2() {
		
		PrefixPostfix algo =  new PrefixPostfix();
		Assert.assertEquals("S", algo.findLongestPrefix("SPAM", "SAND"));
	}
	@Test
	public void test_longestPrefix_3() {
		
		PrefixPostfix algo =  new PrefixPostfix();
		Assert.assertEquals("", algo.findLongestPrefix("LPAM", "SAND"));
	}
	
	@Test
	public void test_findLongestPrePostfix_1() {
		
		PrefixPostfix algo =  new PrefixPostfix();
		Assert.assertEquals("ate", algo.findLongestPrePostfix("ateantion", "rotate"));
	}
	@Test
	public void test_findLongestPrePostfix_2() {
		
		PrefixPostfix algo =  new PrefixPostfix();
		Assert.assertEquals("atea", algo.findLongestPrePostfix("ateantion", "rotatea"));
	}

}
