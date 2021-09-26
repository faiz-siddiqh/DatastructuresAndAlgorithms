package datastructures.binarySearchTree;

import datastructures.binaryTree.Node;

/**
 * Given a Binary search tree. Your task is to complete the function which will
 * return the Kth largest element without doing any modification in Binary
 * Search Tree.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class KthLargestElementInBST {
	Node root;

	public KthLargestElementInBST() {
		this.root = null;
	}

	private static int count;
	private static int ans;

	/**
	 * Return Kth Largest Element in the BST
	 * 
	 * @param root
	 * @param K
	 * @return
	 */
	public int kthLargest(Node root, int K) {
		if (root == null)
			return 0;
		ans = -1;
		count = 0;

		findLargest(root, K);

		return ans;
	}

	/**
	 * Recursively traverse in reverse inOrder way and count and find the largest
	 * number in BST
	 * 
	 * @param root
	 * @param K
	 */
	public static void findLargest(Node root, int K) {
		if (root == null)
			return;

		findLargest(root.right, K);
		count++;
		if (count == K) {
			ans = root.data;
			return;
		}
		findLargest(root.left, K);

	}

	public Node insertNode(Node root, int data) {
		if (root == null)
			return new Node(data);
		else if (root.data > data)
			root.left = insertNode(root.left, data);
		else
			root.right = insertNode(root.right, data);

		return root;
	}

	public static void main(String[] args) {
		KthLargestElementInBST BST = new KthLargestElementInBST();

		BST.root = new Node(50);
		BST.insertNode(BST.root, 30);
		BST.insertNode(BST.root, 20);
		BST.insertNode(BST.root, 40);
		BST.insertNode(BST.root, 50);
		BST.insertNode(BST.root, 60);
		BST.insertNode(BST.root, 70);
		BST.insertNode(BST.root, 80);
		int key = 3;
		System.out.println(BST.kthLargest(BST.root, key));
	}

}
