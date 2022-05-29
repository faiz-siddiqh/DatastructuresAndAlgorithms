package datastructures.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * The next greater element of some element x in an array is the first greater
 * element that is to the right of x in the same array.
 * 
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where
 * nums1 is a subset of nums2.
 * 
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] ==
 * nums2[j] and determine the next greater element of nums2[j] in nums2. If
 * there is no next greater element, then the answer for this query is -1.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class LC_496_NextGreaterElement {

	public static void main(String[] args) {

		int[] nums1 = { 4, 1, 2 };
		int[] nums2 = { 1, 3, 4, 2 };

		for (int each : nextGreaterElement(nums1, nums2))
			System.out.println(each + " ");

	}

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

		int[] result = new int[nums1.length];
		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums2.length; i++) {

			while (!stack.isEmpty() && stack.peek() < nums2[i]) {
				map.put(stack.pop(), nums2[i]);
			}

			stack.push(nums2[i]);

		}

		for (int i = 0; i < nums1.length; i++) {
			result[i] = map.getOrDefault(nums1[i], -1);
		}

		return result;
	}

}
