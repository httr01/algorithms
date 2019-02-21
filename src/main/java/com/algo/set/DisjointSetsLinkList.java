package com.algo.set;

import org.junit.Test;

import junit.framework.Assert;

public class DisjointSets {
	/***DisjointSets using link list to implement.*/
	public class Set {
		Node head;
		Node tail;
		int weight ; //  how many element in each set
		public Set(int v){
				head=  new Node(v, this);
				tail = head;
				weight =1;
		}
	}
	public class Node{
		int val;
		Node next;
		Set parent;
		public Node(int v, Set s){
			val= v;
			parent = s;
		}	
	}
	public Set makeSet(int  x){
		// assume that  set does not exists with value x.
		return  new Set(x);
	}
	/**time Complexity 
	 * If We do not use weight:O(N^2), to make union of N elements means calling union N -1 times.
	 * If we use weight O(N log(N)))
	 * One time call to union is O(N)***/
	public Set union( Set s1, Set s2) {
		if (s1 ==  null || s1 ==  null)
				return s1!=null?  s1:  s2;
		Set smallerSet = s1;
		Set biggerSet = s2;
		
		if (s2.weight <= s1.weight) {
				smallerSet = s2;
				biggerSet = s1;
		}
		biggerSet.weight  +=smallerSet.weight;
		
		Node  nodeToAddInSmaller =  smallerSet.head;
		Node preNode = null;
		while (nodeToAddInSmaller!=null) {
			nodeToAddInSmaller.parent = biggerSet;
			preNode = nodeToAddInSmaller;
			nodeToAddInSmaller =  nodeToAddInSmaller.next;
		}//while	
		
		biggerSet.tail.next =smallerSet.head;
		biggerSet.tail= preNode;
		 
		return biggerSet;
	}
	/** Time Complexity O(N)	***/
	public Node findSet(Set[] sets, int x){
		Set targetSet = null;
		Boolean found = false;
		for (int i = 0 ;i < sets.length && !found; ++i) {
			if (sets[i] !=null) {
				Node  currNode =  sets[i] .head;
				while (currNode!=null) {
					if (currNode.val ==x){
						targetSet=  currNode.parent;
						break;
					}
					currNode = currNode.next  ;
					
				}//while
			}//if
		}//for	
		return targetSet!=null?targetSet.head: null;
	}//findSet
	
	
	@Test
	public void test_1() {
		DisjointSets algo = new DisjointSets();
		Set s1 =  algo.makeSet(1);
		Set s2 =  algo.makeSet(2);
		Set s3 =  algo.makeSet(3);
		Set s4 =  algo.makeSet(4);
		Set s5 =  algo.makeSet(5);
		Set s6 =  algo.makeSet(6);
		Set s7 =  algo.makeSet(7);
		
		s1=algo.union(s1, s2);
		Assert.assertEquals(1, s1.head.val);
		Assert.assertEquals(2, s1.tail.val);
		s1=algo.union(s1, s3);
		Assert.assertEquals(1, s1.head.val);
		Assert.assertEquals(3, s1.tail.val);
		Assert.assertEquals(3, s1.weight);
		
		s6=algo.union(s6, s7);
		Assert.assertEquals(6, s6.head.val);
		Assert.assertEquals(7, s6.tail.val);
		Assert.assertEquals(2, s6.weight);
		
		Set[] sets =  {s1,s6,s7,s4,s5};
		Assert.assertEquals(6, algo.findSet(sets, 7).val);
		Assert.assertEquals(1, algo.findSet(sets, 2).val);
		Assert.assertEquals(1, algo.findSet(sets, 3).val);
		Assert.assertEquals(1, algo.findSet(sets, 2).val);
		Assert.assertEquals(5, algo.findSet(sets, 5).val);
		Assert.assertNull( algo.findSet(sets, 8));
		
		
		s1=algo.union(s1, s6);
		Assert.assertEquals(1, s1.head.val);
		Assert.assertEquals(2, s1.head.next.val);
		Assert.assertEquals(7, s1.tail.val);
		Assert.assertEquals(5, s1.weight);
		

		s1=algo.union(s1, s4);
		Assert.assertEquals(1, s1.head.val);
		Assert.assertEquals(2, s1.head.next.val);
		Assert.assertEquals(4, s1.tail.val);
		Assert.assertEquals(6, s1.weight);
		
		
		
	}
}//class

