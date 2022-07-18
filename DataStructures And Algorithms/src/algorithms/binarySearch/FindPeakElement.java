package algorithms.binarySearch;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 * 
 * Given a 0-indexed integer array nums, find a peak element, and return its
 * index. If the array contains multiple peaks, return the index to any of the
 * peaks.
 * 
 * In other words, an element is always considered to be strictly greater than a
 * neighbor that is outside the array.
 * 
 * You must write an algorithm that runs in O(log n) time. Leetcode -162 -
 * https://leetcode.com/problems/find-peak-element/
 * 
 * @author Faiz-Siddiqh
 *
 */
public class FindPeakElement {

	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 1 };

		System.out.println(findPeakElement(nums));
	}

	/**
	 * This method is used to find the index of peak element in an array
	 * 
	 * @param nums - the array to be validated
	 * @return index of peak array if exists
	 */
	private static int findPeakElement(int[] nums) {

		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {

			if (start == end)
				return start;

			int mid = start + (end - start) / 2;

			// if the mid is greater than preceeding and succeeding element - return mid
			if (mid > start && mid < end) {
				if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
					return mid;
			}

			// if the array is decreasing at mid , peak should be before mid
			if (mid > start && nums[mid] < nums[mid - 1])
				end = mid - 1;
			// else if the array is increasing at id then peak must be after mid
			else if (mid < end && nums[mid] < nums[mid + 1])
				start = mid + 1;

			// else if the mid is at start and if start element is peak then return
			// start,else return next index
			else if (mid == start) {
				if (nums[mid] > nums[mid + 1])
					return mid;
				else
					return mid + 1;
			}
			// if the mid is at end and the last element is the peak then return the end
			// index
			else if (mid == end) {

				if (nums[mid] > nums[mid - 1])
					return mid;
				else
					return mid - 1;
			}

		}

		return -1; // if there is no peak element

	}

}
