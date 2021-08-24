package datastructures.linkedlist;

/**
 * Given a singly linked list consisting of N nodes. The task is to remove
 * duplicates (nodes with duplicate values) from the given list (if exists).
 * Note: Try not to use extra space. Expected time complexity is O(N). The nodes
 * are arranged in a sorted way.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class RemoveDuplicatesInSortedLinkedList {

	Node head;

	class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int new_data) {
		Node new_node = new Node(new_data);

		new_node.next = head;

		head = new_node;
	}

	Node removeDuplicates(Node head) {

		Node curNode = head;
		Node nextNode = curNode.next;
		while (nextNode != null) {

			if (curNode.data == nextNode.data) {
				Node node = nextNode.next;
				curNode.next = node;
				nextNode.next = null;
				nextNode = node;
			} else {
				curNode = nextNode;
				nextNode = nextNode.next;
			}

		}
		return head;
	}

	static void printList(Node node) {
		while (node != null) {
			System.out.print(" " + node.data);
			node = node.next;
		}
	}

	public static void main(String[] args) {
		RemoveDuplicatesInSortedLinkedList ll = new RemoveDuplicatesInSortedLinkedList();
		ll.push(20);
		ll.push(14);
		ll.push(13);
		ll.push(12);
		ll.push(12);
		ll.push(11);

		ll.removeDuplicates(ll.head);
		printList(ll.head);

	}

}
