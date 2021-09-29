package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintAnagramsTogether {
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
		
		for()
	}

}
