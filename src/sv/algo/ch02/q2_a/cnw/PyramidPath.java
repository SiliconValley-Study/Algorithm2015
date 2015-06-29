package sv.algo.ch02.q2_a.cnw;

import java.util.HashMap;
import java.util.Map;

public class PyramidPath {

	public static void main(String[] args) {

		PyramidPath pyramidPath = new PyramidPath();

		char[][] pyramid = { { 'A' }, { 'B', 'C' }, { 'D', 'E', 'F' }, { 'G', 'H', 'I', 'J' }, { 'K', 'L', 'M', 'N', 'O' } };

		int result = pyramidPath.getPyramidPath(pyramid);

		System.out.println("result : " + result);
	}

	public int getPyramidPath(char[][] pyramid) {

		Map<String, Integer> memo = new HashMap<String, Integer>();

		int ways = getPyramidPath(pyramid, 0, 0, memo);

		printPyramidPath(pyramid, 0, 0, memo, "");

		return ways;
	}

	private int getPyramidPath(char[][] pyramid, int i, int j, Map<String, Integer> memo) {

		if (i == pyramid.length - 1) {
			return 1;
		}

		String key = String.format("%d:%d", i, j);

		if (memo.containsKey(key)) {
			return memo.get(key);
		}

		int result = getPyramidPath(pyramid, i + 1, j, memo) + getPyramidPath(pyramid, i + 1, j + 1, memo);

		memo.put(key, result);

		return result;

	}

	private void printPyramidPath(char[][] pyramid, int i, int j, Map<String, Integer> memo, String msg) {

		if (i == pyramid.length - 1) {
			System.out.println(msg + pyramid[i][j]);
			return;
		}

		String prefix = msg + pyramid[i][j];

		printPyramidPath(pyramid, i + 1, j, memo, prefix);
		printPyramidPath(pyramid, i + 1, j + 1, memo, prefix);

	}
}
