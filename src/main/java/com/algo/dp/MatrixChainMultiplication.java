package com.algo.dp;

import org.junit.Test;

import junit.framework.Assert;

public class MatrixChainMultiplication {
	
	public class Matrix {
		public Matrix(int i1, int j1, int i2, int j2, int cost ){
			left= new Matrix(i1,j1);
			right = new Matrix(i2,j2);
			this.cost=  cost;
		}
		int i;
		int j;
		int cost;
		Matrix left;
		Matrix right;
		public Matrix(int i , int j) {
			this.i= i;
			this.j=j;
		}
		
	}
	/** A1, A2, A3, A4
	 * 1. Count how many matrix we have
	 * 2. We start with L=0 length matrix ex A1 
	 * 3. We miltiply L=1 length matrix ex A1, A2
	  *4. We miltiply L=2 length matrix ex A1, A2, A3
	  *5. **/
	public  Matrix[][]  matrixChainMultiplicationSteps(int[] R, int[] C) {
		int N = R.length; //1. total number of matrix
		int[][] costArr = new int[N][N];
		Matrix[][] optimalMatrixMult =  new Matrix[N][N];
		for (int L = 0 ; L< N; ++L) { //#1,2,3
			for (int i = 0 ; i<= ( N  -1-L ) ; ++i) {
				int j = i+L;
				if (i ==j) {
					optimalMatrixMult[i][j] = new Matrix(i,i,i,j,0);
					costArr[i][j]=0;
					continue;
				} 
				int minCost = Integer.MAX_VALUE;
				for (int k = i ; k< j ; ++k) {
					
					int cost =   optimalMatrixMult[i][k].cost +  optimalMatrixMult[k+1][j].cost + R[i] * R[k+1]* C[j]; 
					if (cost < minCost ){
						minCost = cost;	
						optimalMatrixMult[i][j] = new Matrix(i,k,k+1,j,minCost);
						costArr[i][j]=minCost;
					}//if
				}//for
			}//for

		}//for
		return optimalMatrixMult;	
		
	}//matrixChainMultiplicationSteps

	@Test
	public void test_1() {
		MatrixChainMultiplication algo = new MatrixChainMultiplication();
		int[] R= {2,3,6,4};
		int[] C = {3,6,4,5};
		Matrix[][] resultMatrix= algo.matrixChainMultiplicationSteps(R, C);
		Assert.assertEquals(124, resultMatrix[0][3].cost);
		Assert.assertEquals(0, resultMatrix[0][3].left.i);
		Assert.assertEquals(2, resultMatrix[0][3].left.j);
		Assert.assertEquals(3, resultMatrix[0][3].right.i);
		Assert.assertEquals(3, resultMatrix[0][3].right.j);
		
		Assert.assertEquals(0, resultMatrix[0][2].left.i);
		Assert.assertEquals(1, resultMatrix[0][2].left.j);
		Assert.assertEquals(2, resultMatrix[0][2].right.i);
		Assert.assertEquals(2, resultMatrix[0][2].right.j);
	}

}
