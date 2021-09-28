package datastructures.arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array of positive integers. Find the length of the longest
 * sub-sequence such that elements in the subsequence are consecutive integers,
 * the consecutive numbers can be in any order.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class longestConsecutiveSubsequence {

	public static void main(String[] args) {

		int arr[] = { 10, 20, 21, 22, 23 };
		int N = arr.length;
		System.out.println(longestSubsequenceSol1(arr, N));

	}

	/**
	 * timeComplexity of this solution is O(logN) and space complexity of O(N) by
	 * using hashing
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	private static int longestSubsequenceSol1(int[] arr, int n) {
		if (n == 1)
			return 1;
		int ans = 1;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++)
			set.add(arr[i]);
		for (int i = 0; i < n; i++) {

			if (!set.contains(arr[i] - 1)) { // if set doesnot contain the element it means this is the first element in
												// the series/sequence

				int j = arr[i];

				while (set.contains(j)) {// check for continous sequence
					j++;
				}

				ans = Math.max(ans, j - arr[i]);// update the count

			}

		}

		return ans;
	}

	/**
	 * timeComplexity of this solution is O(NlogN)
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	private static int longestSubsequence(int[] arr, int n) {
		if (n == 1)
			return 1;
		int curCount = 0;
		int maxCount = 0;
		int j = 0;// keep a track on index of lesser succeeding number

		// Sort the array
		Arrays.sort(arr);

		for (int i = 1; i < n; i++) {
			// Check if the array has duplicates ,if the preceeding number and current
			// number are same then continue
			if (arr[i] == arr[j]) // --------->1
				continue;

			// if the difference is 1,then increment count and point index to current
			// element
			if (arr[i] - arr[j] == 1) {
				curCount++; // --------->2
				j = i;
			}
			// if difference is not 1 ,check if the currentCount > maxCount .then set
			// curCount to 0 and point index to current element
			else {
				if (curCount > maxCount)
					maxCount = curCount; // ---------->3
				curCount = 0;
				j = i;
			}

			// if there are all number with continousSequence then control comes directly
			// from 2 to here so check for this conditions
			if (curCount > maxCount)
				maxCount = curCount;

		}
		return maxCount + 1;
	}

}
