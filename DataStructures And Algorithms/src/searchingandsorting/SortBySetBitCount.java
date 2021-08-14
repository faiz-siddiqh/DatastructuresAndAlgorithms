package searchingandsorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * Given an array of integers, sort the array (in descending order) according to
 * count of set bits in binary representation of array elements.
 * 
 * Note: For integers having same number of set bits in their binary
 * representation, sort according to their position in the original array i.e.,
 * a stable sort.
 *
 */
public class SortBySetBitCount {

	public static void main(String[] args) {
		Integer[] arr = { 5, 2, 3, 9, 4, 6, 7, 15, 32 };
		sortBySetBitCount(arr);
		for (Integer i : arr)
			System.out.print(i + " ");
	}

	/**
	 * This implementation has O(N.log N) time complexity with constant space
	 * complexity
	 * 
	 * @param arr
	 */
	public static void sortBySetBitCount(Integer arr[]) {

		Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int a1 = Integer.bitCount(o1);
				int a2 = Integer.bitCount(o2);
				if (a1 < a2)
					return 1;
				else if (a1 > a2)
					return -1;

				return 0;
			}

		});
	}

	/*
	 * The integers in their binary representation are : 15 - 1111 7 - 0111 5 - 0101
	 * 3 - 0011 9 - 1001 6 - 0110 2 - 0010 4 - 0100 32 - 10000 Hence the
	 * non-increasing sorted order is: {15}, {7}, {5, 3, 9, 6}, {2, 4, 32}
	 */

}
