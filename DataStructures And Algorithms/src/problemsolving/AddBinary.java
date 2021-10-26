package problemsolving;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 */
public class AddBinary {

	private static String addBinary(String a, String b) {
		String ans = "";
		int carry = 0;

		for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
			int sum = carry;
			sum += (i >= 0) ? a.charAt(i) - '0' : 0;
			sum += (j >= 0) ? b.charAt(j) - '0' : 0;
			ans += (sum % 2);
			carry = sum / 2;

		}
		if (carry != 0) {
			ans += carry;
		}

		char[] arr = ans.toCharArray();

		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;

		}

		return String.valueOf(arr);
	}

	public static void main(String[] args) {
		String a = "1010";
		String b = "1011";

		System.out.println(addBinary(a, b));
	}

}
