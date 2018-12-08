package com.algo.array.heap;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
 
public class PriorityQueue {

private   class MyComparator implements Comparator<Object>{
	public int compare (Object ob1, Object ob2){
			  
			return ((Comparable)ob1 ).compareTo((Comparable)ob2 );
 	}
}
	private int MAX_ARRAY_SIZE = 10;
	private int arraySize=0;
	private int MAX_ELEMENT_INITIAL = 10;
	private java.util.List<Object> myArr =  new ArrayList<Object>(MAX_ELEMENT_INITIAL);
	private MyComparator defaultComparator = new MyComparator();

	public PriorityQueue() {}
	/*public PriorityQueue(Object[] dataArray ){
		set(dataArray);
	}*/
	public void set(Object[] dataArray) {
		myArr =  Arrays.asList(dataArray); 
		arraySize=myArr.size();
		for(int startingIndex = myArr.size()/2-1 ; startingIndex >=0; --startingIndex )	{
			heapify(startingIndex);
		}
		
	}
/***
@precondition:All the element in sub tree of rootIndex are already heapify 
@postcondition:Elements of the tree with root as rootIndex will be  heapified.
****/
private void heapify(int rootIndex){
	int leftIndex = 2*rootIndex + 1;
	int rightIndex= leftIndex+1;
	if (leftIndex>=arraySize ) return;

	if (rightIndex>=arraySize && defaultComparator.compare(myArr.get(leftIndex), myArr.get(rootIndex) ) > 0  ) {
		// only left root
		swap(rootIndex,leftIndex);
		heapify(leftIndex);
}
// Now when we have left and right
if (rightIndex< arraySize && defaultComparator.compare(myArr.get(leftIndex) , myArr.get(rootIndex)) > 0 &&  defaultComparator.compare ( myArr.get(leftIndex),  myArr.get(rightIndex) )>0  )  {
	// if left is biggest
			swap(rootIndex,leftIndex);
			heapify(leftIndex);
}else if (rightIndex< arraySize && defaultComparator.compare ( myArr.get(rightIndex), myArr.get(rootIndex) ) >0 && defaultComparator.compare ( myArr.get(rightIndex) , myArr.get(leftIndex) ) > 0  )  {
	// if  right is biggest
			swap(rootIndex,rightIndex);
			heapify(rightIndex);
}//if
		
}//heapify

public Object peek(){
	return myArr.get(0);
}
public Object remove (){
	Object topObject = myArr.get(0);
	myArr.set(0,myArr.get(--arraySize));
	
	heapify(0);
	return topObject;

}
public void add (Object keyToAdd){
	if (arraySize >= MAX_ARRAY_SIZE) {
		// Full array
		return;
}
	myArr.add(++arraySize,keyToAdd);
	heapifyUp(arraySize-1);
	
}

	private void heapifyUp(int currentIndex) {
		while (currentIndex >=0) {
			int parentIndex = currentIndex/2;
			if ( defaultComparator.compare( myArr.get(currentIndex) ,   myArr.get(parentIndex ) ) > 0  ) {
				swap(currentIndex,parentIndex);
				if (parentIndex ==0) break;
				heapifyUp(parentIndex);
			}//if
			
		}//while

	}// function

	private void swap(int currentIndex, int parentIndex ) {
		Object temp = myArr.get(currentIndex);
		myArr.set(currentIndex, myArr.get(parentIndex) )	;
		myArr.set(parentIndex,temp);
	}
	
	
	@Test
	public void happyPath_5Element() {
		Integer[] dataArr =   {new Integer(2),new Integer(12),new Integer(8),new Integer(4),new Integer(1), };
		PriorityQueue pq=  new PriorityQueue();
		pq.set(dataArr);
		Integer firstMaxElement =(Integer) pq.remove();
		Assert.assertEquals(12, firstMaxElement.intValue());
		Integer element =(Integer) pq.peek();
		Assert.assertEquals(8, element.intValue());
		element =(Integer) pq.remove();
		Assert.assertEquals(8, element.intValue());
		element =(Integer) pq.peek();
		Assert.assertEquals(4, element.intValue());
	}
	@Test
	public void happyPath_10Element() {
		int[] dataArrInt =  {8,12,16,4,20,15,10,7,3,14};
		Integer[] dataArr = IntStream.of(dataArrInt).boxed().toArray(Integer[]::new);
		PriorityQueue pq=  new PriorityQueue();
		pq.set(dataArr);
		Integer firstMaxElement =(Integer) pq.remove();
		Assert.assertEquals(20, firstMaxElement.intValue());
		Integer element =(Integer) pq.peek();
		Assert.assertEquals(16, element.intValue());
		element =(Integer) pq.remove();
		Assert.assertEquals(16, element.intValue());
		element =(Integer) pq.remove();
		Assert.assertEquals(15, element.intValue());
		element =(Integer) pq.remove();
		Assert.assertEquals(14, element.intValue());
	}
}


