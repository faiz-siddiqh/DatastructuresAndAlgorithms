package datastructures.queue;

public class Main {

	public static void main(String[] args) {
		Queue queue = new Queue(10);

		queue.add(new Employee("John ", "Doe", 123444));
		queue.add(new Employee("pankaj ", "raj", 23452));
		queue.add(new Employee("happy ", "A", 12523534));
		queue.add(new Employee("Vicky ", "V", 23532));
		queue.add(new Employee("Dicky ", "G", 65356));

		queue.printQueue();

		queue.add(new Employee("Leol ", "AS", 1834));
		queue.add(new Employee("Messi", "SSSS", 1823434));

		queue.printQueue();

		System.out.println(queue.remove());
		System.out.println(queue.peek());

	}

}
