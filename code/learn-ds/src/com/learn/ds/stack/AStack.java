package com.learn.ds.stack;

public class AStack {

	class Node {
		Node next;
		Integer data;

		public Node(int data) {
			this.data = data;
		}
	}

	Node top;

	public AStack() {
		top = null;
	}

	public void push(int k) {
		Node n = new Node(k);
		if (top == null) {
			top = n;
		} else {
			n.next = top;
			top = n;
		}
	}

	public Integer pop() {
		if (top != null) {
			int item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}

	public Integer peek() {
		if (top != null) {
			return top.data;
		}
		return null;
	}

}
