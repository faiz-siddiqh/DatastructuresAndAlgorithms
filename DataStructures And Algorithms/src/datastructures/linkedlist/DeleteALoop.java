package datastructures.linkedlist;

/**
 * Given a linked list of N nodes. The task is to check if the linked list has a loop.
 *  Linked list can contain self loop.
 */
import java.util.HashSet;

public class DeleteALoop {

	Node head;

	class Node {

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

	/**
	 * Detect if a loop is present in the LL
	 * 
	 * @param head
	 * @return
	 */
	public static boolean detectLoop(Node head) {
		HashSet<Node> hs = new HashSet<Node>();

		while (head != null) {
			if (hs.contains(head))
				return true;

			hs.add(head);
			head = head.next;

		}

		return false;
	}

	/**
	 * Removes the loop if exists in the LL
	 * 
	 * @param head
	 */
	private void removeLoop(Node head) {
		Node cur = head;
		Node prev = null;

		HashSet<Node> hs = new HashSet<>();

		while (cur != null) {

			if (hs.contains(cur)) {
				prev.next = null;
				return;
			}
			hs.add(cur);
			prev = cur;
			cur = cur.next;

		}

	}

	public static void main(String[] args) {
		DeleteALoop dl = new DeleteALoop();
		dl.push(2);
		dl.push(22);
		dl.push(23);
		dl.push(24);
		dl.push(25);

		dl.head.next.next.next = dl.head;// manually looping the linkedList
		System.out.println("Does loop exists in the Linked List:" + detectLoop(dl.head));
		dl.removeLoop(dl.head);
		System.out.println("Does loop exists in the Linked List:" + detectLoop(dl.head));

	}

}
