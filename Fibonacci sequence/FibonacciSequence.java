

public class FibonacciSequence {
	protected long findFib(char[] N, long M) {
		long p = findRepeatingSequence(M);
		long x = modulous(N, p);
		return fibonacci(x + 1, M);
	}

	private long fibonacci(long N, long M) {
		long f0 = 0, f1 = 1, f2 = 0;
		for (int i = 0; i < N; i++) {
			f2 = (f0 + f1) % M;
			f0 = f1;
			f1 = f2;
		}
		return f0;
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

	private long findRepeatingSequence(long M) {
		long f0 = 0, f1 = 1, f2 = 0;
		long p = 0;
		for (int i = 0; i < 6 * M; i++) {
			f2 = (f0 + f1) % M;
			f0 = f1;
			f1 = f2;
			if (f0 == 0 && f1 == 1) {
				p = i;
				break;
			}
		}
		return p + 1;
	}

}
