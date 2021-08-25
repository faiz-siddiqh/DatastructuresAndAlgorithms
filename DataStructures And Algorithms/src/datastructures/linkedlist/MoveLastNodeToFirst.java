package datastructures.linkedlist;

import java.util.HashSet;

/**
 * Write a function that moves the last element to the front in a given Singly
 * Linked List. For example, if the given Linked List is 1->2->3->4->5, then the
 * function should change the list to 5->1->2->3->4.
 * 
 */
public class MoveLastNodeToFirst {

	Node head;

	class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int new_data) {
		Node new_node = new Node(new_data);

		new_node.next = head;

		head = new_node;
	}

	public Node moveToFront(Node head) {

		if (head == null || head.next == null)
			return head;
		Node curNode = head;
		Node nextNode = head.next;

		while (nextNode.next != null) {
			curNode = nextNode;
			nextNode = nextNode.next;
		}
		curNode.next = null;
		nextNode.next = head;
		return nextNode;

	}

	static void printList(Node node) {
		while (node != null) {
			System.out.print(" " + node.data);
			node = node.next;
		}
	}

	public static void main(String[] args) {
		MoveLastNodeToFirst ll = new MoveLastNodeToFirst();
		ll.push(5);
		ll.push(4);
		ll.push(3);
		ll.push(2);
		ll.push(1);

		printList(ll.moveToFront(ll.head));

	}

}
