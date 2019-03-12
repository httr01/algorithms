package com.algo.tree;

import org.junit.Assert;
import org.junit.Test;

/***
 *** Identical tree : if  two tree has same in structure and has same values.
 ***/

public class SubTree {
	public class Node {
		public Node(int v) {
			value =v;
		}
		int value;
		Node left;
		Node right;
	}
	public boolean isSubTree(Node root1, Node root2) {
		  	boolean subtree = identicalTree(root1,  root2) ;
			if (!subtree && root1.left !=  null ) subtree = isSubTree(root1.left, root2);  
			if (!subtree && root1.right !=  null ) subtree = isSubTree(root1.right, root2);
		  	return subtree;
	}

	 
	
	public boolean identicalTree(Node root1, Node root2) {
		if (root2 ==  null && root1 ==  null) return true;
		if (root1 == null & root2 != null ) return false;		
		if (root2 == null & root1 != null ) return false;
		if (root2.value !=  root1.value ) return false;

		return root2.value ==  root1.value && identicalTree(root1.left, root2.left) &&  identicalTree(root1.right, root2.right);
	}

	public boolean sameStructureTree(Node T1, Node T2) {
		if (T2 ==  null && T1 ==  null) return true;
		if (T1 == null & T2 != null ) return false;		
		if (T2 == null & T1 != null ) return false;
		return sameStructureTree(T1.left, T2.left) &&  sameStructureTree(T1.right, T2.right);
	}
	
	@Test
	public void test_sameStructureTree_1() {
		SubTree algo =  new SubTree();
		Node root1 =  new Node(14);
		Node root2 =  new Node(15);
		
		Node t6 =  new Node(6);
		Node t3 =  new Node(3);
		Node t16 =  new Node(16);
		Node t13 =  new Node(13);
		root1.left= t6;
		root1.right=t3;
		root2.left=t16;
		root2.right=t13;
		
		Assert.assertTrue(algo.sameStructureTree(root1, root2));
	}
	
	@Test
	public void test_not_sameStructureTree_2() {
		SubTree algo =  new SubTree();
		Node root1 =  new Node(14);
		Node root2 =  new Node(15);
		
		Node t6 =  new Node(6);
		Node t3 =  new Node(3);
		
		Node t16 =  new Node(16);
		root1.left= t6;
		root1.right=t3;
		root2.left=t16;
		 Assert.assertFalse(algo.sameStructureTree(root1, root2));
	}
	
	
	
	@Test
	public void test_sameStructureTree_3() {
		SubTree algo =  new SubTree();
		Node root1 =  new Node(14);
		Node root2 =  new Node(15);
		
		Node t6 =  new Node(6);
		
		Node t16 =  new Node(16);
		root1.left= t6;
		root2.left=t16;
		 Assert.assertTrue(algo.sameStructureTree(root1, root2));
	}
	
	
	@Test
	public void test_sameStructureTree_4() {
		SubTree algo =  new SubTree();
		Node root1 =  new Node(14);
		Node root2 =  new Node(15);
		Assert.assertTrue(algo.sameStructureTree(root1, root2));
	}
	
	@Test
	public void test_not_sameStructureTree_5() {
		SubTree algo =  new SubTree();
		Node root1 =  new Node(14);
		Node root2 =  new Node(15);
		Node t6 =  new Node(6);
		Node t3 =  new Node(3);
		Node t16 =  new Node(16);
		Node t26 =  new Node(26);
		root1.left= t6;
		root1.right=t3;
		root2.left=t16;
		t16.right=t26;
		 Assert.assertFalse(algo.sameStructureTree(root1, root2));
	}
	
