package com.learn.ds.tree;

import java.util.Queue;
import java.util.stream.Stream;

import com.learn.ds.list.LinkedList;

public class BinarySearchTree {

	class Node {
		int data;
		Node left;
		Node right;
		Node parent;

		Node(int data, Node left, Node right, Node parent) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}

		@Override
		public boolean equals(Object obj) {
			Node n = (Node) obj;
			if (this.data != n.data)
				return false;
			if (this.left != null && n.left != null && this.left != n.left)
				return false;
			if (this.right != null && n.right != null && this.right != n.right)
				return false;
			return true;
		}

		@Override
		public int hashCode() {
			int p = 37;
			return this.data * p;
		}
	}

//	private transient static int nodeCount = 0;

	private Node newNode(int data) {
		return new Node(data, null, null, null);
	}

	Node root;

	public BinarySearchTree() {
		root = null;
	}

	public boolean add(int data) {
//		nodeCount++;
		Node node = newNode(data);

		Node y = null;
		Node x = root;

		while (x != null) {
			y = x;
			if (node.data <= x.data) {
				x = x.left;
			} else {
				x = x.right;
			}
		}

		node.parent = y;

		if (y == null) {
			root = node;
		} else if (node.data <= y.data) {
			y.left = node;
		} else {
			y.right = node;
		}

		return true;
	}

	private void inOrderTraversal(Node x) {
		if (x != null) {
			inOrderTraversal(x.left);
			System.out.print(x.data + " ");
			inOrderTraversal(x.right);
		}
	}

	public int getDiameter() {
		return getDiameter(root);
	}

	public int getSuccessor(int d) {
		Node n = binarySearch(d);
		if (n != null) {
			return getSuccessor(n).data;
		}
		return -1;
	}

	public void deleteTreeNode(int d) {
		Node z = binarySearch(d);
		if (z == null)
			return;
		Node y = null;
		if (z.left == null || z.right == null) {
			y = z;
		} else {
			y = getSuccessor(z);
		}
		Node x;
		if (y.left != null) {
			x = y.left;
		} else {
			x = y.right;
		}

		if (x != null) {
			x.parent = y.parent;
		}

		if (y.parent == null) {
			root = x;
		} else if (y.equals(y.parent.left)) {
			y.parent.left = x;
		} else {
			y.parent.right = x;
		}

		if (y != z) {
			z.data = y.data;
		}
	}

	private Node binarySearch(int d) {
		Node t = root;
		Node n = null;
		while (t != null) {
			if (d < t.data) {
				t = t.left;
			} else if (d > t.data) {
				t = t.right;
			} else {
				n = t;
				break;
			}
		}
		return n;
	}

	private Node getSuccessor(Node x) {
		if (x == null) {
			return x;
		}

		if (x.right != null) {
			return treeMinimum(x.right);
		}
		Node y = x.parent;
		while (y != null && (y.right != null && y.right.equals(x))) {
			y = y.parent;
		}

		return y;
	}

	private Node treeMinimum(Node n) {
		while (n.left != null) {
				n = n.left;
		}
		return n;
	}

	private int getDiameter(Node root) {
		Node x = root;
		if (x == null) {
			return 0;
		}

		int lh = getHeight(x.left);
		int rh = getHeight(x.right);

		int ld = getDiameter(x.left);
		int rd = getDiameter(x.right);

		return Math.max(lh + rh + 1, Math.max(ld, rd));
	}

	private int getHeight(Node node) {
		if (node == null) {
			return 0;
		}

		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}

	public void inOrderTraversal() {
		inOrderTraversal(root);
		System.out.println();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public int getHeight() {
		return getHeight(root);
	}

	public LinkedList printLevelOrder() {
		if (root == null) {
			return null;
		}
		LinkedList list = new LinkedList();
		Queue<Node> nodes = new java.util.LinkedList<Node>();

		nodes.add(root);
		while (!nodes.isEmpty()) {
			Node temp = nodes.poll();
			list.add(temp.data);
			if (temp.left != null) {
				nodes.add(temp.left);
			}
			if (temp.right != null) {
				nodes.add(temp.right);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		
		Stream.of(59, 35, 2, 15, 1, 20, 14, 6, 17, 81, 29, 13, 16, 45, 12, 56, 78).forEach(bst::add);
		
		bst.inOrderTraversal();
		
//		System.out.println(bst.getDiameter());
//		
//		System.out.println(bst.getHeight());
//		
//		LinkedList list = bst.printLevelOrder();
//		System.out.println(list.toString());
//		System.out.println(bst.getSuccessor(16));
		
		bst.deleteTreeNode(35);
		
		bst.inOrderTraversal();
		
		
	}
}
