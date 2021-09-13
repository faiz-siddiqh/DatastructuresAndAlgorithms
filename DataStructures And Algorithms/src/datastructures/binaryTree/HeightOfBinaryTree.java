package datastructures.binaryTree;

public class HeightOfBinaryTree {
	Node root;

	/*
	 * class Node { int data; Node left; Node right;
	 * 
	 * public Node(int data) { this.data = data; } }
	 */
	/**
	 * Find the height of Binary Tree
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
		HeightOfBinaryTree tree = new HeightOfBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		System.out.println("Height of the tree is " + findHeight(tree.root));
	}

}
