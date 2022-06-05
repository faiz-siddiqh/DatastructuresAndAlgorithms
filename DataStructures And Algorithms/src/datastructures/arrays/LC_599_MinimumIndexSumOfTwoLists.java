package datastructures.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both
 * have a list of favorite restaurants represented by strings.
 * 
 * You need to help them find out their common interest with the least list
 * index sum. If there is a choice tie between answers, output all of them with
 * no order requirement. You could assume there always exists an answer.
 * 
 * Leetcode -599- https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 * 
 * @author Faiz-Siddiqh
 *
 */
public class LC_599_MinimumIndexSumOfTwoLists {

	public String[] findRestaurant(String[] list1, String[] list2) {
		if (list2.length < list1.length)
			return findRestaurant(list2, list1);

		Map<String, Integer> map = new HashMap<>();
		List<String> results = new ArrayList<>();
		int minIndex = Integer.MAX_VALUE;
		int curIndex = minIndex;

		for (int i = 0; i < list1.length; i++)
			map.put(list1[i], i);

		for (int i = 0; i < list2.length; i++) {

			if (map.containsKey(list2[i])) {
				curIndex = map.get(list2[i]) + i;
				if (curIndex < minIndex) {
					results.clear();
					minIndex = curIndex;
				}
				results.add(list2[i]);

			}

		}

		return results.toArray(new String[0]);

	}

	public static void main(String[] args) {

		String[] list1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
		String[] list2 = { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };

		for (String eachRes : new LC_599_MinimumIndexSumOfTwoLists().findRestaurant(list1, list2))
			System.out.println(eachRes + " ");

	}

}
