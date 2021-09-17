package datastructures.binarySearchTree;

import datastructures.binaryTree.Node;

public class BinarySearchTree {
	Node root;

	/*
	 * class Node {
	 * 
	 * Node left; Node right; int data;
	 * 
	 * public Node(int data) { this.data = data; }
	 * 
	 * }
	 */
	public BinarySearchTree() {
		this.root = null;
	}

	public void insert(int key) {
		root = insertNode(root, key);

	}

	// insert Node in The BST at right position
	private Node insertNode(Node root, int key) {

		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (root.data > key)
			root.left = insertNode(root.left, key);
		else if (root.data < key)
			root.right = insertNode(root.right, key);

		return root;
	}

	private boolean search(Node root, int key) {
		if (root == null)// reached end of the trees
			return false;
		if (root.data == key)
			return true;
		// if root data is greater than key then search in left view
		if (root.data > key)
			return search(root.left, key);

		// else search in right view
		return search(root.right, key);
	}

	public static void main(String[] args) {

		BinarySearchTree bt = new BinarySearchTree();
		bt.insert(20);
		bt.insert(30);
		bt.insert(40);
		bt.insert(50);
		bt.insert(10);
		bt.insert(70);

		if (bt.search(bt.root, 70))
			System.out.println("Node found");
		else
			System.out.println("Node not present");
	}

}
