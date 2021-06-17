package datastructures.arrays;

public class QueriesOnLeftAndRightCircularArray {

	/*
	 * Given an array A of N integers. There are three type of type of commands:
	 * 
	 * 1 x : Right Circular Shift the array x times. If an array is a[0], a[1], ….,
	 * a[n – 1], then after one right circular shift the array will become a[n – 1],
	 * a[0], a[1], …., a[n – 2]. 2 y : Left Circular Shift the array y times. If an
	 * array is a[0], a[1], …., a[n – 1], then after one right circular shift the
	 * array will become a[1], …., a[n – 2], a[n – 1], a[0]. 3 l r : Print the sum
	 * of all integers in the subarray a[l…r] (l and r inclusive).
	 */
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };

		int[] query = { 3, 0, 2 };

		if (query.length == 2) {
			if (query[0] == 1) {
				rightRotate(arr, 0, query[1]);
				printArray(arr);
			} else {
				leftRotate(arr, query[1], arr.length);
				printArray(arr);
			}
		}
		if (query.length == 3)
			System.out.println(printSum(arr, query[1], query[2]));
		else
			System.out.println("Query Incorrect");

	}

	private static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static int printSum(int arr[], int query, int query2) {
		int sum = 0;
		for (int i = query; query <= query2; query++) {
			sum = sum + arr[query];
		}
		return sum;
	}

	private static void leftRotate(int arr[], int d, int n) {

		int gcd = gcd(d, n);
		int i, j, k, temp;
		for (i = 0; i < gcd; i++) {
			temp = arr[i];
			j = i;
			while (true) {
				k = j + d;
				if (k >= n) {
					k = k - n;
				}
				if (k == i) {
					break;
				}
				arr[j] = arr[k];
				j = k;

			}
			arr[j] = temp;

		}

	}

	private static int gcd(int d, int n) {
		if (n == 0) {
			return d;
		}
		return gcd(n, d % n);
	}

	private static void rightRotate(int arr[], int l, int d) {
		int n = arr.length;
		rotateArray(arr, 0, n - 1);
		rotateArray(arr, 0, d - 1);
		rotateArray(arr, d, n - 1);

	}

	private static void rotateArray(int[] arr, int start, int end) {
		int temp;
		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}

	}

}