	@Test
	public void test_identicalTree_False_6() {
		SubTree algo =  new SubTree();
		Node root1 =  new Node(14);
		Node root2 =  new Node(15);
		Node t6 =  new Node(6);
		Node t3 =  new Node(3);
		Node t16 =  new Node(16);
		Node t13 =  new Node(13);
		root1.left= t6;
		root1.right=t3;
		root2.left=t16;
		root2.right=t13;
		Assert.assertFalse(algo.identicalTree(root1, root2));
	}
	
	@Test
	public void test_identicalTree_True_7() {
		SubTree algo =  new SubTree();
		Node root1 =  new Node(14);
		Node root2 =  new Node(14);
		Node t6 =  new Node(6);
		Node t3 =  new Node(3);
		Node t16 =  new Node(6);
		Node t13 =  new Node(3);
		root1.left= t6;
		root1.right=t3;
		root2.left=t16;
		root2.right=t13;
		Assert.assertTrue(algo.identicalTree(root1, root2));
	}
	
	@Test
	public void test_identicalTree_True_8() {
		SubTree algo =  new SubTree();
		Node root1 =  new Node(14);
		Node root2 =  new Node(14);
		Node t6 =  new Node(6);
		Node t16 =  new Node(6);
		root1.left= t6;
		root2.left=t16;
		Assert.assertTrue(algo.identicalTree(root1, root2));
	}
	
	@Test
	public void test_identicalTree_True_9() {
		SubTree algo =  new SubTree();
		Node root1 =  new Node(14);
		Node root2 =  new Node(14);
		Assert.assertTrue(algo.identicalTree(root1, root2));
	}
	
	@Test
	public void test_identicalTree_10() {
		SubTree algo =  new SubTree();
		Node root1 =  new Node(14);
		Node root2 =  new Node(14);
		
		Node t6 =  new Node(6);
		root1.right= t6;
		Assert.assertFalse(algo.identicalTree(root1, root2));
		
		
		Node t6_2 =  new Node(6);
		root2.right= t6_2;
		Assert.assertTrue(algo.identicalTree(root1, root2));
	}
	
	@Test
	public void test_isSubTree_True_11() {
		SubTree algo =  new SubTree();
		Node root1 =  new Node(14);
		Node root2 =  new Node(14);
		Node t15 =  new Node(15);
		root1.left=t15;
		Node t16 =  new Node(16);
		root2.left=t16;
		Assert.assertFalse(algo.isSubTree(root1, root2));
	}
	
	@Test
	public void test_isSubTree12() {
		SubTree algo =  new SubTree();
		Node root1 =  new Node(14);
		Node root2 =  new Node(14);
		
		Node t6_2 =  new Node(6);
		Node t3_2 =  new Node(3);
		root2.left=t6_2;
		root2.right=t3_2;
		
		Node t15 =  new Node(15);
		root1.left=t15;
		Node t14 =  new Node(14);
		
		Node t6_1 =  new Node(6);
		Node t3_1 =  new Node(3);
		t14.left=t6_1;
		t14.right=t3_1;
		
		Assert.assertFalse(algo.isSubTree(root1, root2));
		t15.right = t14;
		Assert.assertTrue(algo.isSubTree(root1, root2));
	}
	
	@Test
	public void test_isSubTree_13() {
		SubTree algo =  new SubTree();
		Node root1 =  new Node(14);
		Node root2 =  new Node(14);
		Assert.assertTrue(algo.isSubTree(root1, root2));
		
		Node t6_2 =  new Node(6);
		Node t3_2 =  new Node(3);
		root2.left=t6_2;
		root2.right=t3_2;
		Assert.assertFalse(algo.isSubTree(root1, root2));
		
		Node t15 =  new Node(15);
		root1.left=t15;
		Node t14 =  new Node(14);
		
		Node t6_1 =  new Node(6);
		Node t3_1 =  new Node(3);
		t14.left=t6_1;
		t14.right=t3_1;
		
		Assert.assertFalse(algo.isSubTree(root1, root2));
		t15.right = t14;
		Assert.assertTrue(algo.isSubTree(root1, root2));
	}

}
