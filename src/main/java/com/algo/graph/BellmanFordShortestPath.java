package com.algo.graph;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class BellmanFordShortestPath {
	/** Bellman ford shortest path .
	 * We can have negative cost.
	 * Time :O (V+E)
	 * Space : O( V) **/
	public int[] findShortestPath(int howManyVertex, int[][] edges, int src , int dest)    
	{
		int [] [] vertexMetadata = new int[howManyVertex][2];
		//  init src to src to 0  rest will be max integer
		init(howManyVertex,vertexMetadata, src); 
		for (int i = 0 ; i< howManyVertex-1; ++i) { // we need to run only for V-1 times
			for (int j = 0 ; j< edges.length; ++j) { // relax each edge
				int u = edges[j][0];
				int v = edges[j][1];
				int currWeight= edges[j][2];
				if (vertexMetadata[u][0]!= Integer.MAX_VALUE && 
						vertexMetadata[u][0] + currWeight < vertexMetadata[v][0] ) 
				{
					vertexMetadata[v][0] = vertexMetadata[u][0] + currWeight;
					vertexMetadata[v][1] =u; //  change the parent
				}//if 
			}// for
		}//	for
		// We have done V* E loop	
		Stack<Integer> optimalPath = new Stack<Integer>();

		int cameFromNode = dest;//vertexMetadata[dest][1];
		int sizeOfPath =  1;
		while (cameFromNode != src) {
			optimalPath.push(cameFromNode);
			cameFromNode =vertexMetadata[cameFromNode][1];
			++sizeOfPath;
		}
		optimalPath.push(cameFromNode);
		// convert this into Array.
		int[] path =  new int[sizeOfPath];
		int i= 0;
		while (!optimalPath.isEmpty()) 	
			path[i++] = optimalPath.pop().intValue();
		return path;
	}//findShortestPath



	private void init(int howManyVertex, int [] [] vertexMetadata ,int src){
		for (int i = 0 ;i < howManyVertex ; ++i) {
			
			vertexMetadata[i][0] = Integer.MAX_VALUE;
			
		}
		vertexMetadata[src][0] = 0;
		
	}

	
		@Test
		public void test_1(){
			BellmanFordShortestPath algo =  new BellmanFordShortestPath();
			int[][] edges = { {0,3,6},{3,4,2} , {4,5,2} , {5,4,1} , {2,5,4}, {0,1,4} , {0,2,5}, {1,2,-3}};
			int[] actualPath = algo.findShortestPath(6, edges, 0, 5);
			int[] expectedPath= {0,1,2,5};
			Assert.assertArrayEquals(expectedPath, actualPath);
		}
		
		//@Test
		public void test_2(){
			BellmanFordShortestPath algo =  new BellmanFordShortestPath();
			int[][] edges = { {0,2,5},{0,1,7} , {1,2,-4} };
			int[] actualPath = algo.findShortestPath(3, edges, 0, 2);
			int[] expectedPath= {0,1,2};
			Assert.assertArrayEquals(expectedPath, actualPath);
		}
}//class

