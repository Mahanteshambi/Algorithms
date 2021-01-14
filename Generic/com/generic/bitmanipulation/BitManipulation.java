package com.generic.bitmanipulation;

import java.util.Scanner;

public class BitManipulation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BitManipulation object = new BitManipulation();
		// object.checkIthBit(sc);
		// object.countNoOfSetBitsApproach1(sc);
		// object.countNoOfSetBitsApproach2(sc);
//		object.isPowerOfTwoApproach1(sc);
		object.isPowerOfTwoApproach2(sc);
	}

	private void checkIthBit(Scanner sc) {
		int q = sc.nextInt();
		while (q-- > 0) {
			System.out.println("Enter no: ");
			int a = sc.nextInt();
			System.out.println("i: ");
			int i = sc.nextInt();
			String status = ((a & 1 << i - 1) == 0) ? "Not set" : "Set";
			System.out.println(status);
		}
	}

	private void countNoOfSetBitsApproach1(Scanner sc) {
		int q = sc.nextInt();
		while (q-- > 0) {
			int n = sc.nextInt();
			int count = 0;
			while (n > 0) {
				if ((n & 1) > 0)
					count++;
				n = n >> 1;
			}
			System.out.println(count);
		}
	}

	private void countNoOfSetBitsApproach2(Scanner sc) {
		int q = sc.nextInt();
		while (q-- > 0) {
			int n = sc.nextInt();
			int count = 0;
			while (n > 0) {
				count++;
				n = n & n - 1;
			}
			System.out.println(count);
		}
	}

	private void isPowerOfTwoApproach1(Scanner sc) {
		int q = sc.nextInt();
		while (q-- > 0) {
			System.out.println("Enter No: ");
			int n = sc.nextInt();
			if (n <= 1) {
				System.out.println("No");
				continue;
			}
			int count = 0;
			while (n > 0) {
				count++;
				n = n & n - 1;
			}
			if (count == 1) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}

	private void isPowerOfTwoApproach2(Scanner sc) {
		int q = sc.nextInt();
		while (q-- > 0) {
			System.out.println("Enter No: ");
			int n = sc.nextInt();
			if (n <= 1) {
				System.out.println("No");
				continue;
			}
			if ((n & n - 1) == 0) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}

}
