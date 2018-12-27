package com.algo.tree;

import org.junit.Assert;
import org.junit.Test;

public class CountUniqueBinarySearchTree {
	 
	public int numTrees(int n) {
		if (n<2) return 1;
		int[] preCalcTotalArr = new int[n+1];
		
		preCalcTotalArr[0]=1;
		preCalcTotalArr[1]=1;
		preCalcTotalArr[2]=2;
		int totalUnique =0;
		for (int i = 2; i< n; ++i){
			totalUnique =0;
			for (int j = 0 ; j<= i ; ++j){
				totalUnique += preCalcTotalArr[j] * preCalcTotalArr[i-j];
			}
			preCalcTotalArr[i+1]=totalUnique;
		}
		return preCalcTotalArr[n];        
	 }
	
	@Test
	public void test_3() {
		CountUniqueBinarySearchTree algo =  new CountUniqueBinarySearchTree();
		Assert.assertEquals(5, algo.numTrees(3));
	}
	@Test
	public void test_4() {
		CountUniqueBinarySearchTree algo =  new CountUniqueBinarySearchTree();
		Assert.assertEquals(14, algo.numTrees(4));
	}
	
	@Test
	public void test_5() {
		CountUniqueBinarySearchTree algo =  new CountUniqueBinarySearchTree();
		Assert.assertEquals(42, algo.numTrees(5));
	}
}
