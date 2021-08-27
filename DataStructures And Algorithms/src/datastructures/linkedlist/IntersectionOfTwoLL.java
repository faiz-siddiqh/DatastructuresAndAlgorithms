package datastructures.linkedlist;

/**
 * Write a Program to return a LinkedList with intersection of 2 Linked Lists.
 * 
 */
public class IntersectionOfTwoLL {
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
		IntersectionOfTwoLL ll1 = new IntersectionOfTwoLL();
		IntersectionOfTwoLL ll2 = new IntersectionOfTwoLL();
		ll1.push(7);
		ll1.push(8);
		ll1.push(9);
		ll2.push(8);
		ll2.push(9);
		ll1.print(findIntersection(ll1.head, ll2.head));

	}

	public static Node findIntersection(Node head1, Node head2) {

		Node node = null;
		Node head = null;

		while (head1 != null && head2 != null) {

			if (head1.data == head2.data) {
				Node newNode = new Node(head1.data);
				if (node != null) {
					node.next = newNode;
					node = node.next;
				} else {
					node = head = newNode;
				}
				head1 = head1.next;
				head2 = head2.next;
			} else if (head1.data > head2.data) {
				head2 = head2.next;
			} else {
				head1 = head1.next;
			}

		}
		return head;
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
