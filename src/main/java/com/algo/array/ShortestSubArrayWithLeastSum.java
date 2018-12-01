package com.algo.array;

import org.junit.Test;

import org.junit.Assert;

/**
 * Problem: https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
 * **/
public class ShortestSubArrayWithLeastSum {
	public int shortestSubarray(int[] dataArray ,int leastSum) {
		if (dataArray.length == 0 ) return 0;
		int startIndex=0;
		int endIndex=0;
		int[] finalSubArray = new int[4];
		finalSubArray[0]=-1; // start
		finalSubArray[1]=-1;// end
		finalSubArray[2]=Integer.MAX_VALUE;// minlength	
		finalSubArray[3]=Integer.MIN_VALUE;// sum
		int currSum =0;
		
		currSum+=dataArray[endIndex];
		while(endIndex<dataArray.length) {
			if (currSum>=leastSum) {
				if (finalSubArray[2]> (endIndex-startIndex+1) ) {
					finalSubArray[0]=startIndex; // start
					finalSubArray[1]=endIndex;// end
					finalSubArray[2]=endIndex-startIndex+1;// minlength	
					finalSubArray[3]=currSum;// sum
					if (finalSubArray[2]==1) break;
				} 
				currSum-=dataArray[startIndex++];
			}else {
				++endIndex;
				if (endIndex<dataArray.length) currSum+=dataArray[endIndex]; // ArrayIndexOutOfBound Exception check
			}
		}
		
		//System.out.println("Data: "+dataArray + " , startIndex="+finalSubArray[0] + ", endIndex="+finalSubArray[1] + ", minLength= "+finalSubArray[2]);
		return finalSubArray[2];
	}
	
	@Test
	
	public void happyPath_1() {
		int[] dataArr = {6,1,-1,1,7};
		int minLengthActual = shortestSubarray(dataArr,7);
		Assert.assertEquals(1, minLengthActual);
	}
	@Test
	public void happyPath_2() {
		int[] dataArr = {6,1,-1,1,7};
		int minLengthActual = shortestSubarray(dataArr,6);
		Assert.assertEquals(1, minLengthActual);
	}
	
	@Test
	public void happyPath_3() {
		int[] dataArr = {-1,1,-1,1,7};
		int minLengthActual = shortestSubarray(dataArr,1);
		Assert.assertEquals(1, minLengthActual);
	}
	
	@Test
	public void happyPath_4() {
		int[] dataArr = {1,1,4,1,2};
		int minLengthActual = shortestSubarray(dataArr,5);
		Assert.assertEquals(2, minLengthActual);
	}
	
	
	@Test
	public void happyPath_5() {
		int[] dataArr = {3,2,2,6,1,0};
		int minLengthActual = shortestSubarray(dataArr,7);
		Assert.assertEquals(2, minLengthActual);
	}
	@Test
	public void happyPath_6() {
		int[] dataArr = {0};
		int minLengthActual = shortestSubarray(dataArr,0);
		Assert.assertEquals(1, minLengthActual);
	}
	
	@Test
	public void negativePath_1() {
		int[] dataArr = {1,2};
		int minLengthActual = shortestSubarray(dataArr,4);
		Assert.assertEquals(-1, minLengthActual);
	}
}
