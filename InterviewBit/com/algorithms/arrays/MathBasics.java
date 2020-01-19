package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

public class MathBasics {

	public ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        ArrayList<Integer> small = new ArrayList<Integer>();
        ArrayList<Integer> large = new ArrayList<Integer>();
        
        for(int i=1; i<=Math.sqrt(A); i++) {
            if (A%i == 0) {
                int a = i;
                int b = A/i;
                if (a != b) {
                    small.add(a);
                    large.add(b);
                }
                else {
                    small.add(a);
                }
            }
        }
        
        for (int num : small) {
            factors.add(num);
        }
        
        for(int i=large.size()-1;i>=0; i--) {
            factors.add(large.get(i));
        }
        return factors;
    }
	
	public int isPrime(int A) {
        if(A<=1) {
            return 0;
        }
        for(int i=2;i<=Math.sqrt(A);i++){
            if(A%i == 0) {
                return 0;
            }
        }
        return 1;
    }
	
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
		for(int i=2;i<primes.size();i++) {
			if (primes.get(i) == 1) {
				result.add(i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MathBasics obj = new MathBasics();
		List<Integer> result = obj.sieve(7);
		obj.print(result);
	}

	private void print(List<Integer> A) {
		System.out.println("Printing Array");
		for (int i = 0; i < A.size(); i++) {
			System.out.print(A.get(i) + " ");
		}
		System.out.println();
	}

}
