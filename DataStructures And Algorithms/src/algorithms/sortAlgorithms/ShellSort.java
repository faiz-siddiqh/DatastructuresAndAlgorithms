package algorithms.sortAlgorithms;

/*
 * To reduce the time complexity of Insert sort algorithm.
 * If an array has some sorted elements then we can reduce the number of iterations/shifting of elements
 * This is an in-place Algorithm ,Unstable Algorithm and has Time-Complexity of O(n2) in worst case
 * 
 */
public class ShellSort {

	public static void main(String[] args) {

		int[] arr = { 20, 35, 12, -7, -22, 15, 3 };

		for (int gap = arr.length / 2; gap > 0; gap /= 2) {

			for (int i = gap; i < arr.length; i++) {
				int j = i;

				int newElement = arr[i];
				while (j >= gap && arr[j - gap] > newElement) {
					arr[j] = arr[j - gap];
					j -= gap;
				}
				arr[j] = newElement;
			}

		}

		for (int k = 0; k < arr.length; k++) {
			System.out.println(arr[k]);
		}
	}

}
