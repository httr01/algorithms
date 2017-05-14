package com.algo.amazon.stack;

/**
 * Ref: https://www.careercup.com/question?id=9845672
 * Support push, pop, min operation in O(1) time complexity.**/

public class StackWithMin {
	int MAX_ELEMENT = 20;
	int[] origStack = new int[MAX_ELEMENT];
	int[] minStack = new int[MAX_ELEMENT];
	int origStackTopIndex =-1 ;
	int minStackTopIndex =-1;

	public void push(int element) throws Exception{
		if (origStackTopIndex ==MAX_ELEMENT ) throw new Exception("Stack is full. Max element "+MAX_ELEMENT);
		origStack[++origStackTopIndex] = element;
		if (origStackTopIndex == 0 || element<= minStack[minStackTopIndex] )  
			minStack[++minStackTopIndex] = element;		
	 	 
	}
	public int peek(){
		return origStack[origStackTopIndex] ;
	}
	public int pop() throws Exception{
		if (origStackTopIndex == -1)  throw  new Exception ("Stack is already empty");
		if (origStack[origStackTopIndex] ==  minStack[minStackTopIndex]  ) --minStackTopIndex;
		return origStack[origStackTopIndex--];
	}
	public int min(){
		return minStack[minStackTopIndex];
	}
	
}
