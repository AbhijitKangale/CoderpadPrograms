package com.sapient.coderpad;

public class ReverseLinkedList {

	private static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	private static class LinkedList {

		static Node root;

		Node reverse(Node root) {
			Node prev = null;
			Node current = root;
			Node next = null;
			while (current != null) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			root = prev;
			return root;
		}

		// prints content of double linked list
		void printList(Node node) {
			while (node != null) {
				System.out.print(node.data + " ");
				node = node.next;
			}
		}
	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.root = new Node(85);
		list.root.next = new Node(15);
		list.root.next.next = new Node(4);
		list.root.next.next.next = new Node(20);

		System.out.println("Given Linked list");
		list.printList(list.root);
		list.root = list.reverse(list.root);
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList(list.root);

		boolean pass = true;

		pass = pass && list.reverse(list.root).data == 85;

		if (pass)
			System.out.println("\nAll test cases are passed");
		else
			System.out.println("\nAt least one test case failed");
	}
}
