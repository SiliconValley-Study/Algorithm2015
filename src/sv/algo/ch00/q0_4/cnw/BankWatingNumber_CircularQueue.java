package sv.algo.ch00.q0_4.cnw;

import java.util.Scanner;

public class BankWatingNumber_CircularQueue {
	
	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		
		boolean isRunning = true;
		
		CircularQueue queue = new CircularQueue();
		
		while(isRunning){
			
			System.out.print("[1.Enqueue, 2.DeQueue, 3.Exit] input : ");
			String input = scanner.next();
			
			switch (input) {
			case "1":
				
				System.out.print("숫자만 입력하세요. : ");
				int num = Integer.parseInt(scanner.next());
				queue.enqueue(num);
				System.out.println(queue);
				System.out.println();
				break;
				
			case "2":
				
				int val = queue.dequeue();
				System.out.println("dequeue num : " + val);
				System.out.println(queue);
				System.out.println();
				
				break;
			case "3":
				isRunning = false;
				
				break;

			default:
				
				System.out.println("다시 입력해주셈");
				continue;
			}
			
		}
		
		System.out.println(queue);
		
		
	}

}


class CircularQueue{
	
	private int[] array;
	
	private int head;
	
	private int tail;
	
	private int capacity;
	
	public CircularQueue(int capacity){
		
		this.array = new int[capacity];
		
		this.capacity = capacity;
		
	}
	
	public CircularQueue(){
		this(10);
	}
	
	public boolean isEmpty(){
		return head == tail;
	}
	
	public boolean isFull(){
		return (this.tail + 1)%this.capacity == this.head%this.capacity;
	}
	
	public void enqueue(int value){
		
		if(isFull()){
			
			System.out.println("꽉 찼따!!!");
			
			return ;
		}
		
		this.tail = this.tail%this.capacity;
		
		this.array[this.tail++] = value;
	}
	
	public int dequeue() throws Exception{
		
		if(isEmpty()){
			throw new Exception("뽑을 것이 없다");
		}
		
		this.head = this.head%this.capacity;
		
		return this.array[this.head++];
	}
	
	public int getSize(){
		return this.tail >= this.head ? this.tail - this.head : this.tail + (this.capacity - this.head);
	}
	
	public String toString(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append('[');
		
		int i = 0;
		
		while(i < this.getSize()){
			
			int idx = (this.head + i)%this.capacity;
			
			sb.append(this.array[idx]).append(',');
			
			i++;
			
		}
		
		sb.append(']');
		
		return sb.toString();
	}
	
}
