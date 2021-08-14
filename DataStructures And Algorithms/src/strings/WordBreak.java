package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 *Given a string A and a dictionary of n words B, find out if A can be segmented into a space-separated
 * sequence of dictionary words.
 */
public class WordBreak {

	public static void main(String[] args) {
		String[] arr = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "icecream", "man", "go",
				"mango" };
		ArrayList<String> B = new ArrayList<>(Arrays.asList(arr));
		String A = "ilike";
		System.out.println(wordBreak(A, B));
	}

	private static Set<String> set = new HashSet<>();

	public static int wordBreak(String A, ArrayList<String> B) {

		for (String each : B)
			set.add(each);

		boolean flag = isWorkBreak(A);
		if (flag == true)
			return 1;

		return 0;
	}

	private static boolean isWorkBreak(String a) {

		int size = a.length();
		if (size == 0)
			return true;

		for (int i = 1; i <= size; i++)
			if (set.contains(a.substring(0, i)) && isWorkBreak(a.substring(i, size)))
				return true;

		return false;
	}

}
