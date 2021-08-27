package datastructures.linkedlist;

/**
 * Write a Program to Add 2 numbers represented by Linked List.
 * 
 */
public class AddTwoNumbersLinkedList {
	Node head;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	void push(int data) {
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
	}

	void print(Node node) {
		Node temp = node;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		AddTwoNumbersLinkedList ll1 = new AddTwoNumbersLinkedList();
		AddTwoNumbersLinkedList ll2 = new AddTwoNumbersLinkedList();
		ll1.push(9);
		ll1.push(9);
		ll1.push(9);
		ll2.push(1);
		ll2.push(6);
		ll1.print(addTwoLists(ll1.head, ll2.head));

	}

	static Node addTwoLists(Node first, Node second) {

		if (first == null)
			return second;
		if (second == null)
			return first;
		Node node = null;
		Node head = null;
		first = reverse(first);
		second = reverse(second);
		int carry = 0;

		while (first != null || second != null) {
			int sum = 0;
			if (first != null) {
				sum += first.data;
				first = first.next;
			}
			if (second != null) {
				sum += second.data;
				second = second.next;
			}

			sum += carry;
			carry = (sum > 9) ? 1 : 0;
			sum = sum % 10;

			Node newNode = new Node(sum);
			if (node != null) {
				node.next = newNode;
				node = node.next;
			} else {
				node = head = newNode;
			}
		}

		if (carry > 0) {
			node.next = new Node(carry);
		}

		return reverse(head);

	}

	/**
	 * Reverse the LinkedList
	 * 
	 * @param node
	 * @return
	 */
	private static Node reverse(Node node) {
		Node current = node;
		Node prev = null;
		Node next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;

		return node;

	}

}
