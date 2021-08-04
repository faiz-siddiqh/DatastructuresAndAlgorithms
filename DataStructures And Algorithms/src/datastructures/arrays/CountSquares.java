package datastructures.arrays;

/*
 * Consider a sample space S consisting of all perfect squares starting from 1, 4, 9 and so on. You are given a number N, you have to output the number of integers less than N in the sample space S.
 */
public class CountSquares {

	public static void main(String[] args) {
		int n = 16;
		System.out.println(countSquares(n));
	}

	static int countSquares(int N) {
		if (N <= 1)
			return 0;
		int count = 1;

		for (int n = 2; Math.pow(n, 2) < N; n++) {
			count++;
		}
		return count;
	}
}
