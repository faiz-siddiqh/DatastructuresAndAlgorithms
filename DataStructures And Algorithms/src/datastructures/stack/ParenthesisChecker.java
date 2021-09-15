package datastructures.stack;

import java.util.Stack;

/**
 * Given an expression string x. Examine whether the pairs and the orders of
 * “{“,”}”,”(“,”)”,”[“,”]” are correct in exp. For example, the function should
 * return 'true' for exp = “[()]{}{[()()]()}” and 'false' for exp = “[(])”.
 * 
 *
 */
public class ParenthesisChecker {
	private static Stack stack;

	// Function to check if brackets are balanced or not.
	static boolean ispar(String x) {

		stack = new Stack<>();
		String[] arr = x.split("");
		if (arr.length <= 1)
			return false;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i].equals("{") || arr[i].equals("(") || arr[i].equals("["))
				stack.push(arr[i]);
			else if (!validate(arr[i]))
				return false;

		}
		if (!stack.isEmpty())
			return false;

		return true;
	}

	static boolean validate(String str) {
		if (stack.isEmpty())
			return false;
		String s = stack.pop().toString();
		if (str.equals("}") && s.equals("{"))
			return true;
		else if (str.equals(")") && s.equals("("))
			return true;
		else if (str.equals("]") && s.equals("["))
			return true;

		return false;
	}

	public static void main(String[] args) {

		String str = "{[()]}";
		System.out.println(ispar(str));
	}

}
