package com.algo.tree;

import org.junit.Assert;
import org.junit.Test;
 
/***
 * Find common Ancestor
 *  			24
 *  		   / \
 *  		15	   16
 *      /\
 *     8  14
 *        /\
 *       6   3 
 * Example for 16,6  common Ancestor = 24
 **/
public class CommonAncestor {

	public class Node {
		public Node(int v) {
			value =v;
		}
		int value;
		Node left;
		Node right;
		int count;// increase if this  node is  in path which find the element we are looking for
	}
	
	int commonAncestor = Integer.MIN_VALUE;
	public int firstCommonAncestor(Node root, int v1, int v2) {
			tracePath(root, v1);
			tracePath(root,v2);
			return commonAncestor;
		}
	private boolean tracePath(Node root, int v) {
			if (root ==  null)
				return false;
			if (root.value == v) {
				if (root.count == 0){
					++root.count;
					return true;
				}else {
					if (commonAncestor == Integer.MIN_VALUE)
						commonAncestor =root.value;
					return true;
				}
			}
			Boolean found = tracePath(root.left, v);
			if (!found)   {
				found = tracePath(root.right, v);
			}
			if (found) {
				if (root.count == 0){
					++root.count;
					return true;
				}else {
					if (commonAncestor == Integer.MIN_VALUE)
					commonAncestor =root.value;
					return true;
				}
			}else 
				return false;
		}
	
	@Test
	public void test_1() {
		CommonAncestor algo =  new CommonAncestor();
		Node root1 =  new Node(24);
		Node t15 =  new Node(15);
		root1.left=t15;
		Node t14 =  new Node(14);
		
		Node t6_1 =  new Node(6);
		Node t3_1 =  new Node(3);
		t14.left=t6_1;
		t14.right=t3_1;
		
		t15.right = t14;
		Assert.assertEquals(14,algo.firstCommonAncestor(root1, 6,3));
		 
		
	}
	@Test
	public void test_2() {
		CommonAncestor algo =  new CommonAncestor();
		Node root1 =  new Node(24);
		Node t15 =  new Node(15);
		root1.left=t15;
		Node t14 =  new Node(14);
		
		Node t6_1 =  new Node(6);
		Node t3_1 =  new Node(3);
		t14.left=t6_1;
		t14.right=t3_1;
		
		t15.right = t14;
		 
		Assert.assertEquals(15,algo.firstCommonAncestor(root1, 15,6));
		
	}
	@Test
	public void test_3() {
		CommonAncestor algo =  new CommonAncestor();
		Node root1 =  new Node(24);
		Node t15 =  new Node(15);
		Node t16 =  new Node(16);
		Node t8 =  new Node(8);
		root1.left=t15;
		root1.right=t16;
		Node t14 =  new Node(14);
		
		Node t6_1 =  new Node(6);
		Node t3_1 =  new Node(3);
		t14.left=t6_1;
		t14.right=t3_1;
		
		t15.right = t14;
		t15.left = t8;
		 
		Assert.assertEquals(24,algo.firstCommonAncestor(root1, 16,6));
		
	}
	
	@Test
	public void test_4() {
		CommonAncestor algo =  new CommonAncestor();
		Node root1 =  new Node(24);
		Node t15 =  new Node(15);
		Node t16 =  new Node(16);
		Node t8 =  new Node(8);
		root1.left=t15;
		root1.right=t16;
		Node t14 =  new Node(14);
		
		Node t6_1 =  new Node(6);
		Node t3_1 =  new Node(3);
		t14.left=t6_1;
		t14.right=t3_1;
		
		t15.right = t14;
		t15.left = t8;
		 
		Assert.assertEquals(15,algo.firstCommonAncestor(root1, 3,8));
		
	}

}
