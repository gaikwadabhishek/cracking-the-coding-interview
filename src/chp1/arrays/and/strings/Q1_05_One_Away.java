package chp1.arrays.and.strings;

/*
There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
EXAMPLE
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bae -> false
*/
public class Q1_05_One_Away {

	// approach 1
	public static boolean oneEditAway(String first, String second) {
		if (first.length() == second.length()) {
			return editOneReplace(first, second);
		} else if (first.length() - second.length() == 1) {
			return editOneInsert(first, second);
		} else if (first.length() - second.length() == -1) {
			return editOneInsert(second, first);
		}
		return false;
	}

	private static boolean editOneInsert(String first, String second) {
		int index1 = 0;
		int index2 = 0;
		while (index2 < second.length() && index1 < first.length()) {
			if (first.charAt(index1) != second.charAt(index2)) {
				if (index1 != index2)
					return false;
				index1++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}

	private static boolean editOneReplace(String first, String second) {
		int n = first.length();
		boolean differenceFound = false;
		for (int i = 0; i < n; i++) {
			if (first.charAt(i) != second.charAt(i)) {
				if (differenceFound)
					return false;
				differenceFound = true;
			}
		}
		return true;
	}

//appraoch 2
	public static boolean oneEditAway1(String first, String second) {
		if (Math.abs(first.length() - second.length()) > 1)
			return false;

		String s1 = first.length() < second.length() ? first : second;
		String s2 = first.length() < second.length() ? second : first;

		int index1 = 0;
		int index2 = 0;
		boolean differenceFound = false;
		while (index1 < s1.length() && index2 < s2.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (differenceFound)
					return false;
				differenceFound = true;
				if (s1.length() == s2.length())
					index1++;
			} else {
				index1++;
			}
			index2++;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(oneEditAway1("apple", "appl"));
		System.out.println(oneEditAway1("appe", "appl"));
		System.out.println(oneEditAway1("appe", "apl"));
	}
}
