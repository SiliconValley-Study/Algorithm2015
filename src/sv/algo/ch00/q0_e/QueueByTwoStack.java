package sv.algo.ch00.q0_e;

import java.util.Stack;

public class QueueByTwoStack implements Queue {

	public Stack<Integer> inStack;

	public Stack<Integer> outStack;

	public QueueByTwoStack() {
		this.inStack = new Stack<>();
		this.outStack = new Stack<>();
	}

	@Override
	public void enqueue(int value) {
		this.inStack.push(value);
	}

	@Override
	public int dequeue() throws Exception {

		if (this.inStack.isEmpty()) {
			throw new Exception("Queue is Empty.");
		}

		if (this.outStack.isEmpty()) {

			while (!this.inStack.isEmpty()) {

				this.outStack.push(this.inStack.pop());

			}

		}

		return this.outStack.pop();
	}

	@Override
	public String toString() {
		return "QueueByTwoStack [inStack=" + inStack + ", outStack=" + outStack
				+ "]";
	}

}
