package sv.algo.ch01.q1_a.cnw;

/*
 * 1.a
 * n과 k를 입력받아서 1^k + 2^k + 3^k...n^k 를 구하는 프로그램을 재귀적, 비재귀적인 방법으로 작성하라.
 * 
 */

public class Q1_a {

	public static void main(String[] args) {

		Q1_a a = new Q1_a();

		int n = 5;

		int k = 1;

		long result = a.sumSquareNumberRecursive(n, k);

		System.out.println(result);

		result = a.sumSquareNumberWhile(n, k);

		System.out.println(result);

	}

	public long sumSquareNumberRecursive(int n, int k) {

		if (n == 1) {
			return 1;
		}

		long val = n;
		int i = k;

		while (i > 1) {
			val *= n;
			i--;
		}

		return val + sumSquareNumberRecursive(n - 1, k);
	}

	public long sumSquareNumberWhile(int n, int k) {

		long result = 0;

		for (int i = 1; i <= n; i++) {

			int j = k;

			int val = i;

			while (j > 1) {
				val *= i;
				j--;
			}

			result += val;
		}

		return result;

	}

}
