package datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem link - 118 -https://leetcode.com/problems/pascals-triangle/
 * @author Faiz-Siddiqh
 *
 */
public class PascalTriangle {

	public static void main(String[] args) {

		int n = 7;

		System.out.println(generate(n));

	}

	public static List<List<Integer>> generate(int numRows) {

		List<List<Integer>> allRows = new ArrayList<>();
		List<Integer> eachRow = new ArrayList<>();
		// if numRows==1
		eachRow.add(1);
		allRows.add(eachRow);
		if (numRows == 1)
			return allRows;

		// if numRows==2
		eachRow = new ArrayList<>();
		eachRow.add(1);
		eachRow.add(1);
		allRows.add(eachRow);
		if (numRows == 2)
			return allRows;

		for (int i = 3; i <= numRows; i++) {
			eachRow = new ArrayList<Integer>();
			eachRow.add(1);

			List<Integer> previousRow = allRows.get(i - 2);

			for (int j = 0; j < previousRow.size() - 1; j++) {
				int sum = previousRow.get(j) + previousRow.get(j + 1);
				eachRow.add(sum);
			}

			eachRow.add(1);
			allRows.add(eachRow);

		}

		return allRows;
	}
}