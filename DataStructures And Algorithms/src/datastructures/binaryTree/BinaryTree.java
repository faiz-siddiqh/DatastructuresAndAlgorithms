package datastructures.binaryTree;

import java.util.Scanner;

public class BinaryTree {

	class Node {

		Node left;
		Node right;
		int data;

		public Node(int data) {
			this.data = data;
		}

	}

	Scanner sc = new Scanner(System.in);

	public Node createBinaryTree() {
		Node root = null;
		System.out.println("Enter the data");
		int data = sc.nextInt();
		if (data == -1)
			return null;
		root = new Node(data);
		System.out.println("Enter the left Node data for " + data);
		root.left = createBinaryTree();
		System.out.println("Enter the right Node data for " + data);
		root.right = createBinaryTree();

		return root;

	}

	public static void main(String[] args) {
		BinaryTree BT = new BinaryTree();
		BT.createBinaryTree();
	}

}
