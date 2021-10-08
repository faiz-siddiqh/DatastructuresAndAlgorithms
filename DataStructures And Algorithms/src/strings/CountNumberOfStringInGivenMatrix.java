package strings;

/**
 * Given a 2-Dimensional character array and a string, we need to find the given
 * string in 2-dimensional character array such that individual characters can
 * be present left to right, right to left, top to down or down to top.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class CountNumberOfStringInGivenMatrix {
	/**
	 * Count the occurrence of string 'search' in matrix 'arr' of length 'len'
	 * recursively
	 * 
	 * @param i
	 * @param j
	 * @param search
	 * @param arr
	 * @param length
	 * @param index
	 * @return
	 */
	private static int solve(int i, int j, String search, char[][] arr, int length, int index) {
		int found = 0;

		if (i >= 0 && j >= 0 && i < arr.length && j < arr.length && search.charAt(index) == arr[i][j]) {
			char temp = search.charAt(index);
			arr[i][j] = 0; // we are turning this char value as 0 so as not to loop again same char
			index += 1;
			if (index == length) {
				found = 1;
			} else {
				found += solve(i, j + 1, search, arr, length, index);// look for next char on right
				found += solve(i - 1, j, search, arr, length, index);// look for next char on left
				found += solve(i, j - 1, search, arr, length, index);// look for next char on top
				found += solve(i + 1, j, search, arr, length, index);// look for next char down the matrix recursively

			}

			arr[i][j] = temp; // backtracking the values to original value which were changed to 0

		}

		return found;
	}

	public static void main(String[] args) {

		char[][] arr = { { 'B', 'B', 'A', 'B', 'B', 'M' }, { 'C', 'B', 'M', 'B', 'B', 'A' },
				{ 'I', 'B', 'A', 'B', 'B', 'G' }, { 'G', 'O', 'Z', 'B', 'B', 'I' }, { 'A', 'B', 'B', 'B', 'B', 'C' },
				{ 'M', 'C', 'I', 'G', 'A', 'M' } };
		String search = "MAGIC";
		int len = arr.length;
		int found = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				found += solve(i, j, search, arr, search.length(), 0);
			}
		}

		System.out.println("The number of Appearence of the word are :" + found);

	}

}
