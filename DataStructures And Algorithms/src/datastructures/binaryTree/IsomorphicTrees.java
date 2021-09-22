package datastructures.binaryTree;

/**
 * Write a function to detect if two trees are isomorphic. Two trees are called
 * isomorphic if one of them can be obtained from other by a series of flips,
 * i.e. by swapping left and right children of a number of nodes. Any number of
 * nodes at any level can have their children swapped. Two empty trees are
 * isomorphic.
 * 
 */
public class IsomorphicTrees {
	Node root1;
	Node root2;

	public IsomorphicTrees() {
		this.root1 = null;
		this.root2 = null;
	}

	/**
	 * Return true if both trees are isomorphic to each other
	 * 
	 * two conditions for subtrees rooted with n1 and n2 to be isomorphic. 1) Data
	 * of n1 and n2 is same. 2) One of the following two is true for children of n1
	 * and n2 ……a) Left child of n1 is isomorphic to left child of n2 and right
	 * child of n1 is isomorphic to right child of n2. ……b) Left child of n1 is
	 * isomorphic to right child of n2 and right child of n1 is isomorphic to left
	 * child of n2.
	 * 
	 * @param root12
	 * @param root22
	 * @return
	 */
	private boolean isIsomorphic(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;

		if (root1.data != root2.data)
			return false;

		return isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right)
				|| isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left);
	}

	public static void main(String[] args) {
		IsomorphicTrees tree = new IsomorphicTrees();
		tree.root1 = new Node(1);
		tree.root1.left = new Node(2);
		tree.root1.right = new Node(3);
		tree.root1.left.left = new Node(4);
		tree.root1.left.right = new Node(5);
		tree.root1.right.left = new Node(6);
		tree.root1.left.right.left = new Node(7);
		tree.root1.left.right.right = new Node(8);

		tree.root2 = new Node(1);
		tree.root2.left = new Node(3);
		tree.root2.right = new Node(2);
		tree.root2.right.left = new Node(4);
		tree.root2.right.right = new Node(5);
		tree.root2.left.right = new Node(6);
		tree.root2.right.right.left = new Node(8);
		tree.root2.right.right.right = new Node(7);

		if (tree.isIsomorphic(tree.root1, tree.root2))
			System.out.println(1);
		else
			System.out.println(0);
	}

}
