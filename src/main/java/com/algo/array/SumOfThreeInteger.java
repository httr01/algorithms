package com.algo.array;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
For example, given array S = {-1 2 1 -4}, and target = 1. 
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
public class SumOfThreeInteger {
	public int findSumOfThreeInteger(int[] dataArray, int target) {
		if (dataArray.length< 3) 
		Arrays.sort(dataArray);
		int sumOfInteger = Integer.MAX_VALUE;
		int howfarFromTarget = Integer.MAX_VALUE;
		for (int index = 2 ; index < dataArray.length; ++index) {
			int currentSum = dataArray[index] +  dataArray[index-1] +  dataArray[index-2] ;
			int currentHowfarFromTarget = Math.abs(currentSum-target);
			if (currentHowfarFromTarget < howfarFromTarget ) {
				howfarFromTarget = currentHowfarFromTarget;
				sumOfInteger=currentSum;
			}
		}
		
		return sumOfInteger;
	}
	
	@Test
	public void test_1() {
		SumOfThreeInteger soti = new SumOfThreeInteger();
		int[] dataArray = {-1 ,2, 1, -4};
		Assert.assertEquals(2, soti.findSumOfThreeInteger(dataArray, 1));		
	}
	
	@Test
	public void test_2() {
		SumOfThreeInteger soti = new SumOfThreeInteger();
		int[] dataArray = {-1 ,2, 1, -4,2,-1,3,-2};
		Arrays.sort(dataArray);
		System.out.println("Sorted: "+Arrays.toString(dataArray));
		Assert.assertEquals(-1, soti.findSumOfThreeInteger(dataArray, -2));		
	}
	
	@Test
	public void test_3() {
		SumOfThreeInteger soti = new SumOfThreeInteger();
		int[] dataArray = {-1 ,2, 1, -4,2,-1,3,-2,0,-3};
		Arrays.sort(dataArray);
		Assert.assertEquals(-2, soti.findSumOfThreeInteger(dataArray, -1));		
	}
	
	@Test
	public void test_4() {
		SumOfThreeInteger soti = new SumOfThreeInteger();
		int[] dataArray = {-1 ,2, 1, -4,2,-1,3,-2,0,-3};
		Arrays.sort(dataArray);
		Assert.assertEquals(-2, soti.findSumOfThreeInteger(dataArray, -2));		
	}
}
