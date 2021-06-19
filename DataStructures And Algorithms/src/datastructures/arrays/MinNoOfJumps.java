package datastructures.arrays;

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
