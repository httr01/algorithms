package com.algo.amazon.stack;

import junit.framework.Assert;

import org.junit.Test;

public class StackWithMinTest {
	
	/**Elements order to push in stack ( First)  5 , 10,3 ,15,4 (last)*/
	@Test 
	public void testStack_case1() throws Exception{
		StackWithMin lStackWithMin =  new StackWithMin();
		lStackWithMin.push(5);
		lStackWithMin.push(10);
		lStackWithMin.push(3);
		Assert.assertEquals(lStackWithMin.min(), 3);
		Assert.assertEquals(lStackWithMin.pop(), 3);
		Assert.assertEquals(lStackWithMin.min(), 5);
		Assert.assertEquals(lStackWithMin.peek(), 10);
		lStackWithMin.push(3);
		lStackWithMin.push(15);
		Assert.assertEquals(lStackWithMin.min(), 3);
		Assert.assertEquals(lStackWithMin.peek(), 15);
		lStackWithMin.push(4);
		Assert.assertEquals(lStackWithMin.peek(), 4);
		Assert.assertEquals(lStackWithMin.pop(), 4);
		Assert.assertEquals(lStackWithMin.min(), 3);
		Assert.assertEquals(lStackWithMin.pop(), 15);
		Assert.assertEquals(lStackWithMin.min(), 3);
		Assert.assertEquals(lStackWithMin.pop(), 3);
		Assert.assertEquals(lStackWithMin.min(), 5);
	}
}
