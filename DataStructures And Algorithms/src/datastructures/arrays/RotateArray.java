package datastructures.arrays;

public class RotateArray {

	public int[] rotate(int[] arr, int rotateBy, int length, String direction) {

		for (int i = 0; i < rotateBy; i++) {
			if (direction.equalsIgnoreCase("left")) {
				leftRotate(arr, length);
			} else {
				rightRotate(arr, length);
			}
		}
		return arr;
	}

	private void rightRotate(int[] arr, int length) {
		int j;
		int temp = arr[arr.length - 1];
		for (j = arr.length - 1; j > 0; j--) {
			arr[j] = arr[j - 1];
		}
		arr[j] = temp;
	}

	private void leftRotate(int[] arr, int length) {
		int i;
		int temp = arr[0];
		for (i = 0; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[i] = temp;
	}

	// reversal algorithm for array Rotation
	public void reverse(int[] arr, int start, int end) {

		int temp;

		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;

		}

	}

	public void printArray(int[] arr) {
		for (int each : arr) {
			System.out.print(each + " ");
		}
	}

	public static void main(String[] args) {
		RotateArray ra = new RotateArray();
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int rotateBy = 2;
		arr = ra.rotate(arr, rotateBy, arr.length, "right");
		ra.printArray(arr);

	}

}
