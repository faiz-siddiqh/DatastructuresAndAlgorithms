package datastructures.linkedlist;

import java.util.HashSet;

/**
 * Given an unsorted linked list of N nodes. The task is to remove duplicate
 * elements from this unsorted Linked List. When a value appears in multiple
 * nodes, the node which appeared first should be kept, all others duplicates
 * are to be removed.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class RemoveDuplicatesInUnSortedLinkedList {

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

	/*
	 * Function to remove duplicates from unsorted linked list.
	 */
	public Node removeDuplicates(Node head) {
		HashSet<Integer> hs = new HashSet<>();
		hs.add(head.data);
		Node curNode = head;
		Node nextNode = head.next;

		while (nextNode != null) {
			if (hs.contains(nextNode.data)) {
				Node n = nextNode.next;
				curNode.next = n;
				nextNode.next = null;
				nextNode = n;
			} else {
				hs.add(nextNode.data);
				curNode = nextNode;
				nextNode = nextNode.next;
			}

		}

		return head;

	}

	static void printList(Node node) {
		while (node != null) {
			System.out.print(" " + node.data);
			node = node.next;
		}
	}

	public static void main(String[] args) {
		RemoveDuplicatesInUnSortedLinkedList ll = new RemoveDuplicatesInUnSortedLinkedList();
		ll.push(20);
		ll.push(14);
		ll.push(13);
		ll.push(12);
		ll.push(14);
		ll.push(21);

		ll.removeDuplicates(ll.head);
		printList(ll.head);

	}

}
