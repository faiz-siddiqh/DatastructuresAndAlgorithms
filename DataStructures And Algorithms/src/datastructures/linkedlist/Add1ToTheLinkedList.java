package datastructures.linkedlist;

/**
 * Write a Program to Add 1 to the number represented in Linked List.
 * 
 */
public class Add1ToTheLinkedList {
	Node head;

	class Node {

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
		Add1ToTheLinkedList ll = new Add1ToTheLinkedList();
		ll.push(9);
		ll.push(4);
//		ll.push(9);

		ll.print(ll.head);
		System.out.println("-----------------------------");

		ll.print(ll.addOne(ll.head));

	}

	public Node addOne(Node head) {
		Node rev = reverse(head);
		Node node = rev;
		Node temp = null;
		int car = 1; // carry
		int sum = 0;
		while (rev != null) {
			sum = rev.data + car;
			car = (sum > 9) ? 1 : 0;
			sum = sum % 10;
			rev.data = sum;
			temp = rev;
			rev = rev.next;
		}

		// 999 the result is 1000 ,hence a new node must be created if carry is 1
		if (car > 0)
			temp.next = new Node(car);

		return reverse(node);
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
