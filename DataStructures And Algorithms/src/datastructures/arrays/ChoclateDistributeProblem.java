package datastructures.arrays;

import java.util.*;

/**
 * Given an array of n integers where each value represents the number of
 * chocolates in a packet. Each packet can have a variable number of chocolates.
 * There are m students, the task is to distribute chocolate packets such that:
 * 
 * Each student gets one packet. The difference between the number of chocolates
 * in the packet with maximum chocolates and packet with minimum chocolates
 * given to the students is minimum.
 * 
 *
 */
public class ChoclateDistributeProblem {

	public static void main(String[] args) {
		int arr[] = { 12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50 };

		int m = 7; // Number of students

		int n = arr.length;
		System.out.println("Minimum difference is " + findMinDiff(arr, n, m));

	}

	public static int findMinDiff(int[] a, int n, int m) {
		int minDiff = Integer.MAX_VALUE;
		int curDiff = 0;
		Arrays.sort(a);
		for (int i = 0; i <= n - m; i++) {
			curDiff = a[i + m - 1] - a[i];
			if (curDiff < minDiff)
				minDiff = curDiff;
		}

		return minDiff;
	}
}
