package datastructures.doublyLinkedlist;

/**
 * Given a doubly linked list of n elements. The task is to reverse the doubly
 * linked list.
 *
 */
public class ReverseADLL {
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
	 * reverse the DLL
	 */
	private void reverse() {
		Node node = null;
		Node cur = head;

		while (cur != null) {
			node = cur.prev;
			cur.prev = cur.next;
			cur.next = node;
			cur = cur.prev;
		}

		if (node != null)
			head = node.prev;
	}

	public static void main(String[] args) {
		ReverseADLL dll = new ReverseADLL();
		dll.push(1);
		dll.push(2);
		dll.push(3);
		dll.push(4);
		dll.push(5);

		dll.printList(dll.head);
		dll.reverse();
		dll.printList(dll.head);

	}

}
