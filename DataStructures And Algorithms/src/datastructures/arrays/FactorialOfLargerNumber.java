package datastructures.arrays;

import java.util.ArrayList;

public class FactorialOfLargerNumber {

	public static void main(String[] args) {
		int n = 5;

		// findFactorialUsingArray(n);
		ArrayList<Integer> al = findFactorialUsingArrayList(n);
		for (int j = al.size() - 1; j >= 0; j--)
			System.out.print(al.get(j));

	}

	/**
	 * This method is using ArrayList ,with Time Complexity of O(N) and space
	 * complexity of O(1)
	 * 
	 * @param n
	 * @return
	 */
	private static ArrayList<Integer> findFactorialUsingArrayList(int n) {
		ArrayList<Integer> al = new ArrayList<Integer>();

		int x = 0;
		int num = 1;
		int len = 1;
		al.add(num);

		for (int i = 2; i <= n; i++) {
			int carry = 0;
			x = 0;

			while (x < len) {
				num = al.get(x);
				num = (num * i) + carry;
				carry = num / 10;
				num %= 10;
				al.set(x, num);

				x++;

			}
			while (carry != 0) {
				num = carry % 10;
				al.add(len, num);
				carry /= 10;
				len++;
			}

		}
		return al;

	}

	/**
	 * This implementation takes O(N) time complexity and space complexity of O(N)
	 * 
	 * @param n
	 */
	private static void findFactorialUsingArray(int n) {

		int[] arr = new int[500];
		int x = 0;
		int len = 1;
		int carry = 0;
		arr[x] = 1;

		for (int i = 2; i <= n; i++) {
			x = 0;
			carry = 0;

			while (x < len) {
				arr[x] *= i;
				arr[x] += carry;
				carry = arr[x] / 10;
				arr[x] %= 10;
				x++;
			}
			while (carry != 0) {
				arr[len] = carry % 10;
				carry /= 10;
				len++;
			}
		}

		for (int j = len - 1; j >= 0; j--) {
			System.out.print(arr[j]);
		}

	}

}
