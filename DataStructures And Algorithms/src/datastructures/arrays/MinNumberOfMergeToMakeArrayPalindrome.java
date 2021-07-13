package datastructures.arrays;

/*
 * Find minimum number of merge operations to make an array palindrome
 */
public class MinNumberOfMergeToMakeArrayPalindrome {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 4, 5, 9, 1 };
		System.out.println("Count of minimum operations is " + findMinOps(arr, arr.length));
	}

	private static int findMinOps(int[] arr, int n) {
		int operations = 0;

		for (int i = 0, j = n - 1; i < j;) {
			if (arr[i] == arr[j]) {
				i++;
				j--;
			}
			// if the element at left is greater than the right ,then merge the left 2
			// elements
			else if (arr[i] > arr[j]) {
				j--;
				arr[j] += arr[j + 1];
				operations++;
			}
			// else if the element is greater than left then merge the 2 elements
			else {
				i++;
				arr[i] += arr[i - 1];
				operations++;
			}
		}

		return operations;
	}

}
