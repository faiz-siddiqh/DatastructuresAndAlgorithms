package datastructures.binaryTree;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}
}

public class TraversalsInBinaryTree {

	public TraversalsInBinaryTree() {
		root = null;
	}

	Node root;

	public static void main(String[] args) {
		TraversalsInBinaryTree tree = new TraversalsInBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		preOrderTraversal(tree.root);
		System.out.println();
		postOrderTraversal(tree.root);
		System.out.println();
		inOrderTraversal(tree.root);

	}

	private static void postOrderTraversal(Node root) {
		if (root == null)
			return;

		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data);
	}

	private static void inOrderTraversal(Node root) {
		if (root == null)
			return;

		inOrderTraversal(root.left);
		System.out.print(root.data);
		inOrderTraversal(root.right);
	}

	private static void preOrderTraversal(Node root) {
		if (root == null)
			return;

		System.out.print(root.data);
		preOrderTraversal(root.left);

		preOrderTraversal(root.right);

	}

}
