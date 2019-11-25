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
		acc.add(node.value);
		inOrderTraversal(node.right, acc);
	}

	public Node search(int value) {
		return searchValue(root, value);
	}

	private Node searchValue(Node root, int value) {
		if (root == null || root.value == value)
			return root;

		if (value < root.value)
			return searchValue(root.left, value);

		return searchValue(root.right, value);
	}

	public void delete(int value) {
		root = deleteValue(root, value);
	}

	private Node deleteValue(Node root, int value) {
		// This is the base case. If the tree is empty
		if (root == null)
			return root;

		// Recur down the tree
		if (value < root.value)
			return deleteValue(root.left, value);
		else if (value > root.value)
			return deleteValue(root.right, value);
		// Handle if node has one, two or no child's
		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// This is the case of node with two children's. Get inorder
			// successor to
			// replace node to be deleted.
			root.value = minimumValue(root.right);

			// Delete corresponding node
			return deleteValue(root.right, root.value);
		}
	}

	private int minimumValue(Node root) {
		int minValue = root.value;
		while (root.right != null) {
			minValue = root.right.value;
			root = root.right;
		}

		return minValue;
	}

	public boolean contains(int value) {
		return containsValue(root, value);
	}

	private boolean containsValue(Node root, int value) {
		if (root == null)
			return false;
		if (root.value == value)
			return true;

		if (value < root.value)
			return containsValue(root.left, value);

		return containsValue(root.right, value);
	}

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.put(3);
		bst.put(1);
		bst.put(2);
		bst.put(5);

		boolean pass = true;

		pass = pass && Arrays.asList(1, 2, 3, 5).equals(bst.inOrderTraversal());
		pass = pass && bst.search(5).value == 5;
		pass = pass && bst.contains(1);

		if (pass)
			System.out.println("All test cases are passed");
		else
			System.out.println("At least one test case failed");
	}
}
