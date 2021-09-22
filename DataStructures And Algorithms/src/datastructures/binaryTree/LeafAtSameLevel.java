package datastructures.binaryTree;

/**
 * Given a Binary Tree, check if all leaves are at same level or not.
 *
 */
public class LeafAtSameLevel {
	Node root;
	private static int leafLevel;

	private boolean check(Node root) {
		if (root == null)
			return false;
		leafLevel = 0;
		return areLeavesAtSameLevel(root, 0);
	}

	/**
	 * recursively checks if the leafs are at same level
	 * 
	 * @param root
	 * @param level
	 * @return
	 */
	private boolean areLeavesAtSameLevel(Node root, int level) {
		if (root == null)
			return true;

		// check for leaf node and match the leafLevel with current level of node
		if (root.left == null && root.right == null) {
			if (leafLevel == 0)// if leaflevel is zero the this is the first leaf,so update it with the current
								// leaf level
				leafLevel = level;
			return leafLevel == level;
		}

		return areLeavesAtSameLevel(root.left, level + 1) && areLeavesAtSameLevel(root.right, level + 1);
	}

	public static void main(String[] args) {
		LeafAtSameLevel tree = new LeafAtSameLevel();
		tree.root = new Node(12);
		tree.root.left = new Node(5);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(9);
		tree.root.left.left.left = new Node(1);
		tree.root.left.right.left = new Node(1);
		if (tree.check(tree.root))
			System.out.println("Leaves are at same level");
		else
			System.out.println("Leaves are not at same level");

	}

}
