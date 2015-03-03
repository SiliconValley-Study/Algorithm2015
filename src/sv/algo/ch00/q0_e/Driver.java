package sv.algo.ch00.q0_e;

public class Driver {

	public static void main(String[] args) throws Exception {

		Queue queue = new QueueByTwoStack();

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);

		System.out.println("Before : ");
		System.out.println(queue);

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

		System.out.println("After : ");
		System.out.println(queue);

	}

}
