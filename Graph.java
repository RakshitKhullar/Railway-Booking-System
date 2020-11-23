package Graphs;
import java.util.*;
public class Graph {

	private LinkedList<Integer>  adj[];
	public Graph(int v) {
		adj = new LinkedList[v]; 
		for(int i = 0;i<v;i++) {
			adj[i] = new LinkedList<>();
		}
	 
	}
	public  void addEdge(int source , int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}
	
	
	public Stack<Integer> bfs(int source,int destination){
		boolean[] vis = new boolean[adj.length];
		int parent[] = new int[adj.length];
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		
		parent[source] = -1;
		
		vis[source] = true;
		
		while(!q.isEmpty()) {
		int curr = q.poll();
		if(curr == destination ) break;
		for(int neighbour :adj[curr]) {
			if(!vis[neighbour]) {
				vis[neighbour] = true;
				q.add(neighbour);
				parent[neighbour] = curr;
			}
		}
		}
		Stack<Integer> v = new Stack();
		int curr = destination;
		int d = 0;
		while(parent[curr] != -1) {
			d++;
			v.push(curr);
			curr = parent[curr];
		}
		v.push(source);

		v.push(d);
		return v;
	}
}
 
