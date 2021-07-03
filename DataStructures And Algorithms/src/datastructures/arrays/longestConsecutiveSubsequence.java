package datastructures.arrays;

import java.util.Arrays;

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
		System.out.println(longestSubsequence(arr, N));

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
			if (arr[i] == arr[j]) 							// --------->1
				continue;

			// if the difference is 1,then increment count and point index to current
			// element
			if (arr[i] - arr[j] == 1) {
				curCount++; 								// --------->2
				j = i;
			}
			// if difference is not 1 ,check if the currentCount > maxCount .then set
			// curCount to 0 and point index to current element
			else {
				if (curCount > maxCount)
					maxCount = curCount; 					// ---------->3
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
