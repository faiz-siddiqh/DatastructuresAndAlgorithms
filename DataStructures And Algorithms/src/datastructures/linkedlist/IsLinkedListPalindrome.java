package datastructures.linkedlist;

/**
 * Given a singly linked list of size N of integers. The task is to check if the
 * given linked list is palindrome or not.
 *
 */
public class IsLinkedListPalindrome {
	Node head = null;
	Node secondHalf;

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
	 * check if the ll is palindrome
	 * 
	 * @param arr ,K
	 * @return
	 */

	boolean isPalindrome(Node head) {
		if (head.next == null)
			return true;

		if (head.next.next == null && head.data == head.next.data)
			return true;

		boolean flag;
		Node sf = head;
		Node ff = head;
		Node prev = null;
		Node middle = null;

		// finding the middle element
		while (ff != null && ff.next != null) {
			prev = sf;
			sf = sf.next;
			ff = ff.next.next;
		}
		// if their is a last element then its a odd list and intitalise the middle Node
		if (ff != null) {
			middle = sf;
			sf = sf.next;
		}
		secondHalf = sf;
		prev.next = null;

		// reverse the second half of the list
		secondHalf = reverse(secondHalf);
		flag = compareTheLL(head, secondHalf);/// compare the two lists
		reverse(secondHalf);// reverse back the second half as we have to do it in O(1) space

		// if middle element exists then join both the lists with midddle Node between
		// the lists as connector
		if (middle != null) {
			prev.next = middle;
			middle.next = secondHalf;
		} else
			prev.next = secondHalf;
		return flag;
	}

	/**
	 * Compare the LL s for equality
	 * 
	 * @param head
	 * @param secondHalf
	 * @return
	 */
	private boolean compareTheLL(Node head, Node secondHalf) {
		Node head2 = head;
		Node secondHalf2 = secondHalf;

		while (head2 != null && secondHalf2 != null) {
			if (head2.data == secondHalf2.data) {
				head2 = head2.next;
				secondHalf2 = secondHalf2.next;
			} else
				return false;
		}

		// if it is a balanced and equal list
		if (head2 == null && secondHalf2 == null)
			return true;

		return false;

	}

	/**
	 * reverse the LL
	 * 
	 * @param node
	 * @return
	 */
	public static Node reverse(Node node) {
		Node cur = node;
		Node prev = null;
		Node nextNode = null;

		while (cur != null) {
			nextNode = cur.next;
			cur.next = prev;
			prev = cur;
			cur = nextNode;

		}

		return prev;

	}

	public static void main(String[] args) {
		IsLinkedListPalindrome ll = new IsLinkedListPalindrome();
		ll.push(1);
		ll.push(2);
		ll.push(2);
		ll.push(1);

		System.out.println("Is LinkedList Palindrome -" + ll.isPalindrome(ll.head));

	}

}
