package algorithms.binarySearch;

/**
 * A conveyor belt has packages that must be shipped from one port to another
 * within days days.
 * 
 * The ith package on the conveyor belt has a weight of weights[i]. Each day, we
 * load the ship with packages on the conveyor belt (in the order given by
 * weights). We may not load more weight than the maximum weight capacity of the
 * ship.
 * 
 * Return the least weight capacity of the ship that will result in all the
 * packages on the conveyor belt being shipped within days days. Leetcode -
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * 
 * @author Faiz-Siddiqh
 *
 */
public class LC_CapacityToShipPackages {

	public static void main(String[] args) {

		int[] weights = { 1, 2, 3, 1, 1 };
		int days = 4;

		System.out.println("The minimum weight of the ships is " + shipWithinDays(weights, days));
	}

	private static int shipWithinDays(int[] weights, int days) {
		int result = -1;

		int max = 0;
		int sum = 0;

		for (int weight : weights) {
			max = Math.max(weight, max);
			sum += weight;
		}
		int start = max;
		int end = sum;

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (isEnoughWeight(weights, mid, days)) {
				result = (result != -1) ? Math.min(result, mid) : mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}

		return result;
	}

	/**
	 * This method validates if we can assign weights accordingly for all the days
	 * 
	 * @param weights -array of weights
	 * @param mid     - the median weight under check
	 * @param days    - the number of days to ship
	 * @return true if able to assign the weights
	 */
	private static boolean isEnoughWeight(int[] weights, int mid, int days) {

		int curSum = 0;
		int day = 1;

		for (int weigh : weights) {
			curSum += weigh;

			// If the sum exceeds mid then we assign it to next day
			if (curSum > mid) {
				curSum = weigh;
				day++;
			}

		}

		return (day <= days);
	}

}
