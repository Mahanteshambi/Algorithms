

public class FibonacciBinary {

	protected long findFib(char[] N, long M) {
		long fibIdentity[][] = { { 1, 1 }, { 1, 0 } };
		long[][] result = matrixPower(fibIdentity, N, M);
		return result[0][0];
	}

	private long[][] matrixPower(long[][] A, char[] n, long m) {
		long[][] identity = { { 1, 0 }, { 0, 1 } };
		while (isNGreaterThanZero(n)) {
			int size = n.length;
			if (n[size - 1] == 49) {
				identity = matrixMultiply(identity, A, m);
			}
			A = matrixMultiply(A, A, m);
			n = rightShift(n);
		}

		return identity;
	}

	private char[] rightShift(char[] N) {
		char[] right = new char[N.length - 1];
		for (int i = 0; i < N.length - 1; i++) {
			right[i] = N[i];
		}
		return right;
	}

	private boolean isNGreaterThanZero(char[] n) {
		for (int i = n.length - 1; i >= 0; i--) {
			if (n[i] > 48) {
				return true;
			}
		}
		return false;
	}

	private long[][] matrixMultiply(long[][] identity, long[][] a, long M) {
		long[][] result = new long[2][2];
		long m = identity.length;
		long n = a[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				long sum = 0;
				for (int k = 0; k < a.length; k++) {
					sum = (sum + (identity[i][k] * a[k][j]) % M) % M;
				}
				result[i][j] = sum;
			}
		}
		return result;
	}

	protected char[] decimalToBinary(char[] N) {
		char[] binary = new char[N.length * 4];
		int i = 0;
		while (isNGreaterThanZero(N)) {
			binary[i++] = (char) (modulous(N, 2) + 48);
			N = division(N, 2);
		}
		char[] binary1 = new char[i];
		int k = 0;
		for (int j = i - 1; j >= 0; j--) {
			binary1[k++] = binary[j];
		}
		return binary1;
	}

	private long modulous(char[] dividend, long divisor) {
		char[] quotient = new char[dividend.length];
		int i = 0, j = 0;
		long temp = 0;
		for (i = 0; i < dividend.length; i++) {
			temp = temp * 10 + dividend[i] - 48;
			if (temp < divisor) {
				quotient[j++] = 48;
			} else {
				quotient[j++] = (char) ((temp / divisor) + 48);
				temp = temp % divisor;
			}
		}
		return temp;
	}

	private char[] division(char[] dividend, int divisor) {
		char[] quotient = new char[dividend.length];
		int i = 0, j = 0;
		long temp = 0;
		for (i = 0; i < dividend.length; i++) {
			temp = temp * 10 + dividend[i] - 48;
			if (temp < divisor) {
				quotient[j++] = 48;
			} else {
				quotient[j++] = (char) ((temp / divisor) + 48);
				temp = temp % divisor;
			}
		}
		return quotient;
	}
}
