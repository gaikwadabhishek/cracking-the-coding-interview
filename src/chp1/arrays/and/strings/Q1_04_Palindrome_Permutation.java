package chp1.arrays.and.strings;

/*
Given a string, write a function to check if it is a permutation of
a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
permutation is a rearrangement of letters. The palindrome does not need to be limited to just
dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations:"taco cat'; "atco cta'; etc.)
*/

public class Q1_04_Palindrome_Permutation {

	public static boolean isPermutationOfPalindrome(String s) {
		int[] letters = new int[26];
		int oddCounter = 0;
		for (char c : s.toCharArray()) {
			int curr = c - 'a';
			if (curr >= 0 && curr <= 26) {
				letters[c - 'a']++;
				if (letters[c - 'a'] % 2 == 1) {
					oddCounter++;
				} else {
					oddCounter--;
				}
			}
		}
		return oddCounter <= 1;
	}

	public static void main(String[] args) {
		String ip = "taco cat";
		System.out.println(isPermutationOfPalindrome(ip));
	}
}
