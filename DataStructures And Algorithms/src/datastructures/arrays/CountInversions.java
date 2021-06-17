package datastructures.arrays;

public class CountInversions {

	public static void main(String[] args) {
		int N = 4;
		int arr[] = {8, 4, 2, 1};

		System.out.println(countInversions(arr, N));
	}

	private static int countInversions(int[] arr, int n) {

		int count = 0;

		for (int i = 0; i < n; i++) {

			int j = i + 1;

			while (j < n) {
				if (arr[i] > arr[j]) {
					count++;
					j++;
				} else
					j++;
			}

		}

		return count;
	}

}
