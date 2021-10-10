package datastructures.binarySearchTree;

import java.util.Arrays;

import datastructures.binaryTree.Node;

/**
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 * 
 * A height-balanced binary tree is a binary tree in which the depth of the two
 * subtrees of every node never differs by more than one
 * 
 */
public class ConvertSortedArrayToBST {
	Node root;

	public ConvertSortedArrayToBST() {
		this.root = null;
	}

	/**
	 * Recursively create a BinarySearchTree from a sorted Array with diff in height
	 * of leaves !>1
	 * 
	 * @param nums
	 * @return
	 */
	private static Node sortedArrayToBST(int[] nums) {

		if (nums.length == 0)
			return null;
		if (nums.length == 1)
			return new Node(nums[0]);
		if (nums.length == 2) {
			Node node = new Node(nums[1]);
			node.left = new Node(nums[0]);
			return node;
		}
		if (nums.length == 3) {
			Node node = new Node(nums[1]);
			node.left = new Node(nums[0]);
			node.right = new Node(nums[2]);
			return node;

		}

		int mid = nums.length / 2;
		Node node = new Node(nums[mid]);
		node.left = sortedArrayToBST(Arrays.copyOf(nums, mid));
		node.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));

		return node;
	}

	/**
	 * Print pre Order Traversal of BST
	 * 
	 * @param root2
	 */
	private static void printPreOrderTraversal(Node root2) {
		if (root2 == null)
			return;
		System.out.print(root2.data + " ");
		printPreOrderTraversal(root2.left);

		printPreOrderTraversal(root2.right);

	}

	public static void main(String[] args) {
		ConvertSortedArrayToBST tree = new ConvertSortedArrayToBST();
		int[] nums = { 0, 1, 2, 3, 4, 5 };
		tree.root = sortedArrayToBST(nums);
		printPreOrderTraversal(tree.root);
	}

}
