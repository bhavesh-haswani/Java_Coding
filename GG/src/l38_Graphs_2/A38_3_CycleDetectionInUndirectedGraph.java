package l38_Graphs_2;

import java.util.*;

public class A38_3_CycleDetectionInUndirectedGraph {
	
	public static class Edge {
		
		int source;
		int destination;
		
		Edge(int source, int destination) {
			this.source = source;
			this.destination = destination;
		}
		
	}
	
	
	public static boolean cycleDetectionUndirectedGraph() {
		
		
		
		
		
		return false;
		
	}
	
	
	

	public static void main(String[] args) {
		
		/*
		 	   0--------3
			  /|		|
			 / |		|
			1  |		|
			 \ |		|
			  \|		|
			   2		4
		
		*/
		
		int Vertex = 5;
		
		ArrayList<Edge>[] graph = new ArrayList[Vertex];
		
		//creating graph
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		//
		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));
		graph[0].add(new Edge(0, 3));
		
		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 2));
		
		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 1));
		
		graph[3].add(new Edge(3, 0));
		graph[3].add(new Edge(3, 4));
		
		graph[4].add(new Edge(4, 2));
		graph[4].add(new Edge(4, 3));
		
		
		boolean cycleExists = cycleDetectionUndirectedGraph(graph);
		
	}

}
