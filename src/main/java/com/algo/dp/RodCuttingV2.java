package com.algo.dp;
import java.util.*;

import org.junit.Assert;
import org.junit.Test;
public class RodCuttingV2 {
	
	/** r:  revenue array, r[0] =0. To reduce confusion with size because min size always is 1 .
	 * n : the size of rod we have
	 * We are following bottom up approach where we calculate form size = 1 and save optimal cut in array 's'.
	 * The response is size of optimal cut we are making for the rod.
	 * 1. Here we remember the cut we made which make it optimal cut.
	 * Time complexity = O (N^2)*/
	
	public List<Integer>  cutRod4MaxProfit( int n, int[] r) {
		int s[] =  new int[r.length];
		for (int i = 1; i <= n ; ++i) {
			int maxProfit = Integer.MIN_VALUE;
			for (int j = 1 ; j <= i ; ++j ){
				int newProfit =  r[j] + r[i-j];
				if (newProfit>maxProfit ) {
					s[i] = j; //#1
					maxProfit =  newProfit;
				}
			}	
		}
		return constructOptimalPiecesLength(r,s,n);		
	}//cutRod4MaxProfit
	
	private List<Integer> constructOptimalPiecesLength(int[] r, int[] s, int n) {
		List<Integer> cutRodSizes =  new ArrayList<Integer>();
		while (n>0 ) {
				cutRodSizes.add(s[n]);
				n = n -   s[n] ;	
		}//while
		return cutRodSizes;
	}//
	
	@Test
	public void test_1() {
		RodCuttingV2 algo = new RodCuttingV2();
		int[] profitArr = {0,1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		List<Integer>  resultList = algo.cutRod4MaxProfit (5,profitArr);
		Assert.assertEquals(2,resultList.get(0).intValue() );
		Assert.assertEquals(3,resultList.get(1).intValue() );
	}
	
	@Test
	public void test_2() {
		RodCuttingV2 algo = new RodCuttingV2();
		int[] profitArr = {0,1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		List<Integer>  resultList = algo.cutRod4MaxProfit (6,profitArr);
		Assert.assertEquals(1,resultList.size() );
		Assert.assertEquals(6,resultList.get(0).intValue() );
		
	}
	
	@Test
	public void test_3() {
		RodCuttingV2 algo = new RodCuttingV2();
		int[] profitArr = {0,1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		List<Integer>  resultList = algo.cutRod4MaxProfit (8,profitArr);
		Assert.assertEquals(2,resultList.size() );
		Assert.assertEquals(2,resultList.get(0).intValue() );
		Assert.assertEquals(6,resultList.get(1).intValue() );
	}
	
	@Test
	public void test_4() {
		RodCuttingV2 algo = new RodCuttingV2();
		int[] profitArr = {0,1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		List<Integer>  resultList = algo.cutRod4MaxProfit (9,profitArr);
		Assert.assertEquals(2,resultList.size() );
		Assert.assertEquals(3,resultList.get(0).intValue() );
		Assert.assertEquals(6,resultList.get(1).intValue() );
	}
	@Test
	public void test_5() {
		RodCuttingV2 algo = new RodCuttingV2();
		int[] profitArr = {0,1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		List<Integer>  resultList = algo.cutRod4MaxProfit (10,profitArr);
		Assert.assertEquals(1,resultList.size() );
		Assert.assertEquals(10,resultList.get(0).intValue() );
	}
	
	@Test
	public void test_6() {
		RodCuttingV2 algo = new RodCuttingV2();
		int[] profitArr = {0,4, 5, 8, 9, 10, 17, 17, 20, 29, 30};
		List<Integer>  resultList = algo.cutRod4MaxProfit (10,profitArr);
		Assert.assertEquals(2,resultList.size() );
		Assert.assertEquals(1,resultList.get(0).intValue() );
		Assert.assertEquals(9,resultList.get(1).intValue() );
	}

}
