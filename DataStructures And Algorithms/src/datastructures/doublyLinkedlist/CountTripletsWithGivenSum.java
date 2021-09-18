package datastructures.doublyLinkedlist;

import java.util.HashMap;

class Doubly_Node {
	Doubly_Node prev;
	Doubly_Node next;
	int data;

	public Doubly_Node(int data) {
		this.data = data;
		prev = null;
		next = null;
	}

}

/**
 * Count triplets in a sorted doubly linked list whose sum is equal to a given
 * value x
 *
 */
public class CountTripletsWithGivenSum {

	Doubly_Node head;

	public CountTripletsWithGivenSum() {
		this.head = null;
	}

	private void push(int data) {
		Doubly_Node node = new Doubly_Node(data);
		node.next = head;
		node.prev = null;

		if (head != null)
			head.prev = node;

		head = node;
	}

	/**
	 * Return the number of triplets with given sum X in the sorted doubly Linked
	 * List The Time Complexity is O(N2)
	 * 
	 * @param node
	 * @param x
	 * @return
	 */
	private static int countTripletsWithSum(Doubly_Node node, int x) {
		int count = 0;
		if (node == null)
			return 0;
		HashMap<Integer, Doubly_Node> map = new HashMap<>();
		Doubly_Node ptr1 = null;
		Doubly_Node ptr2 = null;

		for (ptr1 = node; ptr1 != null; ptr1 = ptr1.next)
			map.put(ptr1.data, ptr1);

		for (ptr1 = node; ptr1 != null; ptr1 = ptr1.next) {
			for (ptr2 = ptr1.next; ptr2 != null; ptr2 = ptr2.next) {
				int sum = ptr1.data + ptr2.data;

				if (map.containsKey(x - sum) && map.get(x - sum) != ptr2)
					count++;

			}
		}

		return count / 3;
	}

	public static void main(String[] args) {
		CountTripletsWithGivenSum dll = new CountTripletsWithGivenSum();
		dll.push(9);
		dll.push(8);
		dll.push(6);
		dll.push(5);
		dll.push(4);
		dll.push(2);
		dll.push(1);
		int x = 17;

		System.out.println(countTripletsWithSum(dll.head, x));
	}

}
