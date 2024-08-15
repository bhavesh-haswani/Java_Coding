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
	
	//modified depth first search
	public static boolean cycleDetectionUndirectedGraph(ArrayList<Edge>[] graph) {
		
		boolean isVisited[] = new boolean[graph.length];
		
		boolean isCycle = false;
		
		for(int i=0; i<graph.length; i++) {
			if(isVisited[i] == false) {
				isCycle = cycleDetectionUndirectedGraphUtil(graph, isVisited, i, -1);
			}
		}
		
		return isCycle;
		
	}
	
	public static boolean cycleDetectionUndirectedGraphUtil(ArrayList<Edge>[] graph, boolean isVisited[], int source, int parent) {
		
		isVisited[source] = true;
		
		for(int i=0; i<graph[source].size(); i++) {
			
			//case 3
			if(isVisited[ graph[source].get(i).destination ] == false) {
				boolean isV = cycleDetectionUndirectedGraphUtil(graph, isVisited, graph[source].get(i).destination, source);
				
				if(isV) {
					return true;
				}
				
			} 
			//case 1
			else if(isVisited[graph[source].get(i).destination] == true && graph[source].get(i).destination != parent) {
				return true;	//cycle esists
			}
			//case 2 - do nothing
			
		}
		
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
		
		graph[4].add(new Edge(4, 3));
		
		
		boolean cycleExists = cycleDetectionUndirectedGraph(graph);
		System.out.println(cycleExists);
		
	}

}
