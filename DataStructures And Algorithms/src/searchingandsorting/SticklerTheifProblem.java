package searchingandsorting;

public class SticklerTheifProblem {
	/*
	 * Stickler the thief wants to loot money from a society having n houses in a
	 * single line. He is a weird person and follows a certain rule when looting the
	 * houses. According to the rule, he will never loot two consecutive houses. At
	 * the same time, he wants to maximize the amount he loots. The thief knows
	 * which house has what amount of money but is unable to come up with an optimal
	 * looting strategy. He asks for your help to find the maximum money he can get
	 * if he strictly follows the rule. Each house has a[i] amount of money present
	 * in it.
	 */
	public static void main(String[] args) {

		int arr[] = { 5, 5, 10, 100, 10, 5 };
		int n = arr.length;
		System.out.println(findMaxSum(arr, n));

	}

	private static int findMaxSum(int[] arr, int n) {

		// if it has no elements i.e an empty arr ,return 0
		if (n == 0)
			return 0;
		// if it has only one element ,return the element
		if (n == 1)
			return arr[0];

		int[] dp = new int[n];

		dp[0] = arr[0];

		// if there are 2 homes ,then the home with max amount is to be returned.
		dp[1] = Math.max(arr[0], arr[1]);

		// if n>2 then loop from 2md house till last home
		for (int i = 2; i < n; i++)
			dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
		// sum can be max of either the sum of i-2 and ith home amount or the middle
		// home amount.

		return dp[n - 1];
	}

}
