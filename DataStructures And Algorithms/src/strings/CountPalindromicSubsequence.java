package strings;

public class CountPalindromicSubsequence {

	public static void main(String[] args) {
		String str = "aab";
		System.out.println(countPS(str));
	}

	private static long count;

	/**
	 * Not all testcases are passing -- to be improvised
	 * 
	 * @param str
	 * @return
	 */
	private static long countPS(String str) {
		count = str.length();

		for (int i = 1; i < str.length(); i++)
			recursiveCount(str.substring(0, i));

		return count;
	}

	private static void recursiveCount(String str) {
		if (str.length() <= 1)
			return;
		if (isRecursive(str))
			count++;

		recursiveCount(str.substring(0, str.length() - 1));

	}

	private static boolean isRecursive(String str) {
		char[] arr = str.toCharArray();
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			if (arr[start] != arr[end])
				return false;
			start++;
			end--;
		}

		return true;
	}

}
