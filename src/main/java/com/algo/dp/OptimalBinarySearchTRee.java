package com.algo.dp;

import org.junit.Test;

import junit.framework.Assert;

public class OptimalBinarySearchTRee {
	public class Tree{
		int value;
		int cost;
		int index;	
		 	Tree  left;
		 	Tree  right;
		public Tree( int cost, int index){
				this.cost=  cost;
				this.index=index;
		}
			public Tree(int value, int cost, int index){
				this.cost=  cost;
				this.index=index;
				this.value=value;
			}
	}
		
		public Tree optimalBST(int[] values, int[] freq){
			int totalLength =   values.length;	
			Tree [][] A =  new Tree[totalLength][totalLength];
			for (int L = 0 ;L < totalLength ; ++L) {
				for (int i = 0 ;i < totalLength-L ; ++i) {
					int j = i+L;
					if (i ==j){
						A[i][j] = new Tree(freq[i],i);
						continue;
					}
					int minCost = Integer.MAX_VALUE;
					for (int k =i ; k <=j ; ++k) {
						int newCost = 0;
						for (int i1 =i ; i1<=j; ++i1 )
							newCost+= freq[i1]   ;
						
						
						if (k-1>= i ){
							newCost += A[i][k-1].cost; 
						} 
						if (j>=k+1 ){
							newCost += A[k+1][j].cost; 
						} 
						if (newCost<minCost ) {
							minCost=newCost;
							Tree tree =  new Tree(minCost,k);
							A[i][j] = tree;
						}
					}	

				}	
			
			}//for
			return constructTree(values, A,0,values.length-1);
		}
		private Tree constructTree(int[] values,Tree[][] A, int low, int high) {
			if (low>high)
				return null;
			Tree currtree = A[low][high];
			currtree.value= values[currtree.index];
			if ( low == high)
				return currtree;
			currtree.left = constructTree(values,A,low, currtree.index-1);
			currtree.right = constructTree(values,A, currtree.index+1, high);
			return currtree;
		 
		} 

		@Test
		public void test_1() {
			OptimalBinarySearchTRee algo = new OptimalBinarySearchTRee();
			int[] values = {10,12,16,21};
			int[]  freq = {4,2,6,3};
			Tree root =  algo.optimalBST(values, freq);
			Assert.assertEquals(16, root.value);
			Assert.assertEquals(10, root.left.value);
			Assert.assertEquals(12, root.left.right.value);
			Assert.assertEquals(21, root.right.value);
		}

}
