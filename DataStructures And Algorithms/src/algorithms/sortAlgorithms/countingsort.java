package algorithms.sortAlgorithms;

/*
 * 1) Only works with non-negative discrete values .(only positive integers and not with float and Strings )
 * 2)works on data provided or on assumptions -must specify min and max values
 * 3) Not an InPlace Algorithm and has linear time complexity -O(n).
 */
public class countingsort {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 5, 4, 5, 2, 6, 7 };
		countingSort(arr, 1, 7);

		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static void countingSort(int[] arr, int min, int max) {

		int[] countArray = new int[(max - min) + 1];

		for (int i = 0; i < arr.length; i++) {
			countArray[arr[i] - min]++;
		}

		int j = 0;

		for (int i = min; i <= max; i++) {

			while (countArray[i - min] > 0) {
				arr[j++] = i;
				countArray[i - min]--;
			}
		}

	}
}
