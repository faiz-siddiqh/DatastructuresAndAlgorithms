package strings;

public class ReverseAString {

	public static void main(String[] args) {

		String str = "Hello";
		char arr[] = str.toCharArray();

		reverse(arr);

		for (char c : arr)
			System.out.print(c + " ");

	}

	private static void reverse(char[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

}
