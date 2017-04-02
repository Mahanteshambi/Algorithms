

public class FibonacciDecimal {
	
	public static void main(String[] args) {
		String str = "1000000008945386535333333333333333111111111111322222222222222220565165135313131531321351321531321313215321531321351313513513135131351313151351348698465";
		char[] N = str.toCharArray();
		long M = 999999999;
		FibonacciDecimal instance = new FibonacciDecimal();
		long fib = instance.findFib(N, M);
		System.out.println(fib);
	}

	protected long findFib(char[] N, long M) {
		long[][] fibIdentity = { { 1, 1 }, { 1, 0 } };
		long[][] result = matrixPower(fibIdentity, N, M);
		return result[0][0];
	}

	private long[][] matrixPower(long[][] A, char[] n, long M) {
		long[][] identity = { { 1, 0 }, { 0, 1 } };
		int size = n.length;
		while (isNGreaterThanZero(n)) {
			if (n[size - 1] % 2 == 1) {
				identity = matrixMultiply(identity, A, M);
			}
			A = matrixMultiply(A, A, M);
			n = division(n, 2);
		}

		return identity;
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
