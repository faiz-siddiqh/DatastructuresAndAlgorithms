package datastructures.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindASubArrayWithSum0 {

	/*
	 * Find if there is a subarray with 0 sum
	 */

	private static boolean subArrayExists(int[] arr) {
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		
		/*
		 *    3   4   -1   4   3  -6  -7  2 
		 *  <--x-->  <----0-------->
		 *	<--------y------------->
		 *	Here the x==y ,as the sum in between is 0
		 * So the set contains 7 till X and already has 7 till we reach Y 
		 * So the sum in between that is subarray is 0
		 */
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
				/*
				 * If array contains 0 then its a subarray itself with sum 0;
				 * if set already contains the sum 
				 * else if sum==0 then return true
				 */
			if (sum == 0 || set.contains(sum) || arr[i] == 0)
				return true;

			set.add(sum);

		}

		return false;
	}

	public static void main(String[] args) {
		int arr[] = { -5, 2, 3, 4, 5 };
		if (subArrayExists(arr))
			System.out.println("Found a Subarray with 0 sum");
		else
			System.out.println("No Such Sub Array Exists!");
	}

}
