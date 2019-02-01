package com.algo.number;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

 
public class NumbersWithSameConsecutiveDifferences {
	
	
    public int[] numsSameConsecDiff(int N, int K) {
    	   	 ArrayList<Integer> XArray = new ArrayList<Integer>();
    	 	
        for (int i =1 ;i <10;++i) 
        		if (i +K < 10) XArray.add(i);
        int XNonZeroTotalNumbers = 10-K;
        
        if (N==1) XNonZeroTotalNumbers=9-XArray.size() +1;
        ArrayList<Integer> finalNumbers = new ArrayList<Integer>();
        
        for (int j = 0 ;j< XArray.size(); ++j) {
        		String numStr = "";
        		boolean chooseX =  true;
	        for (int i=1 ;i <=N ; ++i) {
	        		numStr += (chooseX?XArray.get(j):XArray.get(j)+K);
	        		chooseX = !chooseX;
	        }
	        finalNumbers.add(Integer.parseInt(numStr));
        }
        if (N==1) {
        	finalNumbers.add( 0);
        		for (int i =  XArray.size() ;i <10-1; ++i ) finalNumbers.add(  i+1);
        }
        
        for (int j = 0 ; N>1 && K>0 && j< XNonZeroTotalNumbers ; ++j) {
        		boolean chooseX =  true;
        		String numStr = "";
        		for (int i=1 ;i <=N ; ++i) {
        			numStr += chooseX? (K+j):j;
        			chooseX = !chooseX;
        		}
        		finalNumbers.add(Integer.parseInt(numStr));
        }
        
        int[] array = finalNumbers.stream().mapToInt(i->i).toArray();
        
        return array;
    }
    
	@Test
	public  void test_1() {
		int[] expected = {181,292,707,818,929};
		NumbersWithSameConsecutiveDifferences algo= new NumbersWithSameConsecutiveDifferences();
		Assert.assertArrayEquals(expected,algo.numsSameConsecDiff(3,7));
	}
	@Test
	public  void test_2() {
		int[] expected = {10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98};
		NumbersWithSameConsecutiveDifferences algo= new NumbersWithSameConsecutiveDifferences();
		int[] realResp = algo.numsSameConsecDiff(2,1);
		//Assert.assertArrayEquals(expected,realResp);
		Assert.assertTrue(Arrays.equals(expected, realResp));
	}
	@Test
	public  void test_4() {
		int[] expected = {1,2,3,4,5,6,7,8,9,0};
		NumbersWithSameConsecutiveDifferences algo= new NumbersWithSameConsecutiveDifferences();
		int[] realResp = algo.numsSameConsecDiff(1,0);
		Assert.assertArrayEquals(expected,realResp);
	}
	
	@Test
	public  void test_5() {
		int[] expected = {1,2,3,4,5,6,7,8,9,0};
		NumbersWithSameConsecutiveDifferences algo= new NumbersWithSameConsecutiveDifferences();
		int[] realResp = algo.numsSameConsecDiff(1,1);
		Assert.assertArrayEquals(expected,realResp);
	}
	@Test
	public  void test_6() {
		int[] expected = {11,22,33,44,55,66,77,88,99};
		NumbersWithSameConsecutiveDifferences algo= new NumbersWithSameConsecutiveDifferences();
		int[] realResp = algo.numsSameConsecDiff(2,0);
		Assert.assertArrayEquals(expected,realResp);
	}
	
	@Test
	public  void test_7() {
		int[] expected = {101,121,123,210,212,232,234,321,323,343,345,432,434,454,456,543,545,565,567,654,656,676,678,765,767,787,789,876,878,898,987,989};
		NumbersWithSameConsecutiveDifferences algo= new NumbersWithSameConsecutiveDifferences();
		int[] realResp = algo.numsSameConsecDiff(3,1);
		Assert.assertArrayEquals(expected,realResp);
	}
    
}
