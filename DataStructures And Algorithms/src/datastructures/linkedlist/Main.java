package datastructures.linkedlist;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		
		LinkedList<Employee> l;
		Employee Ahmed = new Employee("Ahmed", "K", 1978);
		Employee Mohs = new Employee("Mohs", "Shine", 1008);
		Employee Ravish = new Employee("Ravish", "Kumar", 1928);
		Employee patel = new Employee("patel", "Ker", 1843);
		Employee Arjun = new Employee("Arjun", "p", 1783);

		EmployeeLinkedlist list = new EmployeeLinkedlist();

		list.addToFront(patel);
		list.addToFront(Ravish);
		list.addToFront(Mohs);
		list.addToFront(Arjun);
		list.addToFront(Ahmed);
		
		System.out.println(list.getSize());
		list.printList();
		
		list.removeFront();
		System.out.println(list.getSize());
		list.printList();

	}
}
