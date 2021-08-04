package strings;

public class CountAndSay {

	/*
	 * The count-and-say sequence is a sequence of digit strings defined by the
	 * recursive formula:
	 * 
	 * countAndSay(1) = "1" countAndSay(n) is the way you would "say" the digit
	 * string from countAndSay(n-1), which is then converted into a different digit
	 * string.
	 * 
	 */
	public static void main(String[] args) {
		int n = 11;

		System.out.println(countAndSay(n));
	}

	private static String countAndSay(int n) {
		if (n == 1)
			return "1";
		if (n == 2)
			return "11";

		String str = "11";

		int count = 1;
		for (int i = 3; i <= n; i++) {
			str += "&";
			String temp = "";
			for (int j = 1; j < str.length(); j++) {

				if (str.charAt(j) == str.charAt(j - 1)) {
					count++;
				} else {
					temp += String.valueOf(count) + str.charAt(j - 1);
					count = 1;
				}
			}
			str = temp;
		}
		return str;
	}

}
