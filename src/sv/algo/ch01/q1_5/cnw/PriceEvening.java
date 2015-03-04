package sv.algo.ch01.q1_5.cnw;

public class PriceEvening {

	private final int[] bills;

	private final int price;

	public PriceEvening(int[] bills, int price) {
		this.bills = bills;
		this.price = price;
	}

	public int getTotalCalcCount() {

		int count = calcCount(this.bills, this.price, 0, "");

		return count;
	}

	private int calcCount(int[] bills, int price, int count, String msg) {

		if (price < 0) {
			return 0;
		}

		if (price == 0) {
			System.out.println(msg);
			return 1;
		}

		for (int bill : bills) {
			count += calcCount(bills, price - bill, 0, msg + " " + bill);
		}

		return count;

	}

	public int getTotalCalcCaseCount() {

		int count = calcCaseCount(this.bills, this.price, 0, 0, "");

		return count;
	}

	private int calcCaseCount(int[] bills, int price, int count, int strtIndex,
			String msg) {

		if (price < 0) {
			return 0;
		}

		if (price == 0) {

			System.out.println(msg);

			return 1;
		}

		for (int i = strtIndex; i < bills.length; i++) {

			count += calcCaseCount(this.bills, price - this.bills[i], 0, i, msg
					+ " " + bills[i]);
		}

		return count;

	}
}
