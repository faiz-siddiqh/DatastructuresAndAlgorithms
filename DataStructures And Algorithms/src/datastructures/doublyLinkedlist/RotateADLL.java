package datastructures.doublyLinkedlist;

/**
 * Given a doubly-linked list, rotate the linked list counter-clockwise by N
 * nodes. Here N is a given positive integer and is smaller than the count of
 * nodes in linked list.
 *
 */
public class RotateADLL {
	Node head;

	class Node {
		int data;
		Node next, prev;

		public Node(int data) {
			this.data = data;
			next = prev = null;
		}
	}

	/**
	 * push the node to the front
	 * 
	 * @param data
	 */
	public void push(int data) {
		Node node = new Node(data);
		node.next = head;
		node.prev = null;

		if (head != null)
			head.prev = node;

		head = node;
	}

	/**
	 * Print the DLL
	 * 
	 * @param node
	 */
	public void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	/**
	 * rotate the DLL
	 */
	private void rotate(int N) {
		Node node = null;
		Node cur = head;
		int count = 1;

		if (head == null)
			return;
		while (count < N && cur != null) {
			cur = cur.next;
			count++;
		}

		if (cur == null)// if cur is null then we hav traversed to last of the LL or N> size of LL
			return;

		node = cur;// the last node of the rotated list

		while (cur.next != null)// move to the last node
			cur = cur.next;

		cur.next = head;// connect the last node to current head and head prev to current last node
		head.prev = cur;
		// reset the head and the last element of rotated LL
		head = node.next;
		head.prev = null;
		node.next = null;

	}

	public static void main(String[] args) {
		RotateADLL dll = new RotateADLL();
		dll.push(1);
		dll.push(2);
		dll.push(3);
		dll.push(4);
		dll.push(5);

		dll.printList(dll.head);
		int n = 3;
		dll.rotate(n);
		dll.printList(dll.head);

	}

}
