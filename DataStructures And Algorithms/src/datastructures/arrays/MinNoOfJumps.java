package datastructures.arrays;

/**
 * Given an array of N integers arr[] where each element represents the max
 * number of steps that can be made forward from that element. Find the minimum
 * number of jumps to reach the end of the array (starting from the first
 * element). If an element is 0, then you cannot move through that element.
 * 
 */
public class MinNoOfJumps {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		int n = arr.length;
		System.out.print("Minimum number of jumps to reach end is " + minJumps(arr, n));
	}

	private static int minJumps(int[] arr, int n) {

		if (n == 1)
			return 0;

		int i = 0;
		int count = 0;

		while (i >= 0) {
			if (i >= n - 1) {
				return count;
			}

			if (arr[i] == 0) {
				count++;
				i++;
				continue;
			}

			i += arr[i];
			count++;
		}

		return count;
	}

}
