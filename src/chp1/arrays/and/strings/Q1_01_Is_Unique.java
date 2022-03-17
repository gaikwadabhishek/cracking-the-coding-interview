package chp1.arrays.and.strings;

public class Q1_01_Is_Unique {

	// implement a algorith to determine if a string has all unique characters.
	public static boolean isUnique_A(String s) {
		boolean[] allCharacters = new boolean[128];
		for (char c : s.toCharArray()) {
			if (allCharacters[c - 'a'])
				return false;
			allCharacters[c - 'a'] = true;
		}
		return true;
	}

	// what if you cannot use additional data structures
	// ans. compare each char to every other char of string: time (O(n^2)) and space
	// O(1)
	// ans. if allowed to modify the string then sort the string O(nLogn) and then
	// linearly check
	public static boolean isUnique_B(String s) {
		int checker = 0;
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isUnique_A("abcdef"));
		System.out.println(isUnique_B("abcda"));
	}
}
