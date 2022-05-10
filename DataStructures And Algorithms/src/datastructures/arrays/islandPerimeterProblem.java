package datastructures.arrays;

/**
 * Leetcode -Problem 463 -https://leetcode.com/problems/island-perimeter/
 * 
 * @author Faiz-Siddiqh 
 * 
 * Problem Statement : You are given row x col grid representing a map where
 *         grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 * 
 *         Grid cells are connected horizontally/vertically (not diagonally).
 *         The grid is completely surrounded by water, and there is exactly one
 *         island (i.e., one or more connected land cells).
 */
public class islandPerimeterProblem {

	public static void main(String[] args) {

		int[][] matrix = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };

		System.out.println(calculateIslandPerimeter(matrix));

	}

	private static int calculateIslandPerimeter(int[][] matrix) {
		int islands = 0;
		int adjacentIsland = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {

				// If it is an island - increment the islands count and calculate the
				// adjacentislands on right and below
				if (matrix[i][j] == 1) {
					islands++;
					if (i < matrix.length - 1 && matrix[i + 1][j] == 1)
						adjacentIsland++;
					if (j < matrix[i].length - 1 && matrix[i][j + 1] == 1)
						adjacentIsland++;

				}

			}

		}

		return islands * 4 - adjacentIsland * 2;
	}

}
