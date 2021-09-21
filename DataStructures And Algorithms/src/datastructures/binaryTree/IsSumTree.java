package datastructures.binaryTree;

/**
 * Given a Binary Tree. Return 1 if, for every node X in the tree other than the
 * leaves, its value is equal to the sum of its left subtree's value and its
 * right subtree's value. Else return 0.
 * 
 * An empty tree is also a Sum Tree as the sum of an empty tree can be
 * considered to be 0. A leaf node is also considered a Sum Tree.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class IsSumTree {
	Node root;

	public IsSumTree() {
		this.root = null;
	}

	/**
	 * Return true if it is a sum Tree
	 * 
	 * @param root
	 * @return
	 */
	boolean isSumTree(Node root) {
		if (root == null)
			return true;

		// if it is a leaf node return true
		if (root.left == null && root.right == null)
			return true;

		boolean isLeft = isSumTree(root.left);
		boolean isRight = isSumTree(root.right);

		int left = (root.left != null) ? root.left.data : 0;// get the value of the left node
		int right = (root.right != null) ? root.right.data : 0;// get the value of right node
		int sum = left + right;
		int val = root.data;// store the existing node value
		root.data += sum;// update the node value to sum +existing value

		// if existing value of node[val] is equal to the sum of left and right then
		// return true
		return isLeft && isRight && val == sum;
	}

	public static void main(String[] args) {
		IsSumTree tree = new IsSumTree();

		/*
		 * Testcase 1: tree.root = new Node(3); tree.root.left = new Node(1);
		 * tree.root.right = new Node(2);
		 */

		// Testcase 2:
		tree.root = new Node(62);
		tree.root.left = new Node(16);
		tree.root.right = new Node(15);
		tree.root.left.right = new Node(8);
		tree.root.left.right.right = new Node(8);
		tree.root.right.right = new Node(7);
		tree.root.right.left = new Node(4);
		tree.root.right.left.right = new Node(4);

		if (tree.isSumTree(tree.root))
			System.out.println(1);
		else
			System.out.println(0);
	}

}
