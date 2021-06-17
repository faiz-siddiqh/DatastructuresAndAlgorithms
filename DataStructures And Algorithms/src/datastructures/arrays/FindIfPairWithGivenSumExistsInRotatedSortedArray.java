package datastructures.arrays;

public class FindIfPairWithGivenSumExistsInRotatedSortedArray {
	// Given a sorted and rotated array, find if there is a pair with a given sum

	// Time complexity of the solution is -O(n)=O(logn)

	public static void main(String[] args) {

		FindIfPairWithGivenSumExistsInRotatedSortedArray problem = new FindIfPairWithGivenSumExistsInRotatedSortedArray();
		int[] arr = { 11, 12, 15, 4, 6, 8, 9, 10 };
		int sum = 16;

		System.out.println(problem.pairsInSortedArray(arr, sum, arr.length));

	}

	private int pairsInSortedArray(int[] arr, int sum, int n) {

		// find the pivot point in the rotated sorted array
		int i;
		for (i = 0; i < n - 1; i++)
			if (arr[i] > arr[i + 1])
				break;

		// smallest element index
		int l = (i + 1) % n;

		// largest element index
		int r = i;

		// to count total number of pairs with sum
		int count = 0;
		while (l != r) {

			if (arr[l] + arr[r] == sum) {
				count++;

				// condition to break the while loop else its a infinite loop
				if (l == (r - 1 + n) % n) {
					return count;
				}

				l = (l + 1) % n;
				r = (r - 1 + n) % n;

			}

			// if current pair sum is less,then move towards the higher sum side
			if (arr[l] + arr[r] < sum)
				l = (l + 1) % n;

			// else if current pair sum is more,then move towards the lower sum side
			else
				r = (n + r - 1) % n;

		}
		return count;
	}

}
