package com.algo.tree;

import org.junit.Test;

 

import junit.framework.Assert;

/***
 * https://leetcode.com/problems/balanced-binary-tree/
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
*/
public class BalancedBinaryTree {
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  /**
	   * A tree is balanced if
	   * 1. its left tree height and right tree height differs by 1 or less.
	   * 2. Left sub tree and right sub tree should be balanced.
	   * */
	 public boolean isBalanced(TreeNode root) {
	        if (root ==  null) return true;
	        
	        int leftHeight = height(root.left);// get height of left sub tree
	        int rightHeight = height(root.right);// get height of right sub tree
	        
	        return Math.abs(leftHeight-rightHeight) <=1 && isBalanced(root.left) && isBalanced(root.right);


	    }//isBalanced
	 
	 /*** a= Find out height of left sub tree.
	  *   b= Find out height of right sub tree;
	  *   c = find max of left and right tree height.
	  *   final height = We also need to add 1 to c as this node is not null;
	  * */
	private int height(TreeNode root) {
		if (root ==  null)
			return 0;
		int leftH =  height(root.left);
		int rightH =  height(root.right);
		return Math.max(leftH,rightH) +1;	
	}//height
	
	  
	  @Test
	  public void test_1_leftMax_balanced(){
		  TreeNode root = new TreeNode  (3);
		  TreeNode N7 = new TreeNode  (7);
		  TreeNode N5 = new TreeNode  (7);
		  TreeNode N8 = new TreeNode  (8);
		  TreeNode N2 = new TreeNode  (2);
		  N2.left=N7;
		  N2.right=N5;
		  root.left=N2;
		  root.right=N8;
		  BalancedBinaryTree algo=   new BalancedBinaryTree();
		  Assert.assertEquals(true,  algo.isBalanced(root));
	  }
	  @Test
	  public void test_2_rightNull_notbalanced(){
		  TreeNode root = new TreeNode  (3);
		  TreeNode N7 = new TreeNode  (7);
		  TreeNode N5 = new TreeNode  (7);
		  TreeNode N2 = new TreeNode  (2);
		  N2.left=N7;
		  N2.right=N5;
		  root.left=N2;
		  BalancedBinaryTree algo=   new BalancedBinaryTree();
		  Assert.assertEquals(false,  algo.isBalanced(root));
	  }
	  
	  @Test
	  public void test_3_leftNull_balanced(){
		  TreeNode root = new TreeNode  (3);
	 	  TreeNode N8 = new TreeNode  (8);
		  root.right=N8;
		  BalancedBinaryTree algo=   new BalancedBinaryTree();
		  Assert.assertEquals(true,  algo.isBalanced(root));
	  }
	  
	  @Test
	  public void test_5_Right_Max_balanced(){
		
		  TreeNode root = new TreeNode  (3);
		  TreeNode N7 = new TreeNode  (7);
		  TreeNode N5 = new TreeNode  (7);
		  TreeNode N8 = new TreeNode  (8);
		  TreeNode N2 = new TreeNode  (2);
		  N2.left=N7;
		  N2.right=N5;
		  root.left=N8;
		  root.right=N2;
		  BalancedBinaryTree algo=   new BalancedBinaryTree();
		  Assert.assertEquals(true,  algo.isBalanced(root));
	  }
	  
	  @Test
	  public void test_3_nullRoot(){
		   
		  BalancedBinaryTree algo=   new BalancedBinaryTree();
		  Assert.assertEquals(true,  algo.isBalanced(null));
	  }
}
