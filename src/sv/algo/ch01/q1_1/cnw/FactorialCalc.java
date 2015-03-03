package sv.algo.ch01.q1_1.cnw;

public class FactorialCalc {

	public static void main(String[] args) {

		System.out.println(factorial(5));

		System.out.println(factorial2(5));
	}

	public static int factorial(int n) {

		if (n == 0 || n < 0) {
			return 1;
		}

		if (n == 1) {
			return 1;
		}

		return factorial(n - 1) * n;
	}

	public static int factorial2(int n) {

		if (n == 0 || n < 0) {
			return 1;
		}

		if (n == 1) {
			return 1;
		}

		int result = 1;

		for (int i = 2; i <= n; i++) {

			result = result * i;

		}

		return result;
	}
}
