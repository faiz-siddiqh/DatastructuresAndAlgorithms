package strings;

/**
 * 
 * 
 * Given a binary string, that is it contains only 0s and 1s. We need to make
 * this string a sequence of alternate characters by flipping some of the bits,
 * our goal is to minimize the number of bits to be flipped
 * 
 *
 */
public class MinNumOfFlipsForAlternateBinary {

	public static void main(String[] args) {
		String str = "11000101010110100";
		System.out.println(minFlips(str));

	}

	public static int minFlips(String S) {
		// return the min flips by considering the first position by either of the
		// binaries
		return Math.min(flips(S, '0'), flips(S, '1'));
	}

	public static int flips(String S, char exp) {

		int count = 0;
		char[] arr = S.toCharArray();
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] != exp)
				count++;

			exp = swap(exp);
		}

		return count;
	}

	public static char swap(char c) {
		return (c == '1') ? '0' : '1';
	}

}
