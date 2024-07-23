package l37_Graphs_1;

import java.util.*;

public class A37_5_CreateAGraphusingAdjacencyList {

	static class Edge {
		
		int source;
		int destination;
		int weight;
		
		public Edge(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
		
	}
	
	
	public static void main(String[] args) {
		
		/*
					(5)
				0 ----- 1
					   / \
				  (1) /   \ (3)
					 /     \
					2 ----- 3
					|	(1)
				(2)	|
					|
					4
		
		*/
		
		String str = "Bhavesh";
		
		int vertices = 5;
		
		ArrayList<Edge>[] graph = new ArrayList[vertices];
		
		
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		
		//vertex0
		graph[0].add(new Edge(0, 1, 5));
		
		//vertex1
		graph[1].add(new Edge(1, 0, 5));
		graph[1].add(new Edge(1, 2, 1));
		graph[1].add(new Edge(1, 3, 3));
		
		//vertex2
//		ArrayList<Integer> vertex2 = new ArrayList();
		graph[2].add(new Edge(2, 1, 1));
		graph[2].add(new Edge(2, 3, 1));
		graph[2].add(new Edge(2, 4, 2));
		
//		//vertex3
//		ArrayList<Integer> vertex3 = new ArrayList();
		graph[3].add(new Edge(3, 1, 3));
		graph[3].add(new Edge(3, 2, 1));
		
		//vertex4
		graph[4].add(new Edge(4, 2, 2));
		
		
		//print all neighbours of vertex 2
		
		for(int i=0; i<graph[2].size(); i++) {
			System.out.println("graph[2].get(" +i +").destination = " +graph[2].get(i).destination);
		}
		
		
		
		
	}

}
