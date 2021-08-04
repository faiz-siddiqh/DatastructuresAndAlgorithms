package strings;

import java.util.Arrays;

public class StringIsValidShuffleOfStrings {

	/*
	 * Write a Program to check whether a string is a valid shuffle of two strings
	 * or not
	 * 
	 */
	public static void main(String[] args) {
		String first = "XY";
		String second = "12";
		String[] results = { "1XY2", "Y1X2", "Y21XX" };

		// call the method to check if result string is
		// shuffle of the string first and second
		for (String result : results) {
			if (checkLength(first, second, result) == true && shuffleCheck(first, second, result) == true) {
				System.out.println(result + " is a valid shuffle of " + first + " and " + second);
			} else {
				System.out.println(result + " is not a valid shuffle of " + first + " and " + second);
			}
		}
	}

	private static boolean shuffleCheck(String first, String second, String result) {
		result = sort(result);
		int i = 0, j = 0, k = 0;

		while (k != result.length()) {

			if (i < first.length() && first.charAt(i) == result.charAt(k))
				i++;
			else if (j < second.length() && second.charAt(j) == result.charAt(k))
				j++;
			else
				return false;

			k++;

		}

		return true;
	}

	private static String sort(String result) {

		char[] arr = result.toCharArray();
		Arrays.sort(arr);
		return String.valueOf(arr);
	}

	private static boolean checkLength(String first, String second, String result) {

		if (first.length() + second.length() == result.length())
			return true;

		return false;
	}
}
