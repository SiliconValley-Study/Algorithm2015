package sv.algo.ch02.q2_1.cnw;

import java.util.HashMap;
import java.util.Map;
/*

p.87
memoization 2차원 배열 대신 Map 자료구조 적용.

*/
public class CountCommuteWay {

	public static void main(String[] args) {

		CountCommuteWay commuteWay = new CountCommuteWay();

		int[][] map = {
			{ 1, 1, 1, 1, 0 },
			{ 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1 },
			{ 1, 0, 1, 1, 1 },
			{ 1, 1, 1, 1, 1 }
		};

		int count = commuteWay.getCommuteWayCount(map);

		System.out.println(String.format("가는 방법 수 : %d 가지", count));

	}

	public int getCommuteWayCount(int[][] map) {
		return getCommuteWayCount(map, map.length - 1, map[0].length - 1, new HashMap<String, Integer>());
	}

	private int getCommuteWayCount(int[][] map, int i, int k, Map<String, Integer> memo) {

		String key = String.format("%d:%d", i, k);

		if (memo.containsKey(key)) {
			return memo.get(key);
		}

		if (i < 1 || k < 1) {
			return map[i][k];
		}

		int cnt = 0;

		if (map[i][k] == 1) {

			cnt = getCommuteWayCount(map, i - 1, k, memo)
					+ getCommuteWayCount(map, i, k - 1, memo);

		}

		memo.put(key, cnt);

		return cnt;
	}
}
