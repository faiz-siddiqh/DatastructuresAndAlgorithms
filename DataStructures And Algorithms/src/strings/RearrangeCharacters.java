package strings;

import java.util.*;

/**
 * Given a string S with repeated characters. The task is to rearrange
 * characters in a string such that no two adjacent characters are the same.
 * 
 */
public class RearrangeCharacters {
	public static void main(String[] args) {
		// code
		Scanner sc = new Scanner(System.in);
//		String str = sc.nextLine();
		String str = "aabbbghdfdzziz";
		System.out.println(isRearrangable(str));

	}

	/**
	 * Best approach -O(N)
	 * 
	 * @param str
	 * @return
	 */
	private static String isRearrangable(String str) {

		HashMap<Character, Integer> map = new HashMap<>();
		int maxFreq = 0;
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (map.containsKey(ch[i])) {
				map.put(ch[i], map.get(ch[i]) + 1);

				if (map.get(ch[i]) > maxFreq)
					maxFreq = map.get(ch[i]);
			} else {
				map.put(ch[i], 1);

				if (map.get(ch[i]) > maxFreq)
					maxFreq = map.get(ch[i]);
			}
		}

		if (maxFreq <= ch.length - maxFreq + 1)
			return "1";

		return "0";
	}

	/**
	 * Naive approach -partially accepted Solution
	 * 
	 * @param str
	 * @param n
	 * @return
	 */
	public static int isRearrangable(String str, int n) {

		if (n == 1)
			return 0;

		if (n == 2) {
			if (str.charAt(1) == str.charAt(0))
				return 0;
			else
				return 1;
		}

		for (int i = 1; i <= n - 1; i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				boolean flag = false;
				int j = i + 1;
				while (j < n) {
					if (str.charAt(j) != str.charAt(i)) {
						char[] c = str.toCharArray();
						char temp = c[i];
						c[i] = c[j];
						c[j] = temp;
						str = String.valueOf(c);
						flag = true;
						break;
					} else {
						j++;
					}
				}
				if (flag == false)
					return 0;
			}
		}
		System.out.println(str);
		return 1;
	}
}