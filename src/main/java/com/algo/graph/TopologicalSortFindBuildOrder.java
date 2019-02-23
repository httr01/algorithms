package com.algo.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class TopologicalSortFindBuildOrder {
	/****Find build order based on dependency.
	 * directedGraph[0].length tells how many nodes in graph
	 * Example Graph: { {4} , {0}, {0,6}, {}, {3,5} , {7}, {5}, {} }
	 * Example { {1} , {}, {0}, {0} }
	 * 
	 * 		3 ----> 0---> 1
	 * 				^
	 * 				|
	 * 		2--------
	 * 	 Right Order to build : {3,2,0,1}  or {2, 3,0,1}
	 * 		
	 * **/
	public int[] findBuildOrder(int[][] directedGraph) {

		List<Integer> visited = new ArrayList<Integer>();
		Stack<Integer> finalListStack = new Stack<Integer>();
				for (int i=0 ; i< directedGraph.length; ++i) {
					if (visited.contains(i))
						continue;
					topologocalSort(i, directedGraph,  visited ,   finalListStack  );
				}//for
				int[] orderedListPackages = new int[directedGraph.length];
				int i=0;
				while (!finalListStack.isEmpty())  
					orderedListPackages[i++] = finalListStack.pop();
					
				return orderedListPackages;
		}

		private void topologocalSort(int currNode, int[][] directedGraph, List<Integer> visited , Stack<Integer> finalList  ) {

		        if (!visited.contains(currNode)) 
		        		visited.add(currNode);
		        for (int j = 0 ; j<directedGraph[currNode].length ; ++j) {
		        		// visit all the child's if they are not in visited
		        		if (visited.contains(directedGraph[currNode][j]))
		        			continue;
					topologocalSort(directedGraph[currNode][j], directedGraph,  visited ,   finalList  );
					
		        }// for
		 	finalList.push(currNode);

		}
		
		@Test
		public void test_1() {
			int[][] directedGraph = { {4} , {0}, {0,6}, {}, {3,5} , {7}, {5}, {} };
			TopologicalSortFindBuildOrder algo =  new TopologicalSortFindBuildOrder();
			int[] expectedBuildOrder = {2,6,1,0,4,5,7,3};
			int[] actualOrder = algo.findBuildOrder(directedGraph);
			Assert.assertArrayEquals(expectedBuildOrder, actualOrder);		
		}

		@Test
		public void test_2() {
			int[][] directedGraph = { {1} , {}, {0}, {0} };
			TopologicalSortFindBuildOrder algo =  new TopologicalSortFindBuildOrder();
			int[] expectedBuildOrder = {3,2,0,1};
			int[] actualOrder = algo.findBuildOrder(directedGraph);
			Assert.assertArrayEquals(expectedBuildOrder, actualOrder);		
		}
		@Test
		public void test_3() {
			int[][] directedGraph = { {1} , {}, {0,3}, {0} };
			TopologicalSortFindBuildOrder algo =  new TopologicalSortFindBuildOrder();
			int[] expectedBuildOrder = {2,3,0,1};
			int[] actualOrder = algo.findBuildOrder(directedGraph);
			Assert.assertArrayEquals(expectedBuildOrder, actualOrder);		
		}
}
