package com.algo.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOfDoubledPairs {
	/**
	 * https://leetcode.com/problems/array-of-doubled-pairs/
	 * Given an array of integers A with even length, return true if and only if it is possible to reorder it such 
	 * that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.
	 * */
	
    public boolean canReorderDoubled(int[] A) {
    		if (Math.floorMod(A.length,2) != 0) return false; // even length of the array.
    		// Keep a counter in hash of how many times a number appeared.
    		HashMap<String,Integer> keysHashMap = new HashMap<String,Integer>();
    		for (int index = 0 ;index < A.length; ++index ) {
    			String key= A[index]+"";
    			if (keysHashMap.get(key) == null)
    				keysHashMap.put(key, new Integer(1));
    			else
    				keysHashMap.put(key, keysHashMap.get(key)+1);
    			
    		}
    		Arrays.sort(A);
    		
    		int index = 0;
    		while (index< A.length) {
    			String currKey= A[index]+"";
    			Integer keyvalue = Integer.parseInt(currKey);
    			if (keysHashMap.get(currKey)<=0) {
    				++index;
    				continue;
    			}
    			
    			// if the key is 0 and multiply or divide by 2 is always zero
    			if (keyvalue ==0  && Math.floorMod(keysHashMap.get(currKey),2) !=0) {
    					return false;
    			}else {
	    			int nextMatchingKeyToFind = keyvalue * 2;
	    			boolean findNextMatchingKey =  true;
	    			if (keyvalue <0 ) {
	    				nextMatchingKeyToFind = keyvalue /2;
	    				double nextHalfMatchingKeyToFind = keyvalue /2.0;
	    				if (nextHalfMatchingKeyToFind!=nextMatchingKeyToFind) {
	    					findNextMatchingKey =  false;
	    				}
	    			}
	    			
	    			if (findNextMatchingKey && keysHashMap.containsKey(nextMatchingKeyToFind+"") && keysHashMap.get(nextMatchingKeyToFind+"")>0 ) {
	    				int minToMatchPairs= Math.min(keysHashMap.get(currKey).intValue(),keysHashMap.get(nextMatchingKeyToFind+"").intValue());
	    				keysHashMap.put(currKey, keysHashMap.get(currKey).intValue()-minToMatchPairs);
	    				keysHashMap.put(nextMatchingKeyToFind+"", keysHashMap.get(nextMatchingKeyToFind+"").intValue()-minToMatchPairs);
	    				
	    			}
    			
    			}
    			if (keysHashMap.get(currKey).intValue()> 0)
    				return false;
    			++index; 
    		}
    		return true;
    }
    
    
    @Test
    public void test_1() {
    		ArrayOfDoubledPairs aodp= new ArrayOfDoubledPairs();
    		int[] data =  {3,1,3,6};
    		Assert.assertEquals(false, aodp.canReorderDoubled(data));
    }
    
    @Test
    public void test_2() {
    		ArrayOfDoubledPairs aodp= new ArrayOfDoubledPairs();
    		int[] data =  {2,1,2,6};
    		Assert.assertEquals(false, aodp.canReorderDoubled(data));
    }
    
    @Test
    public void test_3() {
    		ArrayOfDoubledPairs aodp= new ArrayOfDoubledPairs();
    		int[] data =  {4,-2,2,-4};
    		Assert.assertEquals(true, aodp.canReorderDoubled(data));
    }
    
    @Test
    public void test_4() {
    		ArrayOfDoubledPairs aodp= new ArrayOfDoubledPairs();
    		int[] data =  {1,2,4,16,8,4};
    		Assert.assertEquals(false, aodp.canReorderDoubled(data));
    }
    @Test
    public void test_5() {
    		ArrayOfDoubledPairs aodp= new ArrayOfDoubledPairs();
    		int[] data =  {0,0};
    		Assert.assertEquals(true, aodp.canReorderDoubled(data));
    }
    
    
    
    @Test
    public void test_6() {
    		ArrayOfDoubledPairs aodp= new ArrayOfDoubledPairs();
    		int[] data =  {0,0,0,0};
    		Assert.assertEquals(true, aodp.canReorderDoubled(data));
    }
    
    @Test
    public void test_7() {
    		ArrayOfDoubledPairs aodp= new ArrayOfDoubledPairs();
    		int[] data =  {0,0,0,0,0,0};
    		Assert.assertEquals(true, aodp.canReorderDoubled(data));
    }
    @Test
    public void test_8() {
    		ArrayOfDoubledPairs aodp= new ArrayOfDoubledPairs();
    		int[] data =  {0,-2,0,-4};
    		Assert.assertEquals(true, aodp.canReorderDoubled(data));
    }
    
    @Test
    public void test_9() {
    		ArrayOfDoubledPairs aodp= new ArrayOfDoubledPairs();
    		int[] data =  {2,1,2,1};
    		Assert.assertEquals(true, aodp.canReorderDoubled(data));
    }
    @Test
    public void test_10() {
    		ArrayOfDoubledPairs aodp= new ArrayOfDoubledPairs();
    		int[] data =  {2,1,2,1,1,2};
    		Assert.assertEquals(true, aodp.canReorderDoubled(data));
    }
    
    @Test
    public void test_11() {
    		ArrayOfDoubledPairs aodp= new ArrayOfDoubledPairs();
    		int[] data =  {2,1,2,1,1,2,1,2};
    		Assert.assertEquals(true, aodp.canReorderDoubled(data));
    }
    
    @Test
    public void test_12() {
    		ArrayOfDoubledPairs aodp= new ArrayOfDoubledPairs();
    		int[] data =  {10,20,40,80};
    		Assert.assertEquals(true, aodp.canReorderDoubled(data));
    }
    
    @Test
    public void test_13() {
    		ArrayOfDoubledPairs aodp= new ArrayOfDoubledPairs();
    		int[] data =  {1,2,1,-8,8,-4,4,-4,2,-2};
    		Assert.assertEquals(true, aodp.canReorderDoubled(data));
    }
    @Test
    public void test_14() {
    		ArrayOfDoubledPairs aodp= new ArrayOfDoubledPairs();
    		int[] data =  {78,26,-34,-44,21,-37,8,98,12,18,36,16,-64,-48,-4,-78,2,47,39,-17,39,-64,-46,52,18,-86,36,-52,42,5,-32,-28,12,-14,-29,48,-42,-30,-94,78,90,-8,-26,-40,20,-34,-2,32,96,-90,-4,18,-39,3,24,94,74,-11,-82,64,-11,26,1,78,56,9,11,40,2,14,37,28,33,88,96,-20,32,-96,-7,-58,-5,1,-42,47,72,41,36,48,-14,-43,25,-92,-41,94,-12,-19,-47,48,-10,-40,-92,49,-37,84,-17,22,-24,18,66,-74,-88,-22,52,-20,-46,82,-20,-32,39,96,44,-74,-45,-10,-38,-84,28,6,4,9,10,42,24,50,-22,-44,45,-22,-15,-84};
    		Assert.assertEquals(true, aodp.canReorderDoubled(data));
    }
}
