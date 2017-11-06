package algorithm;

public class Palindrome {

	public static boolean isPalindrome(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		
		if (str.length() == 1 || str.length() == 2) {
			return true;
		} 
		
		if (str.charAt(0) == str.charAt(str.length() - 1)) {
			return isPalindrome(str.substring(1, str.length() - 1));
		}
		
		return false;
	}

	/*
	 * DP
	 * time:O(n^2)
	 * space:O(n^2)
	 */
	public static String getMaxPalindrome(String str) {
		if (str == null || str.length() == 0 || str.length() == 1) {
			return str;
		}

		int start = 0;
		int length = str.length();
		int maxLen = 1;
		int s[][] = new int[length][length];

		// init
		for (int i = 0; i < length; i++) {
			s[i][i] = 1;
			if ((i < length - 1) && (str.charAt(i) == str.charAt(i + 1))) {
				start = i;
				maxLen = 2;
				s[i][i + 1] = 1;
			}
		}

		// the word is from i to j
		for (int len = 3; len <= length; len++) {
			for (int i = 0; i <= length - len; i++) {
				int j = i + len - 1;
				if (s[i + 1][j - 1] == 1 && (str.charAt(i) == str.charAt(j))) {
					s[i][j] = 1;
					maxLen = len;
					start = i;
				}
			}
		}

		return str.substring(start, maxLen + start);
	}

	public static void main(String[] args) {
		String word = "abccbaabc";
		// max is cbaabc
		System.out.println(getMaxPalindrome(word));
		// false
		System.out.println(isPalindrome(word));
		// true
		System.out.println(isPalindrome(getMaxPalindrome(word)));
	}

}
