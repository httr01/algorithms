package com.algo.array;

import org.junit.Assert;

import org.junit.Test;
 
public class MaxSubArray {
/**
 * Problem:Suppose that you been offered the opportunity to invest in the Volatile Chemical Corporation.
 * Like the chemicals the company produces, the stock price of the Volatile Chemical Corporation is rather 
 * volatile. You are allowed to buy one unit of stock only one time and then sell it at a later date, 
 * buying and selling after the close of trading for the day. To compensate for this restriction, 
 * you are allowed to learn what the price of the stock will be in the future. Your goal is to maximize 
 * your profit. Figure 4.1 shows the price of the stock over a 17-day period. You may buy the stock at 
 * any one time, starting after day 0, when the price is $100 per share. Of course, you would want to “buy low,
 * sell high”—buy at the lowest possible price and later on sell at the highest possible price—to maximize 
 * your profit.
 * 
 * @returns int[] : start , end index of max sub array, Sum of max sub array
 * **/
	
	public int[] maxSubArray(int[] dataArray, int startIndex,int endIndex ) {
		
		// base condition if there is only one element in the sub array
		if (startIndex == endIndex) {
			int[] returnMaxSubArray = new int[3];
			returnMaxSubArray[0]=startIndex;
			returnMaxSubArray[1]=endIndex;
			returnMaxSubArray[2]=dataArray[startIndex];
			return returnMaxSubArray;
		}
		int midIndex = (startIndex+ endIndex) /2;
		
		int[] leftMaxSubArray = 	maxSubArray(dataArray,startIndex,midIndex);
		int[] rightMaxSubArray = 	maxSubArray(dataArray,midIndex+1,endIndex);
		int[] crossingMaxSubArray = 	crossongMaxSubArray(dataArray,startIndex,midIndex,endIndex);
		
		if (leftMaxSubArray[2] >=rightMaxSubArray[2] && leftMaxSubArray[2] >=crossingMaxSubArray[2]) {
			return leftMaxSubArray;
		}else if (rightMaxSubArray[2] >=leftMaxSubArray[2] && rightMaxSubArray[2] >=crossingMaxSubArray[2]) {
			return rightMaxSubArray;
		}else {
			//crossing max array has largest sum
			return crossingMaxSubArray;
		}
		
	}
	
	private int[] crossongMaxSubArray(int[] dataArray, int startIndex, int midIndex, int endIndex ) {
		int[] returnMaxSubArray = new int[3];
		int start = midIndex;
		int end =midIndex+1;
		int leftSum =Integer.MIN_VALUE;
		int currSum = 0;
		for( int i = midIndex ;i>=startIndex ; --i ) {
			 currSum= currSum +dataArray[i];
			if (currSum > leftSum  ) {
				leftSum = currSum;
				start =i;
			}
			
		}
		
		int rightSum = Integer.MIN_VALUE;
	     currSum = 0;
		for( int i = midIndex+1 ;i<=endIndex ; ++i ) {
			currSum= currSum +dataArray[i];
			if (currSum > rightSum  ) {
				rightSum = currSum;
				end =i;
			}
			
		}
		returnMaxSubArray[0]=start;
		returnMaxSubArray[1]=end;
		returnMaxSubArray[2]=rightSum+leftSum;
		
		return returnMaxSubArray;
	}
	
	@Test
	public void test_happyPath() {
		int[] dataArray= {-5,4,-1,2,4,5};
		int[] actualResultArray = maxSubArray(dataArray, 0,dataArray.length-1 );
		int[] expectedRequltArray = {1,5,14};
		Assert.assertArrayEquals(expectedRequltArray, actualResultArray);
	}
	
}
