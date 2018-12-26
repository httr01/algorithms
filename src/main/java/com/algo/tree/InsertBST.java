package com.algo.tree;

 /***
  * https://leetcode.com/problems/insert-into-a-binary-search-tree/
  * Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
  * Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
  **/
public class InsertBST {
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 public TreeNode insertIntoBST(TreeNode root, int val) {
	        traverseAndInsert(root,val);
	        return root;
	    }
		private void  traverseAndInsert(TreeNode root, int val){
			if ( root ==  null) return;
			if (val >= root.val) {
				if (root.right ==null){
					root.right = new TreeNode(val);
					return;
				}else {
					traverseAndInsert(  root.right,   val);
				}
			}else if (val < root.val) {
				if (root.left ==null){
					root.left = new TreeNode(val);
					return;
				}else {
					traverseAndInsert(  root.left,   val);
				}
			}
		}

}
