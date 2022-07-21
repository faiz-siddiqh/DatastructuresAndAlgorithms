package algorithms.binarySearch;

/**
 * Given an array of integers nums and an integer threshold, we will choose a
 * positive integer divisor, divide all the array by it, and sum the division's
 * result. Find the smallest divisor such that the result mentioned above is
 * less than or equal to threshold.
 * 
 * Each result of the division is rounded to the nearest integer greater than or
 * equal to that element. (For example: 7/3 = 3 and 10/2 = 5). LEETCODE :
 * -https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 * 
 * @author Faiz-Siddiqh
 *
 */
public class LC_FindSmallestDivisorGivenThreshold {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 5, 9 };
		int threshold = 6;

		System.out.println("The divisor is " + smallestDivisor(nums, threshold));
	}

	public static int smallestDivisor(int[] nums, int threshold) {

		int start = 1;
		int end = Integer.MIN_VALUE;
		int result = Integer.MAX_VALUE;
		for (int i : nums) {
			start = Math.min(start, i);
			end = Math.max(end, i);
		}

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (isValidDivisor(nums, mid, threshold)) {
				result = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}

		return result;
	}

	private static boolean isValidDivisor(int[] nums, int mid, int threshold) {

		int cur = 0;

		for (int i : nums) {
			cur += (int) Math.ceil((double)i / mid);
		}

		if (cur <= threshold)
			return true;

		return false;
	}

}
