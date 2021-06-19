package datastructures.arrays;

import java.util.HashMap;

public class CountPairsWithGivenSum {

	public static void main(String args[]) {
		int[] arr = { 1, 5, 7, -1, 5 };
		int sum = 6;
		//getPairsCountSol1(arr, sum);
		getPairsCountSol2(arr, sum);

	}

	private static void getPairsCountSol2(int[] arr, int sum) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			if (!map.containsKey(arr[i]))
				map.put(arr[i], 0);

			map.put(arr[i], map.get(arr[i]) + 1);

		}

		int count = 0;

		for (int i = 0; i < arr.length; i++) {

			if (map.get(sum - arr[i]) != null) {
				count += map.get(sum - arr[i]);
			}

			if (sum - arr[i] == arr[i])
				count--;

		}

		System.out.println(count / 2);
	}

	/*
	 * Time Complexity of O(n2)
	 */
	private static void getPairsCountSol1(int[] arr, int sum) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == sum)
					count++;

			}
		}
		System.out.println(count);

	}

}
