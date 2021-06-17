package datastructures.arrays;

public class RearrangeArray {

	public static void main(String[] args) {

		/*
		 * Rearrange array such that arr[i] =i if not arr[i]=-1 i Input : arr[] = {-1,
		 * -1, 6, 1, 9, 3, 2, -1, 4, -1 } Output : -1 1 2 3 4 -1 6 -1 -1 9
		 */
		int[] arr = { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };

		rearrange(arr, arr.length);
		for (int i : arr) {
			System.out.print(i + "  ");
		}
	}

	private static void rearrange(int[] arr, int n) {
		int i = 0;
		while (i < n) {
			while (arr[i] != i && arr[i] >= 0) {
				swap(arr, i, arr[i]);
			}
			i++;
		}

	}

	private static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
