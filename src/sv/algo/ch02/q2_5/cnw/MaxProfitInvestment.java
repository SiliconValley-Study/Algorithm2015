package sv.algo.ch02.q2_5.cnw;

import java.util.HashMap;
import java.util.Map;

/*
 * p.100
 * 2.5 최대 이익 투자
 * print와 calc_recursive를 동시에 하려하지말자. memo에서 추출해 print가 나을 수도 있음.
 */
public class MaxProfitInvestment {

	public static void main(String[] args) {

		MaxProfitInvestment investment = new MaxProfitInvestment();

		int[][] profitTable = { { 0, 0, 0 }, { 2, 3, 1 }, { 4, 5, 3 }, { 6, 6, 7 }, { 9, 8, 9 } };

		System.out.println("Table : ");

		for (int[] m : profitTable) {
			for (int k : m) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
		System.out.println();

		int result = investment.getMaxProfit(4, 3, profitTable);

		System.out.println("Max Return : " + result);

	}

	public int getMaxProfit(int investingAmount, int bankCount, int[][] profitTable) {

		Map<String, Integer> memo = new HashMap<String, Integer>();

		int result = calcMaxProfit(investingAmount, bankCount, 0, profitTable, memo);

		printMaxProfitWay(investingAmount, bankCount, 0, profitTable, "");

		return result;
	}

	private int calcMaxProfit(int amount, int bankCnt, int k, int[][] profitTable, Map<String, Integer> memo) {

		String key = String.format("%d:%d", amount, k);

		if (memo.containsKey(key)) {
			return memo.get(key);
		}

		int max = 0;

		for (int i = k; i < bankCnt; i++) {

			for (int j = 1; j <= amount; j++) {

				int val = profitTable[j][i] + calcMaxProfit(amount - j, bankCnt, k + 1, profitTable, memo);

				if (val > max) {
					max = val;
				}

			}

		}

		memo.put(key, max);

		return max;
	}

	private void printMaxProfitWay(int amount, int bankCnt, int k, int[][] profitTable, String msg) {

		if (amount == 0) {
			System.out.println(msg);
		}

		for (int i = k; i < bankCnt; i++) {

			for (int j = 1; j <= amount; j++) {

				String prefix = msg + (String.format("(bank : %d, invest : %d) => %d ", i, j, profitTable[j][i]));

				printMaxProfitWay(amount - j, bankCnt, k + 1, profitTable, prefix);
			}
		}

		System.out.println();

	}
}
