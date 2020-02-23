package com.algorithms.backtracking;

public class RatMaze {

	public static void main(String[] args) {
		int[][] maze = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		RatMaze obj = new RatMaze();
		obj.solveRatMaze(maze);
	}

	int[] xMove = { 1, 0 };
	int[] yMove = { 0, 1 };

	private void solveRatMaze(int[][] maze) {
		int[][] sol = new int[maze.length][maze[0].length];
		sol[0][0] = 1;
		if (mazeUtil(0, 0, sol, maze)) {
			printSolution(sol);
		} else {
			System.out.println("Solution doesn't exist!");
		}
	}

	private boolean mazeUtil(int i, int j, int[][] sol, int[][] matrix) {
		if (i == sol.length - 1 && j == sol.length - 1) {
			return true;
		}

		for (int m = 0; m < xMove.length; m++) {
			int newX = i + xMove[m];
			int newY = j + yMove[m];
			if (isMoveSafe(newX, newY, matrix)) {
				sol[newX][newY] = 1;
				if (mazeUtil(newX, newY, sol, matrix)) {
					return true;
				} else {
					sol[newX][newY] = 0;
				}
			}
		}
		return false;
	}

	private boolean isMoveSafe(int x, int y, int[][] matrix) {
		if (x >= 0 && x < matrix.length && y >= 0 && y < matrix.length && matrix[x][y] == 1) {
			return true;
		}
		return false;
	}

	private void printSolution(int[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
	}

}
