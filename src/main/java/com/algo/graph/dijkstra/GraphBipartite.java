package com.algo.graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.Test;

import junit.framework.Assert;

/**https://leetcode.com/problems/is-graph-bipartite/
 * 
 * Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation: 
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.
Example 2:
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation: 
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes into two independent subsets.
 

Note:

graph will have length in range [1, 100].
graph[i] will contain integers in range [0, graph.length - 1].
graph[i] will not contain i or duplicate values.
The graph is undirected: if any element j is in graph[i], then i will be in graph[j].**/
public class GraphBipartite {
	/**
	 * Paint alternate node in a graph with alternate color. If you encounter a node which is already colored
	 * and not equalto next color, we exit with false.
	 * 
	 *#1 Traverse each node
	 *#2 if current node is not colored, process it
	 *#3 color current node in RED color and add in  nodesQueue.
	 *#4  process until nodesQueue is empty.
	 *#5 All the child should be colored alternate of previous color.
	 *#6. if child already have color and that is not equal to color we want,  thats a contradiction and we exit
	 ***/
	public boolean isBipartite(int[][] graph) {
        int[] color =  new int [graph.length];
        int colorCode = 1; // 1 RED  , -1 GREEN 
        for (int i = 0 ; i< graph.length; ++i ) { //#1
	        	if (color[i] == 0 ){  //#2
	        		Queue<Integer> nodesQueue =  new LinkedList<Integer> ();
	        		nodesQueue.add(i);
	        		color[i] =colorCode; //#3
	        		while (!nodesQueue.isEmpty()){  //#4
	        			int preNode = nodesQueue.poll();
	        			int nextColor = -color[preNode]; //#5
	        			for (int j = 0 ;  j < graph[preNode].length; ++j) {
	        				int nextNode = graph[preNode][j];
	        				if (color[nextNode] == 0 ) {
	        					color[nextNode]=nextColor;
	        					nodesQueue.add(nextNode);
	        				}
	        				if (color[nextNode] != nextColor ) { //#6
	        					return false;
	        				}
	        			}//for
	        		}//  while
	        }//if 
	 
        }//for
        return true;
	}

	
	 @Test
	 public void test_1() {
		 int[][] graph =  {{1,2,3}, {0,2}, {0,1,3}, {0,2}};
		 GraphBipartite algo = new GraphBipartite();
		 Assert.assertFalse(algo.isBipartite(graph));
		 
	 }
	 
	 @Test
	 public void test_2_4nodes() {
		 int[][] graph =  {{1,3}, {0,2}, {1,3}, {0,2}};
		 GraphBipartite algo = new GraphBipartite();
		 Assert.assertTrue(algo.isBipartite(graph));
		 
	 }
	 
	 @Test
	 public void test_3_5nodes() {
		 int[][] graph =  {{1,4}, {0,2,3}, {1,3}, {1,2}, {0,2}};
		 GraphBipartite algo = new GraphBipartite();
		 Assert.assertFalse(algo.isBipartite(graph));
		 
	 }
	 
	 @Test
	 public void test_4_5nodes() {
		 int[][] graph =  {{1,4}, {0,2,3}, {1}, {1}, {0,2}};
		 GraphBipartite algo = new GraphBipartite();
		 Assert.assertTrue(algo.isBipartite(graph));
		 
	 }
	 
	 @Test
	 public void test_5_5nodes() {
		 int[][] graph =  {{3}, {2,4}, {1}, {0,4}, {1,3}};
		 GraphBipartite algo = new GraphBipartite();
		 Assert.assertTrue(algo.isBipartite(graph));
		 
	 }
}
