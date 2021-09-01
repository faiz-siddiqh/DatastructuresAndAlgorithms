package datastructures.linkedlist;

public class MergeSortLinkedList {
	Node head = null;

	static class Node {

		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

	}

	/**
	 * Push data to the front of the list
	 * 
	 * @param data
	 */
	public void push(int data) {

		Node temp = new Node(data);
		temp.next = head;
		head = temp;

	}

	/**
	 * Print all the Nodes in a LL
	 * 
	 * @param start
	 */
	public void printList(Node start) {
		if (start == null) {
			return;
		}

		Node temp = start;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();

	}

	/**
	 * merge sort the given LL usinf divide and conquer method
	 * 
	 * @param start
	 * @return
	 */
	private Node mergeSort(Node start) {
		if (start == null || start.next == null)
			return start;

		Node middle = getMiddle(start);
		Node middleNext = middle.next;
		middle.next = null;

		Node left = mergeSort(start);
		Node right = mergeSort(middleNext);

		Node cl = mergeTwoLL(left, right);
		return cl;

	}

//	private Node mergeTwoLL(Node head1, Node head2) {
//
//		Node merged = new Node(-1);
//		Node temp = merged;
//
//		// While head1 is not null and head2
//		// is not null
//		while (head1 != null && head2 != null) {
//			if (head1.data < head2.data) {
//				temp.next = head1;
//				head1 = head1.next;
//			} else {
//				temp.next = head2;
//				head2 = head2.next;
//			}
//			temp = temp.next;
//		}
//
//		while (head1 != null) {
//			temp.next = head1;
//			head1 = head1.next;
//			temp = temp.next;
//		}
//
//		while (head2 != null) {
//			temp.next = head2;
//			head2 = head2.next;
//			temp = temp.next;
//		}
//		return merged.next;
//	}

	/**
	 * Merge two sorted LL
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	public Node mergeTwoLL(Node left, Node right) {
		if (right == null)
			return left;
		if (left == null)
			return right;

		Node sorted = null;
		if (left.data <= right.data) {
			sorted = left;
			sorted.next = mergeTwoLL(left.next, right);
		} else {
			sorted = right;
			sorted.next = mergeTwoLL(left, right.next);
		}

		return sorted;

	}

	/**
	 * Get the middle element of LL
	 * 
	 * @param start
	 * @return
	 */
	private Node getMiddle(Node start) {
		if (start == null)
			return start;

		Node fastForward = start;
		Node shortForward = start;

		while (fastForward.next != null && fastForward.next.next != null) {
			fastForward = fastForward.next.next;
			shortForward = shortForward.next;
		}

		return shortForward;
	}

	public static void main(String[] args) {
		MergeSortLinkedList ll = new MergeSortLinkedList();
		ll.push(3);
		ll.push(4);
		ll.push(2);
		ll.push(1);
		ll.push(5);
		ll.printList(ll.head);
		ll.head = ll.mergeSort(ll.head);
		ll.printList(ll.head);
	}

}
