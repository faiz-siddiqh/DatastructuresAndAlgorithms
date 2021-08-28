package datastructures.linkedlist;

/**
 * Given a singly linked list, remove all the nodes which have a greater value
 * on its following nodes.
 */

public class DeleteLargerNumberToRight {

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

	Node compute(Node head) {
		head = reverse(head);

		Node maxNode = head;
		Node cur = head;
		Node temp;

		while (cur != null && cur.next != null) {

			if (cur.next.data < maxNode.data) {
				temp = cur.next;
				cur.next = temp.next;
				temp = null;
			} else {
				cur = cur.next;
				maxNode = cur;

			}

		}
		return reverse(head);

	}

	public static Node reverse(Node lead) {

		Node cur = lead;
		Node next = null;
		Node prev = null;

		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		lead = prev;
		return lead;
	}

	public static void main(String[] args) {
		DeleteLargerNumberToRight dl = new DeleteLargerNumberToRight();
		dl.push(50);
		dl.push(40);
		dl.push(30);
		dl.push(20);
		dl.push(10);

		dl.print(dl.compute(dl.head));

	}

}
