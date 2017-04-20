package com.algo.graph.dijkstra;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra { 
	/**int with infinite distance.*/
	private void setInfiniteDistance(Set<Vertex> graph){
		graph.forEach(v -> v.currentDistance= Integer.MAX_VALUE);
	} 
	/**Time complexity
	 * M: Number of vertex
	 * N: Number of edges
	 * O(M log(N) )
	 * */
	public String  findShortestPath_v2(HashSet<Vertex> graph, Vertex startVertex, Vertex vertexToReach) {
		HashSet<Vertex> visitedVertex = new HashSet<Vertex>();
		PriorityQueue<Vertex> pqNotVisitedVertex = new PriorityQueue<Vertex>();
		
		setInfiniteDistance(graph);
		startVertex.currentDistance=0;
		startVertex.path=startVertex.name;
		pqNotVisitedVertex.add(startVertex);
		Vertex nextSelectedVertex = null;
		
		while (!pqNotVisitedVertex.isEmpty()){
			nextSelectedVertex = pqNotVisitedVertex.poll();
			
			// match if we found what we were looking for
			if ( nextSelectedVertex.name.equalsIgnoreCase(vertexToReach.name)) {
				System.out.print("Total Distance:"+nextSelectedVertex.currentDistance);
				return nextSelectedVertex.path;
			}
			// recalculate distance because we have got new vertex which is added in visited vertex set
			relax_v2(nextSelectedVertex,pqNotVisitedVertex,visitedVertex);
			
			// add that in visited set
			visitedVertex.add(nextSelectedVertex);
			 
		}//while
		return "DID-NOT-FIND";
	}
	/**1. Visit all the edges from nextSelectedVertex
	 * 2. recalculate distance for the vertex which can be reached by these edges if they are not in visited vertex already.
	 * **/
	private void relax_v2(Vertex nextSelectedVertex,PriorityQueue<Vertex> pqNotVisitedVertex,HashSet<Vertex> visitedVertex){
		for (Edge currentEdge: nextSelectedVertex.adjEdge) {
			if (!visitedVertex.contains(currentEdge.destinatonVertex)) {
				int newDistanceToDestinatonVertex = nextSelectedVertex.currentDistance + currentEdge.distance;
				if (newDistanceToDestinatonVertex < currentEdge.destinatonVertex.currentDistance) {
					// add in priority Queue if  not already there
					if (!pqNotVisitedVertex.contains(currentEdge.destinatonVertex))  {
						pqNotVisitedVertex.add(currentEdge.destinatonVertex);
					}
					currentEdge.destinatonVertex.currentDistance = newDistanceToDestinatonVertex;
					currentEdge.destinatonVertex.path = nextSelectedVertex.path + "->"+currentEdge.destinatonVertex.name;
				}
			}
		}
	}
	
	/**Time complexity
	 * M: Number of vertex
	 * N: Number of edges
	 * O (M * N )
	 * */
	public String  findShortestPath_v1(HashSet<Vertex> graph, Vertex startVertex, Vertex vertexToReach) {
		HashSet<Vertex> visitedVertex = new HashSet<Vertex>();
		visitedVertex.add(startVertex);
		setInfiniteDistance(graph);
		startVertex.currentDistance=0;
		startVertex.path=startVertex.name;
		Vertex nextSelectedVertex = startVertex;
		while (nextSelectedVertex!= null){
			visitedVertex.add(nextSelectedVertex);
			// match if we found what we were looking for
			if ( nextSelectedVertex.name.equalsIgnoreCase(vertexToReach.name)) {
				System.out.print("Total Distance:"+nextSelectedVertex.currentDistance);
				return nextSelectedVertex.path;
			}
			// find next nearest vertex  from unvisited
			nextSelectedVertex = findNextNearestUnvisited_v1(visitedVertex);
			 
		}//while
		return "DID-NOT-FIND";
	}
	//It will do following
	//1. Update all the vertex with new distance if it is less
	//2. Find new vertex from un visited universe.
	private Vertex findNextNearestUnvisited_v1(HashSet<Vertex> visitedVertex ) {
		Vertex selectedNextVertex= null;
		int minDistance= Integer.MAX_VALUE;
		for (Vertex currentV:visitedVertex){
			if  (currentV.adjEdge ==  null) continue;
			for (Edge nextEdge:currentV.adjEdge){
				int distanceToNextVertex= currentV.currentDistance +nextEdge.distance;
				if (distanceToNextVertex< nextEdge.destinatonVertex.currentDistance) {
					nextEdge.destinatonVertex.currentDistance=distanceToNextVertex;
					nextEdge.destinatonVertex.path=currentV.path+"->"+nextEdge.destinatonVertex.name;
				}
				// here we choose next vertex which is not in current nextEdge.destinatonVertex set
				if (!visitedVertex.contains(nextEdge.destinatonVertex)){
					if (distanceToNextVertex< minDistance){
						minDistance=distanceToNextVertex;
						selectedNextVertex=nextEdge.destinatonVertex;
					}
				}
			}
		}
		return selectedNextVertex;
	}	
}