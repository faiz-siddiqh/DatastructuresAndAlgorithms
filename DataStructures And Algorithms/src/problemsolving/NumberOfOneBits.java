package problemsolving;

import java.util.Scanner;

/**
 * Write a function that takes an unsigned integer and returns the number of '1'
 * bits it has (also known as the Hamming weight).
 *
 */
public class NumberOfOneBits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inp = sc.nextInt();

		System.out.println(hammingWeight(inp));
	}

	private static int hammingWeight(int inp) {

		int ans = 0;

		while (inp > 0) {
			ans += (inp & 1);
			inp = (inp >>> 1);

		}
		return ans;
	}

}
