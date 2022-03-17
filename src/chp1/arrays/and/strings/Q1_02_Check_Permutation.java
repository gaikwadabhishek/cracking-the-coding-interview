package chp1.arrays.and.strings;

// check if both strings are permutations of each other
public class Q1_02_Check_Permutation {

	// two approaches
	// 1) sort string and compare with each other
	// 2) create a int[128] and then increment decrement count
	public static boolean checkPermutation(String a, String b) {

		// 128 assuming charset is ASCII
		int[] letters = new int[128];
		for (char c : a.toCharArray()) {
			letters[c - 'a']++;
		}
		for (char c : b.toCharArray()) {
			letters[c - 'a']--;
			if (letters[c - 'a'] < 0)
				return false;
		}
		for (int i = 0; i < 128; i++) {
			if (letters[i] > 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		System.out.println(checkPermutation("abcd", "dabc"));
		System.out.println(checkPermutation("abcd", "dabsc"));

	}

}
