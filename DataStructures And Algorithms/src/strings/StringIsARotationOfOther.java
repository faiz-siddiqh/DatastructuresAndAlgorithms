package strings;

public class StringIsARotationOfOther {

	/*
	 * A Program to check if strings are rotations of each other or not
	 */
	public static void main(String[] args) {

		String str1 = "ABACDA";
		String str2 = "CDAABA";
		if (areRoataionsOfEachOther(str1, str2))
			System.out.println("Yes");
		else
			System.out.println("No");

	}

	private static boolean areRoataionsOfEachOther(String str1, String str2) {
		// ABACDA + ABACDA = ABACDAABACDA has CDAABA

		return (str1.length() == str2.length()) && (str1 + str1).indexOf(str2) != -1;
	}

}
