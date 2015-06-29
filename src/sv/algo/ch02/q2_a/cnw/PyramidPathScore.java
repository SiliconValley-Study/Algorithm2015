package sv.algo.ch02.q2_a.cnw;

import java.util.HashMap;
import java.util.Map;

public class PyramidPathScore {

	public static void main(String[] args) {

		PyramidPathScore pathScore = new PyramidPathScore();

		int[][] pyramid = { { 4 }, { 3, 8 }, { 3, 5, 1 }, { 6, 4, 3, 2 }, { 1, 3, 2, 1, 1 } };

		pathScore.printFastPath(pyramid);
	}

	public void printFastPath(int[][] pyramid) {

		Map<String, Integer> memo = new HashMap<String, Integer>();

		int len = pyramid[pyramid.length - 1].length;

		for (int i = 0; i < len; i++) {
			memo.put(String.format("%d:%d", len - 1, i), pyramid[len - 1][i]);
		}

		int result = calcFastPath(pyramid, 0, 0, memo);

		System.out.println("총 점수 : " + result);
		System.out.print("경로 : ");
		printPath(pyramid, 0, 0, memo);

	}

	private int calcFastPath(int[][] pyramid, int i, int j, Map<String, Integer> memo) {

		String key = String.format("%d:%d", i, j);

		if (memo.containsKey(key)) {
			return memo.get(key);
		}

		if (i == pyramid.length - 1) {
			return pyramid[i][j];
		}

		int left = calcFastPath(pyramid, i + 1, j, memo);

		int right = calcFastPath(pyramid, i + 1, j + 1, memo);

		int result = (left > right ? right : left) + pyramid[i][j];

		memo.put(key, result);

		return result;

	}

	private void printPath(int[][] pyramid, int i, int j, Map<String, Integer> memo) {

		System.out.print(pyramid[i][j] + " ");

		if (i == pyramid.length - 1) {
			return;
		}

		String leftKey = String.format("%d:%d", i + 1, j);
		int leftVal = 0;

		if (memo.containsKey(leftKey)) {
			leftVal = memo.get(leftKey);
		}

		String rightKey = String.format("%d:%d", i + 1, j + 1);
		int rightVal = 0;

		if (memo.containsKey(rightKey)) {
			rightVal = memo.get(rightKey);
		}

		int val = rightVal < leftVal ? j + 1 : j;

		printPath(pyramid, i + 1, val, memo);

	}
}
