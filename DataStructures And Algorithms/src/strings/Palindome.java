package strings;

public class Palindome {

	public static void main(String[] args) {

		String str = "abbbba";
		System.out.println(isPalindome(str));
	}

	private static boolean isPalindome(String str) {

		boolean flag = true;
		char[] arr = str.toCharArray();
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			if (arr[start] != arr[end])
				return false;
			start++;
			end--;

		}
		return flag;
	}

}
