package l37_Graphs_1;

import java.util.*;

import l37_Graphs_1.A37_5_CreateAGraphusingAdjacencyList.Edge;

public class A37_6_BFS {

	
	static class Edge {
		
		int source;
		int destination;
		int weight;
		
		Edge(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
		
	}
	
	
//----> 1. BFS(Breadth First Search)
	public static ArrayList<Integer> BFS(ArrayList<Edge>[] graph) {
		
		ArrayList<Integer> BFSlist = new ArrayList<>();
		boolean edgeVisited[] = new boolean[graph.length];
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(0);
		
		
		while(!q.isEmpty()) {
			
			System.out.println(q);
			
			int currEdge = q.remove();
			if(edgeVisited[currEdge] == false) {	//edge not visited
				BFSlist.add(currEdge);
				for(int i=0; i<graph[currEdge].size(); i++) {
					q.add(graph[currEdge].get(i).destination);
				}
			}
			edgeVisited[currEdge] = true; 
			
		}
		
		
		
		return BFSlist;
	}
	
	
	
	public static void main(String[] args) {
		
		/*
				
				   1------3
				  /		  |\
				 /		  |	\
				0		  |	 5-----6
				 \		  |	/
				  \		  |/
				   2------4
		
		*/
		
		int Vertex = 5;
		
		ArrayList<Edge>[] graph = new ArrayList[7];
		
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		
		//vertex1
		graph[0].add(new Edge(0, 1, 1));
		graph[0].add(new Edge(0, 2, 1));
		
		//vertex1
		graph[1].add(new Edge(1, 0, 1));
		graph[1].add(new Edge(1, 3, 1));
		
		//vertex2
		graph[2].add(new Edge(2, 0, 1));
		graph[2].add(new Edge(2, 4, 1));
		
		//vertex3
		graph[3].add(new Edge(3, 1, 1));
		graph[3].add(new Edge(3, 4, 1));
		graph[3].add(new Edge(3, 5, 1));
		
		//vertex4
		graph[4].add(new Edge(4, 2, 1));
		graph[4].add(new Edge(4, 3, 1));
		graph[4].add(new Edge(4, 5, 1));
		
		//vertex5
		graph[5].add(new Edge(5, 3, 1));
		graph[5].add(new Edge(5, 4, 1));
		graph[5].add(new Edge(5, 6, 1));
		
		//vertex6
		graph[6].add(new Edge(6, 5, 1));	
		
		
		ArrayList<Integer> BFSList = BFS(graph);
		System.out.println("----------");
		System.out.println(BFSList);
		
	}

}
