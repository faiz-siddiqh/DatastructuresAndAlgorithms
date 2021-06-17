package datastructures.doublyLinkedlist;

public class Main {

	public static void main(String[] args) {

		Employee Ahmed = new Employee("Ahmed", "K", 1978);
		Employee Arjun = new Employee("Arjun", "A", 2018);
		Employee Mohs = new Employee("Mohs", "Shine", 1008);
		Employee Ravish = new Employee("Ravish", "Kumar", 1928);
		Employee patel = new Employee("patel", "Ker", 1843);
		Employee Alpha = new Employee("Alpha", "beta", 2001);

		EmployeeDoublyLinkedlist list = new EmployeeDoublyLinkedlist();

		list.addToFront(patel);
		list.addToFront(Ravish);
		list.addToFront(Mohs);
		list.addToFront(Arjun);

		System.out.println(list.getSize());
		list.printList();
		System.out.println();
		list.addToEnd(Ahmed);
		System.out.println(list.getSize());
		list.printList();

		System.out.println();
		list.addBefore(new Employee("huha", "ab", 1234), Arjun);
		System.out.println(list.getSize());
		System.out.println();
		list.printList();

	}
}
