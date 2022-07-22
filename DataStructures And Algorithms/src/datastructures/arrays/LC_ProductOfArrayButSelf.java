package datastructures.arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * 
 * LC-https://leetcode.com/problems/product-of-array-except-self/
 * 
 * @author Faiz-Siddiqh
 *
 */
public class LC_ProductOfArrayButSelf {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4 };

		for (int num : productExceptSelf(nums))
			System.out.print(num + " ");
	}

	/**
	 * Solution with O(1) Space complexity and O(N) TC
	 */
	private static int[] productExceptSelf(int[] nums) {

		int[] prodArray = new int[nums.length];
		prodArray[0] = 1;
		int rightProd = 1;

		for (int i = 1; i < nums.length; i++)
			prodArray[i] = prodArray[i - 1] * nums[i - 1];

		for (int i = nums.length - 2; i >= 0; i--) {
			rightProd *= nums[i + 1];
			prodArray[i] *= rightProd;
		}

		return prodArray;
	}

	/**
	 * Solution with O(n) Space complexity and O(N) TC
	 */
	private static int[] productExceptSelf2(int[] nums) {

		int[] rightProdArray = new int[nums.length];
		int[] leftProdArray = new int[nums.length];
		rightProdArray[0] = 1;
		leftProdArray[nums.length - 1] = 1;

		for (int i = 1; i < nums.length; i++)
			rightProdArray[i] = rightProdArray[i - 1] * nums[i - 1];

		for (int i = nums.length - 2; i >= 0; i--)
			leftProdArray[i] = leftProdArray[i + 1] * nums[i + 1];

		for (int i = 0; i < nums.length; i++)
			nums[i] = rightProdArray[i] * leftProdArray[i];

		return nums;
	}
}
