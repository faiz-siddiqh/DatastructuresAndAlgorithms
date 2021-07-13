package datastructures.arrays;

public class MinSwapsToBringElementsLessKTogether {

	public static void main(String[] args) {
		int arr[] = { 2, 1,8,7,9, 5, 6, 3 ,1};
		int n = arr.length;
		int k = 7;
		System.out.print(minSwap(arr, n, k) + "\n");
	}

	public static int minSwap(int arr[], int n, int k) {
		// Complete the function
		int count = 0;
		int less = 0;
		int great = 0;
		if (n == 1) {
			return 0;
		}

		for (int i = 0; i < n; i++)
			if (arr[i] <= k)
				less++;
		for (int i = 0; i < less; i++)
			if (arr[i] > k)
				great++;

		count = great;

		for (int i = 0, j = less; j < n; i++, j++) {
			if (arr[i] > k)
				great--;

			if (arr[j] > k)
				great++;

			count = Math.min(count, great);
		}

		return count;
	}

}
