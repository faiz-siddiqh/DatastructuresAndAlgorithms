package strings;

/*
 * Given a string in roman no format (s)  your task is to convert it to an integer . Various symbols and their values are given below.
I 1
V 5
X 10
L 50
C 100
D 500
M 1000
 */
public class RomanNumberToInteger {

	public static void main(String[] args) {
		String str = "XL";

		System.out.println(romanToDecimal(str));
	}

	public static int romanToDecimal(String str) {
		String[] arr = str.split("");

		if (arr.length == 0)
			return 0;

		// initialising the value of first literal to sum
		int sum = getNumberValue(str.charAt(0));

		if (arr.length == 2) {
			// if the String has only 2 Characters and the first one is lesser than
			// second,then we subtract the value from bigger

			if (getNumberValue(str.charAt(1)) > sum)
				sum = getNumberValue(str.charAt(1)) - sum;
			// else add the numbers
			else
				sum += getNumberValue(str.charAt(1));

		}
		// if there are more chars then perform the same untill the last char and if a
		// char at i is less than i+1 then subtract else add
		else {
			int i = 0;
			sum = 0;
			int len = arr.length;
			while (i < len - 1) {
				if (getNumberValue(str.charAt(i)) >= getNumberValue(str.charAt(i + 1)))
					sum += getNumberValue(str.charAt(i++));
				else {
					sum += getNumberValue(str.charAt(i + 1)) - getNumberValue(str.charAt(i));
					i += 2;
				}
			}
			// finally add the last char value
			if (i == len - 1)
				sum += getNumberValue(str.charAt(i++));

		}
		// return the sum
		return sum;
	}

	/**
	 * Returns the value of the specific Roman Literal
	 * 
	 * @param S
	 * @return
	 */
	public static int getNumberValue(char S) {
		int value = -1;
		switch (S) {
		case 'I':
			value = 1;
			break;
		case 'V':
			value = 5;
			break;
		case 'X':
			value = 10;
			break;
		case 'L':
			value = 50;
			break;
		case 'C':
			value = 100;
			break;
		case 'D':
			value = 500;
			break;
		case 'M':
			value = 1000;
			break;
		default:
			System.out.println("Invalid");

		}

		return value;
	}

}
