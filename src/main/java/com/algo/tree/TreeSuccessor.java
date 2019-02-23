package com.algo.tree;

import org.junit.Test;

import junit.framework.Assert;

public class TreeSuccessor {
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	public int findSuccessor(TreeNode root){
		if (root == null ) return -1; // Exception
			if (root.right ==  null)
				return root.val;
			else 
				return findSuccessorRecur(root.right);
		}

		private int findSuccessorRecur(TreeNode root){
			if (root.left == null )
				return root.val;
			else 
				return findSuccessorRecur(  root.left);
			
		}
	@Test
	public void test_1() {
		TreeSuccessor algo =  new TreeSuccessor();
		TreeNode n21 =  new TreeNode(21) ;
		TreeNode n24 =  new TreeNode(24) ;
		TreeNode n30 =  new TreeNode(30) ;
		TreeNode n23 =  new TreeNode(23) ;
		n23.left=n21;
		n23.right=n24;
		TreeNode n25 =  new TreeNode(25) ;
		n25.right= n30;
		n25.left=n23;
		
		TreeNode n15 =  new TreeNode(15) ;
		
		TreeNode n20 =  new TreeNode(20) ;
		n20.left=n15;
		n20.right=n25;
		
		Assert.assertEquals(21, algo.findSuccessor(n20));
		Assert.assertEquals(24, algo.findSuccessor(n23));
		
		Assert.assertEquals(30, algo.findSuccessor(n25));
		Assert.assertEquals(30, algo.findSuccessor(n30));
		Assert.assertEquals(-1, algo.findSuccessor(null));
		
	}
		
}//class
