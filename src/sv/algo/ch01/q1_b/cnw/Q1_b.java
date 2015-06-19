package sv.algo.ch01.q1_b.cnw;

import java.util.HashMap;
import java.util.Map;

/*
 * 파스칼의 삼각형
 */

public class Q1_b {

	public static void main(String[] args) {

		Q1_b b = new Q1_b();

		b.printPascal(6);

	}

	public void printPascal(int lineNumber) {

		Map<String, Integer> map = new HashMap<String, Integer>();

		printPascal(lineNumber, map);

	}

	private void printPascal(int lineNumber, Map<String, Integer> map) {

		if (lineNumber < 1) {
			return;
		}

		printPascal(lineNumber - 1, map);

		for (int i = 1; i <= lineNumber; i++) {
			System.out.print(getPascalVal(lineNumber, i, map) + "\t");
		}

		System.out.println();
	}

	private int getPascalVal(int line, int order, Map<String, Integer> map) {

		String key = String.format("%d:%d", line, order);

		if (map.containsKey(key)) {
			return map.get(key);
		}

		if (line == 1 || order == 1 || line == order) {
			return 1;
		}

		int result = getPascalVal(line - 1, order - 1, map)
				+ getPascalVal(line - 1, order, map);

		map.put(String.format("%d:%d", line, order), result);

		return result;

	}
}
