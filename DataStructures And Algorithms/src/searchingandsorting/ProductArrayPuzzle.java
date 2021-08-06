package searchingandsorting;

/*
 * Given an array nums[] of size n, construct a Product Array P (of same size n) such that P[i] is 
 * equal to the product of all the elements of nums except nums[i].
 */
public class ProductArrayPuzzle {

	public static void main(String[] args) {

		int nums[] = { 10, 3, 5, 6, 2 };
		int n = nums.length;
		long[] arr = productExceptSelf(nums, n);
		for (long i : arr)
			System.out.println(i);
	}

	/**
	 * This implementation takes O(N) space and time .
	 * 
	 * @param nums
	 * @param n
	 * @return
	 */
	public static long[] productExceptSelf(int nums[], int n) {
		long maxSum = 1;
		long[] arr = new long[n];
		// if the input array has one element then return 1
		if (n == 1) {
			arr[0] = nums[0];
			return arr;
		}

		// count stores the num of zeros in the input array
		int count = 0;
		// loop through array and find the product of the array and if element is zero
		// then increment count
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0)
				count++;
			else
				maxSum *= nums[i];
		}

		// if count =0 then there are no elements with 0 ,then the product will be
		// max/arr[i]
		if (count == 0)
			for (int i = 0; i < n; i++)
				arr[i] = maxSum / nums[i];

		// if array has 1 zero ,count ==1 then the product will be 0 at all other
		// positions and at 0 it
		// will be the maxProduct
		else if (count == 1)
			for (int i = 0; i < n; i++) {
				if (nums[i] == 0)
					arr[i] = maxSum;
				else
					arr[i] = 0;
			}

		// if array has more than one zero then it will return arr with all zeros which
		// are by default while creating the array .So it will return arr with zeros

		return arr;

	}

}
