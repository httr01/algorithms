package com.algo.array;

import org.junit.Assert;
import org.junit.Test;
/**https://leetcode.com/problems/gas-station/submissions/
 * 
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

Note:

If there exists a solution, it is guaranteed to be unique.
Both input arrays are non-empty and have the same length.
Each element in the input arrays is a non-negative integer.
Example 1:

Input: 
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

Output: 3
*/
public class GasStation {
		public int canCompleteCircuit(int[] gas, int[] cost) {

				int oilBox[] = new int[2*gas.length];
				for (int i = 0 ; i <gas.length ; ++i)   {
						// calculate CumelativeFromStart
					oilBox[i]=  ( gas[i]- cost[i] );
					oilBox[i+gas.length]=  oilBox[i];	
			 
				}    
		
				int oilInBox = 0;
				int start = 0;
				for (int i = 0 ;   i <oilBox.length ; ++i)   {
					if (oilBox[i]+oilInBox<0) {
						start = i+1;
						oilInBox=0;
					}else {
						oilInBox +=oilBox[i];
					}
				}//for 
				if (start>=gas.length) return -1;
				return start;
		 }
	
	
	@Test
	public void test_1() {
		int[]  gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		GasStation algo = new GasStation();
		Assert.assertEquals(3, algo.canCompleteCircuit(gas, cost));
	}

	@Test
	public void test_2() {
		int[]  gas = {2,3,4};
		int[] cost = {3,4,3};
		GasStation algo = new GasStation();
		Assert.assertEquals(-1, algo.canCompleteCircuit(gas, cost));
	}
	
	
	@Test
	public void test_3() {
		int[]  gas = {2,3};
		int[] cost = {3,4};
		GasStation algo = new GasStation();
		Assert.assertEquals(-1, algo.canCompleteCircuit(gas, cost));
	}
	
	@Test
	public void test_4() {
		int[]  gas = {2};
		int[] cost = {1};
		GasStation algo = new GasStation();
		Assert.assertEquals(0, algo.canCompleteCircuit(gas, cost));
	}
	@Test
	public void test_5() {
		int[]  gas = {2,3};
		int[] cost = {3,2};
		GasStation algo = new GasStation();
		Assert.assertEquals(1, algo.canCompleteCircuit(gas, cost));
	}
	
	@Test
	public void test_6() {
		int[]  gas = {1,2,3,4,5};
		int[] cost = {3,4,5,5,2};
		GasStation algo = new GasStation();
		Assert.assertEquals(-1, algo.canCompleteCircuit(gas, cost));
	}
	
	@Test
	public void test_7() {
	 
		int[]  gas = {5,1,2,3,4};
		int[] cost = {4,4,1,5,1};
		GasStation algo = new GasStation();
		Assert.assertEquals(4, algo.canCompleteCircuit(gas, cost));
	}
}
