package com.algorithms.math;

public class EcelColNo {

	public static void main(String[] args) {
		EcelColNo obj = new EcelColNo();
		System.out.println(obj.titleToNumber("BCSUS"));
		System.out.println(obj.convertToTitle(980089));
	}

	public int titleToNumber(String A) {

		int no = 0;
		for (int c = 0; c < A.length(); c++) {
			no *= 26;
			no += A.charAt(c) - 'A' + 1;
		}
		return no;

	}

	public String convertToTitle(int A) {
		StringBuilder strBuilder = new StringBuilder();
		while (A > 0) {
			int b = A % 26;
			if (b == 0) {
				strBuilder.append("Z");
				A = (A / 26) - 1;
			} else {
				strBuilder.append((char) ((b - 1) + 'A'));
				A = A / 26;
			}

		}
		return strBuilder.reverse().toString();
	}
}
