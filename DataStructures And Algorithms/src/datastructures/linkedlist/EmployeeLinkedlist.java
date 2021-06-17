package datastructures.linkedlist;

public class EmployeeLinkedlist {

	private EmployeeNode head;
	private int size;

	public void addToFront(Employee employee) {

		EmployeeNode node = new EmployeeNode(employee);
		node.setNext(head);
		head = node;
		size++;
	}
	
	public EmployeeNode removeFront() {
		if(isEmpty()) {
			return null;
		}
		EmployeeNode removedNode=head;
		head=head.getNext();
		size--;
		removedNode.setNext(null);
		return removedNode;		
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public int getSize() {
		return size;
	}

	public void printList() {

		EmployeeNode current = head;
		System.out.print("<- HEAD  ");
		while (current != null) {
			System.out.print(current);
			current = current.getNext();
			System.out.print(" ->");
		}
		System.out.print(" null->");
	}
	
	

}
