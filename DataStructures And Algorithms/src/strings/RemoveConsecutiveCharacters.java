package strings;

/**
 * Given a string S delete the characters which are appearing more than once
 * consecutively.
 *
 */
public class RemoveConsecutiveCharacters {

	/**
	 * remove the adjacent characters in the string
	 * 
	 * @param S
	 * @return
	 */
	public static String removeConsecutiveCharacter(String S) {
		StringBuilder s = new StringBuilder();
		s.append(S.charAt(0));
		for (int i = 1; i < S.length(); i++) {
			if (S.charAt(i) != S.charAt(i - 1))
				s.append(S.charAt(i));
		}

		return s.toString();
	}

	public static void main(String[] args) {
		String str = "abbbccdde";
		System.out.println(removeConsecutiveCharacter(str));
	}

}
