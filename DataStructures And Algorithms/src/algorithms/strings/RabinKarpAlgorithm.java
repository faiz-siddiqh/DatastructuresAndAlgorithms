package algorithms.strings;

/**
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function
 * search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[].
 * You may assume that n > m.
 */
public class RabinKarpAlgorithm {

	private static void search(String pat, String txt) {
		int n = txt.length();
		int m = pat.length();
		int i = 0;
		int j = 0;
		int hashcode = 0;// hashcode of the pattern
		int hash = 0;// hashcode of the each text loop
		int count = 0;
		int divisor = 101;// any prime number

		// calculate the hashcode for the pattern
		for (i = 0; i < m; i++)
			hashcode += pat.charAt(i) * Math.pow(10, count++);

		hashcode %= divisor;// reduce the hashcode to int

		// loop through the text and find if there exists a pattern with the hashcode
		for (j = 0; j <= n - m; j++) {

			hash = 0;
			count = 0;
			// calculate the hashcode of definite length of the text
			for (i = j; i < j + m; i++)
				hash += txt.charAt(i) * Math.pow(10, count++);

			hash %= divisor; // reduce the hashcode

			// check if the pattern exits and hashcode matches
			if (hashcode == hash)
				System.out.println("Pattern found at index " + j);
		}

	}

	public static void main(String[] args) {

		String txt = "AABAACAADAABAA BAABBAABAAABAAABAAAAABA";
		String pat = "AABA";

		search(pat, txt);

	}

}
