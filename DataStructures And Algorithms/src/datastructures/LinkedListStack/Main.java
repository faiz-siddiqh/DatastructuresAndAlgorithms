package datastructures.LinkedListStack;

import datastructures.linkedlist.Employee;

public class Main {

	public static void main(String[] args) {
		
		LinkedListStack stack=new LinkedListStack();
		
		stack.push(new Employee("James","Rowling",7373));
		stack.push(new Employee("joy","berg",2925));
		stack.push(new Employee("apple","farg",4637));
		stack.push(new Employee("johnson","johnson",4643));
		
		stack.printStack();
		
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
	}

}
