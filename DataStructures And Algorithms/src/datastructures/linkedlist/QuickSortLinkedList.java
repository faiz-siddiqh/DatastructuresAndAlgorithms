package datastructures.linkedlist;

/**
 * Sort the given Linked List using quicksort. which takes O(n^2) time in worst
 * case and O(nLogn) in average and best cases
 *
 */
public class QuickSortLinkedList {
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
	 * merge sort the given LL using recursion
	 * 
	 * @param start
	 * @return
	 */
	private void quickSort(Node start, Node end) {
		if (start == null || start.next == end || end == null)
			return;

		Node pivotNode = partition(start, end);
		quickSort(start, pivotNode);

		// if start is pivot then sort the remaning LL
		if (pivotNode != null && pivotNode == start)
			quickSort(pivotNode.next, end);

		// if the pivot is in the middle then sort from the next to pivot[i.e
		// pivotIndex.next.next] to last of the LL ,end
		else if (pivotNode != null && pivotNode.next != null)
			quickSort(pivotNode.next.next, end);

	}

	private Node partition(Node start, Node end) {

		if (start == null || start == end || end == null)
			return start;

		Node pivotPrev = start;
		Node cur = start;
		int pivot = end.data;

		while (start != end) {
			if (start.data < pivot) {
				pivotPrev = cur;
				int temp = cur.data;
				cur.data = start.data;
				start.data = temp;
				cur = cur.next;
			}
			start = start.next;
		}
		int temp = cur.data;
		cur.data = pivot;
		end.data = temp;

		return pivotPrev;
	}

	public static void main(String[] args) {
		QuickSortLinkedList ll = new QuickSortLinkedList();
		ll.push(3);
		ll.push(4);
		ll.push(2);
		ll.push(1);
		ll.push(5);
		ll.printList(ll.head);
		Node lastNode = ll.head;
		while (lastNode.next != null) {
			lastNode = lastNode.next;
		}

		ll.quickSort(ll.head, lastNode);
		ll.printList(ll.head);
	}

}
