package strings;

import java.util.Stack;

/**
 * You are given a string S of 2N characters consisting of N ‘[‘ brackets and N
 * ‘]’ brackets. A string is considered balanced if it can be represented in the
 * for S2[S1] where S1 and S2 are balanced strings. We can make an unbalanced
 * string balanced by swapping adjacent characters. Calculate the minimum number
 * of swaps necessary to make a string balanced.
 *
 */
public class MinSwapsForBracketBalancing {

	public static void main(String[] args) {
		String str = "[]][][";
		System.out.println(minimumNumberOfSwaps(str));
	}

	/**
	 * Best solution
	 * 
	 * @param S
	 * @return
	 */
	static int minimumNumberOfSwaps(String S) {

		int unBalanced = 0;
		int swap = 0;
		char[] arr = S.toCharArray();
		int rightCount = 0; // to track opening braces '['
		int leftCount = 0; // to track closing braces ']'

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '[') {
				leftCount++;
				if (unBalanced > 0) {
					// last swap plus current imbalance ,as we have input with even number of
					// brackets hence each imbalance can be balanced
					swap += unBalanced;
					unBalanced--;
				}

			} else if (arr[i] == ']') {
				rightCount++;
				// updating the imbalance of braces
				unBalanced = rightCount - leftCount;
			}

		}

		return swap;
	}

	/**
	 * Naive approach -Partially passing
	 * 
	 * @param S
	 * @return
	 */
	static int minimumNumberOfSwap(String S) {
		Stack<Character> stack = new Stack<>();
		int count = 0;
		int i = 0;
		char ch[] = S.toCharArray();

		while (i < ch.length) {
			if (ch[i] == '[') {
				stack.push(ch[i]);
				i++;
			} else if (ch[i] == ']') {
				int j = i + 1;

				// if stack is empty and j<n ,then we loop unitll we find a '[' and swap it with
				// current pos ']'
				if (stack.isEmpty() && j < ch.length) {
					while (j < ch.length) {
						if (ch[j] == '[') {
							char temp = ch[i];
							ch[i] = ch[j];
							ch[j] = temp;
							count++;
							break;
						} else {
							j++;
						}
					}
				}
				// if stack is not empty then it has '[' and pop it as the brackets are balanced
				else if (!stack.isEmpty()) {
					stack.pop();
					i++;
				}
				// if none of the solutions apply then return 0,the brackets cannot be balanced
				else {
					return 0;
				}
			}
		}
		return count;
	}

}
