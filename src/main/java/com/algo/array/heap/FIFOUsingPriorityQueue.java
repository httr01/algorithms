package com.algo.array.heap;

import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

/**
Show how to implement a first-in, first-out queue with a priority queue. 
Show how to implement a stack with a priority queue.
 ***/
public class FIFOUsingPriorityQueue {
	private static class MyComparator implements Comparator<MyObject>{
		public int compare (MyObject ob1, MyObject ob2){
			return ob1.getPriority().compareTo(ob2.getPriority());
			
		}
	}// MyComparator

private class MyObject   {
	public MyObject(int p, Object o){
		this.priority= p;
		this.value = o;
	}
	Integer priority;
	Object value;
	public Object getValue() {
		return this.value;
	}
	public Integer getPriority() {
		return this.priority;
	}
} 
		private class MaxHeap {
			private MyComparator myComparator = new MyComparator();
			private int arrLength=0;
			private int maxArrayLength =0;
			private MyObject[] dataArr = null;
			
			public MaxHeap(int maxLength){
				dataArr = new MyObject[maxLength];
				maxArrayLength = maxLength;
				
				//for(int index = 2 * arrLength -1; index>0 ; --index) {
				//	heapify(index);
				//}
		
			}
		
		public void heapify(int currentRoot){
			int leftChild = 2*currentRoot+1;
			int rightChild = leftChild+1;
			if (rightChild<arrLength) { 
			 
				if ( myComparator.compare(dataArr[leftChild], dataArr[rightChild])>0  && myComparator.compare(dataArr[leftChild] , dataArr[currentRoot])>0  ){
					swap(leftChild,currentRoot);
					heapify(leftChild);
				}else if (myComparator.compare(dataArr[rightChild] , dataArr[leftChild]) >0 && myComparator.compare(dataArr[rightChild] , dataArr[currentRoot]) >0  ){
						swap(rightChild,currentRoot);
						heapify(rightChild);
				}
			}else if (leftChild<arrLength)  {
					if (myComparator.compare(dataArr[leftChild] , dataArr[rightChild]) >0 ){
						swap(leftChild,currentRoot);
						heapify(leftChild);
					}
				}
		
			}
		public void swap(int index1, int index2) {
			MyObject temp = dataArr[index1];
			dataArr[index1] =dataArr[index2];
			dataArr[index2] = temp;
		}
		
		public MyObject peek(){
			if (arrLength >0)
				return dataArr[0];
			else return null;
		}
		
		public void add(MyObject obj){
			if (arrLength >= maxArrayLength) return;
			++arrLength;
			dataArr[arrLength-1] = obj;
			heapify_up( arrLength-1 );
		}
		public MyObject remove(){
			if (arrLength <=0 ) return null;;
			MyObject temp = dataArr[0];
			dataArr[0] = dataArr[arrLength-1];
			--arrLength;
			heapify(0);
			return temp;
		}
		
		public void heapify_up(int  currentRootIndex){
			if (currentRootIndex>=0) {
					int parentInex= currentRootIndex/2;
				if (myComparator.compare(dataArr[currentRootIndex] , dataArr[parentInex] )>0  ) {
					swap(currentRootIndex,parentInex );
				}
				if (parentInex > 0 )  heapify_up(parentInex);
			}
		}
		 
}// end of ` class
	
 	
	MaxHeap maxHeap = null;
	
	public void init(int maxLength){
		maxHeap = new MaxHeap( maxLength) ;	
	}
	
	public Object pop(){
		MyObject myObj= maxHeap.remove();
		if (myObj!=null)
			return myObj.getValue();
		return null;
}
public Object peek(){
	MyObject myObj= maxHeap.peek();

	if (myObj!=null)
			return myObj.getValue();
		return null;
	}
	private int currPriority = Integer.MAX_VALUE;
	public void push(Object obj){
		maxHeap.add( new MyObject(currPriority--, obj));
	}

	@Test
	public void test_1() {
		  
		FIFOUsingPriorityQueue fupq= new FIFOUsingPriorityQueue();
		fupq.init(100);
		fupq.push("A");
		fupq.push("D");
		fupq.push("AC");
		fupq.push("BD");
		Assert.assertEquals("A", fupq.peek());
		Assert.assertEquals("A", fupq.pop());
		Assert.assertEquals("D", fupq.peek());
		Assert.assertEquals("D", fupq.pop());
		Assert.assertEquals("AC", fupq.peek());
		Assert.assertEquals("AC", fupq.pop());
	}
	@Test
	public void test_2() {
		 
		FIFOUsingPriorityQueue fupq= new FIFOUsingPriorityQueue();
		fupq.init(100);
		fupq.push(40);
		fupq.push(20);
		fupq.push(10);
		fupq.push(5);
		Assert.assertEquals(40, fupq.peek());
		Assert.assertEquals(40, fupq.pop());
		Assert.assertEquals(20, fupq.peek());
		Assert.assertEquals(20, fupq.pop());
		Assert.assertEquals(10, fupq.peek());
		Assert.assertEquals(10, fupq.pop());
	}
	@Test
	public void test_3() {
		 
		FIFOUsingPriorityQueue fupq= new FIFOUsingPriorityQueue();
		fupq.init(100);
		fupq.push("A");
		fupq.push(20);
		fupq.push("v");
		fupq.push(5);
		Assert.assertEquals("A", fupq.peek());
		Assert.assertEquals("A", fupq.pop());
		Assert.assertEquals(20, fupq.peek());
		Assert.assertEquals(20, fupq.pop());
		Assert.assertEquals("v", fupq.peek());
		Assert.assertEquals("v", fupq.pop());
		
	}
}// class end

