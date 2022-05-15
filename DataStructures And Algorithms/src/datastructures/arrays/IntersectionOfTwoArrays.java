package datastructures.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode : Given two integer arrays nums1 and nums2, return an array of their
 * intersection. Each element in the result must appear as many times as it
 * shows in both arrays and you may return the result in any order.
 * 
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * 
 * @author Faiz-Siddiqh
 *
 */
public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		int[] nums1 = { 2, 3, 3, 1 };
		int[] nums2 = { 1, 2, 3, 3, 3, 4 };

		int[] results = intersect(nums1, nums2);

		for (int i : results)
			System.out.println(i + " ");

	}

	private static int[] intersect(int[] nums1, int[] nums2) {

		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();

		for (int i : nums1)
			if (map.containsKey(i))
				map.put(i, map.get(i) + 1);
			else
				map.put(i, 1);

		// check for values in second array and decrement their occurance
		for (int i : nums2)
			if (map.containsKey(i) && map.get(i) >= 1) {
				list.add(i);
				map.put(i, map.get(i) - 1);
			}

		int[] arr = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}

		return arr;
	}

}
