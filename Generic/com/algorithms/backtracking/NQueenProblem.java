package com.algorithms.backtracking;

public class NQueenProblem {

	public static void main(String[] args) {
		NQueenProblem obj = new NQueenProblem();
		obj.solveNQueen(8);
	}

	private void solveNQueen(int N) {
		int[][] sol = new int[N][N];
		boolean isSolExist = false;
		for (int i = 0; i < N; i++) {
			if (solveNQueenUtil(i, 0, sol)) {
				System.out.println("Solution exists!");
				printSolution(sol);
				isSolExist = true;
			}
		}
		if (!isSolExist) {
			System.out.println("Solution doesn't exist!");
		}
	}

	private boolean solveNQueenUtil(int i, int j, int[][] sol) {
		if (i == sol.length) {
			return true;
		}
		for (int m = 0; m < sol.length; m++) {
			if (isQueenSafe(i, m, sol)) {
				sol[i][m] = 1;
				if (solveNQueenUtil(i + 1, 0, sol)) {
					return true;
				}
				sol[i][m] = 0;
			}
		}
		return false;
	}

	private boolean isQueenSafe(int i, int j, int[][] sol) {
		for (int m = 0; m < i; m++) {
			if (sol[m][j] == 1) {
				return false;
			}
		}

		for (int x = i, y = j; x >= 0 && y >= 0; x--, y--) {
			if (sol[x][y] == 1) {
				return false;
			}
		}
		for (int u = i, v = j; u >= 0 && v < sol[0].length; u--, v++) {
			if (sol[u][v] == 1) {
				return false;
			}
		}
		return true;
	}

	private void printSolution(int[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j]);
			}
			System.out.println();
		}
	}

}
