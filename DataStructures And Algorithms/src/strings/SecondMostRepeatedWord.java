package strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given a sequence of strings, the task is to find out the second most repeated
 * (or frequent) string in the given sequence.
 * 
 * Note: No two strings are the second most repeated, there will be always a
 * single string.
 */
public class SecondMostRepeatedWord {

	public static void main(String[] args) {
		String arr[] = { "aaa", "aaa", "ccc", "aaa", "aaa", "aaa", "aaa" };
		System.out.println(secFrequent(arr, arr.length));
	}

	static String secFrequent(String arr[], int N) {
		HashMap<String, Integer> map = new HashMap<>();

		// add all the values to the hashmap
		for (int i = 0; i < N; i++) {
			if (map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i]) + 1);
			else
				map.put(arr[i], 1);
		}

		Values val = new Values(Integer.MIN_VALUE, Integer.MIN_VALUE, "", "");

		// looping using iterator and finding the most and second most repeated values
		Iterator<Map.Entry<String, Integer>> itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, Integer> entry = itr.next();
			int v = entry.getValue();
			if (v > val.firstMax) {
				val.firstMax = v;
				val.firstMaxValue = entry.getKey();
			} else if (v > val.secondMax && v != val.firstMax) {
				val.secondMax = v;
				val.secondMaxValue = entry.getKey();
			}
		}

		// returning the second largest repeated value
		return val.secondMaxValue;
	}

}

/*
 * A class to keep a track on the first and second largest repeated values
 */
class Values {
	int firstMax;
	int secondMax;
	String firstMaxValue;
	String secondMaxValue;

	public Values(int firstMax, int secondMax, String firstMaxValue, String secondMaxValue) {
		super();
		this.firstMax = firstMax;
		this.secondMax = secondMax;
		this.firstMaxValue = firstMaxValue;
		this.secondMaxValue = secondMaxValue;
	}

}
