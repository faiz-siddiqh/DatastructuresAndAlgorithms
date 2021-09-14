package datastructures.binaryTree;

import java.util.ArrayList;

/**
 * Print the Right viewof the Binary Tree. Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(Height of the Tree).
 *
 */
public class PrintRightViewOfBinaryTree {
	Node root;
	static ArrayList<Integer> list;
	static int level;

	/*
	 * class Node { int data; Node left; Node right;
	 * 
	 * public Node(int data) { this.data = data; } }
	 */
	public PrintRightViewOfBinaryTree() {
		this.root = null;
	}

	private ArrayList<Integer> printRightView(Node root) {

		list = new ArrayList<>();
		level = 0;

		navigateIntoLevels(root, 1);

		return list;
	}

	private void navigateIntoLevels(Node root, int curLevel) {

		if (root == null)
			return;
		if (level < curLevel) {
			list.add(root.data);
			level = curLevel;
		}
		navigateIntoLevels(root.right, curLevel + 1);
		navigateIntoLevels(root.left, curLevel + 1);

	}

	public static void main(String[] args) {
		PrintRightViewOfBinaryTree tree = new PrintRightViewOfBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.right.right = new Node(6);
		tree.root.left.right.left = new Node(7);

		tree.printRightView(tree.root);
		for (int eachData : list)
			System.out.print(eachData + " ");

	}

}
