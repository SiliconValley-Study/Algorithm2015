package sv.algo.ch00.q0_g.cnw;

public class DecimalTurnToBinaryNumber {
	
	public static void main(String[] args) {
		
		String result = getBinaryNum(10);
		
		System.out.println(result);
		
	}
	
	public static String getBinaryNum(int val){
		
		String result = "";

		if(val < 0){
			return result;
		}
		
		while(val > 0){
			
			int rest = val%2;
			int share = val/2;
			
			result = rest + result;
			
			val = share;
		}
		
		return result;
		
	}

}
