	package com.algo.tree;

import org.junit.Test;

import junit.framework.Assert;

//https://leetcode.com/problems/convert-bst-to-greater-tree/submissions/
/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
          **/	
public class ConvertBSTToGreaterTree {
	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	  int sum = 0;
	   public TreeNode convertBST(TreeNode root) {
	        if  (root ==  null) 
			return null;
		// First go all the way to right most node and  come back from there by adding each node.
		convertBST(root.right);
		root.val =  sum=  sum+ root.val;
		convertBST(root.left);
		return root;
	}

    
		@Test
		public void test_1() {
			ConvertBSTToGreaterTree algo =  new ConvertBSTToGreaterTree();
			TreeNode root=  new TreeNode(5);
			TreeNode n2=  new TreeNode(2);
			TreeNode n13=  new TreeNode(13);
			root.left = n2;
			root.right = n13;
			root=  algo.convertBST(root);
			Assert.assertEquals(18, root.val);
			Assert.assertEquals(20, root.left.val);
			Assert.assertEquals(13, root.right.val);
			
		}
		
	    
			@Test
			public void test_2() {
				ConvertBSTToGreaterTree algo =  new ConvertBSTToGreaterTree();
				TreeNode root=  new TreeNode(5);
				TreeNode n2=  new TreeNode(2);
				TreeNode n13=  new TreeNode(13);
				
				TreeNode n14=  new TreeNode(14);
				n13.right = n14;
				root.left = n2;
				root.right = n13;
				root=  algo.convertBST(root);
				Assert.assertEquals(32, root.val);
				Assert.assertEquals(34, root.left.val);
				Assert.assertEquals(27, root.right.val);
				
				Assert.assertEquals(14, root.right.right.val);
				
			}
			@Test
			public void test_3() {
				ConvertBSTToGreaterTree algo =  new ConvertBSTToGreaterTree();
				TreeNode root=  new TreeNode(5);
				TreeNode n2=  new TreeNode(2);
				 
				root.left = n2;
				 
				root=  algo.convertBST(root);
				Assert.assertEquals(5, root.val);
				Assert.assertEquals(7, root.left.val);
			}
			
}


