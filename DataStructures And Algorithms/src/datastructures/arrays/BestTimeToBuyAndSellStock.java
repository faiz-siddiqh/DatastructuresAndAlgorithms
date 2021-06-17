package datastructures.arrays;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		int[] arr = { 7, 1, 5, 3, 6, 4 };
		int n = arr.length;
		System.out.println(maxProfit(arr, n));
	}

	private static int maxProfit(int[] arr, int n) {

		int cost = 0;
		int maxCost = 0;
		int minPrice = arr[0];
		if (n == 0)
			return -1;

		for (int i = 0; i < arr.length - 1; i++) {

			minPrice = Math.min(minPrice, arr[i]);

			cost = arr[i] - minPrice;

			maxCost = Math.max(maxCost, cost);

		}

		return maxCost;

	}

}
