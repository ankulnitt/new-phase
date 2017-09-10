package com.learn.ds.list;

import java.util.stream.Stream;

public class LinkedList {

	class Node {
		int data;
		Node next;

		Node(int d) {
			this.data = d;
		}
	}

	Node head;
	Node last;

	public void add(int d) {
		Node tmp = new Node(d);
		tmp.next = null;
		if (head == null) {
			head = tmp;
			last = tmp;
		}

		last.next = tmp;
		last = tmp;
	}

	private int getMiddle(Node head) {
		if (head == null) {
			return 0;
		}

		Node tmp = head;
		Node tmp2 = head;

		while (tmp2.next != null && (tmp2.next != null && tmp2.next.next != null)) {
			tmp = tmp.next;
			tmp2 = tmp2.next.next;
		}

		return tmp.data;
	}

	public int getMiddle() {
		return getMiddle(head);
	}

	public LinkedList() {
		this.head = null;
		this.last = null;
	}

	public void rotateList(int k) {
		Node current = head;
		Node temp = head;
		int i = 1;
		while (i < k) {
			temp = temp.next;
			i++;
		}

		head = temp.next;
		//making last.next null, so that it should not create circle.
		temp.next = null;
		//making this temp as last
		last = temp;

		temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = current;
	}

	public void reversListInGroup(int k) {
		Node current = reversListInGroup(head, k);
		head = current;
	}

	private Node reversListInGroup(Node node, int k) {
		Node p = null;
		Node c = node;
		Node n = null;
		int i = k;
		while (c!= null && i > 0) {
			i--;
			n = c.next;
			c.next = p;
			p = c;
			c = n;
		}
		if (n != null) {
			node.next = reversListInGroup(n, k);
		}
		return p;
	}
	
	Node reverse(Node head, int k)
    {
       Node current = head;
       Node next = null;
       Node prev = null;
        
       int count = 0;
 
       /* Reverse first k nodes of linked list */
       while (count < k && current != null) 
       {
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
           count++;
       }
 
       /* next is now a pointer to (k+1)th node 
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
       if (next != null) 
          head.next = reverse(next, k);
 
       // prev is now head of input list
       return prev;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Node current = head;
		while (current != null) {
			builder.append(current.data).append(", ");
			current = current.next;
		}
		return builder.toString();
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Stream.of(1, 2, 4, 6, 7, 8, 9, 12, 13, 16, 45, 12, 56, 78).forEach(list::add);
//		System.out.println(list.getMiddle());
		System.out.println("before rotation " + list.toString());
		
		list.rotateList(4);
		
		System.out.println("after rotation " + list.toString());
		
		list.reversListInGroup(3);
		
		System.out.println(list.toString());
	}
}
