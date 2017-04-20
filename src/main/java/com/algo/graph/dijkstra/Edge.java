package com.algo.graph.dijkstra;

public class Edge {
	int distance;
	Vertex destinatonVertex;
	public Edge (int distance,Vertex destinatonVertex ){
		this.distance =  distance;
		this.destinatonVertex =  destinatonVertex;
	}
	public Edge (int distance  ){
		this.distance =  distance;
		 
	}	 
}
