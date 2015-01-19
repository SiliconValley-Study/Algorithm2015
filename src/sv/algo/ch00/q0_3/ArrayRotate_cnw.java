package sv.algo.ch00.q0_3;

public class ArrayRotate_cnw {
	
	public static void main(String[] args) {
		
		
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		
		rotateArray(arr, 6, 2);
		
		for(int k : arr){
			System.out.print(k  + " ");
		}
		
		System.out.println();
		
		int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8};
		
		rotateArray(arr2, 1, 4);
		
		for(int k : arr2){
			System.out.print(k  + " ");
		}
		
	}
	
	public static void rotateArray(int[] arr, int fromIndex, int toIndex){
		
		if(arr == null || fromIndex == toIndex){
			return;
		}
		
		int original = arr[fromIndex];
		
		if(fromIndex > toIndex){
			
			for(int i = fromIndex, len = toIndex; i > len; i--){
				
				arr[i] = arr[i - 1];
				
			}
			
		}else{
			
			for(int i = fromIndex, len = toIndex; i < len; i++){
				
				arr[i] = arr[i + 1];
			
			}
			
		}
		
		arr[toIndex] = original;
		
	}

}
