package datastructures.LinkedListStack;

import java.util.LinkedList;
import datastructures.linkedlist.Employee;

public class LinkedListStack {
	private LinkedList<Employee> stack;
	
	public LinkedListStack() {
		
		stack=new LinkedList<Employee>();
	}
	
	public void push(Employee employee) {
		stack.push(employee);
	}
	
	public Employee peek() {
		return stack.peek();
		
	}
	
	public Employee pop() {
		
		return stack.pop();
	}
	
	public void printStack() {
		
		
		for(Employee emp: stack) {
			System.out.println(emp);
		}
	}
	
	
}
