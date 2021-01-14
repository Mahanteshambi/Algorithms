package com.generic.bitmanipulation;

public class Leetcode_SingleNumberII {

	public static void main(String[] args) {
		Leetcode_SingleNumberII object = new Leetcode_SingleNumberII();
		// int[] myIntArray = { 5, 8, 2, 2, 8, 5, 8, 3, 5, 2 };
		int[] myIntArray = { -2, -2, 1, 1, 4, 1, 4, 4, -4, -2 };

		int no = object.singleNumber(myIntArray);
		System.out.println(no);
	}

	public int singleNumber_old(int[] nums) {
		int no = 0;
		int[] f = new int[64];
		for (int i = 0; i < 64; i++) {
			for (int j = 0; j < nums.length; j++) {
				f[i] = ((nums[j] & 1 << i) > 0) ? f[i] + 1 : f[i];
			}
		}
		for (int i = 0; i < 64; i++) {
			if (f[i] % 3 != 0) {
				no += 1 << i;
			}
		}
		return no;
	}

	public int singleNumber(int[] nums) {
		int one = 0, two = 0;
		for (int arrIterator = 0; arrIterator < nums.length; arrIterator++) {
			one = (one ^ nums[arrIterator]) & ~two;
			two = (two ^ nums[arrIterator]) & ~one;
		}
		return one;
	}

}
