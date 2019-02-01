package com.algo.tree;

import org.junit.Assert;
import org.junit.Test;

import com.algo.tree.KthSmallestElement.TreeNode;

 
public class UniValueTree {
	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	  
	    public boolean isUnivalTree(TreeNode root) {
	        return isUnivalTreeInOrder(root, root.val);
	    }
	    
	    private boolean isUnivalTreeInOrder(TreeNode root, int value) {
	        if (root == null ) return true;
	        
	        if ( root.val == value && isUnivalTreeInOrder(root.left,value) && isUnivalTreeInOrder(root.right,value) ) return true;
	        else return false;
	    }
	    
	    
	    
		@Test
		public  void test_1() {
			int[] dataArr = {2,2,2,2,2,2};
			UniValueTree tt= new UniValueTree();
			Assert.assertTrue(tt.isUnivalTree(createTree(dataArr)));
		}
		@Test
		public  void test_2() {
			int[] dataArr = {2,2,2,2,2,1};
			UniValueTree tt= new UniValueTree();
			Assert.assertTrue(!tt.isUnivalTree(createTree(dataArr)));
		}
		
		@Test
		public  void test_3() {
			int[] dataArr = {0,0,0,0,0,0,0,0,0,0};
			UniValueTree tt= new UniValueTree();
			Assert.assertTrue(tt.isUnivalTree(createTree(dataArr)));
		}
		@Test
		public  void test_4() {
			int[] dataArr = {0,0,0,0,0,0,0,0,0,1};
			UniValueTree tt= new UniValueTree();
			Assert.assertTrue(!tt.isUnivalTree(createTree(dataArr)));
		}
		
		
		
		@Test
		public  void test_5() {
			int[] dataArr = {0,0,0,0,0,0,-1,0,0,0};
			UniValueTree tt= new UniValueTree();
			Assert.assertTrue(tt.isUnivalTree(createTree(dataArr)));
		}
		
		@Test
		public  void test_6() {
			int[] dataArr = {2,2,2,2,2,2,2,2,2,-1};
			UniValueTree tt= new UniValueTree();
			Assert.assertTrue(tt.isUnivalTree(createTree(dataArr)));
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
