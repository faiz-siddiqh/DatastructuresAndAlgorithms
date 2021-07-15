package datastructures.arrays;

public class SmallestSubArrayWithSumGreaterThanX {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 4, 7, 10, 10, 8, 10 };
		int n = arr.length;
		int X = 10;
		System.out.println(smallestSubArray(arr, n, X));

	}

	public static int smallestSubArray(int arr[], int n, int x) {

		// If any element is greater than required sum,then it is the smallest
		// subarray,So return 1
		for (int i = 0; i < n; i++)
			if (arr[i] > x)
				return 1;

		int start = 0;
		int curSum = arr[0];// tracking the sum of the subArray
		int minLen = Integer.MAX_VALUE;

		for (int i = 1; i < n; i++) {

			curSum += arr[i];
			// check if curSum > x if yes then set the length of subArray and start
			// subtracting the sum from the start to find the min subArray
			while (curSum > x && start < i) {
				minLen = Math.min(minLen, i + 1 - start);
				curSum = curSum - arr[start];
				start++;
			}

		}
		return minLen;
	}
}