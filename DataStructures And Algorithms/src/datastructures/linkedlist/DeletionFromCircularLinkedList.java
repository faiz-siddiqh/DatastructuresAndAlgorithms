package datastructures.linkedlist;

/**
 * Delete a Node from Circular Linked List
 * 
 */

public class DeletionFromCircularLinkedList {
	class Node {
		Node next;
		int data;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

	Node head;

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
	 * delete the node from the circular linked list
	 * 
	 * @param list
	 */
	Node deleteNode(Node head, int data) {
		Node cur = head;
		Node prev = null;
		Node next = null; // last second node of list
		Node last = null; // last node of list

		// traverse to the end of the list to intialise last and prev node
		while (cur.next.next != head) {
			cur = cur.next;
		}
		prev = cur;
		last = cur.next;
		cur = head;

		// if last node is to be deleted
		if (last.data == data) {
			last.next = null;
			prev.next = head;
			return head;
		}

		while (cur.next != head) {
			if (cur.data == data) {
				next = cur.next;
				cur.next = null;
				if (cur == head)// if head node is to be deleted
					last.next = head = next;
				else
					last.next = next;
				cur = next;
				break;
			} else {
				last = cur;
				cur = cur.next;
			}

		}

		return head;

	}

	public static void main(String[] args) {

		DeletionFromCircularLinkedList ll = new DeletionFromCircularLinkedList();
		ll.head = ll.new Node(3);
		ll.addToTheLast(ll.new Node(8));
		ll.addToTheLast(ll.new Node(5));
		ll.addToTheLast(ll.new Node(2));
		ll.addToTheLast(ll.new Node(6));
		ll.addToTheLast(ll.new Node(4));
		ll.circular();
		ll.printList(ll.head);
		ll.printList(ll.deleteNode(ll.head, 4));

	}

}
