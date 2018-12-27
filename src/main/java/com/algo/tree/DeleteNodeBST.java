package com.algo.tree;

import org.junit.Assert;
import org.junit.Test;

/**https://leetcode.com/problems/delete-node-in-a-bst/
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).
*/
 
public class DeleteNodeBST {

	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 public TreeNode deleteNode(TreeNode root, int key) {
		 	if (root ==  null) return null;
		 	if (key  == root.val) {
		 		// Take care of root , if root needs to be deleted
		 		root = deleteRoot(root);
		 	}else
		 		findNodeAndDelete(root, key,root);
	        return root;
	   }

	 private TreeNode deleteRoot(TreeNode root) {
		 if (root ==  null ) return null;
		 if (root.left ==  null && root.right== null) return null;
		 if (root.left ==  null) return root.right;
		 if (root.right ==  null) return root.left;
		 // when both right and left are not null
		 TreeNode[] minNode = findMinNodeAndParent(root.right, null, root);
		  
		 return deleteAndPlaceMinNode ( minNode,root, null ) ;
	 }
	 
	 private TreeNode findNodeAndDelete(TreeNode currNode,  int key, TreeNode parent) {	
			if (currNode == null) return null;
			if (key == currNode.val) {
				// here we found the node to delete
				deleteNode(currNode,parent);
				return currNode;
			}else if (key< currNode.val) {
				return findNodeAndDelete(currNode.left, key,currNode);
			}else {
				return findNodeAndDelete(currNode.right, key,currNode);
			}		 
	 }
	private void deleteNode(TreeNode node, TreeNode parent) {
		if (node ==  null) return;
		if (node.left == null && node.right ==  null) {
			// A. delete it, when  node does not have left and right
			if (parent.right == node) parent.right = null;
			else parent.left = null;
			return;
		}else if (node.left == null) {
			//B. When node does not have left node
			if (parent.right == node){
				parent.right=node.right;
			}else parent.left=node.right;
				return;
			}else if (node.right == null) {
				//C: When node does not have right node
				if (parent.right == node){
						parent.right=node.left;
				}else parent.left=node.left;
				return;
			}else{
				//D.  When node have both left and right node.
				TreeNode[] minNode = findMinNodeAndParent(node.right, null, node);
				deleteAndPlaceMinNode ( minNode,node,   parent ) ;
			}//if
	
	}//deleteNode
	
	private TreeNode deleteAndPlaceMinNode(TreeNode[] minNode,TreeNode nodeToDelete, TreeNode parent ) {
		/*
		//minNode[0] = min node, minNode[1] = parent of min node, 
		// D1 : minNode can be equal to right child of node.
		// D2 : minNode is NOT equal to right child of node.
		*/
		boolean deleteRoot =  false;
		if (parent ==  null) {
			parent =    minNode[0];
			deleteRoot =  true;
		}
		if (minNode[0] == nodeToDelete.right) {
			//D1:
			if (!deleteRoot) {
				if (parent.right == nodeToDelete){
					parent.right=minNode[0];
				}else {
					parent.left=minNode[0];
				}
			} 
			minNode[0].left=nodeToDelete.left;
		}else{
			//D2:
			// Get minNode ready
			
				TreeNode minNodeRightTemp = minNode[0].right;
				minNode[0].right = minNode[1];
				minNode[1].left = minNodeRightTemp;
	
				minNode[0].left=  nodeToDelete.left; // 
				if (!deleteRoot) {
					if (parent.right == nodeToDelete){
						parent.right=minNode[0];
					}else {
						parent.left=minNode[0];
					}
				}
			 

		}//if
		return parent;
	}

