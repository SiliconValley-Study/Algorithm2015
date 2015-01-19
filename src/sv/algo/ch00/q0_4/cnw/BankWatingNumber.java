package sv.algo.ch00.q0_4.cnw;

public class BankWatingNumber {
	
	public static void main(String[] args) throws Exception {
		
		Queue queue = new Queue();
		
		for(int i = 0; i <= 40; i= i + 10){
			queue.enqueue(i);
		}
		
		System.out.println(queue);
		
		System.out.println();
		
		for(int i = 0; i < 10; i++){
			
			int val = queue.dequeue();
			
			System.out.println(val);
			
		}
		
	}

}

class Queue{
	
	private int[] array;
	
	private int head;
	
	private int tail;
	
	private int size;
	
	public Queue(int size){
		
		this.array = new int[size];
		
		this.size = size;
		
		this.head = 0;
		
		this.tail = 0;
		
	}
	
	public Queue(){
		this(10);
	}
	
	public boolean isEmpty(){
		return head == tail;
	}
	
	public boolean isFull(){
		return this.tail == this.size;
	}
	
	public void enqueue(int value){
		
		if(isFull()){
			
			System.out.println("꽉 찼따!!!");
			
			return ;
		}
		
		this.array[this.tail++] = value;
		
	}
	
	public int dequeue() throws Exception{
		
		if(isEmpty()){
			throw new Exception("뽑을 것이 없다");
		}
		
		return this.array[this.head++];
	}
	
	public String toString(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append('[');
		
		for(int i = this.head, len = this.tail; i < len; i++){
			
			sb.append(this.array[i]).append(',');
		}
		
		sb.append(']');
		
		return sb.toString();
	}
	
}
