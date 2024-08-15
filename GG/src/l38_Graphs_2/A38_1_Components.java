package l38_Graphs_2;

import java.util.*;

public class A38_1_Components {

	public static class Edge {
		
		int source;
		int destination;
		
		public Edge(int source, int destination) {
			this.source = source;
			this.destination = destination;
		}
		
	}
	
	
	public static ArrayList<Integer> BFS(ArrayList<Edge>[] graph) {
		ArrayList<Integer> BFSList = new ArrayList<Integer>();
		
		boolean isVisited[] = new boolean[graph.length];
		
		for(int i=0; i<isVisited.length; i++) {
			if(isVisited[i] == false) {
				BFSUtil(graph, BFSList, isVisited, i);
			}
		}
		
		return BFSList;
	}
	
	public static void BFSUtil(ArrayList<Edge>[] graph, ArrayList<Integer> BFSList, boolean isVisited[], int index) {
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(graph[index].get(0).source);
		
		while(!q.isEmpty()) {
			int src = q.remove();
			if(isVisited[src] == false) {
				isVisited[src] = true;
				BFSList.add(src);
				for(int i=0; i<graph[src].size(); i++) {
					;				int destination = graph[src].get(i).destination;
					if(isVisited[destination] == false) {
						//BFSUtil(graph, BFSList, isVisited, graph[src].get(i).destination);
						q.add(destination);
					}
				}
			}
			
			
			
		}
		
		
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
		
		
		final int VERTICES = 7;
		ArrayList<Edge>[] graph = new ArrayList[VERTICES];
		
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		
		//vertex0 
		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));
		
		//vertex1
		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 3));
		
		//vertex2
		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 4));
		
		//vertex3
		graph[3].add(new Edge(3, 1));
		graph[3].add(new Edge(3, 4));
		graph[3].add(new Edge(3, 5));
		
		//vertex4
		graph[4].add(new Edge(4, 2));
		graph[4].add(new Edge(4, 3));
		graph[4].add(new Edge(4, 5));
		
		//vertex5
		graph[5].add(new Edge(5, 3));
		graph[5].add(new Edge(5, 4));
		graph[5].add(new Edge(5, 6));
		
		graph[6].add(new Edge(6, 5));
		
		
		ArrayList<Integer> BFSList = BFS(graph);
		System.out.println(BFSList);
		
		
	}

}
