package sv.algo.ch01.q1_4.cnw;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	public static void main(String[] args) {

		System.out.println(calcFibonacci(20));

		System.out.println(calcFibonacciMemoization(50));

	}

	public static int calcFibonacci(int n) {

		if (n > 30) {
			return -1;
		}

		if (n == 0 || n == 1) {
			return 1;
		} else if (n == 2) {
			return 1;
		}

		return calcFibonacci(n - 1) + calcFibonacci(n - 2);
	}

	public static long calcFibonacciMemoization(int n) {

		Map<Integer, Long> memo = new HashMap<>();
		memo.put(0, (long) 1);
		memo.put(1, (long) 1);
		memo.put(2, (long) 1);

		return calcFibonacciMemoization(memo, n);
	}

	public static long calcFibonacciMemoization(Map<Integer, Long> memo, int n) {

		if (memo.containsKey(n)) {
			return memo.get(n);
		}

		long val = calcFibonacciMemoization(memo, n - 1)
				+ calcFibonacciMemoization(memo, n - 2);

		memo.put(n, val);

		return val;
	}

}
