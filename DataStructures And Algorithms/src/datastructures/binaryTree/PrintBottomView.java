package datastructures.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
/*
class Pair {
	public int pos;
	public Node curNode;

	public Pair(int pos, Node node) {
		this.pos = pos;
		this.curNode = node;
	}
}*/

/**
 * Given a binary tree, print the bottom view from left to right. A node is
 * included in bottom view if it can be seen when we look at the tree from
 * bottom.
 * 
 */
public class PrintBottomView {
	Node root;

	public PrintBottomView() {
		this.root = null;
	}

	private static ArrayList<Integer> arr;

	/**
	 * Function to return a list of nodes visible from the Bottom view from left to
	 * right in Binary Tree.
	 * 
	 * @param root
	 * @return
	 */
	static ArrayList<Integer> topView(Node root) {

		arr = new ArrayList<>();

		if (root == null)
			return arr;

		Queue<Pair> q = new LinkedList<>();
		Map<Integer, Integer> map = new TreeMap<>();

		q.add(new Pair(0, root));
		while (!q.isEmpty()) {
			Pair curPair = q.remove();
			int position = curPair.pos;
			Node temp = curPair.curNode;
			// keep on updating the vertical view and the last updated node in the vertical
			// lane is visible from bottom
			map.put(position, temp.data);
			if (temp.left != null)
				q.add(new Pair(position - 1, temp.left));
			if (temp.right != null)
				q.add(new Pair(position + 1, temp.right));

		}

		for (Map.Entry<Integer, Integer> data : map.entrySet())
			arr.add(data.getValue());

		return arr;

	}

	public static void main(String[] args) {
		PrintBottomView tree = new PrintBottomView();
		tree.root = new Node(2);
		tree.root.left = new Node(1);
		tree.root.right = new Node(4);
		tree.root.right.left = new Node(3);
		tree.root.right.right = new Node(6);

		topView(tree.root);

		for (int data : arr)
			System.out.print(data + "  ");
	}
}
