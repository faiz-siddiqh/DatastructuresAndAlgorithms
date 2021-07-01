package datastructures.arrays;

/**
 * Given an array that contains both positive and negative integers, find the
 * product of the maximum product subarray. Expected Time complexity is O(n) and
 * only O(1) extra space can be used.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class MaxProdcutSubArray {

	public static void main(String[] args) {
		int[] arr = { -2, -40, 0, -2, -3 };
		int n = arr.length;

		System.out.println(maxProductSubArray(arr, n));
	}

	private static int maxProductSubArray(int[] arr, int n) {
		// if the array has only one element then return the element
		if (n == 1)
			return arr[0];

		int maxNegativeProduct = arr[0];
		int maxPositiveProduct = arr[0];
		int maxProduct = arr[0];

		for (int i = 1; i < n; i++) {

			int curMinProd = arr[i] * maxNegativeProduct;
			int curMaxProd = arr[i] * maxPositiveProduct;
			/*
			 * Find min and max product of arr[i] ,curMinProd ,curMaxProd on every loop
			 */

//			maxNegativeProduct = Math.min(arr[i], curMinProd);
			maxNegativeProduct = min(arr[i], curMinProd);
			maxNegativeProduct = Math.min(maxNegativeProduct, curMaxProd);
//			maxPositiveProduct = Math.max(arr[i], curMaxProd);
			maxPositiveProduct = max(arr[i], curMaxProd);
			maxPositiveProduct = Math.max(maxPositiveProduct, curMinProd);

			// checking if the maxProduct is not greater than first max Element or previous
			// max
			if (maxPositiveProduct > maxProduct)
				maxProduct = maxPositiveProduct;

		}

		return maxProduct;
	}

	public static int min(int x, int y) {
		return x > y ? y : x;
	}

	public static int max(int x, int y) {
		return x > y ? x : y;
	}

}
