package datastructures.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversalOfMatrix {

	public static void main(String[] args) {
		
//		int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int matrix[][] = { { 6, 6, 2, 28, 2 }, { 12, 26, 3, 28, 7 }, { 22, 25, 3, 4, 23 } };
		for (int each : spiralOrder(matrix))
			System.out.print(each + " ");
	}

	/**
	 * This approach has a time complexity of O(rc) and spaceComplexity of O(1)
	 * 
	 * @param matrix
	 */
	public static List<Integer> spiralOrder(int[][] matrix) {

		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;

		List<Integer> ans = new ArrayList<>();

		while (rowBegin <= rowEnd && colBegin <= colEnd) {

			for (int i = colBegin; i <= colEnd; i++)
				ans.add(matrix[rowBegin][i]);

			rowBegin++;

			for (int i = rowBegin; i <= rowEnd; i++)
				ans.add(matrix[i][colEnd]);

			colEnd--;

			if (rowBegin <= rowEnd) {

				for (int i = colEnd; i >= colBegin; i--)
					ans.add(matrix[rowEnd][i]);

			}

			rowEnd--;

			if (colBegin <= colEnd) {

				for (int i = rowEnd; i >= rowBegin; i--)
					ans.add(matrix[i][colBegin]);

			}

			colBegin++;

		}

		return ans;

	}
}
