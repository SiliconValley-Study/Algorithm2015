package sv.algo.ch01.q1_5.cnw;

public class Driver {

	public static void main(String[] args) {

		int[] bills = { 1, 2, 5, 10, 20, 50 };

		int price = 100;

		PriceEvening evening = new PriceEvening(bills, price);
		// int cnt = evening.getTotalCalcCount();

		int cnt = evening.getTotalCalcCaseCount();

		System.out.println("경우의 수 : " + cnt);

	}

}
