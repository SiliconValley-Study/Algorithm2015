package sv.algo.ch01.q1_c.cnw;

/*
 * p.74
 * 
 * n과 m을 입력받아서 m개의 자연수를 더해서 n을 만드는 모든 방법을 출력하는 프로그램을 작성하라
 * 
 */
public class Q1_c {

	public static void main(String[] args) {

		Q1_c c = new Q1_c();

		c.printWay(5, 3);

	}

	public void printWay(int n, int m) {

		String msg = "";

		System.out.println(String.format("n, m : %d %d", n, m));

		makeWay(n, m, msg);

	}

	private void makeWay(int n, int m, String msg) {

		if (n == 0 && m == 0) {
			System.out.println(msg);
			return;
		}

		for (int i = 1; i <= n; i++) {

			String prefix = String.format("%s %d", msg, i);

			makeWay(n - i, m - 1, prefix);
		}

	}

}
