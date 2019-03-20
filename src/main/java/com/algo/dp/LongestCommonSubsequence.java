package com.algo.dp;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;
/***
 * 1. Create an array which is based on memorization and Dynamic programming. This array will how many char 
 * matched in smaller sub string.
 * 2. Travel through last cell in the array and use Stack to story matched character
 * 3. Traverse Stack to collect list of char which is a matched  sub sequence.
 * **/
public class LongestCommonSubsequence {
	public String findLCS(String s1, String s2) {
		int[][] matchSeqArr =  new int[s1.length() + 1][s2.length() + 1];	
		//#1
		for(int i = 1 ;i< matchSeqArr.length ; ++i) {
			for(int j = 1 ;j < matchSeqArr[0].length ; ++j) {
					
					if (s1.charAt(i-1) == s2.charAt(j-1)){
						matchSeqArr[i][j] = matchSeqArr[i-1][j-1]+1; 
					}else {
						matchSeqArr[i][j] = Math.max( matchSeqArr[i][j-1] , matchSeqArr[i-1][j]) ;
					}
			}
		} 	
		//#2
		int i = matchSeqArr.length-1;
		int j =matchSeqArr[0].length-1;
		Stack<Character> matchedChar = new Stack<Character>();
		while (i!=0 && j!=0 ) {
			if (s1.charAt(i-1) == s2.charAt(j-1)){
				matchedChar.push(s1.charAt(i-1));
				i = i-1;
				j=j-1;
			}else if (matchSeqArr[i-1][j] >= matchSeqArr[i][j-1] )  {
				i=i-1;
			}else  {
				j=j-1;
			}	
		}//while
		//#3
		StringBuffer sb =  new StringBuffer();
		while(!matchedChar.isEmpty()) {
			sb.append(matchedChar.pop());
		}
		return sb.toString();
	}
	
	@Test
	public void test_1() {
		LongestCommonSubsequence algo = new LongestCommonSubsequence();
		Assert.assertEquals("BCBA", algo.findLCS("ABCBDAB", "BDCABA"));
	}

	@Test
	public void test_2() {
		LongestCommonSubsequence algo = new LongestCommonSubsequence();
		Assert.assertEquals("BC", algo.findLCS("ABC", "BCA"));
	}
	
	@Test
	public void test_3() {
		LongestCommonSubsequence algo = new LongestCommonSubsequence();
		Assert.assertEquals("A", algo.findLCS("ABC", "BA"));
	}
	@Test
	public void test_4() {
		LongestCommonSubsequence algo = new LongestCommonSubsequence();
		Assert.assertEquals("BCD", algo.findLCS("ABCEDF", "BCADA"));
	}
	@Test
	public void test_5() {
		LongestCommonSubsequence algo = new LongestCommonSubsequence();
		Assert.assertEquals("BCDE", algo.findLCS("ABCEDPFE", "BCADAE"));
	}
}
