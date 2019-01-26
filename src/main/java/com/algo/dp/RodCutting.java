package com.algo.dp;

import org.junit.Assert;
import org.junit.Test;

public class RodCutting {
	
	public int findMaxProfit(int size, int[] profitArr) {
		int[] memorisedProfitforSize = new int[size+1]; 
		 
		if ( memorisedProfitforSize[size] > 0 ) 
			return memorisedProfitforSize[size];
		for (int i = 1 ; i <= size ; ++i){
			int profit =Integer.MIN_VALUE;
			for(int j =0 ; j <=i ; ++j){
				if (profit <profitArr[j ]  + memorisedProfitforSize[ i-j]  )
					profit = profitArr[j ]  + memorisedProfitforSize[ i-j] ;
			}
			memorisedProfitforSize[i] = profit;
		}
		return memorisedProfitforSize[size];
	}
	 

	@Test
	public void test_1() {
		RodCutting algo = new RodCutting();
		int[] profitArr = {0,1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		Assert.assertEquals(13, algo.findMaxProfit (5,profitArr));
	}
	
	@Test
	public void test_2() {
		RodCutting algo = new RodCutting();
		int[] profitArr = {0,1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		Assert.assertEquals(17, algo.findMaxProfit (6,profitArr));
	}
	
	@Test
	public void test_3() {
		RodCutting algo = new RodCutting();
		int[] profitArr = {0,1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		Assert.assertEquals(22, algo.findMaxProfit (8,profitArr));
	}
	
	@Test
	public void test_4() {
		RodCutting algo = new RodCutting();
		int[] profitArr = {0,1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		Assert.assertEquals(25, algo.findMaxProfit (9,profitArr));
	}
	@Test
	public void test_5() {
		RodCutting algo = new RodCutting();
		int[] profitArr = {0,1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		Assert.assertEquals(30, algo.findMaxProfit (10,profitArr));
	}
}
