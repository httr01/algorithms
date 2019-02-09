package com.algo.graph.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Test;

import junit.framework.Assert;
/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 * There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
**/
public class CheapestFlightsWithinKStops {
	private class Node implements Comparable<Node>{
		public  Node copy() {
			Node node =  new Node(name);
			node.cost= cost;
			node.depth=depth;
			return node;
		}
		@Override
		public int compareTo(Node other) {
			return cost-other.cost;
		}
		
		int name;
		int cost;
		int depth;
		Node(int n){
			name=n;
		 
		}
	}
	public class Edge{
		Node start;
		Node dest;
		int cost;
		
		public Edge(int start,int dest,int cost) {
			this.start=  new Node(start);
			this.dest =  new Node(dest);
			this.cost =  cost;
		}
		
	}
	private void initMapNodToCost(  Node[] nodeList) {
		for (int i =0; i<nodeList.length;++i) {
			nodeList[i] =  new Node(i);
			nodeList[i].cost=Integer.MAX_VALUE;
		}//for
	}
	private Map<Integer, List<Edge>> convertNodeToEdgesMap(int[][] flights) {
		Map<Integer, List<Edge>> myMap = new HashMap<Integer, List<Edge>>();
		for (int i= 0 ;i <flights.length ; ++i) {
			List<Edge> edgesFromThisNode = myMap.get(flights[i][0]);
			if (edgesFromThisNode ==  null) {
				edgesFromThisNode =  new ArrayList<Edge>();
			}
			Edge edge =  new Edge(flights[i][0],flights[i][1],flights[i][2]);
			edgesFromThisNode.add(edge);
			myMap.put(flights[i][0],edgesFromThisNode);
			
		}//for
		return myMap;
	}
	
	/***steps
	 * 1. Create a map of  Node-> List of Edges
	 * 2.  Initialise All the nodes to Max cost (infinite)
	 * 3. Define a priority Queue. This queue will hold  list of possible candidate till now and return node with least cost.
	 * 		This is done by implementing Comparable interface
	 * 4. Once node is visited, we should not visit again
	 * 5. start with src node and set the cost to 0, since we can go to itself without any cost.
	 * 	   And add this node in Priority Queue 
	 * 6. pick a node from PQ untill it is empty
	 * 7. 	Go to next node if this node is more than K steps away.
	 * 		e are using K+1 ,  since we are counting . Since there is one edge between two cities and 0 stops
	 * 8. if we found our destination break out of loop
	 * 9.  Pick each edge from current node and adjust cost,depth and add that in PQ.*/
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		        	
		Node[] nodeList = new Node[n];
		Map<Integer, List<Edge>> mapNodeToEdge = convertNodeToEdgesMap(flights);  //step #1 
		initMapNodToCost(nodeList); // Step #2
		PriorityQueue<Node>  availableNodesListPQ =  new PriorityQueue<Node>(); //Step #3
		List<Integer>  visitedNodesList =  new ArrayList<Integer>(); //#4
		
