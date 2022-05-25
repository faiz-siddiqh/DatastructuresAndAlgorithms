package datastructures.arrays;

/**
 * You have a set of integers s, which originally contains all the numbers from
 * 1 to n. Unfortunately, due to some error, one of the numbers in s got
 * duplicated to another number in the set, which results in repetition of one
 * number and loss of another number.
 * 
 * Leetcode -645
 * 
 * @author Faiz-Siddiqh
 *
 */
public class SetMismatch {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 3 };

		System.out.println(findErrorNums(arr)[0] + " " + findErrorNums(arr)[1]);

	}

	private static int[] findErrorNums(int[] arr) {

		int[] result = new int[2];

		for (int i = 0; i < arr.length; i++) {

			int index = Math.abs(arr[i]) - 1;
			if (arr[index] > 0)
				arr[index] = -arr[index];
			else
				result[0] = index + 1;

		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0)
				arr[i] = -arr[i];
			else
				result[1] = i + 1;

		}

		return result;
	}

}
