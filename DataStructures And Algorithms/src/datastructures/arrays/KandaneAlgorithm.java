package datastructures.arrays;

public class KandaneAlgorithm {
	/*
	 * Given an array arr of N integers. Find the contiguous sub-array with maximum
	 * sum. Input: N = 5 arr[] = {1,2,3,-2,5} Output: 9
	 */

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, -2, 5 };
		int n = arr.length;
		int maxVal = kandane_Algo_2(arr, n);
		System.out.println(maxVal);
	}

	/**
	 * Implementation 1 --not applicable if the array has all negative numbers
	 * 
	 * @param arr
	 * @param n
	 */
	private static int kandane_Algo_1(int[] arr, int n) {
		int curVal = 0;
		int maxVal = 0;
		for (int i = 0; i < n; i++) {
			curVal += arr[i];
			if (curVal > maxVal)
				maxVal = curVal;

			if (curVal < 0)
				curVal = 0;
		}
		return maxVal;
	}

	/**
	 * Implementation 2 -- applicable even if the array has all negative numbers
	 * 
	 * @param arr
	 * @param n
	 */
	private static int kandane_Algo_2(int[] arr, int n) {
		int curVal = arr[0];
		int maxVal = arr[0];
		for (int i = 1; i < n; i++) {

			curVal = (arr[i] > curVal + arr[i]) ? arr[i] : curVal + arr[i];
			// curVal = Math.max(curVal, curVal + arr[i]);

			maxVal = (maxVal > curVal) ? maxVal : curVal;
			// maxVal = Math.max(curVal, maxVal);
		}
		return maxVal;
	}

}
