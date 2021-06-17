package datastructures.stack;

public class Main {

	public static void main(String[] args) {

		Stack stack = new Stack(10);

		stack.push(new Employee("Jonathan", "James", 1234));
		stack.push(new Employee("french", "lewis", 3623));
		stack.push(new Employee("Nvidia", "carl", 4647));
		stack.push(new Employee("kapoor", "sims", 3737));
		stack.push(new Employee("Ahmed", "sid", 3929));

		stack.printStack();

		System.out.println(stack.pop());
		System.out.println(stack.peek());

	}

}
