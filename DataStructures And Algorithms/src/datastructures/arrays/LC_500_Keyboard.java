package datastructures.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of strings words, return the words that can be typed using
 * letters of the alphabet on only one row of American keyboard like the image
 * below.
 * 
 * In the American keyboard:
 * 
 * the first row consists of the characters "qwertyuiop", the second row
 * consists of the characters "asdfghjkl", and the third row consists of the
 * characters "zxcvbnm".
 * 
 * @author Faiz-Siddiqh
 *
 */
public class LC_500_Keyboard {

	public static void main(String[] args) {

		String[] words = { "Hello", "Alaska", "Dad", "Peace" };

		for (String word : findWords(words))
			System.out.println(word);
	}

	public static String[] findWords(String[] words) {

		List<String> result = new ArrayList<>();
		String s1 = "qwertyuiop";
		String s2 = "asdfghjkl";
		String s3 = "zxcvbnm";

		Set<Character> set1 = new HashSet<>();
		for (char c : s1.toCharArray()) {
			set1.add(c);
		}
		Set<Character> set2 = new HashSet<>();
		for (char c : s2.toCharArray()) {
			set2.add(c);
		}
		Set<Character> set3 = new HashSet<>();
		for (char c : s3.toCharArray()) {
			set3.add(c);
		}

		for (int i = 0; i < words.length; i++) {
			String curWord = words[i].toLowerCase();
			String dupWord = words[i];
			Boolean matches = false;

			if (set1.contains(curWord.charAt(0))) {

				for (int j = 0; j < curWord.length(); j++) {
					matches = (set1.contains(curWord.charAt(j))) ? true : false;
					if (!matches)
						break;

				}
			} else if (set2.contains(curWord.charAt(0))) {
				for (int j = 0; j < curWord.length(); j++) {
					matches = (set2.contains(curWord.charAt(j))) ? true : false;
					if (!matches)
						break;
				}

			} else if (set3.contains(curWord.charAt(0))) {
				for (int j = 0; j < curWord.length(); j++) {
					matches = (set3.contains(curWord.charAt(j))) ? true : false;
					if (!matches)
						break;
				}
			}

			if (matches) {
				result.add(dupWord);
			}

		}

		return result.toArray(new String[result.size()]);

	}

}
