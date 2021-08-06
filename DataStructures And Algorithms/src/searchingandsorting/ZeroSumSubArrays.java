package searchingandsorting;

import java.util.HashSet;

public class ZeroSumSubArrays {

	public static void main(String[] args) {

//		long arr[] = { 0, 0, 5, 5, 0, 0 };
		long arr[] = { 6, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		int n = arr.length;
		System.out.println(findSubarray(arr, n));
	}

	public static long findSubarray(long[] arr, int n) {

		long count = 0;
		long sum = 0;
		HashSet<Long> set = new HashSet<>();

		for (int i = 0; i < n;) {
			sum += arr[i];
			if (!set.contains(sum) && arr[i] != 0) {
				set.add(sum);
				i++;
			} else if (arr[i] == 0) {
				int j = i + 1;
				int zerosCount = 0;
				while (j < n && arr[j] == 0) {
					zerosCount++;
					j++;
				}
				if (zerosCount > 0) {
					count += zerosCount * 3;
				} else {
					count++;
				}
				i += zerosCount + 1;
			} else {
				count++;
				i++;
			}
		}
		return count;

	}

}
