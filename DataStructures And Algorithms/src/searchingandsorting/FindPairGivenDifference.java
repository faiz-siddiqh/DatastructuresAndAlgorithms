package searchingandsorting;

import java.util.Arrays;

/*
 * Given an array Arr[] of size L and a number N, you need to write a program to find if there exists
 *  a pair of elements in the array whose difference is N.
 */
public class FindPairGivenDifference {

	public static void main(String[] args) {

		int N = 15;
		int arr[] = { 5, 20, 3, 2, 5, 80 };
		int L = arr.length;
		if (findPair(arr, L, N))
			System.out.println(1);
		else
			System.err.println(-1);
	}

	public static boolean findPair(int arr[], int size, int n) {

		Arrays.sort(arr);
		int start = 0;
		int end = 1;

		while (start < size && end < size) {
			int diff = arr[end] - arr[start];
			if (start != end && diff == n) {
				return true;
			} else if (diff < n)
				end++;
			else
				start++;
		}

		return false;
	}
}
