package datastructures.binaryTree;

import java.util.ArrayList;

public class ReverseOrderTraversal {
	Node root;
	/*
	 * class Node { int data; Node left; Node right;
	 * 
	 * public Node(int data) { this.data = data; } }
	 */
	static ArrayList<Integer> al;

	public ReverseOrderTraversal() {
		this.root = null;
	}

	private static ArrayList<Integer> reverseOrderTraversal(Node root) {
		int height = findHeight(root);// get the height of the tree
		al = new ArrayList<>();
		// perform traverse operation from leaves and move towards root
		for (int i = height; i >= 1; i--)
			traverse(root, i);

		return al;
	}

	/**
	 * traverse and push data of Nodes at a level
	 * 
	 * @param root
	 * @param level
	 */
	private static void traverse(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			al.add(root.data);
		else if (level > 1) {
			traverse(root.left, level - 1);
			traverse(root.right, level - 1);
		}

	}

	/**
	 * Return the height of Binary Tree
	 * 
	 * @param root
	 * @return
	 */
	private static int findHeight(Node root) {
		if (root == null)
			return 0;
		else {
			int left = findHeight(root.left);
			int right = findHeight(root.right);
			return (left >= right) ? left + 1 : right + 1;
		}
	}

	public static void main(String[] args) {
		ReverseOrderTraversal tree = new ReverseOrderTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		reverseOrderTraversal(tree.root);
		if (al.size() == 0)
			System.out.println("Empty Binary Tree");
		else
			for (int each : al)
				System.out.print(each + " ");
	}

}
