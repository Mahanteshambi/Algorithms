package com.algorithms.math;

import java.util.ArrayList;

public class PrimeSum {

	public ArrayList<Integer> sieve(int A) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 0; i <= A; i++) {
			primes.add(1);
		}

		primes.set(0, 0);
		primes.set(1, 0);
		for (int i = 0; i <= Math.sqrt(A); i++) {
			if (primes.get(i) == 1) {
				for (int j = 2; i * j <= A; j++) {
					primes.set(i * j, 0);
				}
			}
		}
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 2; i < primes.size(); i++) {
			if (primes.get(i) == 1) {
				result.add(i);
			}
		}
		return result;
	}

	public ArrayList<Integer> primesum(int A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (A < 2)
			return result;

		int first = 2;
		int second = A - first;
		while (first <= second) {
			second = A - first;
			if (isPrime(first) && isPrime(second)) {
				result.add(first);
				result.add(second);
				return result;
			}
			first++;
		}

		return result;
	}

	public static boolean isPrime(int n) {

		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		PrimeSum obj = new PrimeSum();
		ArrayList<Integer> result = obj.primesum(8);
		System.out.println(result.toString());
	}

}
