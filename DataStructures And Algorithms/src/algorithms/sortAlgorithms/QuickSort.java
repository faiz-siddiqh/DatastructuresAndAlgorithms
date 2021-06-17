package algorithms.sortAlgorithms;

public class QuickSort {

	public static void main(String[] args) {

		int arr[] = { 20, 35, -15, 7, 55, 1, -22 };

		quickSort(arr, 0, arr.length - 1);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void quickSort(int[] arr, int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1) { // Sort left half
			quickSort(arr, left, index - 1);
		}
		if (index < right) {// Sort right half
			quickSort(arr, index, right);
		}
	}

	public static int partition(int[] arr, int left, int right) {
		 int pivot = arr[(left + right) / 2];
		while (left<= right) {
		// Find element on left that should be on right
		while (arr[left] < pivot) left++;
		
		// II Find element on right that should be on left
		 while (arr[right] > pivot) right--;
		
		// II Swap elements, and move left and right indices
		 if (left<= right) {
		 swap(arr, left, right); 
		 left++;
		 right--;
		 }
		 }
		 return left;
		 }

	private static void swap(int[] arr, int start, int end) {

		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;

	}

}
