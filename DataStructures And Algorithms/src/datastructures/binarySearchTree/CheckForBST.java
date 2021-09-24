package datastructures.binarySearchTree;

import datastructures.binaryTree.Node;

/**
 * VIMP -Diff logic : A program to check if a binary tree is BST or not
 * 
 * @author Faiz-Siddiqh
 *
 */
public class CheckForBST {
	Node root;
	boolean isLeft;
	boolean isRight;

	boolean isBST(Node root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node root, int min, int max) {
		if (root == null)
			return true;
		// false if the root value is less than min or greater than max
		if (root.data < min || root.data > max)
			return false;
		// check for left and right subtrees
		return isBST(root.left, min, root.data - 1) && isBST(root.right, root.data + 1, max);
	}

	public static void main(String[] args) {
		CheckForBST tree = new CheckForBST();
		// TC1
//		tree.root = new Node(3);
//		tree.root.right = new Node(5);
//		tree.root.left = new Node(2);
//		tree.root.left.right = new Node(4);
//		tree.root.left.left = new Node(1);

		// TC2
		tree.root = new Node(3);
		tree.root.right = new Node(5);
		tree.root.right.right = new Node(7);
		tree.root.right.right.right = new Node(9);
		tree.root.right.right.right.right = new Node(12);
		tree.root.right.right.right.right.right = new Node(16);

		if (tree.isBST(tree.root))
			System.out.println(1);
		else
			System.out.println(0);
	}

}
