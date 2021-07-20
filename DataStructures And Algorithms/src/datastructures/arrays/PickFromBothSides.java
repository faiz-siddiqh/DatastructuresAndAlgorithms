package datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class PickFromBothSides {

	public static void main(String[] args) {
		int[] arr = { -533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173,
				436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701,
				35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277,
				741, 529, -222, -684, 35 };
		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			A.add(arr[i]);
		}

		int B = 48;
		System.out.println(solve(A, B));
		System.out.println(maxSum(A, B));
	}

	/**
	 * Optimised Solution
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	private static int maxSum(ArrayList<Integer> A, int B) {
		int n = A.size();

		int result = 0;

		for (int i = 0; i < B; i++) {
			result += A.get(i);
		}

		int sum = result;

		for (int i = 0; i < B; i++) {
			sum -= A.get(B - 1 - i);
			sum += A.get(n - 1 - i);

			result = Math.max(result, sum);
		}

		return result;
	}

	/**
	 * There is a bug in the solution and is only for reference
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static int solve(ArrayList<Integer> A, int B) {
		int maxSum = 0;
		int start = 0;
		int end = A.size() - 1;
		int i;
		int curSum = 0;

		// getting sum of numbers till B
		for (i = 0; i < B; i++) {
			curSum += A.get(i);
		}
		maxSum = Math.max(maxSum, curSum);
		curSum = 0;

		// calculating sum from back of the array B times and comparing it with maxValue
		// and assigning to MaxValue if its greater than existing value
		i = A.size() - 1;
		for (int j = 0; j < B; j++) {
			curSum += A.get(i--);
		}
		maxSum = Math.max(maxSum, curSum);
		curSum = 0;

		// calculating sum from picking from start and end of array which ever element
		// at that position is greater
		while (B > 0 && start < end) {
			if (A.get(start) > A.get(end)) {
				curSum += A.get(start);
				start++;
				B--;
			} else {
				curSum += A.get(end);
				end--;
				B--;
			}
		}

		return Math.max(maxSum, curSum);

	}

}
