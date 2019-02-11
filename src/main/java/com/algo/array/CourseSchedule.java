package com.algo.array;

import java.util.ArrayList;
 
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.**/
public class CourseSchedule {
	
	public class Node{
		int value;
		int hasCycle = -1;// -1=  Not determined, 0: does not have cycle, 1: has cycle
		public Node(int i) {
			 value=i;
 		}
		List<Node> childs =  new ArrayList<Node>();
		public void addChild(Node c){
			if (!childs.contains(c)) 
				childs.add(c);
		}
	}
	private Node[]   initGraph(int numCourses, int[][] prerequisites) {
		 Node[] AllNodes =  new Node[numCourses];
		
		 for (int i =0 ; i < numCourses ; ++i) {
			AllNodes[i]= new Node(i);
		}
		for (int i =0 ;i< prerequisites.length; ++i) {
		 	Node srcNode = AllNodes[prerequisites[i][0]];
			srcNode.addChild( AllNodes[prerequisites[i][1]] );
		}//for
		return AllNodes;
	}
	/***
	 * #1: A node with no child is  not a cycle
	 * #2: A node linking itself is not a cycle
	 * #3: We keep list of visitedNodes. If a node were previously visited, means we found a loop.
	 * #4: A node has a cycle:  if it's childrens does not have  a cycle.
	 * #5: Any node has a cycle we exit.**/
	public boolean hasCycle(Node root , List<Integer> visitedNodes) {
		Boolean nodeHasCycle =  false;
		visitedNodes.add(root.value);
		List<Integer> visitedNodesCopy =  new ArrayList<Integer>();
		for (Integer i:visitedNodes)  {
			visitedNodesCopy.add(i.intValue());
		}
		for (Node currChild: root.childs) {
			visitedNodes  =  new ArrayList<Integer>();
			for (Integer i:visitedNodesCopy)  {
				visitedNodes.add(i.intValue());
			}
			if (currChild.value == root.value)  //#2
					continue;// points to same node;
			if (visitedNodes.contains(currChild.value))
				return true; //  loop  #3
			//#4
			boolean childHasCycle= currChild.hasCycle <0?hasCycle(currChild,visitedNodes):currChild.hasCycle==1;
			
			currChild.hasCycle = (childHasCycle)?1:0;
			nodeHasCycle = nodeHasCycle || childHasCycle;	
			if (nodeHasCycle)  //#5
				break;
		} // for
	
		return nodeHasCycle;
	}//hasCycle
	/*** Think like course is a parent Node and each course have list of child courses/Nodes which is required to complete parent course.
	 *We need to make sure there is no cyclic dependency among nodes
	 * Steps
	 * #1: Create list of nodes and its child nodes
	 * #2 : Go through list of nodes and call function hasCycle( .. )
	 * #3 : We will not call function hasCycle(..) on same node again. 
	 *      Thus we are storing this information in three value flag "hasCycle".
	 *      hasCycle 	= -1 :   Not determined yet, 0: does not have cycle, 1: has cycle
	 * #4 : We exit as soon as we found first cycle.
	 *       **/
	public boolean canFinish(int numCourses, int[][] prerequisites) 
	{
		Node[] allNodesList = initGraph(numCourses,prerequisites);  //#1
		if (  allNodesList.length ==0)
			return true;
	
		for (Node currNode: allNodesList) { //#2
			List<Integer> visitedNodes = new ArrayList<Integer>();
			//Boolean hasCycle = hasCycle(currNode,visitedNodes);
			boolean hasCycle= currNode.hasCycle <0?hasCycle(currNode,visitedNodes):currNode.hasCycle==1;  //#3
			
			currNode.hasCycle = (hasCycle)?1:0;
			if (currNode.hasCycle==1)  //#4
				return false;
		}//for
		return true;
	
	}//initCourseReq
	
	
	@Test
	public void test_1() {
		CourseSchedule algo=  new CourseSchedule();
		int[][] prerequisites = {{1,0}};
		Assert.assertTrue(algo.canFinish(2, prerequisites));
	}
	@Test
	public void test_2() {
		CourseSchedule algo=  new CourseSchedule();
		int[][] prerequisites = {{1,0}, {0,1}};
		Assert.assertFalse(algo.canFinish(2, prerequisites));
	}
	
