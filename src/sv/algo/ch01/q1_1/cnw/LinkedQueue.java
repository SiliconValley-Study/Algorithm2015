package sv.algo.ch01.q1_1.cnw;

/*
 * 연결리스트 큐 작성하기
 * 
 * printNode() 메서드 추가
 * 
 */

interface Queue {

	void enqueue(int val);

	int dequeue() throws Exception;

	boolean isEmpty();

}

public class LinkedQueue implements Queue {

	private Node head;

	@Override
	public void enqueue(int val) {

		if (this.head == null) {
			this.head = new Node(val);
		} else {
			this.head.append(val);
		}

	}

	@Override
	public int dequeue() throws Exception {

		if (isEmpty()) {
			throw new Exception("뽑을 것이 없단다.");
		}

		Node node = this.head;

		this.head = node.next;

		return node.data;
	}

	@Override
	public boolean isEmpty() {
		return this.head == null;
	}

	@Override
	public String toString() {
		return "[" + printReverseOrderNode(this.head, "") + "]";
	}

	private String printNode(Node node, String result) {

		if (node != null) {

			result += node.data + ",";

			return printNode(node.next, result);
		} else {
			return result + "]";
		}

	}

	private String printReverseOrderNode(Node node, String result) {

		if (node != null) {

			return printReverseOrderNode(node.next, result) + "," + node.data;
		} else {
			return "";
		}

	}

	private static class Node {

		int data;

		Node next;

		public Node(int data) {
			this.data = data;
		}

		public void append(int data) {

			Node node = new Node(data);

			Node tmp = this;

			while (tmp.next != null) {
				tmp = tmp.next;
			}

			tmp.next = node;
		}

	}

}
