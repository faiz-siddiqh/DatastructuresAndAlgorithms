package datastructures.arrays;

public class FindMaximumSumOfArray {
	// Find maximum value of Sum( i*arr[i]) with only rotations on given array
	// allowed
	public static void main(String[] args) {

		FindMaximumSumOfArray ar = new FindMaximumSumOfArray();
		int arr[] = { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(ar.findMaxSum(arr, arr.length));

	}

	private int findMaxSum(int[] arr, int length) {
		int maxSum = 0;
		int i;

		for (i = 1; i < length; i++) {
			int sum = 0;

			for (int j = 0; j < arr.length; j++) {
				sum +=(j * arr[j]);
			}
			if (sum > maxSum)
				maxSum = sum;
			
			leftRotate(arr);
		}
		return maxSum;
	}

	private void leftRotate(int[] arr) {
		int temp = arr[0];
		int i;
		for (i = 0; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[i] = temp;

	}

}
