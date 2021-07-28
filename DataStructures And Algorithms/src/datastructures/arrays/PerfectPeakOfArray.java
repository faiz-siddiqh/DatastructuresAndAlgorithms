package datastructures.arrays;

import java.util.ArrayList;

public class PerfectPeakOfArray {

	public static void main(String[] args) {
		int[] arr = {  1, 2, 3, 4, 5, 4, 3, 2, 3, 10  };
//		int[] arr = { 5, 1, 4, 3, 6, 8, 10, 7, 9 };
		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			A.add(arr[i]);
		}
		System.out.println(perfectPeak(A));
	}

	public static int perfectPeak(ArrayList<Integer> A) {
		int n = A.size();
		if (n < 1) {
			return -1;
		}

		for (int i = 1; i < n-1; i++) {
			boolean bool = true;
			boolean bool2 = true;
			int element = A.get(i);
			int j = i - 1;
			int k = i + 1;

			while (j >= 0) {
				if (A.get(j) > element) {
					bool = false;
					break;
				}
				j--;
			}
			if (bool) {
				while (k < n) {
					if (A.get(k) <= element) {
						bool2 = false;
						break;
					}

					k++;
				}
			}
			if (bool && bool2) {
				System.out.println(i);
				return 1;
			}

		}
//[ 9895, 30334, 17674, 23812, 20038, 25668, 6869, 1870, 4665, 27645, 7712, 17036, 31323, 8724, 28254, 28704, 26300, 25548, 15142, 12860, 19913, 32663, 32758 ]

		return 0;
	}

}
