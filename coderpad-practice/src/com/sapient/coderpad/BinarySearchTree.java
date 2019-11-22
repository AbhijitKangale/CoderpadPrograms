package com.sapient.coderpad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTree {

	class Node {
		int value;
		Node left, right;

		public Node(int value) {
			this.value = value;
			right = left = null;
		}
	}

	Node root;

	public BinarySearchTree() {
		root = null;
	}

	public void put(int value) {
		root = insertValue(root, value);
	}

	public Node insertValue(Node root, int value) {
		if (root == null) {
			root = new Node(value);
			return root;
		}

		if (value < root.value)
			root.left = insertValue(root.left, value);
		else if (value > root.value)
			root.right = insertValue(root.right, value);

		return root;
	}

	public List<Integer> inOrderTraversal() {
		final ArrayList<Integer> acc = new ArrayList<>();
		inOrderTraversal(root, acc);
		return acc;
	}

	private void inOrderTraversal(Node node, List<Integer> acc) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left, acc);
		inOrderTraversal(node.right, acc);
		acc.add(node.value);
	}

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.put(3);
		bst.put(1);
		bst.put(2);
		bst.put(5);

		boolean pass = true;

		pass = pass && Arrays.asList(1, 2, 3, 5).equals(bst.inOrderTraversal());

		if (pass)
			System.out.println("All test cases are passed");
		else
			System.out.println("At least one test case failed");
	}
}
