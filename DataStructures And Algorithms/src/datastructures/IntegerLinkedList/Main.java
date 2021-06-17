package datastructures.IntegerLinkedList;

public class Main {

	public static void main(String[] args) {
			
		Integer one=1;
		Integer two=2;
		Integer three=3;
		Integer four=4;
		Integer five=5;
		
		IntegerLinkedList list=new IntegerLinkedList();
		
		list.IntegerSort(two);
		list.printList();
		list.IntegerSort(three);
		list.printList();
		list.IntegerSort(five);
		list.printList();
		list.IntegerSort(one);
		list.printList();
		list.IntegerSort(four);
		list.printList();
		
	}

}
