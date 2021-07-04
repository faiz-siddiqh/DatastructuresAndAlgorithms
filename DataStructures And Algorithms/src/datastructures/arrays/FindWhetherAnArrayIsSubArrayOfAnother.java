package datastructures.arrays;

import java.util.HashSet;

/**
 * Given two arrays: a1[0..n-1] of size n and a2[0..m-1] of size m. Task is to
 * check whether a2[] is a subset of a1[] or not. Both the arrays can be sorted
 * or unsorted. It may be assumed that elements in both array are distinct.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class FindWhetherAnArrayIsSubArrayOfAnother {

	public static void main(String[] args) {
		long a1[] = { 11, 1, 13, 21, 3, 7 };
		long a2[] = { 11, 3, 7, 1 };
		int n = a1.length;
		int m = a1.length;

		System.out.println(isSubset(a1, a2, n, m));
	}

	/**
	 * By using Hashing we can solve the problem with timeComplexity of O(n+m) and spaceComplexity of O(n).
	 * @param a1
	 * @param a2
	 * @param n
	 * @param m
	 * @return
	 */
	private static String isSubset(long[] a1, long[] a2, int n, int m) {

		HashSet<Long> hs = new HashSet<>();
		int i;

		for (i = 0; i < n; i++)
			hs.add(a1[i]);

		for (i = 0; i < m; i++)
			if (!hs.contains(a2[i]))
				return "No";

		return "Yes";
	}

}
