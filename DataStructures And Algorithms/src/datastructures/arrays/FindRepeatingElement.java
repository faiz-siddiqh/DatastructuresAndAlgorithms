package datastructures.arrays;

import java.util.HashMap;

/**
 * Given an array arr[] of size n, find the first repeating element. The element
 * should occurs more than once and the index of its first occurrence should be
 * the smallest.
 * 
 * 
 * @author Faiz-Siddiqh
 *
 */
public class FindRepeatingElement {

	public static void main(String[] args) {
		int[] arr = { 7, 4, 0, 9, 4, 8, 8, 2, 4, 5, 5, 1 };
		System.out.println(firstRepeated(arr, arr.length));
	}

	/**
	 * Find the first position of the repeated value in an array
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	private static int firstRepeated(int[] arr, int n) {
		HashMap<Integer, Integer> hs = new HashMap<>(); // keep track of Value and Position of a element
		int minPos = n;
		for (int i = 0; i < n; i++)
			if (hs.containsKey(arr[i])) {
				if (hs.get(arr[i]) < minPos)// update only if the pos of the repeated value < existing position of a
											// repeated element
					minPos = hs.get(arr[i]);
			} else
				hs.put(arr[i], i + 1);

		if (minPos != n)// then there is atleast one repeated value
			return minPos;

		return -1;
	}

}
