package sv.algo.ch02.q2_3.cnw;

import java.util.HashMap;
import java.util.Map;

public class EnjoyCommutePath {

	public static void main(String[] args) {

		EnjoyCommutePath enjoyCommutePath = new EnjoyCommutePath();

		int[][] map = { { 1, 2, 2, 1, 5 }, { 1, 4, 4, 3, 1 },
				{ 2, 1, 1, 1, 2 }, { 1, 3, 5, 1, 1 }, { 1, 5, 1, 2, 2 }

		};

		int wayCnt = enjoyCommutePath.getEnjoyCommuteWay(map);

		System.out.println("가지 수 : " + wayCnt);

	}

	public int getEnjoyCommuteWay(int[][] map) {

		Map<String, Integer> memo = new HashMap<String, Integer>();

		int xSum = 0, ySum = 0;

		for (int i = 0; i < map.length; i++) {

			xSum += map[0][i];

			String key = String.format("%d:%d", 0, i);

			memo.put(key, xSum);

		}

		for (int i = 0; i < map[0].length; i++) {
			ySum += map[i][0];

			String key = String.format("%d:%d", i, 0);

			memo.put(key, ySum);
		}

		int result = getEnjoyCommuteWay(map, map.length - 1, map[0].length - 1,
				memo);

		printPath(map, memo);

		return result;
	}

	private int getEnjoyCommuteWay(int[][] map, int i, int j,
			Map<String, Integer> memo) {

		String key = String.format("%d:%d", i, j);

		if (memo.containsKey(key)) {
			return memo.get(key);
		}

		int val = 0;

		int upVal = getEnjoyCommuteWay(map, i - 1, j, memo);
		int sideVal = getEnjoyCommuteWay(map, i, j - 1, memo);

		val = upVal > sideVal ? upVal + map[i][j] : sideVal + map[i][j];

		memo.put(key, val);

		return val;
	}

	public void printPath(int[][] map, Map<String, Integer> memo) {

		printPath(map, map.length - 1, map[0].length - 1, memo);

	}

	private void printPath(int[][] map, int i, int j, Map<String, Integer> memo) {

		if (i == 0 && j == 0) {
			return;
		}

		System.out.println(String.format("(%d:%d)", i, j));

		String upKey = String.format("%d:%d", i - 1, j);

		String leftKey = String.format("%d:%d", i, j - 1);

		int upVal = 0;

		if (memo.containsKey(upKey)) {
			upVal = memo.get(upKey);
		}

		int leftVal = 0;

		if (memo.containsKey(leftKey)) {
			leftVal = memo.get(leftKey);
		}

		if (upVal > leftVal) {
			printPath(map, i - 1, j, memo);
		} else {
			printPath(map, i, j - 1, memo);
		}

	}
}
