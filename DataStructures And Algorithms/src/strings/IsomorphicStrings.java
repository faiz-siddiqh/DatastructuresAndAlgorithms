package strings;

import java.util.Arrays;

/**
 * Two strings str1 and str2 are called isomorphic if there is a one-to-one
 * mapping possible for every character of str1 to every character of str2. And
 * all occurrences of every character in ‘str1’ map to the same character in
 * ‘str2’
 * 
 *
 */
public class IsomorphicStrings {

	private static int noOfChars = 26;

	/**
	 * check if the strings are isoMorphic -TimeComplexity of O(N)
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean areIsomorphic(String str1, String str2) {
		if (str1.length() != str2.length() || str1 == null || str2 == null)
			return false;

		int[] str1Count = new int[noOfChars];
		int[] str2Count = new int[noOfChars];

		for (int i = 0; i < str1.length(); i++) {

			str1Count[str1.charAt(i) - 'a']++;
			str2Count[str2.charAt(i) - 'a']++;

			if (str1Count[str1.charAt(i) - 'a'] != str2Count[str2.charAt(i) - 'a'])
				return false;

		}

		return true;
	}

	/**
	 * check if the strings are isoMorphic -TimeComplexity of O(N) -another method
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean areIsomorphicStrings(String str1, String str2) {
		if (str1.length() != str2.length() || str1 == null || str2 == null)
			return false;

		int[] map = new int[noOfChars];
		Arrays.fill(map, -1);
		boolean[] isMarked = new boolean[noOfChars];
		Arrays.fill(isMarked, false);

		for (int i = 0; i < str1.length(); i++) {

			if (map[str1.charAt(i) - 'a'] == -1) {

				if (isMarked[str2.charAt(i) - 'a'] == true)
					return false;

				isMarked[str2.charAt(i) - 'a'] = true;

				map[str1.charAt(i) - 'a'] = str2.charAt(i);
			} else if (map[str1.charAt(i) - 'a'] != str2.charAt(i))
				return false;

		}

		return true;
	}

	public static void main(String[] args) {

		String str1 = "aab";
		String str2 = "yyw";
		System.out.println(areIsomorphicStrings(str1, str2));
	}

}
