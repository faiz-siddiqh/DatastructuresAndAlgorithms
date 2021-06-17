package datastructures.arrays;

public class MinElementInSortedRotatedArray {

	public static void main(String[] args) {

		MinElementInSortedRotatedArray ar = new MinElementInSortedRotatedArray();

		int[] arr = { 1, 2, 3, 4, 5, 6 };
		System.out.println(ar.findMin(arr, 0, arr.length - 1));

	}

	private int findMin(int[] arr, int low, int high) {

		if (low > high)
			return arr[0];

		if (high == low)
			return arr[low];

		int mid = (low + high) / 2;

		if (mid < high && arr[mid] > arr[mid + 1])
			return arr[mid + 1];

		if (mid > low && arr[mid] < arr[mid - 1])
			return arr[mid];

		if (arr[high] > arr[mid])
			return findMin(arr, low, mid - 1);

		return findMin(arr, mid + 1, high);
	}

}
