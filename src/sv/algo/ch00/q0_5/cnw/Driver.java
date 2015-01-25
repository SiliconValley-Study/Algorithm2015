package sv.algo.ch00.q0_5.cnw;

import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args)  {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("========Queue by Linked List========");
		
		LinkedQueue queue = new LinkedQueue();
		
		String input = "";
		
		while(!input.equalsIgnoreCase("q")){
			
			System.out.println("[e : enqueue, d : dequeue, q : Exit]");
			input = scanner.next();
			
			
			switch (input) {
			case "e":
				System.out.print("input nuber : ");
				int num = Integer.parseInt(scanner.next());
				
				queue.enqueue(num);
				System.out.println();
				System.out.println(queue);
				break;

			case "d":
				
				int output = 0;
				
				try{
					
					output = queue.dequeue();
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("[Dequeued Number : " + output + " ]");
				System.out.println();
				System.out.println(queue);
				break;
			case "q":
				
			default:
				System.out.println("시스템 종료");
				break;
			}
			
		}
		
	}

}