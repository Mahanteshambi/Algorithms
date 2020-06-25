package com.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {

	class Grapth {
		int v;
		LinkedList<Integer> adjList[];

		Grapth(int v) {
			this.v = v;
			adjList = new LinkedList[v];
			for (int i = 0; i < v; i++) {
				adjList[i] = new LinkedList<Integer>();
			}
		}

		protected void addEdge(int u, int v) {
			adjList[u].add(v);
		}

		protected void bfsTraversal() {
			boolean[] visited = new boolean[v];
			for (int i = 0; i < v; i++) {
				if (!visited[i]) {
					bfsUtil(i, visited);
				}
			}
		}

		private void bfsUtil(int root, boolean[] visited) {

			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(root);
			visited[root] = true;
			while (!queue.isEmpty()) {
				int currNode = queue.poll();
				System.out.print(currNode + " ");
				for (int i = 0; i < adjList[currNode].size(); i++) {
					int adjNode = adjList[currNode].get(i);
					if (!visited[adjNode]) {
						visited[adjNode] = true;
						queue.add(adjList[currNode].get(i));
					}
				}
			}
		}

		protected void dfsTraversal() {
			boolean[] visited = new boolean[v];
			for (int i = 0; i < v; i++) {
				if (!visited[i]) {
					dfsUtil(i, visited);
				}
			}
		}

		private void dfsUtil(int root, boolean visited[]) {
			visited[root] = true;
			System.out.print(root + " ");
			for (int i = 0; i < adjList[root].size(); i++) {
				int adjNode = adjList[root].get(i);
				if (!visited[adjNode]) {
					visited[adjNode] = true;
					dfsUtil(adjNode, visited);
				}
			}
		}

	}

	public static void main(String[] args) {
		GraphTraversal.Grapth graph = new GraphTraversal().new Grapth(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		graph.bfsTraversal();
		System.out.println();
		graph.dfsTraversal();
	}

}
