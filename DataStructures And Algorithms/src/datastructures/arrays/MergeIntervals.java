package datastructures.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {

	public static void main(String[] args) {

		Interval[] arr = new Interval[6];
		arr[0] = new Interval(1, 10);
		arr[1] = new Interval(2, 9);
		arr[2] = new Interval(3, 8);
		arr[3] = new Interval(4, 7);
		arr[4] = new Interval(5, 6);
		arr[5] = new Interval(6, 6);
		int arr_size = arr.length;
//1, 10), (2, 9), (3, 8), (4, 7), (5, 6), (6, 6)
		mergeIntervals(arr, arr_size);
	}

	private static void mergeIntervals(Interval[] arr, int n) {
		if (n == 0)
			return;

		Arrays.sort(arr, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}

		});

		Stack<Interval> stack = new Stack<Interval>();
		stack.push(arr[0]);

		for (int i = 1; i < n; i++) {

			Interval top = stack.peek();

			if (top.end < arr[i].start)
				stack.push(arr[i]);

			else if (top.end < arr[i].end) {
				top.end = arr[i].end;
				stack.pop();
				stack.push(top);
			}

		}

		while (!stack.isEmpty()) {
			Interval t = stack.pop();
			System.out.println("[" + t.start + "," + t.end + "]");
		}

	}

}

class Interval {
	int start;
	int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

}
