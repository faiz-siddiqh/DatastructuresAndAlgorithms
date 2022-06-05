package datastructures.arrays;

import java.util.Arrays;

public class LC_628_MaximumProductOfThreeNumbers {

	public static void main(String[] args) {
		int[] nums = { -710, -107, -851, 657, -14, -859, 278, -182, -749, 718, -640, 127, -930, -462, 694, 969, 143,
				309, 904, -651, 160, 451, -159, -316, 844, -60, 611, -169, -73, 721, -902, 338, -20, -890, -819, -644,
				107, 404, 150, -219, 459, -324, -385, -118, -307, 993, 202, -147, 62, -94, -976, -329, 689, 870, 532,
				-686, 371, -850, -186, 87, 878, 989, -822, -350, -948, -412, 161, -88, -509, 836, -207, -60, 771, 516,
				-287, -366, -512, 509, 904, -459, 683, -563, -766, -837, -333, 93, 893, 303, 908, 532, -206, 990, 280,
				826, -13, 115, -732, 525, -939, -787 };

		System.out.println(maximumProduct2(nums));

	}

	/**
	 * 
	 * This method has a time complexity of O(n*logn) since we are sorting thr array
	 * 
	 * @param nums -An input array with atleast 3 integers
	 * @return maxProduct
	 */
	public static int maximumProduct(int[] nums) {

		int len = nums.length - 1;

		int maxNegProd = Integer.MIN_VALUE; // to track the max prod if array has atleast 2 -ve numbers
		int maxPosProd = Integer.MIN_VALUE; // tracks the prod of last 3 [largest] nums in array

		Arrays.sort(nums);

		// If the array has atleast 2 negative nums ,then calculate the product of first
		// two least neg numbers -which will be positive and multiply with maxPositive
		// number
		maxNegProd = nums[0] * nums[1] * nums[len];

		// Else find the product of last 3 numbers of the array
		maxPosProd = nums[len] * nums[len - 1] * nums[len - 2];

		// return the max between negProd and posProd
		return Math.max(maxNegProd, maxPosProd);
	}

	/**
	 * 
	 * This method has a time complexity of O(n)
	 * 
	 * @param nums -An input array with atleast 3 integers
	 * @return maxProduct
	 */
	public static int maximumProduct2(int[] nums) {

		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;

		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;

		// loop through the array and find 3 max integers and 2 min integers

		for (int num : nums) {

			if (num > max1) {
				max3 = max2;
				max2 = max1;
				max1 = num;

			} else if (num > max2) {
				max3 = max2;
				max2 = num;
			} else if (num > max3)
				max3 = num;

			if (num < min1) {
				min2 = min1;
				min1 = num;
			} else if (num < min2)
				min2 = num;

		}
		// The maxProd would be the product of 2min numbers * 1 max number OR product of
		// 3 max Numbers

		return (max1 * max2 * max3 >= min1 * min2 * max1) ? max1 * max2 * max3 : min1 * min2 * max1;
	}

}
