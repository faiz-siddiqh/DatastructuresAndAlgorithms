package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * The groups must be created in order of their appearance in the original
 * array. Look at the sample case for clarification.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class PrintAnagramsTogether {

	/**
	 * Find all the groups of anagrams in the String [] arrr and return a List of
	 * Collection of anagrams Aprrox TimeComplexity =O(N * Mlog(M)) where M is
	 * length of each string
	 * 
	 * @param arrr
	 * @return
	 */
	public static List<List<String>> Anagrams(String[] arrr) {

		List<List<String>> anagrams = new ArrayList<>();

		HashMap<String, List<String>> map = new HashMap<>();

		for (int i = 0; i < arrr.length; i++) {

			String cur = arrr[i];
			char[] arr = cur.toCharArray();
			Arrays.sort(arr);
			String str = new String(arr);

			if (map.containsKey(str)) {
				map.get(str).add(cur);
			} else {
				List<String> words = new ArrayList<>();
				words.add(cur);
				map.put(str, words);
			}

		}

		for (Map.Entry<String, List<String>> set : map.entrySet()) {
			anagrams.add(set.getValue());

		}

		return anagrams;
	}

	public static void main(String[] args) {

		String[] arr = { "act", "god", "cat", "dog", "tac" };
		List<List<String>> anagrams = Anagrams(arr);

		for (List<String> each : anagrams) {
			for (String eachAnagram : each)
				System.out.print(eachAnagram + " ");
			System.out.println();
		}
	}

}
