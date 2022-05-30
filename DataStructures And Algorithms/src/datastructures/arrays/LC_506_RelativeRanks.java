package datastructures.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array score of size n, where score[i] is the score
 * of the ith athlete in a competition. All the scores are guaranteed to be
 * unique.
 * 
 * The athletes are placed based on their scores, where the 1st place athlete
 * has the highest score, the 2nd place athlete has the 2nd highest score, and
 * so on. The placement of each athlete determines their rank:
 * 
 * The 1st place athlete's rank is "Gold Medal". The 2nd place athlete's rank is
 * "Silver Medal". The 3rd place athlete's rank is "Bronze Medal". For the 4th
 * place to the nth place athlete, their rank is their placement number (i.e.,
 * the xth place athlete's rank is "x").
 * 
 * Return an array answer of size n where answer[i] is the rank of the ith
 * athlete.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class LC_506_RelativeRanks {

	public static String[] findRelativeRanks(int[] score) {

		String[] results = new String[score.length];
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < score.length; i++)
			map.put(score[i], i);

		Arrays.sort(score);

		for (int i = 0; i < score.length; i++) {
			if (i == score.length - 1)
				results[map.get(score[i])] = "Gold Medal";
			else if (i == score.length - 2)
				results[map.get(score[i])] = "Silver Medal";
			else if (i == score.length - 3)
				results[map.get(score[i])] = "Bronze Medal";
			else
				results[map.get(score[i])] = String.valueOf(score.length - i );

		}

		return results;
	}

	public static void main(String[] args) {

		int[] score = { 10, 4, 8, 3, 5, 2 };

		for (String rank : findRelativeRanks(score))
			System.out.println(rank + " ");

	}

}
