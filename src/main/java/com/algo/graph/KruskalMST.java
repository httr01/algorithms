package com.algo.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Test;

import junit.framework.Assert;

/*** Make minimum spanning Tree 
 * Time complexity E log (E)    This is because we sort all the edges.
 * https://www.youtube.com/watch?v=fAuF0EuZVCk
 */
public class KruskalMST {
	public class Vertex{
		char name;
		Vertex parent;
	}
	 
	public class DisjointSet {
		Map<Character, Vertex>  map =  new HashMap<Character, Vertex>();
		int size = 0;
		
		public void makeSet(char name){
			Vertex v =  new Vertex();
			v.name = name;
			v.parent = v;
			map.put(name, v);
			++size;
		}
		/**Time complexity  O(1)*/
		public void union(char name1, char name2){
			Vertex set1 = findSet(name1);
			Vertex set2 = findSet(name2);
			if (set1 != set2) {
				set2.parent = set1;
				--size;
			}
		}
		/**Time complexity  O ( log E) */
		public Vertex findSet(char name){
			Vertex v = map.get(name);
			Vertex parent = v.parent;
			if (v == parent)
					return parent;
			return findSet(parent.name);
			 
		}
		public int size() {
			return size;
		}

	}
	
	public class Edge{
		 char from;
		 char to;
		 int cost;
		 public Edge(char f, char t, int c) {
			 from=f;
			 to = t;
			 cost= c;
		 }
	}
	/***1. Store all the edges in Min Priority Queue
	 *  2. Make each vertex as a disjoint set with one vertex
	 *  3. Now pick each node  from Min Priority Queue and  union them into none set if they are in separate sets.
	 *  4. we end the loop when all the vertex in one set*/
	public List<Edge> getMST(List<Edge> edges, char[] vertex) {
		PriorityQueue<Edge> sortedEdgesPQ =  sort(edges); //#1
		DisjointSet disSet = new DisjointSet();
		//#2
		for (int i = 0 ; i<vertex.length; ++i ) {
			disSet.makeSet(vertex[i]);
		}
		int indexSortedEdges = 0;
		List<Edge> finalEdges=  new ArrayList<Edge>();
		int totalCost = 0;
		int edgeSize = sortedEdgesPQ.size();
		while (disSet.size() >1 && indexSortedEdges <  edgeSize ) { //#4
			//#3
			Edge currEdge = sortedEdgesPQ.poll();
			char fromSetName = disSet.findSet(currEdge.from).name;
			char toSetName = disSet.findSet(currEdge.to).name;
			if (fromSetName == toSetName) 
				continue;
			else {
				disSet.union(fromSetName,toSetName);
				finalEdges.add(currEdge);
				totalCost +=	currEdge.cost;
			}
			++indexSortedEdges;
		}//  while
		return finalEdges;
	}

	public class MyComparator implements Comparator<Edge> {
		@Override
		public int compare(Edge o1, Edge o2) {
			// TODO Auto-generated method stub
			return o1.cost-o2.cost;
		}
	}
	public PriorityQueue<Edge> sort(List<Edge> edges){
			Comparator<Edge> myComparator=  new MyComparator();
			PriorityQueue<Edge> edgePQ = new PriorityQueue<Edge>(myComparator);
			for (int i  = 0 ;i<edges.size() ; ++i) {
				edgePQ.add(edges.get(i));
			}
			return edgePQ;
	} 
	
	@Test
	public void test_1() {
		KruskalMST algo = new KruskalMST();
		List<Edge> edges = new ArrayList<Edge>();
		Edge eDC = new Edge('D', 'C', 1);
		Edge eEF = new Edge('E', 'F', 2);
		Edge eAB = new Edge('A', 'B', 3);
		Edge eAD = new Edge('A', 'D', 1);
		Edge eDE = new Edge('D', 'E', 6);
		Edge eBC = new Edge('B', 'C', 1);
		Edge eCF = new Edge('C', 'F', 4);
		Edge eEC = new Edge('E', 'C', 5);
		Edge eBD = new Edge('B', 'D', 3);
		edges.add(eDC);
		edges.add(eEF);
		edges.add(eAB);
		edges.add(eAD);
		edges.add(eDE);
		edges.add(eBC);
		edges.add(eCF);
		edges.add(eEC);
		edges.add(eBD);
		char[] vertex =  {'D','C','A','B','E','F'};
		List<Edge> mstEdgesActual = algo.getMST(edges, vertex);
		Assert.assertEquals(5, mstEdgesActual.size());
	}
}
