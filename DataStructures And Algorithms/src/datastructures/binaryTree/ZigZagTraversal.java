package datastructures.binaryTree;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of
 * its nodes' values. (i.e., from left to right, then right to left for the next
 * level and alternate between).
 * 
 * @author Faiz-Siddiqh
 *
 */
public class ZigZagTraversal {
	Node root;

	public ZigZagTraversal() {
		this.root = null;
	}

	private static boolean isLeft = true;

	/**
	 * Print the Binary Tree in Zig Zag Manner --Combination of Level Order
	 * Traversal and Alternating the left And right Nodes
	 * 
	 * @param root
	 */
	private void printZigZagTraversal(Node root) {
		int height = findHeight(root);

		for (int i = 1; i <= height; i++) {
			printZigZagTraversal(root, i);
			isLeft = !isLeft;
		}
	}

	/**
	 * Return the Height of BinaryTree
	 * 
	 * @param root
	 * @return
	 */
	private int findHeight(Node root) {
		if (root == null)
			return 0;
		int left = findHeight(root.left);
		int right = findHeight(root.right);

		return (left >= right) ? left + 1 : right + 1;
	}

	/**
	 * Level order traversal of The Binary Tree
	 * 
	 * @param root
	 * @param level
	 */
	private void printZigZagTraversal(Node root, int level) {
		if (root == null)
			return;
		if (level == 1) {
			System.out.print(root.data + " ");
		} else if (isLeft) {
			printZigZagTraversal(root.left, level - 1);
			printZigZagTraversal(root.right, level - 1);
		} else {
			printZigZagTraversal(root.right, level - 1);
			printZigZagTraversal(root.left, level - 1);
		}

	}

	public static void main(String[] args) {
		ZigZagTraversal tree = new ZigZagTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(7);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(4);

		tree.printZigZagTraversal(tree.root);
	}

}
