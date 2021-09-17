package datastructures.binaryTree;

/**
 * Given a binary tree, the task is to create a new binary tree which is a
 * mirror image of the given binary tree.
 *
 */
public class MirrorTree {

	Node root;

	public MirrorTree() {
		this.root = null;
	}

	private static Node mirror;

	/**
	 * InOrder Traversal of The Binary Tree
	 * 
	 * @param root
	 */
	private static void inOrder(Node root) {
		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);

	}

	/**
	 * Create a Mirror Binary tree
	 * 
	 * @param root
	 * @return
	 */
	private static Node mirrorifyTree(Node root) {
		if (root == null)
			return null;
		Node mirror = insertNode(root.data);
		mirror.left = mirrorifyTree(root.right);
		mirror.right = mirrorifyTree(root.left);
		return mirror;
	}

	/**
	 * Mirror a BT with O(1) space complexity
	 * 
	 * @param root
	 * @return
	 */
	private static Node mirrorify(Node root) {
		if (root == null)
			return null;
		Node left = mirrorify(root.left);
		Node right = mirrorify(root.right);

		root.right = left;
		root.left = right;

		return root;
	}

	/**
	 * Create a new Node and return the node
	 * 
	 * @param data
	 * @return
	 */
	private static Node insertNode(int data) {
		Node node = new Node(data);
		node.left = null;
		node.right = null;
		return node;
	}

	public static void main(String[] args) {
		MirrorTree tree = new MirrorTree();
		tree.root = new Node(2);
		tree.root.left = new Node(1);
		tree.root.right = new Node(4);
		tree.root.right.left = new Node(3);
		tree.root.right.right = new Node(6);
		inOrder(tree.root);
		mirror = mirrorifyTree(tree.root);
		System.out.println();
		inOrder(mirror);
	}

}
