package com.algorithms.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LengthNLessThanK {

//	public int solve(ArrayList<Integer> A, int B, int C) {
//		int count = 0;
//
//		return count;
//	}

	static int MAX = 10;

	// Function to convert a number into ArrayList
	static ArrayList<Integer> numToVec(int N) {
		ArrayList<Integer> digit = new ArrayList<Integer>();

		while (N != 0) {
			digit.add(N % 10);
			N = N / 10;
		}

		if (digit.size() == 0)
			digit.add(0);

		Collections.reverse(digit);

		return digit;
	}

	// Function to return the count
	// of B length integers which are
	// less than C and they contain
	// digits from set A[] only
	static int solve(ArrayList<Integer> A, int B, int C) {
		ArrayList<Integer> digit = new ArrayList<Integer>();
		int d, d2;

		digit = numToVec(C);
		d = A.size();

		if (B > digit.size() || d == 0)
			return 0;

		else if (B < digit.size()) {
			if (A.get(0) == 0 && B != 1)
				return (int) ((d - 1) * Math.pow(d, B - 1));
			else
				return (int) Math.pow(d, B);
		}

		else {
			int[] dp = new int[B + 1];
			int[] lower = new int[MAX + 1];

			for (int i = 0; i < d; i++)
				lower[A.get(i) + 1] = 1;
			for (int i = 1; i <= MAX; i++)
				lower[i] = lower[i - 1] + lower[i];

			boolean flag = true;
			dp[0] = 0;
			for (int i = 1; i <= B; i++) {
				d2 = lower[digit.get(i - 1)];
				dp[i] = dp[i - 1] * d;

				if (i == 1 && A.get(0) == 0 && B != 1)
					d2 = d2 - 1;

				if (flag)
					dp[i] += d2;

				flag = (flag & (lower[digit.get(i - 1) + 1] == lower[digit.get(i - 1)] + 1));
			}
			return dp[B];
		}
	}

	public static void main(String[] args) {
		LengthNLessThanK obj = new LengthNLessThanK();
		Integer arr[] = { 0, 1, 2, 5 };
		// Digits array
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(arr));
		int N = 2;
		int k = 21;

		System.out.println(solve(A, N, k));
	}
}
