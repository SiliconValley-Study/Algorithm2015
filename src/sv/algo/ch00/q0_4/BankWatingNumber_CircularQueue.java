package sv.algo.ch00.q0_4;

public class BankWatingNumber_CircularQueue {
	
	public static void main(String[] args) throws Exception {

		CircularQueue circularQueue = new CircularQueue();

		System.out.println("Init : " + circularQueue);
		
		for(int i = 0; i < 5; i++){
			circularQueue.enqueue(i);
		}
		
		System.out.println("Item Insert : " + circularQueue);
		
		for(int i = 0; i < 5; i++){
			int val = circularQueue.dequeue();
			
			System.out.println(val);
		}
		
		System.out.println("Item Dequeue : " + circularQueue);
		
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
