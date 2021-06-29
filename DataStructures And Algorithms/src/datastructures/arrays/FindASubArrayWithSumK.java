package datastructures.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindASubArrayWithSumK {

	/*
	 * Find if there is a subarray with K sum
	 */

	private static boolean subArrayExists(int[] arr, int k) {
		boolean found = false;
		Set<Integer> set = new HashSet<>();
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			set.add(sum);

			if (sum == 0 || set.contains(sum - k) || arr[i] == 0) {
				found = true;
				break;

			}
			if (found)
				break;
		}

		return found;
	}

	public static void main(String[] args) {
		int arr[] = { -5, 2, 3, 1, 6 };
		int k = 5;
		if (subArrayExists(arr, k))
			System.out.println("Found a Subarray with sum :"+k);
		else
			System.out.println("No Such Sub Array Exists!");
	}

}
