package datastructures.arrays;

/**
 * Our hero Teemo is attacking an enemy Ashe with poison attacks! When Teemo
 * attacks Ashe, Ashe gets poisoned for a exactly duration seconds. More
 * formally, an attack at second t will mean Ashe is poisoned during the
 * inclusive time interval [t, t + duration - 1]. If Teemo attacks again before
 * the poison effect ends, the timer for it is reset, and the poison effect will
 * end duration seconds after the new attack.
 * 
 * You are given a non-decreasing integer array timeSeries, where timeSeries[i]
 * denotes that Teemo attacks Ashe at second timeSeries[i], and an integer
 * duration.
 * 
 * Return the total number of seconds that Ashe is poisoned. LC - 495
 * -https://leetcode.com/problems/teemo-attacking/
 * 
 * @author Faiz-Siddiqh
 *
 */
public class LC_495_TeemoAttacking {

	public static void main(String[] args) {

		int timeSeries[] = { 1, 4, 7 };
		int duration = 3;

		System.out.println(findPoisonedDuration(timeSeries, duration));

	}

	private static int findPoisonedDuration(int[] timeSeries, int duration) {

		int sum = duration;
		for (int i = 1; i < timeSeries.length; i++) {

			sum += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);

		}

		return sum;
	}

	/**
	 * Alternate Solution
	 * 
	 * private static int findPoisonedDuration(int[] timeSeries, int duration) {
	 * 
	 * int sum = 0; for (int i = 1; i < timeSeries.length; i++) {
	 * 
	 * if (timeSeries[i] - timeSeries[i - 1] >= duration) sum += duration; else sum
	 * += timeSeries[i] - timeSeries[i - 1];
	 * 
	 * }
	 * 
	 * return sum + (timeSeries.length > 0 ? duration : 0); }
	 * 
	 **/

}
