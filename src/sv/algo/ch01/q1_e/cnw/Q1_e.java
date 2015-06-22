package sv.algo.ch01.q1_e.cnw;

/*
 * p.75
 * n명 중에 몇 번쨰 사람이 살아남는가? (조세푸스 수열)
 */
public class Q1_e {

	public static void main(String[] args) {

		Q1_e e = new Q1_e();

		int result = e.getAlivePeaple(5);

		System.out.println(result + "번쨰 사람이 살아남는다.");

	}

	public int getAlivePeaple(int peapleNumber) {

		int[] peaple = new int[peapleNumber];

		for (int i = 0; i < peapleNumber; i++) {
			peaple[i] = i + 1;
		}

		return getLiveIndex(0, true, peapleNumber, peaple);

	}

	private int getLiveIndex(int i, boolean isAlive, int aliveCnt, int[] peaple) {

		int idx = i % peaple.length;

		if (peaple[idx] == -1) {
			return getLiveIndex(idx + 1, isAlive, aliveCnt, peaple);
		}

		// -1은 죽음을 의미
		if (!isAlive) {
			peaple[idx] = -1;
			aliveCnt--;

			if (aliveCnt == 0) {
				return idx + 1;
			}
		}

		printPeaple(peaple);

		return getLiveIndex(idx + 1, !isAlive, aliveCnt, peaple);

	}

	private void printPeaple(int[] peaple) {
		for (int k : peaple) {
			System.out.print(k + " ");
		}
		System.out.println();
	}
}
