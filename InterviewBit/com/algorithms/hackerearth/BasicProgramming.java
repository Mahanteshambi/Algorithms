package com.algorithms.hackerearth;

public class BasicProgramming {

	public static void main(String[] args) {
		BasicProgramming obj = new BasicProgramming();
		System.out.println("Largest power of 2, less than 33 is: " + obj.largestPowerofTwoLessThan(33));
	}

	private int largestPowerofTwoLessThan(int n) {
		n = n | (n >> 1);
		n = n | (n >> 2);
		n = n | (n >> 4);
		n = n | (n >> 8);
		return (n + 1) >> 1;
	}

}
