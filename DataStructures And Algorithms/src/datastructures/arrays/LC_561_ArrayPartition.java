package datastructures.arrays;

/**
 * Given an integer array nums of 2n integers, group these integers into n pairs
 * (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i
 * is maximized. Return the maximized sum. 
 * 
 * Range -104 <= nums[i] <= 104
 * 
 * https://leetcode.com/problems/array-partition-i/
 * 
 * @author Faiz-Siddiqh
 *
 */
public class LC_561_ArrayPartition {

	public static int arrayPairSum(int[] nums) {

		int sum = 0;
		int range = 10000;
		// Since given range is -10000 to 10000 ,this includes 2*10000 +1 numbers

		int[] allValues = new int[2 * range + 1];

		// Iterate over the given values and increment their occurances in the buckets
		for (int eachValue : nums)
			allValues[eachValue + 10000]++;

		boolean shouldInclude = true;

		for (int i = 0; i <= 20000; i++) {

			while (allValues[i] > 0) {

				if (shouldInclude) {

					sum += i - 10000;
				}

				shouldInclude = !shouldInclude;
				allValues[i]--;

			}

		}

		return sum;

	}

	public static void main(String[] args) {

		int[] nums = { 1, 4, 3, 2 };
		System.out.println(arrayPairSum(nums));

	}

}
