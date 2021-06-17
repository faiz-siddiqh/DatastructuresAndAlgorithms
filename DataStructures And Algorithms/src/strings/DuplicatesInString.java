package strings;

public class DuplicatesInString {
	private static int noOfCharacters = 256;

	/*
	 * Write an efficient program to print all the duplicates and their counts in
	 * the input string
	 */
	public static void main(String[] args) {
		String str = "mathematics";
		printDuplicates(str);
	}

	private static void printDuplicates(String str) {

		int[] count = new int[noOfCharacters];

		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i)]++;
		}

		for (int i = 0; i < noOfCharacters; i++)
			if (count[i] > 1)
				System.out.println((char) i + " ,count = " + count[i]);
	}

}
