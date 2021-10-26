package problemsolving;

/**
 * Given a non-negative integer x, compute and return the square root of x.
 * 
 * Since the return type is an integer, the decimal digits are truncated, and
 * only the integer part of the result is returned.
 * 
 * Note: You are not allowed to use any built-in exponent function or operator,
 * such as pow(x, 0.5) or x ** 0.5.
 *
 */
public class FindSquareRoot {

	private static int printSqrt(int n) {
		if (n == 1 || n == 0)
			return n;

		int low = 1;
		int high = n / 2;

		while (low <= high) {

			int mid = (low + high) / 2;

			if ((long) mid * mid == n)
				return mid;

			else if ((long) mid * mid < n)
				low = mid + 1;

			else
				high = mid - 1;

		}

		return high;
	}

	public static void main(String[] args) {

		System.out.println(printSqrt(16));

	}

}
