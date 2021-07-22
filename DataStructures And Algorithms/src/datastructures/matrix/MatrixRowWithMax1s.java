package datastructures.matrix;

public class MatrixRowWithMax1s {

	public static void main(String[] args) {
		int mat[][] = { { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
		int R = 4;
		int C = 4;
		System.out.println("Index of row with maximum 1s is " + rowWithMax1sSol1(mat, R, C));
		System.out.println("Index of row with maximum 1s is " + rowWithMax1sSol2(mat, R, C));
	}

	private static int rowWithMax1sSol2(int[][] mat, int r, int c) {

		int maxOneIndex = -1;
		int curMax = 0;

		for (int i = 0; i < r; i++) {
			int j = c - 1;
			int max = 0;
			// if the last index of the arr is 0,then there are no 1s ,hence continue
			if (mat[i][j] == 0)
				continue;
			// keep looping till the array in the matrix has 1s
			while (j >= 0 && mat[i][j] == 1) {
				j--;
				max++;

				if (max > curMax) {
					maxOneIndex = i;
					curMax = max;
				}
			}

		}

		return maxOneIndex;
	}

	/**
	 * The time complexity of this solution is O(R*C) and space complexity of O(1)
	 * 
	 * @param mat
	 * @param R
	 * @param C
	 * @return
	 */
	private static int rowWithMax1sSol1(int[][] mat, int R, int C) {
		int maxOneIndex = -1;
		int curMax = 0;
		for (int i = 0; i < R; i++) {
			int index = traverse(mat[i], 0, C - 1);
			if (index != -1 && C - index > curMax) {
				curMax = C - index;
				maxOneIndex = i;

			}

		}

		return maxOneIndex;
	}

	private static int traverse(int[] arr, int low, int high) {

		while (low <= high) {
			int mid = low + high / 2;
			// if mid is Zero and element at mid is 1 then return mid as the elements after
			// the mid are 1s
			// or if the the element at mid-1 is zero and element at mid is 1 then return
			// mid
			if ((mid == 0 || arr[mid - 1] == 0) && arr[mid] == 1)
				return mid;

			// if the element at the mid is zero then ,1s are present in post mid in the
			// array ,hence traverse the array from mid to high
			else if (arr[mid] == 0)
				return traverse(arr, mid + 1, high);
			// else its common that the 1s are present are in first part of the array and
			// traverse the array from low to mid-1
			else
				return traverse(arr, low, mid - 1);

		}
		return -1;
	}

}
