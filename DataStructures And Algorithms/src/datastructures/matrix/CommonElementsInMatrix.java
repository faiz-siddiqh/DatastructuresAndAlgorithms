package datastructures.matrix;

import java.util.HashMap;

public class CommonElementsInMatrix {

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 1, 4, 8 }, { 3, 7, 8, 5, 1 }, { 8, 7, 7, 3, 1 }, { 8, 1, 2, 7, 9 }, };
		int M = 4;
		int N = 5;
		printCommonElements(mat, M, N);
	}

	/**
	 * Time complexity of this method is O(N)
	 * 
	 * @param mat
	 * @param m
	 * @param n
	 */
	private static void printCommonElements(int[][] mat, int m, int n) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++)
			map.put(mat[0][i], 1);

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (map.get(mat[i][j]) != null && map.get(mat[i][j]) == i) {
					map.put(mat[i][j], i + 1);

					if (i == m - 1)
						System.out.println(mat[i][j] + " ");
				}

			}

		}
	}

}
