package strings;

/**
 * Given a string s, check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class RepeatedSubstringPattern {

	public static void main(String[] args) {

		String str = "abcdabc";

		System.out.println(repeatedSubstringPattern(str));

	}

	private static boolean repeatedSubstringPattern(String str) {

		int len = str.length();
		// Since the max character that can be repeated is len/2 ,we loop from half the
		// length back to 1 and find equal repeatable substring
		for (int i = len / 2; i >= 1; i--) {
			if (len % i == 0) {
				String subStr = str.substring(0, i);
				StringBuilder sb = new StringBuilder();
				// We try to append the equal substring and validate if the string equals
				// original string
				for (int j = 0; j < len / i; j++)
					sb.append(subStr);

				if (sb.toString().equals(str))
					return true;

			}
		}

		return false;
	}

	/**
	 * Alternate approach
	 * 
	 * @param str
	 * @return
	 */
	private static boolean repeatedSubstringPattern2(String str) {

		int len = str.length();
		// Since the max character that can be repeated is len/2 ,we loop from half the
		// length back to 1 and find equal repeatable substring
		for (int i = len / 2; i >= 1; i--) {
			if (len % i == 0) {

				int j = i;
				String subStr = str.substring(0, j);
				// if there exists substring with same value then add them and validate if the
				// length equals original str len
				while (str.indexOf(subStr, j) == j)
					j += i;

				if (j == len)
					return true;

			}
		}

		return false;
	}

}
