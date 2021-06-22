package datastructures.arrays;

import java.util.ArrayList;

/**
 * Given three arrays sorted in increasing order. Find the elements that are
 * common in all three arrays.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class CommonElements {

	public static void main(String[] args) {

		int[] A = { 3, 3, 3, 3, 3, 4, 5, 5 };
		int[] B = { 3, 3, 3, 3, 4, 4, 5, 5, 5 };
		int[] C = { 3, 3, 3, 4, 5, 5 };
		int n1 = A.length;
		int n2 = B.length;

		int n3 = C.length;

		ArrayList<Integer> list = commonElementsSol2(A, B, C, n1, n2, n3);
		// ArrayList<Integer> list = commonElementsSol3(A, B, C, n1, n2, n3);

		if (list.size() == 0)
			System.out.println(-1);
		else
			for (int i = 0; i < list.size(); i++)
				System.out.print(list.get(i) + " ");

	}

	/**
	 * Better solution with optimisation with duplicates handling but doesnt work
	 * well with large input
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param n1
	 * @param n2
	 * @param n3
	 * @return
	 */
	private static ArrayList<Integer> commonElementsSol2(int[] a, int[] b, int[] c, int n1, int n2, int n3) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		int x = 0, y = 0, z = 0;
		while (x < n1 && y < n2 && z < n3) {

			// 1.if all the elements at the respective positions are same
			if (a[x] == b[y] && b[y] == c[z]) {
				list.add(a[x++]);
				y++;
				z++;
			}

			// 2.if the element in A at x is < element in B at y
			else if (a[x] < b[y])
				x++;

			// 3.if the element in B at y is < element in C at z
			else if (b[y] < c[z])
				y++;
			// else increment z
			else
				z++;

		}
		for (int i = list.size() - 1; i > 0;)
			if (list.get(i) == list.get(i - 1))
				list.remove(i--);

			else
				i--;

		return list;
	}

	/**
	 * Not the best implementation
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @param n1
	 * @param n2
	 * @param n3
	 * @return
	 */
	static ArrayList<Integer> commonElementsSol3(int A[], int B[], int C[], int n1, int n2, int n3) {
		// code here
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < n1; i++) {

			if (binarySearch(B, 0, n2, A[i])) {

				if (binarySearch(C, 0, n3, A[i])) {
					list.add(A[i]);
				}

			}

		}

		return list;

	}

	public static boolean binarySearch(int[] arr, int start, int end, int key) {

		while (end >= start) {

			int mid = (start + end) / 2;
			if (arr[mid] == key)
				return true;

			if (arr[mid] > key)
				return binarySearch(arr, start, mid - 1, key);

			else
				return binarySearch(arr, mid + 1, end, key);
		}
		return false;

	}

}
