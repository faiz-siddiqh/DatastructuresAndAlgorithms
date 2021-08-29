package datastructures.linkedlist;

/**
 * Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s
 * only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros
 * segregate to head side, 2s at the end of the linked list, and 1s in the mid
 * of 0s and 2s.
 */

public class SortLinkedListWith0s1s2s {

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

	void print(Node node) {
		Node temp = node;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	static Node segregate(Node head) {
		int[] count = { 0, 0, 0 };

		Node node = head;

		while (node != null) {
			count[node.data]++;
			node = node.next;
		}

		node = head;
		int i = 0;
		while (node != null) {

			if (count[i] == 0) {
				i++;
			} else {
				node.data = i;
				--count[i];
				node = node.next;
			}
		}

		return head;

	}

	public static Node reverse(Node lead) {

		Node cur = lead;
		Node next = null;
		Node prev = null;

		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		lead = prev;
		return lead;
	}

	public static void main(String[] args) {
		SortLinkedListWith0s1s2s ll = new SortLinkedListWith0s1s2s();
		ll.push(1);
		ll.push(0);
		ll.push(0);
		ll.push(2);
		ll.push(1);
		ll.push(2);
		ll.push(2);
		ll.push(0);
		ll.print(ll.head);
		System.out.println();
		ll.print(ll.segregate(ll.head));

	}

}
