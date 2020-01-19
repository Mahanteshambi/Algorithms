package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestNumber {
	public class Node implements Comparable<Node> {
		int number;

		public Node(int num) {
			this.number = num;
		}

		@Override
		public int compareTo(Node that) {
			String first = String.valueOf(this.number) + String.valueOf(that.number);
			String second = String.valueOf(that.number) + String.valueOf(this.number);
			return second.compareTo(first);
		}
	}

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public String largestNumber(final List<Integer> A) {
		StringBuffer result = new StringBuffer();
		Node num[];
		int i = 0;
		num = new Node[A.size()];

		for (int n : A) {
			num[i] = new Node(n);
			i++;
		}

		Arrays.sort(num);
		for (Node n : num) {
			if (n.number == 0 && result.length() != 0)
				continue;
			result.append(n.number);
		}
		return result.toString();
	}

	public static void main(String[] args) {
		LargestNumber obj = new LargestNumber();
		List<Integer> A = new ArrayList<Integer>();
		A.add(3);
		A.add(30);
		A.add(34);
		A.add(5);
		A.add(9);
		A.add(0);
		System.out.println(obj.largestNumber(A));
		// A = obj.getNumbers(A, 3);
		// obj.print(A);
	}

	private void print(List<Integer> A) {
		System.out.println("Printing Array");
		for (int i = 0; i < A.size(); i++) {
			System.out.print(A.get(i) + " ");
		}
		System.out.println();
	}
}
