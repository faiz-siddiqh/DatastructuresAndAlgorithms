package datastructures.binarySearchTree;

import datastructures.binaryTree.Node;

public class PredecessorAndSuccessor {
	Node root;
	Node left;
	Node right;
	private static Node pre = new Node(-1);
	private static Node succ = new Node(-1);

	public PredecessorAndSuccessor() {
		this.root = null;
		this.left = this.right = null;
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

	/**
	 * Find the Predeccesor and Successor for the given key in a BST
	 * 
	 * @param root
	 * @param key
	 */
	private static void findPreAndSucc(Node root, int key) {
		if (root == null)
			return;

		if (root.data == key) {

			if (root.left != null) {
				Node temp = root.left;
				while (temp.right != null)
					temp = temp.right;

				pre = temp;
			}
			if (root.right != null) {
				Node temp = root.right;
				while (temp.left != null)
					temp = temp.left;

				succ = temp;
			}
			return;

		}
		if (root.data > key) {
			succ = root;
			findPreAndSucc(root.left, key);
		}
		if (root.data < key) {
			pre = root;
			findPreAndSucc(root.right, key);
		}

	}

	public static void main(String[] args) {
		PredecessorAndSuccessor BST = new PredecessorAndSuccessor();
		BST.root = new Node(50);
		BST.insertNode(BST.root, 30);
		BST.insertNode(BST.root, 20);
		BST.insertNode(BST.root, 40);
		BST.insertNode(BST.root, 50);
		BST.insertNode(BST.root, 60);
		BST.insertNode(BST.root, 70);
		BST.insertNode(BST.root, 80);
		int key = 65;
		findPreAndSucc(BST.root, key);
		System.out.println(pre.data);
		System.out.println(succ.data);
	}

}
