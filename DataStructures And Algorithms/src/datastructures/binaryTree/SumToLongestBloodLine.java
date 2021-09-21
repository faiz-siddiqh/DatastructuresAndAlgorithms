package datastructures.binaryTree;

/**
 * IMP :Given a binary tree containing n nodes. The problem is to find the sum
 * of all nodes on the longest path from root to leaf node. If two or more paths
 * compete for the longest path, then the path having maximum sum of nodes is
 * being considered.
 *
 */
public class SumToLongestBloodLine {
	Node root;

	public SumToLongestBloodLine() {
		this.root = null;
	}

	private static int maxSum;
	private static int maxLen;

	public int sumOfLongRootToLeafPath(Node root) {

		if (root == null)
			return 0;

		maxLen = 0;
		maxSum = Integer.MIN_VALUE;

		calSum(root, 0, 0);

		return maxSum;
	}

	/**
	 * recursive traversal and calculation of maxSum od BT
	 * 
	 * @param root
	 * @param sum
	 * @param len
	 */
	private void calSum(Node root, int sum, int len) {
		if (root == null) {
			if (maxLen < len) {// if len is greater than maxLen then change the len and sum even if sum<maxSum
				maxLen = len;
				maxSum = sum;
			} else if (maxLen == len && maxSum < sum)
				maxSum = sum;
			return;
		}
		// keep on traversing till end node by incrementing len and sum
		calSum(root.left, sum + root.data, len + 1);
		calSum(root.right, sum + root.data, len + 1);
	}

	public static void main(String[] args) {
		SumToLongestBloodLine tree = new SumToLongestBloodLine();
		tree.root = new Node(0);
		tree.root.right = new Node(7);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(10);
		tree.root.right.left.left = new Node(2);
		tree.root.right.right.left = new Node(9);
		tree.root.right.left.left.right = new Node(3);
		tree.root.right.left.left.right.right = new Node(5);
		tree.root.right.left.left.right.right.left = new Node(4);
		tree.root.right.right.left.left = new Node(8);
		System.out.println(tree.sumOfLongRootToLeafPath(tree.root));
	}

}
