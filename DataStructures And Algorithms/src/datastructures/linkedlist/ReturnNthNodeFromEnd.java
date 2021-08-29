package datastructures.linkedlist;

/**
 * Given a linked list consisting of L nodes and given a number N. The task is
 * to find the Nth node from the end of the linked list.
 * 
 */
public class ReturnNthNodeFromEnd {

	Node head;
	static int j = 0;

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

	int getNthFromLast(Node head, int n) {

		// if the LL has only one node and if n==1 return head
		if (head.next == null && n == 1) {
			return head.data;
		}
		// if the LL has one node and n>1 or if head is null then return -1
		if (head.next == null && n > 1 || head == null) {
			return -1;
		}

		int length = 1; // to track the length of LL
		Node curNode = head;
		Node nextNode = null;
		Node prev = null;

		// reverse the LL
		while (curNode != null) {
			nextNode = curNode.next;
			curNode.next = prev;
			prev = curNode;
			curNode = nextNode;
			length++;

		}

		// if n > length then return -1
		if (n > length)
			return -1;

		// traverse from the back of the LL and return the nTh node
		int count = 1;
		while (count <= length) {
			if (count == n) {
				return prev.data;
			} else {
				count++;
				prev = prev.next;
			}
		}

		return -1;
	}

	// Recursive Soln
	static void printNthFromLast(Node head, int n) {

		if (head == null)
			return;
		printNthFromLast(head.next, n);

		if (++j == n)
			System.out.print(head.data);
	}

	static void printList(Node node) {
		while (node != null) {
			System.out.print(" " + node.data);
			node = node.next;
		}
	}

	public static void main(String[] args) {
		ReturnNthNodeFromEnd ll = new ReturnNthNodeFromEnd();
//		ll.push(7);
//		ll.push(6);
		ll.push(5);
		ll.push(4);
		ll.push(3);
		ll.push(2);
		ll.push(1);

		System.out.println((ll.getNthFromLast(ll.head, 2)));

	}

}
