package datastructures.arrays;

/**
 * Rearrange array in alternating positive & negative items with O(1) extra
 * space
 * 
 * @author Faiz-Siddiqh
 *
 */
public class ArrangeArrayWithAlternateNegAndPosNumbers {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, -4, -1, 4 };
		int n = arr.length;
		reArrange(arr, n);
		for (int z : arr)
			System.out.print(z + " ");
	}

	private static void reArrange(int[] arr, int n) {

		for (int i = 0; i < n - 1; i++) {
			int j = i + 1;

			/*
			 * If there is a postive integer at even position then find the next negative
			 * integer and rotate the array
			 */
			if (i % 2 == 0 && arr[i] >= 0) {

				while (j < n && arr[j] >= 0)
					j++;
				// if we reached end of array,then break
				if (j == n)
					break;

				rotate(arr, i, j);

			}
			/*
			 * If there is a negative integer at odd position then find the positive integer
			 * and rotate the array
			 */
			else if (arr[i] < 0 && i % 2 == 1) {
				while (j < n && arr[j] < 0)
					j++;
				if (j == n)
					break;

				rotate(arr, i, j);
			}
		}

	}

	private static void rotate(int[] arr, int i, int j) {
		int temp = arr[j];
		int k;
		// Right rotate array
		for (k = j; k > i; k--)
			arr[k] = arr[k - 1];

		arr[k] = temp;

	}

}
