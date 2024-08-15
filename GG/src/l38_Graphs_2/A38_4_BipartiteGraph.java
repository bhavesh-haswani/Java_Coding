package l38_Graphs_2;

import java.util.*;

public class A38_4_BipartiteGraph {
	
	static class Edge {
		
		int source;
		int destination;
		
		 Edge(int source, int destination) {
			this.source = source;
			this.destination = destination;
		}
		
	}
	
	
	public static boolean isBipartite(ArrayList<Edge>[] graph) {
		
		boolean color[] = new boolean[graph.length];
		boolean isVisited[] = new boolean[graph.length];
		
		int source = 0;
		isVisited[source] = true;
		
		for(int i=0; i<graph.length; i++) {
			boolean colorAndCheck = colorTheEdge(graph, isVisited, color, i);
			if(colorAndCheck == false) {
				return false;
			}
		}
		
		
		return true;
	}
	
	public static boolean colorTheEdge(ArrayList<Edge>[] graph, boolean isVisited[], boolean color[], int source) {
		
		for(int i=0; i<graph[source].size(); i++) {
			
			boolean sourceColor = color[source];
			int destination = graph[source].get(i).destination;
			
			//case 1 - not visited
			if(isVisited[destination] == false) {
				isVisited[destination] = true;
				color[destination] = !sourceColor;
			}
			//case 2 - visited - compare the color
			else if(color[destination] == sourceColor) {
				return false;
			}
			
		}
		return true;
		
	}
	
	
	public static void main(String args[]) {
		
		/*
		 			0
		 		   / \
		 		  /	  \	
		  		 1	   2
		  		  \	  /
		  		   \ /
		  		    3
		  		    
		 */
		
		final int Vertices = 4;
		
		ArrayList<Edge>[] graph = new ArrayList[Vertices];
		
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));
		
		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 3));

		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 3));

		graph[3].add(new Edge(3, 1));
		graph[3].add(new Edge(3, 2));
		
		
		boolean isBipartite = isBipartite(graph);
		System.out.println("graph1 isBipartite = " +isBipartite);
		
		
		/*
		 
		 			0
		 		   /  \
		 		  /		\
		 		 1		  \ 2
		 		  \			/
		 		   \	   /
		 		   	3-----4
		 
		 
		 */
		
		ArrayList<Edge>[] graph2 = new ArrayList[5];
		
		for(int i=0; i<graph2.length; i++) {
			graph2[i] = new ArrayList<>();
		}
		
		graph2[0].add(new Edge(0, 1));
		graph2[0].add(new Edge(0, 2));
		
		graph2[1].add(new Edge(1, 0));
		graph2[1].add(new Edge(1, 3));
		
		graph2[2].add(new Edge(2, 0));
		graph2[2].add(new Edge(2, 4));

		graph2[3].add(new Edge(3, 1));
		graph2[3].add(new Edge(3, 4));
		
		graph2[4].add(new Edge(4, 2));
		graph2[4].add(new Edge(4, 3));
		
				
		boolean isBipartite2 = isBipartite(graph2);
		System.out.println("graph2 isBipartite = " +isBipartite2);
	}
	
}
