package datastructures.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Pair {
	public int pos;
	public Node curNode;

	public Pair(int pos, Node node) {
		this.pos = pos;
		this.curNode = node;
	}
}

public class PrintTopView {
	Node root;

	public PrintTopView() {
		this.root = null;
	}

	private static ArrayList<Integer> al;

	/**
	 * Function to return a list of nodes visible from the top view from left to
	 * right in Binary Tree.
	 * 
	 * @param root
	 * @return
	 */
	static ArrayList<Integer> topView(Node root) {

		al = new ArrayList<>();
		if (root == null)
			return al;
		// this approach is a combination of Inorder traversal and vertical
		// view/traversal of BT
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(0, root));
		Map<Integer, Integer> map = new TreeMap<>();
		while (!queue.isEmpty()) {
			Pair curPair = queue.remove();
			int lev = curPair.pos;
			Node temp = curPair.curNode;
			// if the map contains the lev then its not the first element in vertical view
			if (!map.containsKey(lev))
				map.put(lev, temp.data);
			if (temp.left != null)
				queue.add(new Pair(lev - 1, temp.left));
			if (temp.right != null)
				queue.add(new Pair(lev + 1, temp.right));
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet())
			al.add(entry.getValue());

		return al;

	}

	public static void main(String[] args) {
		PrintTopView tree = new PrintTopView();
		tree.root = new Node(2);
		tree.root.left = new Node(1);
		tree.root.right = new Node(4);
		tree.root.right.left = new Node(3);
		tree.root.right.right = new Node(6);
		tree.root.left.right.left = new Node(7);

		topView(tree.root);

		for (int data : al)
			System.out.print(data + "  ");
	}

	/*
	 * static ArrayList<Integer> topView(Node root) { al = new ArrayList<>();
	 * addToAL(root.left, 1); al.add(root.data); level = 0; addToRight(root.right,
	 * 1); return al;
	 * 
	 * }
	 * 
	 * static void addToAL(Node root, int curLevel) { if (root == null) return; if
	 * (curLevel > level) { al.add(root.data); level = curLevel; }
	 * addToAL(root.left, curLevel + 1); addToAL(root.right, curLevel - 1);
	 * 
	 * }
	 * 
	 * static void addToRight(Node root, int curLevel) { if (root == null) return;
	 * if (curLevel > level) { al.add(root.data); level = curLevel; }
	 * addToRight(root.right, curLevel + 1); addToRight(root.left, curLevel - 1);
	 * 
	 * }
	 */
}
