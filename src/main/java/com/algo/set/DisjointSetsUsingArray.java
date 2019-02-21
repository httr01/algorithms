package com.algo.set;

import org.junit.Test;

import junit.framework.Assert;

public class DisjointSetsUsingArray {

	int maxValue = 100;
	int[] arr =  new int[maxValue+1];//Not using 0th index*
	public DisjointSetsUsingArray( ) {
		for (int i =1 ; i<= maxValue; ++i)  arr[i]=-1; //  each value is their own set
	}
 
		public void makeSet(int x) {
			arr[x]=-1;
		}
		public int findSet(int x) {
			if (arr [x] < 0)
				return x;
			int setIndex = findSet(arr[x]);
			if (x!=setIndex)
				arr[x] = setIndex; // Path compression
			return arr[x];
		}
		
		public int size(int x) {
			return Math.abs(arr[findSet(x)]);
		}
		public void union (int x, int y ) {
			int s1 = findSet(x);
			int s2 = findSet(y);
			if (s1==s2) return;//both values are in same set
			if (Math.abs(arr[s2]) < Math.abs(arr[s1])) { // Use weight : smaller set gets merge into bigger set.
				 int tempSize = arr[s2];
				arr[s2] = s1;
				arr[s1] =arr[s1]+tempSize;
			}else {
				int tempSize = arr[s1];
				arr[s1] = s2;
				arr[s2] =arr[s2]+tempSize;
			}

		} 
		
		@Test
		public void test_1() {
			DisjointSetsUsingArray algo  = new DisjointSetsUsingArray();
			algo.union(1,2);
			Assert.assertEquals(2, algo.findSet(1));
			Assert.assertEquals(2, algo.findSet(2));
			Assert.assertEquals(2, algo.size(2));
			
			algo.union(2,3);
			
			Assert.assertEquals(2, algo.findSet(1));
			Assert.assertEquals(2, algo.findSet(2));
			Assert.assertEquals(2, algo.findSet(3));
			Assert.assertEquals(3, algo.size(2));
			
			algo.union(5,6);
			Assert.assertEquals(6, algo.findSet(5));
			Assert.assertEquals(6, algo.findSet(6));
			Assert.assertEquals(2, algo.size(6));
			
			
			algo.union(3,6);
			Assert.assertEquals(2, algo.findSet(1));
			Assert.assertEquals(2, algo.findSet(2));
			Assert.assertEquals(2, algo.findSet(3));
			 
			Assert.assertEquals(2, algo.findSet(5));
			Assert.assertEquals(2, algo.findSet(6));
			Assert.assertEquals(5, algo.size(6));
			Assert.assertEquals(5, algo.size(3));
			
			Assert.assertEquals(4, algo.findSet(4));
		}

}
