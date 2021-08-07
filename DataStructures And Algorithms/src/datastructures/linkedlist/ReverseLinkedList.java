package datastructures.linkedlist;

/**
 * Write a Program to reverse the Linked List. (Both Iterative and recursive)
 *  
 */
public class ReverseLinkedList {

	static Node head;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	static void push(int data) {
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
	}

	static void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		push(2);
		push(22);
		push(23);
		push(24);
		push(25);

		print();
		System.out.println("-----------------------------");

//		head = reverse(head);
//		print();

		System.out.println("-----------------------------");
		head = reverseWithRecursion(head, null);
		print();

	}

	/**
	 * This is a traditional method without recursion
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

	/**
	 * Implementation using recursion
	 * 
	 * @param node
	 * @return
	 */
	private static Node reverseWithRecursion(Node node, Node prev) {

		if (head == null)
			return head;

		if (node.next == null) {
			head = node;
			node.next = prev;
			return head;
		}

		Node next = node.next;
		node.next = prev;

		reverseWithRecursion(next, node);

		return head;

	}

}
