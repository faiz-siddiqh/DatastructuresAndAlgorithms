package datastructures.binaryTree;

import java.util.ArrayList;

/** VERY IMP
 * Given a Binary Tree, find its Boundary Traversal. The traversal should be in
 * the following order:
 * 
 * Left boundary nodes: defined as the path from the root to the left-most node
 * ie- the leaf node you could reach when you always travel preferring the left
 * subtree over the right subtree. Leaf nodes: All the leaf nodes except for the
 * ones that are part of left or right boundary. Reverse right boundary nodes:
 * defined as the path from the right-most node to the root. The right-most node
 * is the leaf node you could reach when you always travel preferring the right
 * subtree over the left subtree. Exclude the root from this as it was already
 * included in the traversal of left boundary nodes.
 * 
 * Note: If the root doesn't have a left subtree or right subtree, then the root
 * itself is the left or right boundary.
 * 
 *
 */
public class BoundaryTraversalOfBinaryTree {
	Node root;

	public BoundaryTraversalOfBinaryTree() {
		this.root = null;
	}

	private static ArrayList<Integer> arr;

	private ArrayList<Integer> printBoundary(Node node) {
		arr = new ArrayList<>();
		if (node == null)
			return arr;
		arr.add(node.data);
		leftView(node.left);
		bottomView(node);
		rightView(node.right);

		return arr;
	}

	/**
	 * Add all the left side Nodes to the List except the leaf node
	 * 
	 * @param node
	 */
	private void leftView(Node node) {
		if (node == null)
			return;
		// add the Nodes till the last Node before the leaves
		if (node.left != null) {
			arr.add(node.data);
			leftView(node.left);
		} else if (node.right != null) {
			arr.add(node.data);
			leftView(node.right);
		}

	}

	/**
	 * Print all the leaf nodes of the binary Tree
	 * 
	 * @param node
	 */
	private void bottomView(Node node) {
		if (node == null)
			return;
		if (node.left == null && node.right == null)
			arr.add(node.data);
		bottomView(node.left);
		bottomView(node.right);

	}

	/**
	 * Print/add all the right side/view nodes except the leaf nodes and do it in
	 * reverse as required
	 * 
	 * @param node
	 */
	private void rightView(Node node) {
		if (node == null)
			return;
		// add the Nodes till the last Node before the leaves .Here we first navigate to
		// the last Node and then add it to the list as per requirement
		if (node.right != null) {
			rightView(node.right);
			arr.add(node.data);
		} else if (node.left != null) {
			rightView(node.left);
			arr.add(node.data);
		}
	}

	public static void main(String[] args) {
		BoundaryTraversalOfBinaryTree tree = new BoundaryTraversalOfBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(7);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(4);

		tree.printBoundary(tree.root);

		for (int each : arr)
			System.out.print(each + " ");

	}
	// The idea was to print left view followed by the bottom view and then the
	// right view .
	// It takes a lot of space and partially passing test
	/*
	 * class Pairs { int pos; Node curNode;
	 * 
	 * public Pairs(int pos, Node curNode) { this.pos = pos; this.curNode = curNode;
	 * 
	 * }
	 * 
	 * } private static Stack<Integer> stack;
	 * 
	 * ArrayList<Integer> printBoundary(Node node) { arr = new ArrayList<>(); if
	 * (node == null) return arr; if (node.left == null && node.right == null) {
	 * arr.add(node.data); return arr; } stack = new Stack<Integer>();
	 * leftBoundaryAnalysis(node); bottomBoundaryAnalysis(node);
	 * rightBoundaryAnalysis(node);
	 * 
	 * while (!stack.isEmpty()) { int value = stack.pop(); if (!arr.contains(value))
	 * arr.add(value);
	 * 
	 * }
	 * 
	 * return arr; }
	 * 
	 * private void rightBoundaryAnalysis(Node root) { if (root == null) return;
	 * stack.push(root.data);
	 * 
	 * rightBoundaryAnalysis(root.right);
	 * 
	 * }
	 * 
	 * private void bottomBoundaryAnalysis(Node root) { if (root == null) return;
	 * Queue<Pairs> queue = new LinkedList<>(); Map<Integer, Integer> map = new
	 * TreeMap<>(); queue.add(new Pairs(0, root)); while (!queue.isEmpty()) { Pairs
	 * curPair = queue.remove(); int pos = curPair.pos; Node node = curPair.curNode;
	 * map.put(pos, node.data); if (node.left != null) queue.add(new Pairs(pos - 1,
	 * node.left)); if (node.right != null) queue.add(new Pairs(pos + 1,
	 * node.right));
	 * 
	 * }
	 * 
	 * for (Map.Entry<Integer, Integer> eachPair : map.entrySet()) { if
	 * (!arr.contains(eachPair.getValue())) arr.add(eachPair.getValue()); } }
	 * 
	 * private static void leftBoundaryAnalysis(Node root) { if (root == null)
	 * return; if (!arr.contains(root.data)) arr.add(root.data);
	 * 
	 * leftBoundaryAnalysis(root.left);
	 * 
	 * }
	 */

}
