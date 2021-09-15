package datstructures.binarySearchTree;

import datastructures.binaryTree.Node;

public class MinValueInBST {
	Node root;

	/*
	 * class Node { public Node left; public Node right; public int data;
	 * 
	 * public Node(int data) { this.data = data; } }
	 */
	public MinValueInBST() {
		root = null;
	}

	public void insert(int key) {

		root = insertNode(root, key);
	}

	/**
	 * Insert Node into the BST
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
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

	/**
	 * Find the min Value in BST
	 * 
	 * @param root
	 * @return
	 */
	private int findMin(Node node) {
		if (node == null) // if main root node is null then return -1
			return -1;
		if (node.left == null)// if there is no left node then that is the least number in BST
			return node.data;

		return findMin(node.left);// if left node exist then traverse to next left Node [lesser value node]
	}

	/**
	 * Find the max Value in BST
	 * 
	 * @param root
	 * @return
	 */
	private int findMax(Node node) {
		if (node == null) // if main root node is null then return -1
			return -1;
		if (node.right == null)// if there is no right node then that is the max number in BST
			return node.data;

		return findMax(node.right);// if right node exist then traverse to next right Node [max value node]
	}

	public static void main(String[] args) {
		MinValueInBST bt = new MinValueInBST();
		bt.insert(20);
		bt.insert(30);
		bt.insert(40);
		bt.insert(50);
		bt.insert(10);
		bt.insert(70);

		System.out.println(bt.findMin(bt.root));
		System.out.println(bt.findMax(bt.root));

	}

}