		nodeList[src].cost =0; //#5
		Node currNode = nodeList[src];
		availableNodesListPQ.add(currNode);
		while(!availableNodesListPQ.isEmpty() ) {  //#6
			 
			currNode = availableNodesListPQ.poll();
			if (currNode.depth>K+1)  //#7
					continue;// go to next one
			if (currNode.name == dst) { //#8
				break;//  found the node
			}
			List<Edge> allNeighbourEdges = mapNodeToEdge.get(currNode.name);
			if (allNeighbourEdges ==  null)
					continue;
			  for ( int i = 0  ; i< allNeighbourEdges.size(); ++i) {  //#9
					Edge currEdge = allNeighbourEdges.get(i);
					if (visitedNodesList.contains(currEdge.dest.name))
							continue;
					
					Node newNode =   nodeList[currEdge.dest.name] .copy();
					if (currNode.cost +currEdge.cost < nodeList[currEdge.dest.name].cost) {
						
						newNode.cost=currNode.cost +currEdge.cost;
						newNode.depth = currNode.depth +1;
					}//if 
					
					availableNodesListPQ.add(newNode);
					 
			}//for
			visitedNodesList.add(currNode.name);
		}// while
		if (currNode.name ==  dst && currNode.depth<=K+1)
		    		return currNode.cost;
		else 
			return -1;
	}

    @Test
    public void test_1() {
    		CheapestFlightsWithinKStops algo =  new CheapestFlightsWithinKStops();
    		int[][] flights = {{0,1,100}, {1,2,100} , {0,2,500}};
    		Assert.assertEquals(200, algo.findCheapestPrice(3, flights, 0, 2, 1));
    }
    
    @Test
    public void test_2() {
    		CheapestFlightsWithinKStops algo =  new CheapestFlightsWithinKStops();
    		int[][] flights = {{0,1,100}, {1,2,100} , {0,2,500}};
    		Assert.assertEquals(200, algo.findCheapestPrice(3, flights, 0, 2, 1));
    }
    
    
    
    @Test
    public void test_3() {
    		CheapestFlightsWithinKStops algo =  new CheapestFlightsWithinKStops();
    		int[][] flights = {{0,1,100}, {1,2,100} /*, {0,2,500}*/,{1,3,10},{3,2,20} };
    		Assert.assertEquals(130, algo.findCheapestPrice(4, flights, 0, 2, 2));
    }
    
    @Test
    public void test_4() {
    		CheapestFlightsWithinKStops algo =  new CheapestFlightsWithinKStops();
    		int[][] flights = {{0,1,100}, {1,2,100} , {0,2,500},{1,3,10},{3,2,20} };
    		Assert.assertEquals(130, algo.findCheapestPrice(4, flights, 0, 2, 2));
    }
    
    @Test
    public void test_5() {
    		CheapestFlightsWithinKStops algo =  new CheapestFlightsWithinKStops();
    		int[][] flights = {{0,1,100}, {1,2,100} , {0,2,50},{0,2,500},{1,3,10},{3,2,20} };
    		Assert.assertEquals(50, algo.findCheapestPrice(4, flights, 0, 2, 2));
    }
    
    @Test
    public void test_6() {
    		CheapestFlightsWithinKStops algo =  new CheapestFlightsWithinKStops();
    		int[][] flights = {{0,1,100}, {1,2,100} , {0,2,50},{0,2,500},{1,3,10},{3,2,20} };
    		Assert.assertEquals(50, algo.findCheapestPrice(4, flights, 0, 2, 1));
    }
    
    @Test
    public void test_7() {
    		CheapestFlightsWithinKStops algo =  new CheapestFlightsWithinKStops();
    		int[][] flights = {{0,1,100}, {1,2,100} , {0,2,50},{0,2,500},{1,3,10},{3,2,20} };
    		Assert.assertEquals(50, algo.findCheapestPrice(4, flights, 0, 2, 0));
    }

    @Test
    public void test_8() {
    		CheapestFlightsWithinKStops algo =  new CheapestFlightsWithinKStops();
    		int[][] flights = {{0,0,50},{0,1,20},{0,1,10} };
    		Assert.assertEquals(10, algo.findCheapestPrice(2, flights, 0, 1, 0));
    }
    
    @Test
    public void test_9() {
    		CheapestFlightsWithinKStops algo =  new CheapestFlightsWithinKStops();
    		int[][] flights = {{0,0,50},{0,1,20},{0,1,10},{1,2,10} };
    		Assert.assertEquals(-1, algo.findCheapestPrice(3, flights, 0, 2, 0));
    }
    @Test
    public void test_10() {
    		CheapestFlightsWithinKStops algo =  new CheapestFlightsWithinKStops();
    		int[][] flights = {{0,0,50},{0,1,20},{0,1,10},{1,2,10} };
    		Assert.assertEquals(20, algo.findCheapestPrice(3, flights, 0, 2, 1));
    }
    
    @Test
    public void test_11() {
    		CheapestFlightsWithinKStops algo =  new CheapestFlightsWithinKStops();
    		int[][] flights = {{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}};
    		Assert.assertEquals(-1, algo.findCheapestPrice(5, flights, 2, 1, 1));
    }
  

    @Test
    public void test_12() {
    		CheapestFlightsWithinKStops algo =  new CheapestFlightsWithinKStops();
    		int[][] flights = {{0,1,100}, {1,2,100}, {0,2,500}};
    		Assert.assertEquals(500, algo.findCheapestPrice(3, flights, 0, 2, 0));
    }
}