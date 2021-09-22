package datastructures.binaryTree;

/**
 * Given a binary tree in which nodes are numbered from 1 to n. Given a node and
 * a positive integer K. We have to print the Kth ancestor of the given node in
 * the binary tree. If there does not exist any such ancestor then print -1.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class PrintKthAncestorNode {
	Node root;
	private static int k;
	private static int count = 0;

	public PrintKthAncestorNode() {
		this.root = null;
	}

	/**
	 * Print the Kth ancestor of the a Node with value node
	 * 
	 * @param root2
	 * @param node
	 * @return
	 */
	private int printKthAncestor(Node root2, int node) {
		if (root2 == null)
			return -1;
		if (root2.data == node)
			return 1;

		if (printKthAncestor(root2.left, node) == 1 || printKthAncestor(root2.right, node) == 1) {
			count++;
			if (count == k)
				System.out.println(root2.data);
			return 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		PrintKthAncestorNode tree = new PrintKthAncestorNode();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(9);
		tree.root.right.left = new Node(10);
		tree.root.right.right = new Node(11);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.left.left = new Node(5);
		tree.root.left.left.left.left = new Node(6);
		tree.root.left.left.left.left.left = new Node(7);
		k = 2;
		int node = 11;
		if (tree.printKthAncestor(tree.root, node) != 1)
			System.out.println("Not found " + -1);
	}

}
