package com.algorithms.arrays;

import java.util.ArrayList;

public class PlusOne {
	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<>();
		if (A.size() == 0) {
			return result;
		}
		for (int i = 0; i < A.size(); i++) {
			result.add(A.get(i));
		}
		boolean inc = false;
		for (int i = A.size() - 1; i >= 0; i--) {
			inc = false;
			if ((A.get(i) + 1) != 10) {
				result.set(i, A.get(i) + 1);
				break;
			} else {
				result.set(i, 0);
				inc = true;
			}
		}
		if (inc) {
			result.add(0, 1);
		}
		while (result.get(0) == 0) {
			result.remove(0);
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(0);
		A.add(0);
		A.add(9);
		A.add(1);
		PlusOne obj = new PlusOne();
		for (int i = 0; i < 20; i++) {
			A = obj.plusOne(A);
			obj.print(A);
		}
	}

	private void print(ArrayList<Integer> A) {
		System.out.println("Printing Array");
		for (int i = 0; i < A.size(); i++) {
			System.out.print(A.get(i) + " ");
		}
		System.out.println();
	}
}