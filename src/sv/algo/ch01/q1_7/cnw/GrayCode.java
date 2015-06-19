package sv.algo.ch01.q1_7.cnw;

import java.util.ArrayList;
import java.util.List;

/*
 * 1.7 그레이 코드
 * 
 */

public class GrayCode {

	public static void main(String[] args) {

		GrayCode gc = new GrayCode();

		int bitNum = 4;

		List<String> grayCodes = gc.makeGrayCode(bitNum);

		System.out.println(String.format("==Bit Num : %d==", bitNum));

		for (String code : grayCodes) {
			System.out.println(code);
		}

	}

	public List<String> makeGrayCode(int bit) {

		if (bit <= 1) {

			List<String> list = new ArrayList<String>();

			list.add("0");
			list.add("1");

			return list;
		}

		List<String> newCodes = makeCurGrayCode(makeGrayCode(bit - 1));

		return newCodes;
	}

	private List<String> makeCurGrayCode(List<String> codes) {

		List<String> newCodes = new ArrayList<String>();

		for (String code : codes) {
			newCodes.add("0" + code);
		}

		for (int i = codes.size() - 1; i >= 0; i--) {
			newCodes.add("1" + codes.get(i));
		}

		return newCodes;
	}

}
