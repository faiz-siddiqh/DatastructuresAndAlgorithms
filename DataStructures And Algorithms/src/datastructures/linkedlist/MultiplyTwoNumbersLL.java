package datastructures.linkedlist;

/**
 * Given elements as nodes of the two linked lists. The task is to multiply
 * these two linked lists, say L1 and L2.
 * 
 * Note: The output could be large take modulo 109+7.
 *
 */
public class MultiplyTwoNumbersLL {
	Node head;

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

	void print(Node node) {
		Node temp = node;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MultiplyTwoNumbersLL ll1 = new MultiplyTwoNumbersLL();
		MultiplyTwoNumbersLL ll2 = new MultiplyTwoNumbersLL();
		ll1.push(3);
		ll1.push(2);
		ll2.push(2);
//		ll2.push(1);
		System.out.println((ll1.multiplyTwoLists(ll1.head, ll2.head)));

	}

	/**
	 * Multiply and return the product of Two Linked List
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public long multiplyTwoLists(Node l1, Node l2) {
		long N = 1000000007;
		long prod1 = 0;
		long prod2 = 0;

		while (l1 != null || l2 != null) {

			if (l1 != null) {
				prod1 = (prod1 * 10) % N + l1.data;
				l1 = l1.next;
			}
			if (l2 != null) {
				prod2 = (prod2 * 10) % N + l2.data;
				l2 = l2.next;
			}

		}

		return (prod1 % N) * (prod2 % N) % N;
	}
}
