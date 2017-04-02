

public class FibonacciNthNo {

	public static void main(String[] args) {
		String str = "1000000008945386535333333333333333111111111111322222222222222220565165135313131531321351321531321313215321531321351313513513135131351313151351348698465";
		char[] N = str.toCharArray();
		long M = 999999999;
		FibonacciNthNo instance = new FibonacciNthNo();
		instance.compareFib(N, M);
	}

	private void compareFib(char[] n, long m) {
		for (int i = 0; i < 10; i++) {
			FibonacciDecimal fibDecimal = new FibonacciDecimal();
			FibonacciBinary fibBinary = new FibonacciBinary();
			FibonacciSequence fibSequence = new FibonacciSequence();

			System.out.println("Iteration No: " + (i + 1));

			long startTime = System.currentTimeMillis();
			long result = fibDecimal.findFib(n, m);
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime;
			System.out.println("Fibonacci No using decimal: " + result + " in " + elapsedTime + " milliseonds");

			startTime = System.currentTimeMillis();
			char[] binaryN = fibBinary.decimalToBinary(n);
			result = fibBinary.findFib(binaryN, m);
			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;
			System.out.println("Fibonacci No using binary: " + result + " in " + elapsedTime + " milliseonds");

			startTime = System.currentTimeMillis();
			result = fibSequence.findFib(n, m);
			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;
			System.out.println(
					"Fibonacci No using repeating sequence: " + result + " in " + elapsedTime + " milliseonds");
		}
	}

}
