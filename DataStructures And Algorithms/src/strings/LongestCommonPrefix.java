package strings;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * If there is no common prefix, return an empty string ""
 * 
 *
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {

		String[] arr = { "flower", "flow", "flight" };
		System.out.println(longestCommonPrefix(arr));
	}

	/**
	 * Scanning each element with a prefix element for common letters
	 * 
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];

		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(prefix) != 0)
				prefix = prefix.substring(0, prefix.length() - 1);
			if (prefix.isEmpty())
				return "";
		}

		return prefix;
	}

	/**
	 * Divide and conquer Approach
	 * 
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return " ";

		return lcp(strs, 0, strs.length - 1);
	}

	private static String lcp(String[] arr, int start, int end) {
		if (start == end)
			return arr[start];
		else {
			int mid = (start + end) / 2;
			String left = lcp(arr, start, mid);
			String right = lcp(arr, mid + 1, end);
			return commonPrefix(left, right);
		}

	}

	private static String commonPrefix(String left, String right) {
		int min = Math.min(left.length(), right.length());

		for (int i = 0; i < min; i++)
			if (left.charAt(i) != right.charAt(i))
				return left.substring(0, i);

		return left.substring(0, min);
	}

}
