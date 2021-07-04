package datastructures.arrays;

/**
 * 
 * Rotate a given array with length n ,d times using Juggler Algorithm
 *
 */
public class ArrayRotateByJugglerAlgorithm {

	private int findGCD(int a, int b) {
		if (b == 0)
			return a;

		return findGCD(b, a % b);

	}

	private void printArray(int[] arr) {
		for (int each : arr)
			System.out.print(each + " ");

	}

	private int[] rotate(int[] arr, int d, int n) {
		int j, k, temp;
		d = d % n;
		int gcd = findGCD(d, n);

		for (int i = 0; i < gcd; i++) {

			j = i;
			temp = arr[i];
			while (true) {
				k = j + d;
				if (k >= n)
					k = k - n;

				if (k == i)
					break;

				arr[j] = arr[k];
				j = k;

			}
			arr[j] = temp;
		}
		return arr;
	}

	public static void main(String[] args) {

		ArrayRotateByJugglerAlgorithm ra = new ArrayRotateByJugglerAlgorithm();

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int rotateBy = 2;
		arr = ra.rotate(arr, rotateBy, arr.length);
		ra.printArray(arr);

	}

}
