package datastructures.IntegerLinkedList;

public class IntegerLinkedList {

	private int size;
	private IntegerNode head;

	public boolean isEmpty() {
		return head == null; 
	}

	public void addToFront(Integer value) {

		IntegerNode node = new IntegerNode(value);
		node.setNext(head);
		head = node;
		size++;
	}

	public void IntegerSort(Integer value) {

		if (head == null || head.getValue() >= value) {
			addToFront(value);
			size++;
			return;
		}

		IntegerNode current = head.getNext();
		IntegerNode previous = head;

		while (current != null && current.getValue() < value) {
			previous = current;
			current = current.getNext();
		}

		IntegerNode newNode = new IntegerNode(value);
		newNode.setNext(current);
		previous.setNext(newNode);
		size++;

	}

	public void printList() {

		IntegerNode current = head;
		System.out.print("<- Head ");

		while (current != null) {
			System.out.print("-> " + current);
			current = current.getNext();
		}
		System.out.println(" -> null ->");
	}

	public int getSize() {   
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public IntegerNode getHead() {
		return head;
	}

	public void setHead(IntegerNode head) {
		this.head = head;
	}

}
