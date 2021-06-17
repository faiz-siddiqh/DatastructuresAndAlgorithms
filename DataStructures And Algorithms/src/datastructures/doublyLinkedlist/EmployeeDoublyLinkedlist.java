package datastructures.doublyLinkedlist;

public class EmployeeDoublyLinkedlist {

	private EmployeeNode head;
	private EmployeeNode tail;
	private int size;

	public void addToFront(Employee employee) {

		EmployeeNode node = new EmployeeNode(employee);
		node.setNext(head);

		if (head == null) {
			tail = node;
		} else {
			head.setPrevious(node);
		}

		head = node;
		size++;
	}

	public void addToEnd(Employee employee) {

		EmployeeNode node = new EmployeeNode(employee);
		if (tail == null) {
			head = node;
		} else {
			tail.setNext(node);
			node.setPrevious(tail);
		}

		tail = node;
		size++;

	}

	public boolean addBefore(Employee employee, Employee existingEmployee) {

		if (head == null) {
			return false;
		}

		EmployeeNode current = head;

		while (current != null && !current.getEmployee().equals(existingEmployee)) {
			current = current.getNext();
		}

		if (current == null) {
			return false;
		}

		EmployeeNode newNode = new EmployeeNode(employee);
		newNode.setPrevious(current.getPrevious());
		newNode.setNext(current);
		current.setPrevious(newNode);

		if (head == current) {
			head = newNode;

		} else {
			newNode.getPrevious().setNext(newNode);
		}
		size++;

		return true;

	}

	public EmployeeNode removeFront(Employee employee) {
		if (isEmpty()) {
			return null;
		}

		EmployeeNode removedNode = head;
		if (head.getNext() == null) {
			tail = null;
		} else {
			head.getNext().setPrevious(null);
		}

		head = head.getNext();
		size--;
		removedNode.setNext(null);
		return removedNode;

	}

	public boolean isEmpty() {
		return head == null;
	}

	public int getSize() {
		return size;
	}

	public void printList() {

		EmployeeNode current = head;
		System.out.print("<- HEAD -> ");
		while (current != null) {
			System.out.print(current);
			current = current.getNext();
			System.out.print(" <-> ");
		}
		System.out.print(" null");
	}

}
