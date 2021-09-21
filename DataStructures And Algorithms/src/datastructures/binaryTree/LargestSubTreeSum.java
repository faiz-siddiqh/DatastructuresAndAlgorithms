package datastructures.binaryTree;

/**
 * Given a binary tree, task is to find subtree with maximum sum in tree.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class LargestSubTreeSum {
	Node root;
	private static int maxSum = Integer.MIN_VALUE;

	public LargestSubTreeSum() {
		this.root = null;
	}

	/**
	 * Return the Sum of the tree
	 * 
	 * @param root
	 * @return
	 */
	private static int largestSubTreeSum(Node root) {
		if (root == null)
			return 0;

		int left = largestSubTreeSum(root.left);
		int right = largestSubTreeSum(root.right);
		int sum = left + right + root.data;
		if (sum >= maxSum)
			maxSum = sum;
		return sum;
	}

	public static void main(String[] args) {
		LargestSubTreeSum tree = new LargestSubTreeSum();
		tree.root = new Node(1);
		tree.root.left = new Node(-2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(-6);
		tree.root.right.right = new Node(1);

		largestSubTreeSum(tree.root);
		System.out.println(maxSum);
	}

}
