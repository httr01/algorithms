package com.algo.array;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
    		if (A.length< 3) return 0;
        Arrays.sort(A);
        for (int i = A.length-1 ; i>1; --i) {
        	 if (A[i]< A[i-1] + A[i-2] ) {
        		 return A[i]+ A[i-1] + A[i-2] ;
        	 }
        }
        return 0;
    }
    
    @Test
    public void test_1() {
    		LargestPerimeterTriangle algo =  new LargestPerimeterTriangle();
    		int[] A = {2,1,2};
    		Assert.assertEquals(5, algo.largestPerimeter(A));
    }
    
    @Test
    public void test_2() {
    		LargestPerimeterTriangle algo =  new LargestPerimeterTriangle();
    		int[] A = {1,2,1};
    		Assert.assertEquals(0, algo.largestPerimeter(A));
    }
    
    
    @Test
    public void test_3() {
    		LargestPerimeterTriangle algo =  new LargestPerimeterTriangle();
    		int[] A = {3,2,3,4};
    		Assert.assertEquals(10, algo.largestPerimeter(A));
    }
    @Test
    public void test_4() {
    		LargestPerimeterTriangle algo =  new LargestPerimeterTriangle();
    		int[] A = {3,6,2,3};
    		Assert.assertEquals(8, algo.largestPerimeter(A));
    }
    
}
