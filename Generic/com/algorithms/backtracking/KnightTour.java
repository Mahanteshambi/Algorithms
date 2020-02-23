package com.algorithms.backtracking;

public class KnightTour {

	public static void main(String[] args) {
		KnightTour obj = new KnightTour();
		int N = 8;
		obj.solveKTProblem(N);
	}

	int[] xMov = { 2, 1, -1, -2, -2, -1, 1, 2 };
	int[] yMov = { 1, 2, 2, 1, -1, -2, -2, -1 };

	private void solveKTProblem(int N) {
		int[][] sol = new int[N][N];
		int move = 0;
		sol[0][0] = move;
		boolean isSolExist = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (solveKTUtil(i, j, sol, move + 1)) {
					printSolution(sol);
					isSolExist = true;
				}
			}
		}
		if (!isSolExist) {
			System.out.println("Solution doesn't exist");
		}
	}

	private boolean solveKTUtil(int i, int j, int[][] sol, int move) {
		if (move == (sol.length * sol.length)) {
			return true;
		}
		for (int m = 0; m < xMov.length; m++) {
			int new_x = i + xMov[m];
			int new_y = j + yMov[m];
			if (isMoveSafe(new_x, new_y, sol)) {
				sol[new_x][new_y] = move;
				if (solveKTUtil(new_x, new_y, sol, move + 1)) {
					return true;
				} else {
					sol[new_x][new_y] = 0;
				}
			}

		}
		return false;
	}

	private boolean isMoveSafe(int x, int y, int[][] sol) {
		if (x >= 0 & x < sol.length && y >= 0 && y < sol.length && sol[x][y] == 0) {
			return true;
		}
		return false;
	}

	private void printSolution(int[][] sol) {
		System.out.println("Solution exist!");
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
	}

}
