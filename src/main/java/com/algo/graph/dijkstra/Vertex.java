package com.algo.graph.dijkstra;

public class Vertex   implements Comparable<Vertex>{
	String name;
	Edge[] adjEdge;
	String path;
	int currentDistance;
	public Vertex(String name, Edge[] adjEdge){
		this.name= name;
		this.adjEdge= adjEdge;
	}
	
	public Vertex(String name ){
		this.name= name;
		 
	}
	@Override
	public int hashCode() {
		int hashCode = 0;
		hashCode= name.hashCode() ;
		return hashCode;
	}
	 
	 
	public  int compareTo(Vertex anotherVertex ){
		return currentDistance -anotherVertex.currentDistance;
		
	}
}
