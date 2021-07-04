package datastructures.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n and a number k, find all elements that appear more
 * than n/k times
 * 
 * @author Faiz-Siddiqh
 *
 */
public class ElementsAppearMoreThanNbyKtimes {

	public static void main(String[] args) {

		int arr[] = { 4, 5, 6, 7, 8, 4, 4 };
		int n = arr.length;
		int k = 3;
		moreThanNdK(arr, n, k);

	}

	/**
	 * time complexity =O(nk) and space complexity of O(k)
	 * 
	 * @param arr
	 * @param n
	 * @param k
	 */
	private static void moreThanNdK(int[] arr, int n, int k) {
		int x = n / k;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < n; i++) {

			// if the element is not in hashMap add to map
			if (!hm.containsKey(arr[i]))
				hm.put(arr[i], 1);
			// else if element is present ,increment the count of that element value
			else {
				int curCount = hm.get(arr[i]);
				hm.put(arr[i], curCount + 1);
			}
		}

		// iterate over the map and find the elements whose value[key-value] is > x
		for (Map.Entry m : hm.entrySet()) {

			Integer temp = (Integer) m.getValue();
			if (temp > x)
				System.out.println(m.getKey());
		}

	}

}
