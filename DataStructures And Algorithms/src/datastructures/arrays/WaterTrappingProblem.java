package datastructures.arrays;

public class WaterTrappingProblem {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int n = arr.length;
		System.out.println(maxWater(arr, n));
		System.out.println(maxWaterCapacity(arr, n));

	}

	/**
	 * This method has timeComplexity of O(N) and constant space complexity
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	private static int maxWaterCapacity(int[] arr, int n) {
		int capacity = 0;
		int left = 0;
		int right = n - 1;

		int leftMax = 0;
		int rightMax = 0;

		while (left <= right) {
			if (rightMax <= leftMax) {
				capacity += Math.max(0, rightMax - arr[right]);
				rightMax = Math.max(rightMax, arr[right]);
				right -= 1;

			} else {
				capacity += Math.max(0, leftMax - arr[left]);
				leftMax = Math.max(leftMax, arr[left]);
				left += 1;
			}

		}

		return capacity;
	}

	/**
	 * This method has O(N) time complexity and O(N) space complexity
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	private static int maxWater(int[] arr, int n) {
		int units = 0;
		int[] left = new int[n];
		int[] right = new int[n];
		int max = 0;

		// capturing the max height of blocks from left to right
		for (int i = 0; i < n; i++) {
			left[i] = Math.max(arr[i], max);
			if (arr[i] > max)
				max = arr[i];
		}
		// capturing the max height from blocks at each point from right to left
		max = 0;
		for (int i = n - 1; i >= 0; i--) {
			right[i] = Math.max(arr[i], max);
			if (arr[i] > max)
				max = arr[i];
		}
		// finding the space to be filled by comparing the heights and subtracting the
		// block height

		for (int i = 0; i < n; i++) {

			units += Math.min(left[i], right[i]) - arr[i];

		}

		return units;
	}

}
