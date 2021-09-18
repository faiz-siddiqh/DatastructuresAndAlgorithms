package datastructures.arrays;

import java.util.Stack;
/**LEETCODE PROBLEM -HARD
 * Given a string containing just the characters '(' and ')', find the length 
 * of the longest valid (well-formed) parentheses substring.
 *
 */
public class LongestValidParanthesis {
	private static Stack<Integer> stack;

	public static int longestValidParentheses(String s) {
		if (s.length() <= 1)
			return 0;
		int maxCount = 0;
		stack = new Stack<>();
		stack.push(-1);//to prevent stack being empty and to add the count with the index of ending parenthesis ,as index start from 0
		String[] arr = s.split("");
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("(")) {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.isEmpty())
					stack.push(i);
				else
					maxCount = Math.max(maxCount, i - stack.peek());
			}

		}

		return maxCount;
	}

	public static void main(String[] args) {
		String str = "()(())";

		System.out.println(longestValidParentheses(str));
	}
	
	
	
	/*Some Testcases fail for this solution
	 * public int longestValidParentheses(String s) {
        if(s.length()<=1)
	            return 0;
	        int count=0;
	        int maxCount=0;
	        stack=new Stack<>();
	        String [] arr=s.split("");
	        for(int i=0;i<arr.length;i++){
	            if(arr[i].equals("(")){
	                if(stack.isEmpty())
	                    stack.push(arr[i]);
	                else
	                    count=0;
	            }
	            else{
	             if(!stack.isEmpty()){
	                 stack.pop();
	                 count+=2; 
	                 maxCount=Math.max(maxCount,count);
	             }else
	            	 count=0;
	            }
	            
	        }
	        
	        return maxCount;
    }
	 */

}
