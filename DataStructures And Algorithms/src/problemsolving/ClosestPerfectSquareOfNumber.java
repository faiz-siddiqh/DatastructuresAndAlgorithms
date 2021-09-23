package problemsolving;

/**
 * Given a positive integer N . The task is to find the perfect square number
 * closest to N and steps required to reach this number from N.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class ClosestPerfectSquareOfNumber {
	/**
	 * Find the closest perfect square to given number
	 * 
	 * @param n
	 */
	private static void closestPerfectSquare(int n) {
		if (isPerfect(n)) {
			System.out.println("The given number is a perfect square");
			return;
		}

		int aboveN = n;
		int belowN = n;
		int num = n + 1;

		while (true) {
			if (isPerfect(num))
				break;
			else
				num++;
		}
		aboveN = num;

		num = n - 1;
		while (true) {
			if (isPerfect(num))
				break;
			else
				num--;
		}
		belowN = num;

		int diff1 = aboveN - n;
		int diff2 = n - belowN;

		if (diff1 < diff2)
			System.out.println("The perfect square near to " + n + " exists at distance " + diff1 + " = " + aboveN);
		else
			System.out.println("The perfect square near to " + n + " exists at distance " + diff2 + " = " + belowN);
	}

	/**
	 * Return true if its a perfect square number
	 * 
	 * @param n
	 * @return
	 */
	private static boolean isPerfect(int n) {
		return (Math.sqrt(n) - Math.floor(Math.sqrt(n)) == 0) ? true : false;
	}

	public static void main(String[] args) {
		int N = 133;

		closestPerfectSquare(N);
	}

}
