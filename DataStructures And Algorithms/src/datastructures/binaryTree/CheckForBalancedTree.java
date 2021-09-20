package datastructures.binaryTree;

/**
 * Given a binary tree, find if it is height balanced or not. A tree is height
 * balanced if difference between heights of left and right subtrees is not more
 * than one for all nodes of tree.
 *
 */
public class CheckForBalancedTree {
	Node root;

	public CheckForBalancedTree() {
		this.root = null;
	}

	/**
	 * Check if the tree is Balanced
	 * 
	 * @param root
	 * @return
	 */
	boolean isBalanced(Node root) {
		if (root == null)
			return true;

		int result1 = traverse(root.left);
		int result2 = traverse(root.right);

		// the diff in height betweeen left and right subtree should be atmost 1
		if (Math.abs(result2 - result1) <= 1 && isBalanced(root.left) && isBalanced(root.right))
			return true;

		return false;

	}

	private static int traverse(Node root) {
		if (root == null)
			return 1;

		int left = traverse(root.left);
		int right = traverse(root.right);

		return (left >= right) ? left + 1 : right + 1;
	}

	public static void main(String[] args) {
		CheckForBalancedTree tree = new CheckForBalancedTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
//		tree.root.left.right = new Node(5);
		if (tree.isBalanced(tree.root))
			System.out.println(1);
		else
			System.out.println(0);

	}

}
