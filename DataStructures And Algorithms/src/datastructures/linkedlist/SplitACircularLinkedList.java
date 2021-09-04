package datastructures.linkedlist;

/**
 * Given a Cirular Linked List of size N, split it into two halves circular
 * lists. If there are odd number of nodes in the given circular linked list
 * then out of the resulting two halved lists, first list should have one node
 * more than the second list. The resultant lists should also be circular lists
 * and not linear lists.
 * 
 */
class Node {
	Node next;
	int data;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

}

public class SplitACircularLinkedList {

	Node head, head1, head2;

	Node last = null;

	/**
	 * Add the node to the last
	 * 
	 * @param node
	 */
	public void addToTheLast(Node node) {
		if (head == null)
			head = node;
		else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = node;
		}

	}

	/**
	 * Make the LL circular
	 */
	void circular() {
		last = head;
		while (last.next != null)
			last = last.next;
		last.next = head;
	}

	/**
	 * Print all the Nodes in a LL
	 * 
	 * @param start
	 */
	public void printList(Node start) {
		Node temp = start;
		if (start != null) {
			do {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}

			while (temp != start);
		}
		System.out.println();

	}

	/**
	 * Split the given list into two individual circular linked list
	 * 
	 * @param list
	 */
	void splitList(SplitACircularLinkedList list) {

		Node sf = list.head1 = list.head;
		Node ff = sf;

		while (ff.next != list.head && ff.next.next != list.head) {
			sf = sf.next;
			ff = ff.next.next;
		}

		// if ff.next.next == head then we move to the last of the list in order to set
		// the last node.next as head2
		if (ff.next != list.head)
			ff = ff.next;

		// make both the half lists as individual circular lists by pointing the last
		// Node to their respective heads
		list.head2 = sf.next;
		ff.next = list.head2;
		sf.next = list.head;

	}

	public static void main(String[] args) {

		SplitACircularLinkedList ll = new SplitACircularLinkedList();
		ll.head = new Node(3);
		ll.addToTheLast(new Node(4));
		ll.addToTheLast(new Node(5));
		ll.addToTheLast(new Node(2));
		ll.addToTheLast(new Node(6));
		ll.addToTheLast(new Node(4));
		ll.circular();
		ll.printList(ll.head);
		ll.splitList(ll);
		ll.printList(ll.head1);
		ll.printList(ll.head2);

	}

}