	@Test
	public void test_3() {
		CourseSchedule algo=  new CourseSchedule();
		int[][] prerequisites = {{0,1}, {2,1}};
		Assert.assertTrue(algo.canFinish(4, prerequisites));
	}
	@Test
	public void test_4() {
		CourseSchedule algo=  new CourseSchedule();
		int[][] prerequisites = {{0,1}, {2,3}, {3,2}};
		Assert.assertFalse(algo.canFinish(4, prerequisites));
	}
	
	@Test
	public void test_5() {
		CourseSchedule algo=  new CourseSchedule();
		int[][] prerequisites = {{0,1},{1,2}, {2,3}};
		Assert.assertTrue(algo.canFinish(4, prerequisites));
	}
	@Test
	public void test_6() {
		CourseSchedule algo=  new CourseSchedule();
		int[][] prerequisites = {{0,1},{1,2}, {2,0}};
		Assert.assertFalse(algo.canFinish(4, prerequisites));
	}
	
	@Test
	public void test_7() {
		CourseSchedule algo=  new CourseSchedule();
		int[][] prerequisites = {};
		Assert.assertTrue(algo.canFinish(4, prerequisites));
	}
	
	@Test
	public void test_8() {
		CourseSchedule algo=  new CourseSchedule();
		int[][] prerequisites = {{0,1},{1,2}, {2,3}, {3,4}};
		Assert.assertTrue(algo.canFinish(5, prerequisites));
	}
	
	@Test
	public void test_9() {
		CourseSchedule algo=  new CourseSchedule();
		int[][] prerequisites = {{0,1},{0,2}, {2,3}};
		Assert.assertTrue(algo.canFinish(5, prerequisites));
	}
	
	
	@Test
	public void test_10_loop() {
		CourseSchedule algo=  new CourseSchedule();
		int[][] prerequisites = {{1,0},{1,2}, {0,1}};
		Assert.assertFalse(algo.canFinish(3, prerequisites));
	}
	
	@Test
	public void test_11() {
		CourseSchedule algo=  new CourseSchedule();
		int[][] prerequisites = {{1,0},{2,0}, {3,1}, {4,1}};
		Assert.assertTrue(algo.canFinish(5, prerequisites));
	}
	@Test
	public void test_12_loop_notpossible() {
		CourseSchedule algo=  new CourseSchedule();
		int[][] prerequisites = {{1,0},{2,0}, {3,1}, {4,1}, {0,4}};
		Assert.assertFalse(algo.canFinish(5, prerequisites));
	}
	@Test
	public void test_13_loop_notpossible() {
		CourseSchedule algo=  new CourseSchedule();
		int[][] prerequisites = {{1,0},{1,2},{2,0}, {3,1},{3,2}, {4,1}, {0,4}};
		Assert.assertFalse(algo.canFinish(5, prerequisites));
	}
 
			@Test
			public void test_14() {
				CourseSchedule algo=  new CourseSchedule();
				int[][] prerequisites = {{2,0}, {1,0}, {3,1}, {3,2}, {1,3}};
				Assert.assertFalse(algo.canFinish(4, prerequisites));
			}
			@Test
			public void test_15() {
				CourseSchedule algo=  new CourseSchedule();
				int[][] prerequisites = {{1,0}, {2,6}, {1,7},{6,4}, {7,0},{0,5}};
				Assert.assertTrue(algo.canFinish(8, prerequisites));
			}
			
			@Test
			public void test_16() {
				CourseSchedule algo=  new CourseSchedule();
				int[][] prerequisites = {{1,0}, {2,6}, {1,2},{1,7},{6,4}, {7,0},{7,2},{0,5}};
				Assert.assertTrue(algo.canFinish(8, prerequisites));
			}
			
			@Test
			public void test_17_loop() {
				CourseSchedule algo=  new CourseSchedule();
				int[][] prerequisites = {{1,0},{1,2},{2,0} };
				Assert.assertTrue(algo.canFinish(3, prerequisites));
			}	 
}



