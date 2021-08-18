package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S. The task is to print all permutations of a given string.
 *
 */
public class PermutationsInAString {
	private static List<String> arr = new ArrayList<>();

	public static void main(String[] args) {
		String str = "ABC";
		permutations(str, 0, str.length() - 1);
		for (String each : arr)
			System.out.print(each + " ");

	}

	/**
	 * A recursive function to add permutation of a string in List -time complexity
	 * of O(n!*n) and space complexity of O(N)
	 * 
	 * @param str
	 * @param i
	 * @param j
	 */
	private static void permutations(String str, int i, int j) {
		if (i == j) {
			arr.add(str);
			return;
		} else
			for (int l = i; l <= j; l++) {
				str = swap(str, i, l);
				permutations(str, i + 1, j);
				str = swap(str, i, l);
			}

	}

	/**
	 * Swap the character in a string at given indexes
	 * 
	 * @param string
	 * @param i
	 * @param l
	 * @return
	 */
	private static String swap(String string, int i, int l) {
		char[] ch = string.toCharArray();
		char temp = ch[i];
		ch[i] = ch[l];
		ch[l] = temp;
		return String.valueOf(ch);
	}

}
