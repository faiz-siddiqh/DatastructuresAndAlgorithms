package datastructures.binarySearchTree;

import datastructures.binaryTree.Node;

/**
 * Given a BST and an integer K. Find the Kth Smallest element in the BST.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class KthSmallesttElementInBST {
	Node root;

	public KthSmallesttElementInBST() {
		this.root = null;
	}

	private static int count;
	private static int ans;

	/**
	 * Return Kth Smallest Element in the BST
	 * 
	 * @param root
	 * @param K
	 * @return
	 */
	public int kthSmallest(Node root, int K) {
		if (root == null)
			return 0;
		ans = -1;
		count = 0;

		findSmallest(root, K);

		return ans;
	}

	/**
	 * Recursively traverse in inOrder way and count and find the largest number in
	 * BST
	 * 
	 * @param root
	 * @param K
	 */
	public static void findSmallest(Node root, int K) {
		if (root == null)
			return;

		findSmallest(root.left, K);
		count++;
		if (count == K) {
			ans = root.data;
			return;
		}
		findSmallest(root.right, K);

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
		KthSmallesttElementInBST BST = new KthSmallesttElementInBST();

		BST.root = new Node(50);
		BST.insertNode(BST.root, 30);
		BST.insertNode(BST.root, 20);
		BST.insertNode(BST.root, 40);
		BST.insertNode(BST.root, 50);
		BST.insertNode(BST.root, 60);
		BST.insertNode(BST.root, 70);
		BST.insertNode(BST.root, 80);
		int key = 3;
		System.out.println(BST.kthSmallest(BST.root, key));
	}

}
