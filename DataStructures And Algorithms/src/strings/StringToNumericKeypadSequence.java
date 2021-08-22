package strings;

/**
 * Given a sentence in the form of a string, convert it into its equivalent
 * mobile numeric keypad sequence. Print 0 for space
 */
public class StringToNumericKeypadSequence {

	public static void main(String[] args) {
		String[] arr = { "2", "22", "222", "3", "33", "333", "4", "44", "444", "5", "55", "555", "6", "66", "666", "7",
				"77", "777", "7777", "8", "88", "888", "9", "99", "999", "9999" };
		String str = "Hello world";
		printSequence(str, arr);
	}

	private static void printSequence(String str, String[] arr) {
		str = str.toUpperCase();
		String output = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				output += "0";
			else
				output += arr[str.charAt(i) - 'A']; // the value in arr will be the value of char at the position -value
													// of A i.e 65
		}

		System.out.println(output);
	}

}
