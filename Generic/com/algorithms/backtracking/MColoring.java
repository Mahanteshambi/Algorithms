package com.algorithms.backtracking;

public class MColoring {

	public static void main(String[] args) {
		MColoring obj = new MColoring();
		int graph[][] = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 }, };
		int graph1[][] = { { 0, 1, 0, 1 }, { 1, 0, 1, 1 }, { 0, 1, 0, 1 }, { 1, 1, 1, 0 }, };
		int m = 3;
		obj.solveMColoring(graph1, m);
	}

	private void solveMColoring(int[][] graph, int m) {
		int[] color = new int[graph.length];
		for (int i = 0; i < graph.length; i++) {
			color[i] = -1;
		}
		if (mColoringUtil(0, graph, m, color)) {
			System.out.println("Solution exist!");
			printSolution(color);
		} else {
			System.out.println("Solution doesn't exist!");
		}
	}

	private boolean mColoringUtil(int v, int[][] graph, int m, int[] color) {
		if (v == graph.length) {
			return true;
		}
		for (int i = 0; i < m; i++) {
			if (isColoringSafe(graph, color, i, v)) {
				color[v] = i;
				if (mColoringUtil(v + 1, graph, m, color)) {
					return true;
				}
				color[v] = 0;
			}
		}
		return false;
	}

	private boolean isColoringSafe(int[][] graph, int[] color, int c, int v) {
		for (int i = 0; i < graph.length; i++) {
			if (graph[v][i] == 1 && color[i] == c) {
				return false;
			}
		}
		return true;
	}

	private void printSolution(int[] color) {
		for (int i = 0; i < color.length; i++) {
			System.out.print((color[i] + 1) + " ");
		}
	}
}
