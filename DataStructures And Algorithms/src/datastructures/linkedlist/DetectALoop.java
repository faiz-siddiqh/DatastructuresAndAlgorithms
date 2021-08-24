package datastructures.linkedlist;

/**
 * Given a linked list of N nodes. The task is to check if the linked list has a loop.
 *  Linked list can contain self loop.
 */
import java.util.HashSet;

public class DetectALoop {

	static Node head;

	static class Node {

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

	public static void main(String[] args) {
		DetectALoop dl = new DetectALoop();
		dl.push(2);
		dl.push(22);
		dl.push(23);
		dl.push(24);
		dl.push(25);

		dl.head.next.next.next = dl.head;// manually looping the linkedList

		System.out.println(detectLoop(dl.head));

	}

}
