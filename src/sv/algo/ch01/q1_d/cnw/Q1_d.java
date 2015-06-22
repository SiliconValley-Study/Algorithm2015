package sv.algo.ch01.q1_d.cnw;

/* 
 * p.74
 * 1.d ) 순열의 수의 쌍에서 역전된것 찾기
 */

public class Q1_d {

	public static void main(String[] args) {

		Q1_d d = new Q1_d();

		int[] nums = { 1, 3, 5, 4, 2 };

		int cnt = d.getReverseCnt(nums);

		System.out.println(cnt);

		System.out.println("======================");

		cnt = d.getReversCntRecusive(nums);

		System.out.println(cnt);

	}

	public int getReverseCnt(int[] p) {

		int cnt = 0;

		for (int i = 0; i < p.length; i++) {

			for (int j = i + 1; j < p.length; j++) {

				if (p[i] > p[j]) {
					cnt++;
					System.out.println(String.format("(%d, %d)", p[i], p[j]));
				}
			}
		}

		return cnt;
	}

	public int getReversCntRecusive(int[] p) {

		int cnt = 0;

		for (int i = 0; i < p.length; i++) {
			cnt += getReversCntRecusive(i, i + 1, p);
		}

		return cnt;
	}

	private int getReversCntRecusive(int i, int j, int[] p) {

		if (i >= p.length || j >= p.length) {
			return 0;
		}

		if (p[i] > p[j]) {

			System.out.println(String.format("(%d, %d)", p[i], p[j]));

			return getReversCntRecusive(i, j + 1, p) + 1;
		}

		return getReversCntRecusive(i, j + 1, p);

	}
}
