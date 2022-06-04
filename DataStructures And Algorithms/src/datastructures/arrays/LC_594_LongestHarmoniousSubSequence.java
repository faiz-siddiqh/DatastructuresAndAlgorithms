package datastructures.arrays;

import java.util.Arrays;

/**
 * We define a harmonious array as an array where the difference between its
 * maximum value and its minimum value is exactly 1.
 * 
 * Given an integer array nums, return the length of its longest harmonious
 * subsequence among all its possible subsequences.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class LC_594_LongestHarmoniousSubSequence {

	public static void main(String[] args) {

		int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };

		System.out.println(findLHS(nums));

	}

	private static int findLHS(int[] nums) {

		int maxSize = 0;

		int min = 0;

		Arrays.sort(nums);

		for (int i = 1; i < nums.length;) {

			if (nums[i] - nums[min] == 0)
				i++;
			else if (nums[i] - nums[min] == 1) {
				maxSize = Math.max(maxSize, i - min + 1);
				i++;
			} else
				min++;

		}

		return maxSize;
	}

}
