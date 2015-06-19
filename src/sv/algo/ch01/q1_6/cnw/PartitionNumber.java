package sv.algo.ch01.q1_6.cnw;

import java.util.Map;

/*
 * 수분할
 * 재귀함수를 구현할때는 큰문제 ( 작은 문제1, 작은 문제2)..
 * 점화식을 만들어서 풀면 쉬워진다.
 * 
 */

public class PartitionNumber {

	public static void main(String[] args) {

		PartitionNumber pn = new PartitionNumber();

		// int k = pn.memoPartition(5, 5, new HashMap<String, Integer>());

		pn.partition2Print(5, "");

		// System.out.println("총 갯수 : " + k);
	}

	public int partition(int value, int div) {

		System.out.println("value : " + value + ", div : " + div);

		if (div > value) {
			div = value;
		}

		if (value <= 0) {
			return 1;
		}

		int cnt = 0;

		for (int i = 1; i <= div; i++) {
			cnt += partition(value - i, i);
		}

		return cnt;

	}

	public int partitionPrint(int value, int div, String msg) {

		if (div > value) {
			div = value;
		}

		if (value <= 0) {

			System.out.println(msg);

			return 1;
		}

		int cnt = 0;

		for (int i = 1; i <= div; i++) {

			String result = msg + (i + " ");

			cnt += partitionPrint(value - i, i, result);
		}

		return cnt;

	}

	public int memoPartition(int value, int div, Map<String, Integer> memo) {

		if (div > value) {
			div = value;
		}

		String key = value + ":" + div;

		if (memo.containsKey(key)) {
			return memo.get(key);
		}

		if (value <= 0) {
			return 1;
		}

		int cnt = 0;

		for (int i = 1; i <= div; i++) {
			cnt += memoPartition(value - i, i, memo);
		}

		memo.put(key, cnt);

		return cnt;

	}

	public int partition2(int n) {

		int cnt = 0;

		for (int i = 1; i <= n - 1; i++) {
			cnt += partition2(n - i);
		}

		return cnt + 1;
	}

	public void partition2Print(int n, String msg) {

		if (n <= 0) {
			System.out.println(msg);
			return;
		}

		for (int i = 1; i <= n; i++) {

			String result = msg + " " + i;

			partition2Print(n - i, result);
		}

	}
}
