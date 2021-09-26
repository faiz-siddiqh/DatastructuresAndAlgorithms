package datastructures.binarySearchTree;

import java.util.ArrayList;
import java.util.Collections;

import datastructures.binaryTree.Node;

public class BinaryTreeToBST {

	Node root;
	private static ArrayList<Integer> al;
	private static int count;

	public BinaryTreeToBST() {
		this.root = null;
	}

	/**
	 * Take the binaryTree as input and return the BST-Time Complexity of O(NlogN)
	 * and space -O(N)
	 * 
	 * @param root
	 * @return
	 */
	private static Node convertToBST(Node root) {
		if (root == null)
			return null;
		al = new ArrayList<>();
		count = 0;
		addElementsAndSort(root);
		Collections.sort(al);// sort all the Nodes
		toBST(root);
		return root;
	}

	/**
	 * Change the value of Nodes by performing a InOrder traversal with values from
	 * the Arraylist
	 * 
	 * @param root
	 */
	private static void toBST(Node root) {
		if (root == null)
			return;
		toBST(root.left);
		root.data = al.get(count++);
		toBST(root.right);
	}

	/**
	 * Perform the Inorder traversal and add all the elements to the arraylist
	 * 
	 * @param root
	 */
	private static void addElementsAndSort(Node root) {
		if (root != null) {
			addElementsAndSort(root.left);
			al.add(root.data);
			addElementsAndSort(root.right);
		}
	}

	/**
	 * Print InOrder Traversal of the Binary Tree
	 * 
	 * @param root
	 */
	private static void printInOrder(Node root) {
		if (root == null)
			return;
		printInOrder(root.left);
		System.out.print(root.data + " ");
		printInOrder(root.right);
	}

	public static void main(String[] args) {
		BinaryTreeToBST tree = new BinaryTreeToBST();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);

		printInOrder(tree.root);
		System.out.println();
		tree.root = convertToBST(tree.root);
		printInOrder(tree.root);
	}

}
