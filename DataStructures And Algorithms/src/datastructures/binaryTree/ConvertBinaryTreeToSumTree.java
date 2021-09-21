package datastructures.binaryTree;

/**
 * Given a Binary Tree where each node has positive and negative values. Convert
 * this to a tree where each node contains the sum of the left and right sub
 * trees in the original tree. The values of leaf nodes are changed to 0.
 *
 */
public class ConvertBinaryTreeToSumTree {
	Node root;

	public ConvertBinaryTreeToSumTree() {
		this.root = null;
	}

	public void toSumTree(Node node) {
		if (node == null)
			return;

		sum(node);

	}

	/**
	 * Traverse recursively and change the value of the nodes and return the sum of
	 * existing value and new value
	 * 
	 * @param root
	 * @return
	 */
	private static int sum(Node root) {
		if (root == null)
			return 0;

		int val = root.data;

		root.data = sum(root.left) + sum(root.right);

		return val + root.data;
	}

	private static void inOrderTraversal(Node node) {
		if (node == null)
			return;

		System.out.print(node.data + " ");
		inOrderTraversal(node.left);
		inOrderTraversal(node.right);

	}

	public static void main(String[] args) {
		ConvertBinaryTreeToSumTree tree = new ConvertBinaryTreeToSumTree();
		tree.root = new Node(10);
		tree.root.left = new Node(-2);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(8);
		tree.root.left.right = new Node(-4);
		tree.root.right.left = new Node(7);
		tree.root.right.right = new Node(5);
		inOrderTraversal(tree.root);
		System.out.println();
		tree.toSumTree(tree.root);
		inOrderTraversal(tree.root);

	}

}
