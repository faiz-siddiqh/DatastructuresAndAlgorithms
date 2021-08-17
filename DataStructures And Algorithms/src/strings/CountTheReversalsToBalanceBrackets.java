package strings;

import java.util.Stack;

/**
 * Given a string S consisting of only opening and closing curly brackets '{'
 * and '}', find out the minimum number of reversals required to convert the
 * string into a balanced expression. A reversal means changing '{' to '}' or
 * vice-versa.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class CountTheReversalsToBalanceBrackets {

	public static void main(String[] args) {
		String str = "}{{}}{{{";
//		String str = "{{}{{{}{{}}{{";   --negative scenario
		System.out.println(countRev(str));
	}

	static int countRev(String s) {
		// The stack is used only to track the number of opening braces '{'
		Stack<Character> stack = new Stack<>();
		int count = 0;
		char arr[] = s.toCharArray();

		// if the String has odd number of characters then it cannot be balanced
		if (arr.length % 2 != 0)
			return -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '{')
				stack.push(arr[i]);
			else if (arr[i] == '}') {
				// if stack is empty then switch/reverse the current '}' braces to '{' and push
				// it to stack
				if (stack.isEmpty()) {
					arr[i] = '{';
					stack.push(arr[i]);
					count++; // increment the count
				} else {
					// if stack is not empty ,then pop the '{' as it balances the current '}'
					stack.pop();
				}
			}
		}
		// if the stack has odd number of opening braces then it cant be balanced
		if (stack.size() % 2 != 0)
			return -1;
		else
			// if stack has even number of braces then it can be balanced by reversing n/2
			// number of braces
			count += stack.size() / 2;

		return count;
	}

}
