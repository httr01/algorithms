package com.algo.string;

import org.junit.Assert;
import org.junit.Test;

public class ReplaceSpace {
	private int[] countTotalSpaces(String input) {
			int[] spacesMetadata = new int[2];
			 
			char[] inputCharArr = input.toCharArray();
			
			int currHowManySpaces = 0;
			for (int index = 0 ;index < inputCharArr.length ; ++index) {
				 
				if (inputCharArr[index] == ' ' ) {
					++currHowManySpaces;
				}else {
					spacesMetadata[0]+=currHowManySpaces;
					currHowManySpaces=0;
					spacesMetadata[1] =index;
				}
			}
			return spacesMetadata;
	}
	
	public String replaceSpaces(String input) { 
		char[] inputCharArr = input.toCharArray();
		int[] spacesMetadata =countTotalSpaces(input);
		int indexToPlace = spacesMetadata[1] + spacesMetadata[0]*2;
		for (int index = spacesMetadata[1] ; index >=0 ; --index) {
			if (inputCharArr[index] == ' ') {
				inputCharArr[indexToPlace-2]='%';
				inputCharArr[indexToPlace-1]='2';
				inputCharArr[indexToPlace]='0';
				indexToPlace = indexToPlace-3;
			}else {
				inputCharArr[indexToPlace]=inputCharArr[index];
				--indexToPlace;
			}
		} 
		return String.valueOf(inputCharArr);
	}
	
	@Test
	public void test_1() {
		String input = "this is seattle .           ";
		ReplaceSpace algo =  new ReplaceSpace();
		String changedStr =  algo.replaceSpaces(input);
		Assert.assertTrue(changedStr.startsWith("this%20is%20seattle%20."));
	}
	
	@Test
	public void test_2() {
		String input = "this is seattle.           ";
		ReplaceSpace algo =  new ReplaceSpace();
		String changedStr =  algo.replaceSpaces(input);
		Assert.assertTrue(changedStr.startsWith("this%20is%20seattle."));
	}
	
	@Test
	public void test_3() {
		String input = "Here is my home .            ";
		ReplaceSpace algo =  new ReplaceSpace();
		String changedStr =  algo.replaceSpaces(input);
		Assert.assertTrue(changedStr.startsWith("Here%20is%20my%20home%20."));
	}
	
	@Test
	public void test_4() {
		String input = "Here is my home .            ";
		ReplaceSpace algo =  new ReplaceSpace();
		String changedStr =  algo.replaceSpaces(input);
		Assert.assertTrue(changedStr.startsWith("Here%20is%20my%20home%20."));
	}
}
  