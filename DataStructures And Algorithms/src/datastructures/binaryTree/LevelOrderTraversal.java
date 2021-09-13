package datastructures.binaryTree;

class New_Node {
	int data;
	New_Node right;
	New_Node left;

	public New_Node(int data) {
		this.data = data;
	}

}

public class LevelOrderTraversal {
	New_Node root;

	public LevelOrderTraversal() {
		root = null;
	}

	/**
	 * Perform levelOrderTraversal and print the data
	 * 
	 * @param root
	 */
	private static void levelOrderTraversal(New_Node root) {
		if (root == null) {
			System.out.println("Empty Tree");
			return;
		}

		int height = findHeight(root);

		for (int i = 1; i <= height; i++)
			printLevelData(root, i);
	}

	/**
	 * Print the data at a particular level/height of a tree
	 */
	private static void printLevelData(New_Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printLevelData(root.left, level - 1);
			printLevelData(root.right, level - 1);
		}

	}

	/**
	 * Return the Height of the Binary Tree
	 * 
	 * @param root
	 * @return
	 */
	private static int findHeight(New_Node root) {
		if (root == null)
			return 0;
		else {
			int leftHeight = findHeight(root.left);
			int rightHeight = findHeight(root.right);

			return (leftHeight >= rightHeight) ? leftHeight + 1 : rightHeight + 1;

		}
	}

	public static void main(String[] args) {
		LevelOrderTraversal tree = new LevelOrderTraversal();
		tree.root = new New_Node(1);
		tree.root.left = new New_Node(2);
		tree.root.right = new New_Node(3);
		tree.root.left.left = new New_Node(4);
		tree.root.left.right = new New_Node(5);

		levelOrderTraversal(tree.root);

	}

}
