package datastructures.binaryTree;

/**
 * Perform PreOrder ,PostOrder and InOrder Traversal operations for a given Binary Tree
 */
import java.util.Stack;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}
}

public class TraversalsInBinaryTree {
	Node root;

	public TraversalsInBinaryTree() {
		root = null;
	}

	/**
	 * RECURSION SOLUTIONS FOR TRAVERSALS
	 * 
	 * @param Node root
	 */
//	private static void postOrderTraversal(Node root) {
//		if (root == null)
//			return;
//
//		postOrderTraversal(root.left);
//		postOrderTraversal(root.right);
//		System.out.print(root.data);
//	}

//	private static void inOrderTraversal(Node root) {
//		if (root == null)
//			return;
//
//		inOrderTraversal(root.left);
//		System.out.print(root.data);
//		inOrderTraversal(root.right);
//	}
//
//	private static void preOrderTraversal(Node root) {
//		if (root == null)
//			return;
//
//		System.out.print(root.data);
//		preOrderTraversal(root.left);
//
//		preOrderTraversal(root.right);
//
//	}

	/**
	 * Iterative solution for traversals
	 * 
	 * @param root
	 */
	private static void inOrderTraversal(Node root) {
		if (root == null)
			return;
		Stack<Node> st = new Stack<>();
		Node cur = root;

		while (!st.isEmpty() || cur != null) {

			if (cur != null) {
				st.push(cur);
				cur = cur.left;
			} else {
				cur = st.pop();
				System.out.print(cur.data + " ");
				cur = cur.right;
			}

		}

	}

	private static void preOrderTraversal(Node root) {
		if (root == null)
			return;

		Stack<Node> st = new Stack<>();
		Node cur = root;
		st.push(cur);

		while (!st.isEmpty()) {

			cur = st.pop();
			System.out.print(cur.data + " ");
			if (cur.right != null)
				st.push(cur.right);
			if (cur.left != null)
				st.push(cur.left);

		}

	}

	private static void postOrderTraversal(Node root) {
		if (root == null)
			return;

		Stack<Node> stack = new Stack<>();
		Stack<Node> output = new Stack<>();
		stack.push(root);
		Node cur = null;
		while (!stack.isEmpty()) {

			cur = stack.pop();
			output.push(cur);

			if (cur.left != null)
				stack.push(cur.left);
			if (cur.right != null)
				stack.push(cur.right);

		}
		while (!output.isEmpty())
			System.out.print(output.pop().data + " ");
	}

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

}
