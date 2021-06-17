package datastructures.stack;

import java.util.EmptyStackException;

public class Stack {

	private Employee stack[];
	private int top;

	public Stack(int capacity) {
		stack = new Employee[capacity];

	}

	public void push(Employee employee) {

		if (top == stack.length) {
			Employee[] newArray = new Employee[2 * stack.length];
			System.arraycopy(stack, 0, newArray, 0, stack.length);
			stack = newArray;

		}
		stack[top++] = employee;

	}

	public Employee pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		Employee employee = stack[--top];
		stack[top] = null;
		return employee;
	}

	public Employee peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		Employee emp = stack[top - 1];
		return emp;
	}

	public boolean isEmpty() {

		return top == 0;
	}

	public void printStack() {
		for(int i=top-1;i>=0;i--) {
			System.out.println(stack[i]);
		}
	}
}
