package strings;

/**
 * Given a string str we need to tell minimum characters to be added at front of
 * string to make string palindrome.
 *
 */
public class MinCharactersToAddAtFrontToMakePalindrome {

	/**
	 * Check if the string is palindrome or not
	 * 
	 * @param s
	 * @return
	 */
	private static boolean isPalindrome(String s) {
		int end = s.length() - 1;
		int start = 0;
		while (start <= end) {
			if (s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}

		return true;
	}

	public static void main(String[] args) {
		String s = "AAAABABABAA";
		int count = 0;
		int flag = 0;

		while (s.length() > 0) {
			if (isPalindrome(s)) {// if palindrome then break and print the chars to be added to make it
									// palindrome
				flag = 1;
				break;
			} else {
				count++;
				s = s.substring(0, s.length() - 1);// keep reducing the string
			}
		}
		if (flag == 1)
			System.out.println(count);

	}

}
