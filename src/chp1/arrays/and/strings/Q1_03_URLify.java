package chp1.arrays.and.strings;

// given a string, replace ' ' by "%20"
public class Q1_03_URLify {

	public static void replaceSpaces(char[] s, int trueLength) {
		int spacesCount = 0, index, i = 0;
		for (i = 0; i < trueLength; i++) {
			spacesCount++;
		}
		index = trueLength + 2 * spacesCount;
		for (i = trueLength - 1; i >= 0; i--) {
			if (s[i] == ' ') {
				s[index - 1] = '0';
				s[index - 2] = '2';
				s[index - 3] = '%';
				index = index - 3;
			} else {
				s[index - 1] = s[i];
				index--;
			}
		}
	}

}
