package datastructures.binarySearchTree;

import java.util.ArrayList;
/**
 * Given a BST (Binary Search Tree) that may be unbalanced, convert it into a balanced BST that has minimum possible height.
 */
import datastructures.binaryTree.Node;

public class ConvertBSTtoBalancedBST {

	Node root;
	private static ArrayList<Node> al;

	public ConvertBSTtoBalancedBST() {
		this.root = null;
	}

	/**
	 * Take the binaryTree as input and return the BST-Time Complexity of O(N) and
	 * space -O(1)
	 * 
	 * @param root
	 * @return
	 */
	private static Node convertToBalancedBST(Node root) {
		if (root == null)
			return null;
		al = new ArrayList<>();
		addElements(root);
		return convertToBalancedBST(al, 0, al.size() - 1);

	}

	/**
	 * Create a Balanced BT by using middle element as root
	 * 
	 * @param root
	 */
	private static Node convertToBalancedBST(ArrayList<Node> al, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		Node node = al.get(mid);
		node.left = convertToBalancedBST(al, start, mid - 1);
		node.right = convertToBalancedBST(al, mid + 1, end);

		return node;
	}

	/**
	 * Perform the Inorder traversal and add all the elements to the arraylist
	 * 
	 * @param root
	 */
	private static void addElements(Node root) {
		if (root != null) {
			addElements(root.left);
			al.add(root);
			addElements(root.right);
		}
	}

	/**
	 * Print Pre Order Traversal of the Binary Tree
	 * 
	 * @param root
	 */
	private static void preOrder(Node root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrder(root.left);

		preOrder(root.right);
	}

	public static void main(String[] args) {
		ConvertBSTtoBalancedBST tree = new ConvertBSTtoBalancedBST();
		tree.root = new Node(10);
		tree.root.left = new Node(9);
		tree.root.left.left = new Node(8);
		tree.root.left.left.left = new Node(7);
		tree.root.left.left.left.left = new Node(6);

		preOrder(tree.root);
		System.out.println();
		Node node = convertToBalancedBST(tree.root);
		preOrder(node);
	}

}
