package strings;

import java.util.Stack;

/**
 * Given an expression string x. Examine whether the pairs and the orders of
 * “{“,”}”,”(“,”)”,”[“,”]” are correct in exp. For example, the function should
 * return 'true' for exp = “[()]{}{[()()]()}” and 'false' for exp = “[(])”.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class ParanthesisChecker {

	public static void main(String[] args) {

		String str = "[()]{}{[()()]()}";
		System.out.println(isBalanced(str));
	}

	private static boolean isBalanced(String str) {

		Stack<Character> stack = new Stack<>();

		for (char ch : str.toCharArray()) {

			if (ch == '[' || ch == '{' || ch == '(')
				stack.push(ch);
			else if (stack.isEmpty())
				return false;
			else if (ch == '}' && stack.peek() == '{')
				stack.pop();
			else if (ch == ']' && stack.peek() == '[')
				stack.pop();
			else if (ch == ')' && stack.peek() == '(')
				stack.pop();
			else
				stack.push(ch);

		}

		return stack.isEmpty();

	}

	/**
	 * Alternative Solution
	 */

	private static boolean isBalance(String str) {
		if (str.length() < 1)
			return false;

		char[] cs = str.toCharArray();
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < cs.length; i++) {

			if (cs[i] == '{' || cs[i] == '(' || cs[i] == '[')
				st.push(cs[i]);
			else if (cs[i] == '}' || cs[i] == ')' || cs[i] == ']') {
				if (st.isEmpty())
					return false;
				char toBeMatched = st.pop();
				if (!arePairsMatched(toBeMatched, cs[i]))
					return false;
			}
		}

		if (!st.empty())
			return false;

		return true;
	}

	private static boolean arePairsMatched(char toBeMatched, char c) {

		if (toBeMatched == '{' && c == '}')
			return true;

		if (toBeMatched == '(' && c == ')')
			return true;
		if (toBeMatched == '[' && c == ']')
			return true;

		return false;
	}

}
