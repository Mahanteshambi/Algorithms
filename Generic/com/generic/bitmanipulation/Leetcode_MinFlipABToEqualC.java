package com.generic.bitmanipulation;

public class Leetcode_MinFlipABToEqualC {

	public static void main(String[] args) {
		Leetcode_MinFlipABToEqualC object = new Leetcode_MinFlipABToEqualC();
		int count = object.minFlips(2, 6, 5);
		System.out.println(count);
	}

	public int minFlips(int a, int b, int c) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			boolean x = false, y = false, z = false;
			if ((a & 1 << i) > 0)
				x = true;
			if ((b & 1 << i) > 0)
				y = true;
			if ((c & 1 << i) > 0)
				z = true;
			if (z) {
				if (!x && !y)
					count++;
			} else {
				if (x && y)
					count += 2;
				else if (x || y)
					count++;
			}
		}
		return count;
	}
}
