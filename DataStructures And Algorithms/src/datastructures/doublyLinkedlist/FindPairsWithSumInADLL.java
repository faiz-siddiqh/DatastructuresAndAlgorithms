package datastructures.doublyLinkedlist;

/**
 * Given a sorted doubly linked list of positive distinct elements, the task is
 * to find pairs in a doubly-linked list whose sum is equal to given value x,
 * without using any extra space
 *
 */
public class FindPairsWithSumInADLL {
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
	 * find the sum of the given value in the DLL
	 */
	private void findSum(Node node, int x) {
		Node first = node;
		Node last = node;
		boolean flag = false;

		// traverse and set the last node of the DLL
		while (last.next != null)
			last = last.next;

		while (first != last && last.next != first) {
			if (first.data + last.data == x) {
				System.out.println("(" + first.data + "," + last.data + ")");
				flag = true;
				first = first.next;
				last = last.prev;
			} else {
				// if sum is less than required sum then move to the next node from first
				if (first.data + last.data < x)
					first = first.next;
				else// if sum is greater then move to the lesser value node
					last = last.prev;
			}
		}

		if (flag == false)
			System.out.println("No pair found");

	}

	public static void main(String[] args) {
		FindPairsWithSumInADLL dll = new FindPairsWithSumInADLL();
		dll.push(1);
		dll.push(2);
		dll.push(3);
		dll.push(4);
		dll.push(5);
		int x = 6;
		dll.findSum(dll.head, x);

	}

}
