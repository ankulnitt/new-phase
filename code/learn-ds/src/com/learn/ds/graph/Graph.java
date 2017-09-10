package com.learn.ds.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	private int v;
	private LinkedList<Integer> adj[];

	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<Integer>();
	}

	public void addEdge(int u, int w) {
		adj[u].add(w);
	}

	public void bfs(int s) {
		StringBuilder builder = new StringBuilder();
		boolean[] visited = new boolean[v];
		visited[s] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		while (!q.isEmpty()) {
			Integer w = q.poll();
			builder.append(w).append(" ");
			LinkedList<Integer> adjecents = adj[w];
			for (Integer u : adjecents) {
				if (!visited[u]) {
					visited[u] = true;
					q.add(u);
				}
			}
		}
		System.out.println(builder.toString());
	}

	public void dfs(int s) {
		boolean[] visited = new boolean[v];
		Stack<Integer> stack = new Stack<>();
		StringBuilder path = new StringBuilder();
		visited[s] = true;
		stack.push(s);

		while (!stack.isEmpty()) {
			Integer u = stack.pop();
			path.append(u).append(" ");
			LinkedList<Integer> adjecents = adj[u];
			for (Integer i : adjecents) {
				if (!visited[i]) {
					visited[i] = true;
					stack.push(i);
				}
			}
		}
		System.out.println(path.toString());
	}

	public static void main(String[] args) {
		Graph g = new Graph(12);

		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 7);
		g.addEdge(2, 9);
		g.addEdge(4, 5);
		g.addEdge(5, 6);
		g.addEdge(6, 8);
		g.addEdge(9, 10);
		g.addEdge(7, 11);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.bfs(1);
		
		g.dfs(1);

	}

}
