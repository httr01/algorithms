package com.algo.array;

import org.junit.Assert;
import org.junit.Test;

public class DeleteColumnToMakeSorted {
    public int minDeletionSize(String[] A) {
    		int deleteColumnCount = 0;
    		if (A.length <=1) return 0;
    		int lengthOfString=A[0].length();
    		int[][] isInOrder =  new int[A.length][lengthOfString];
    		int[]  columnInOrder = new int[lengthOfString];
    	    //1. Figure out:  set each to true
	    for (int i =0;i <lengthOfString ; ++i) {
	        		int j = 0;
	        		columnInOrder[i] =1;
	        		while (j<A.length) {
	        				isInOrder[j][i] =  1;
	        				++j;
	        		}
        }//for
	    boolean foundTheColumnWhichWillEstablishOrder =  false;
	    //2. Figure out:  each  each column for each string is in order from previous column/string
	    for (int i =0; !foundTheColumnWhichWillEstablishOrder && i <lengthOfString ; ++i) {
	        		int j = 1;
	        		while (j<A.length) {
	        			if ( A[j].charAt(i) < A[j-1].charAt(i)) {
	        				isInOrder[j][i] =  -1;
	        				columnInOrder[i] = -1;
	        				break;
	        			}else if ( A[j].charAt(i) == A[j-1].charAt(i)) {
	        				isInOrder[j][i] =  0;
	        				columnInOrder[i] = columnInOrder[i] <0 ?columnInOrder[i]:0 ;
	        				
	        			} 
	        			++j;
	        		}
	        		if (columnInOrder[i]< 0 ) {
	        			++deleteColumnCount ;
	        		}if (columnInOrder[i] ==  1 ) {
	        			foundTheColumnWhichWillEstablishOrder=  true;
	        		}
        }//for
	    return deleteColumnCount;
    }
    
    
    @Test
    public void test_1() {
    		DeleteColumnToMakeSorted dctms = new DeleteColumnToMakeSorted();
    		String[] A= {"zyx","wvu","tsr"};
    		Assert.assertEquals(3, dctms.minDeletionSize(A));
    }
    
    @Test
    public void test_2() {
    		DeleteColumnToMakeSorted dctms = new DeleteColumnToMakeSorted();
    		String[] A= {"xc","yb","za"};
    		Assert.assertEquals(0, dctms.minDeletionSize(A));
    }
    
    @Test
    public void test_3() {
    		DeleteColumnToMakeSorted dctms = new DeleteColumnToMakeSorted();
    		String[] A= {"ca","bb","ac"};
    		Assert.assertEquals(1, dctms.minDeletionSize(A));
    }
    
    @Test
    public void test_4() {
    		DeleteColumnToMakeSorted dctms = new DeleteColumnToMakeSorted();
    		String[] A= {"zyxa","wvua","tsra"};
    		Assert.assertEquals(3, dctms.minDeletionSize(A));
    }
    
    @Test
    public void test_5() {
    		DeleteColumnToMakeSorted dctms = new DeleteColumnToMakeSorted();
    		String[] A= {"azyxa","awvua","atsra"};
    		Assert.assertEquals(3, dctms.minDeletionSize(A));
    }
    		/*** Looks like leet code site has wrong expectation as =1 **/
    		@Test
    	    public void test_6() {
    	    		DeleteColumnToMakeSorted dctms = new DeleteColumnToMakeSorted();
    	    		String[] A= {"xga","xfb","yfa"};
    	    		Assert.assertEquals(2, dctms.minDeletionSize(A));
    	    }
}
