package com.algo.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/** We need to make state machine of the pattern.
 *  Time complexity :  O(N )  + time taken to make state machine of pattern
 *  Assumption: Going to get  small alphabets only
 * */

public class StringMatchingFiniteAutomata {
	public class PatternStateMachine{
		int[][] stateMachine=  null;
		List<Character>  differentChars = null;
		
		 int current_i = 0;
		 int current_j = -1;
		 Map<Character,Integer> differentCharPositionMap =  new HashMap<>();
		
		 public PatternStateMachine(String pattern){
			 initStateMachine(pattern);
		 }
		 private List<Character> differentChars(String pattern) {
			 int[] charOccurCount = new int[26]; 
			 int currentPosition = 0;
			 List<Character> differentCharsList = new ArrayList<Character>();
			 for (char  c :pattern.toCharArray() ) {
				 charOccurCount[c-'a'] = charOccurCount[c-'a']+1;
				 if (charOccurCount[c-'a']  ==1) {
					 differentCharsList.add(c);
					 differentCharPositionMap.put(c, currentPosition);
					 ++currentPosition;
				 }
				 
			 }//for
			 
			 return differentCharsList;
		 }
		 private int howManyMatchFromStart(String thisPartOfStrtoMatch, String pattern) {
			 int howManyMatchFromStart = 0;
			 for (int i = 0 ;i < thisPartOfStrtoMatch.length(); ++i) {
				 if (thisPartOfStrtoMatch.charAt(i) == pattern.charAt(i)) {
					 ++howManyMatchFromStart;
				 }else {
					 break;
				 }
			 }
			 return howManyMatchFromStart;
		 }
		 private int howManyCharMatches(String strToMatch, String pattern) {
			 int charMatchCount = 0;
			 for (int i =strToMatch.length()-1 ;i>=0; --i ) {
				 String thisPartOfStrtoMatch = strToMatch.substring(i, strToMatch.length()-1);
				 int howManyMatchInThisPart = howManyMatchFromStart(thisPartOfStrtoMatch,pattern); 
				 	 if (howManyMatchInThisPart > charMatchCount) 
						 charMatchCount = howManyMatchInThisPart ;
				  
			 }
			 return charMatchCount;
			 
		 }
		 
		 private void initStateMachine(String pattern){
			 differentChars = differentChars(pattern);
			 stateMachine =  new int[pattern.length()+1][differentChars.size()];
	
			 for (int i =0 ; i< pattern.length() ;++i) {
		
				 char currentPatternChar = pattern.charAt(i);
				 for (int j=0 ;  j<differentChars.size() ; ++j) {
					 if (i ==0) {
						 if (differentChars.get(j) == currentPatternChar )
							 stateMachine[i][j] = 1;
						 else stateMachine[i][j] = 0;
					 }else{
						 if (differentChars.get(j)  == currentPatternChar ){
							 stateMachine[i][j] = i+1;
						 }else {
							 String strToMatch = ""+pattern.substring(0, i) + differentChars.get(j) ;
							 int nextState_i = howManyCharMatches(strToMatch,pattern);
							 stateMachine[i][j] = nextState_i;
						 }// if

					 }//if
				 }//for j
			 }//for i

		 }//initStateMachine

		 public boolean isAccepted(char  nextChar){
			 boolean accepted = false;
			 if (current_i == stateMachine.length -1) {
				 // Already in accepted state
				 accepted = true;
			 }else {
				 Integer charPosition_j_Obj = differentCharPositionMap.get(nextChar);
				 int charPosition_j = -1;
				 if (charPosition_j_Obj != null )
					 charPosition_j = charPosition_j_Obj;
				 if (charPosition_j>-1) {
					 current_i = stateMachine[current_i][charPosition_j];
					 if (current_i == stateMachine.length -1) {
						 accepted = true;
					 }
				 }
			 }
			 return accepted;
		 }//isAccepted
	}//state machine class
	
	public boolean patternExists(String pattern, String paragraph) {
		if (pattern ==  null || paragraph ==  null || pattern.length() ==0 || paragraph.length() ==0)
				return false;
		PatternStateMachine patternStateMachine =  new PatternStateMachine(pattern);
	
		for(char mychar: paragraph.toCharArray()) {
			if (patternStateMachine.isAccepted(mychar )  ) {
				return true;
			}
		}//for
		return false;
	}//patternExists

	@Test
	public void test_1() {
		StringMatchingFiniteAutomata algo = new StringMatchingFiniteAutomata();
		boolean actual = algo.patternExists("sea", "theseattlewinter");
		Assert.assertTrue(actual);
	}
	
	@Test
	public void test_2() {
		StringMatchingFiniteAutomata algo = new StringMatchingFiniteAutomata();
		boolean actual = algo.patternExists("sea", "seattlewinter");
		Assert.assertTrue(actual);
	}
	
	@Test
	public void test_3() {
		StringMatchingFiniteAutomata algo = new StringMatchingFiniteAutomata();
		boolean actual = algo.patternExists("sea", "thesetatlewinter");
		Assert.assertTrue(actual);
	}
	@Test
	public void test_4() {
		StringMatchingFiniteAutomata algo = new StringMatchingFiniteAutomata();
		boolean actual = algo.patternExists("sea", "t");
		Assert.assertFalse(actual);
	}
	@Test
	public void test_5() {
		StringMatchingFiniteAutomata algo = new StringMatchingFiniteAutomata();
		boolean actual = algo.patternExists("s", "theseattlewinter");
		Assert.assertTrue(actual);
	}

} //class

