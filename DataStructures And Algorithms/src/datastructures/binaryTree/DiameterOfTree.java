package datastructures.binaryTree;

public class DiameterOfTree {
	Node root;
	private static int result;

	public DiameterOfTree() {
		this.root = null;
	}

	int diameter(Node root) {
		if (root == null)
			return 0;

		result = Integer.MIN_VALUE; // initialise the final result as min value of integer
		findDiameter(root, result);
		return result;
	}

	/**
	 * Find the MaxDiameter of BT
	 * 
	 * @param root
	 * @param res
	 * @return
	 */
	private int findDiameter(Node root, int res) {
		if (root == null)
			return 0;

		int left = findDiameter(root.left, res);
		int right = findDiameter(root.right, res);

		int temp = Math.max(left, right) + 1; // the max of the right and left node is taken and 1 is added for the cur
												// Node
		int curMax = Math.max(temp, right + left + 1);// curMax can be the temp or the sum of the left and right node +1
		result = Math.max(result, curMax);// result would be max of result and curMax

		return temp;// return temp next Valuation/parent called method in recursion
	}

	public static void main(String[] args) {
		DiameterOfTree tree = new DiameterOfTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println(tree.diameter(tree.root));
	}

}