	private TreeNode[] findMinNodeAndParent(TreeNode root, TreeNode[] minAndParentNodeArr,TreeNode parent ) {
		if  (root == null) return minAndParentNodeArr;
		minAndParentNodeArr= findMinNodeAndParent(root.left,minAndParentNodeArr, root);
		if (minAndParentNodeArr == null) {
			minAndParentNodeArr= new TreeNode[2];
			minAndParentNodeArr[0]=root;
			minAndParentNodeArr[1]=parent;
		}
		return minAndParentNodeArr;
	}

	
	//A
	@Test
    public void test_0() {
    	DeleteNodeBST algo =  new DeleteNodeBST();
    		int[] dataArr = {3,1,7,-1,-1,6,-1};
    		int[] expected_orderDataArr = {3,-1,7,0,0,6,-1};
    		TreeNode root = createTree(dataArr);
    		algo.deleteNode(root,1);
    		int[] resultArray = new int[dataArr.length];
    		resultArray = treeToArray(root,resultArray,0);
    		 Assert.assertArrayEquals(expected_orderDataArr,resultArray );	
    }
	//B
	@Test
    public void test_1() {
    	DeleteNodeBST algo =  new DeleteNodeBST();
    		int[] dataArr = {3,1,7,-1,-1,6,-1};
    		int[] expected_orderDataArr = {3,1,6,-1,-1,-1,-1};
    		TreeNode root = createTree(dataArr);
    		algo.deleteNode(root,7);
    		int[] resultArray = new int[dataArr.length];
    		resultArray = treeToArray(root,resultArray,0);
    		 Assert.assertArrayEquals(expected_orderDataArr,resultArray );	
    }
	//C
	@Test
    public void test_2() {
    	DeleteNodeBST algo =  new DeleteNodeBST();
    		int[] dataArr = {3,1,6,-1,-1,-1,8};
    		int[] expected_orderDataArr = {3,1,8,-1,-1,-1,-1};
    		TreeNode root = createTree(dataArr);
    		algo.deleteNode(root,6);
    		int[] resultArray = new int[dataArr.length];
    		resultArray = treeToArray(root,resultArray,0);
    		 Assert.assertArrayEquals(expected_orderDataArr,resultArray );	
    }
	//D
    @Test
    public void test_3() {
    	DeleteNodeBST algo =  new DeleteNodeBST();
    		int[] dataArr = {5,3,6,2,4,-1,7};
    		int[] expected_orderDataArr = {5,4,6,2,-1,-1,7};
    		TreeNode root = createTree(dataArr);
    		algo.deleteNode(root,3);
    		int[] resultArray = new int[dataArr.length];
    		resultArray = treeToArray(root,resultArray,0);
    		 Assert.assertArrayEquals(expected_orderDataArr,resultArray );	
    }
    
    @Test
    public void test_delete_root() {
    		DeleteNodeBST algo =  new DeleteNodeBST();
    		int[] dataArr = {5,-1,-1};
    		int[] expected_orderDataArr = {-1};
    		TreeNode root = createTree(dataArr);
    		root= algo.deleteNode(root,5);
    		int[] resultArray = new int[1];
    		resultArray = treeToArray(root,resultArray,0);
    		 Assert.assertArrayEquals(expected_orderDataArr,resultArray );	
    }
    
    @Test
    public void test_delete_root_1() {
    		DeleteNodeBST algo =  new DeleteNodeBST();
    		int[] dataArr = {5,1,10};
    		int[] expected_orderDataArr = {10,1,-1};
    		TreeNode root = createTree(dataArr);
    		root= algo.deleteNode(root,5);
    		int[] resultArray = new int[dataArr.length];
    		resultArray = treeToArray(root,resultArray,0);
    		 Assert.assertArrayEquals(expected_orderDataArr,resultArray );	
    }
    
    @Test
    public void test_delete_root_2() {
    		DeleteNodeBST algo =  new DeleteNodeBST();
    		int[] dataArr = {25,13,40,-1,-1,35,45};
    		int[] expected_orderDataArr = {35,13,40,-1,-1,-1,45};
    		TreeNode root = createTree(dataArr);
    		root= algo.deleteNode(root,25);
    		int[] resultArray = new int[dataArr.length];
    		resultArray = treeToArray(root,resultArray,0);
    		 Assert.assertArrayEquals(expected_orderDataArr,resultArray );	
    }
    private int[] treeToArray(TreeNode root, int[] resultArray,int index) {
    		
    		if (root == null) {
    			if (index< resultArray.length)  resultArray[index] = -1;
    			return resultArray;
    		}
    		resultArray[index] = root.val;
    		treeToArray(  root.left,  resultArray,index*2+1);
    		treeToArray(  root.right,  resultArray,index*2+1+1);
    		return resultArray;
    		
    }
    
	private TreeNode  createTree(int[] dataArr ) {
		TreeNode[] nodeObjArr =  new TreeNode[ dataArr.length];
		nodeObjArr[0] = new TreeNode(dataArr[0]);
		for (int i=0 ; i < dataArr.length/2; ++i) {
			int leftChild = 2*i+1;
			int rightChild= leftChild+1;
			if (leftChild<dataArr.length  && dataArr[leftChild]>=0) {
				nodeObjArr[i].left = new TreeNode(dataArr[leftChild]);
				nodeObjArr[leftChild] = nodeObjArr[i].left;
			}
			if (rightChild<dataArr.length  && dataArr[rightChild]>=0) {
				nodeObjArr[i].right = new TreeNode(dataArr[rightChild]);
				nodeObjArr[rightChild] = nodeObjArr[i].right;
			}
		}
		return nodeObjArr[0] ; 
	}

}
