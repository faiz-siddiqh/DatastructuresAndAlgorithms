package searchingandsorting;

public class IsNumberInAP {

	public static void main(String[] args) {

		int firstNumber = 1;
		int number = 2;
		int diff = 3;

		System.out.println(isNumberInAP(firstNumber, number, diff));
	}

	private static int isNumberInAP(int A, int B, int C) {
		if (C == 0)
			if (A == B)
				return 1;
			else
				return 0;

		// Else difference between A and B
		// must be divisible by C.
		if ((B - A) % C == 0 && (B - A) / C >= 0)
			return 1;
		else
			return 0;

	}

}
