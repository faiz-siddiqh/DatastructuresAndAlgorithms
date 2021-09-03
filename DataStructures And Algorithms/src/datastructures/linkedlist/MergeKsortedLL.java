package datastructures.linkedlist;

/**
 * Given K sorted linked lists of different sizes. The task is to merge them in
 * such a way that after merging they will be a single sorted linked list.
 *
 */
public class MergeKsortedLL {
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
	 * merge sort all the Node in the arr and return the resulted single sorted LL
	 * 
	 * @param arr ,K
	 * @return
	 */

	Node mergeKList(Node[] arr, int K) {
		if (K == 1)
			return arr[0];

		if (K == 2)
			return mergeTwoLL(arr[0], arr[1]);

		Node finalNode = arr[0];

		for (int i = 1; i < K; i++)
			finalNode = mergeTwoLL(finalNode, arr[i]);

		return finalNode;

	}

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

	public static void main(String[] args) {
		MergeKsortedLL ll = new MergeKsortedLL();
		ll.push(3);
		ll.push(2);
		ll.push(1);
		MergeKsortedLL ll2 = new MergeKsortedLL();
		ll2.push(5);
		ll2.push(4);
		MergeKsortedLL ll3 = new MergeKsortedLL();
		ll3.push(7);
		ll3.push(6);

		Node[] arr = { ll.head, ll2.head, ll3.head };
		ll.head = ll.mergeKList(arr, arr.length);
		ll.printList(ll.head);
	}

}
