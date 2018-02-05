package standard;

public class Palindrome {

	/**
	 * 递归判断字符串是否为回文字符串
	 */
	public static boolean isPalindrome(String str) {
		if (str == null || str.trim().length() == 0) // 校验
			return false;
		
		if (str.length() == 1) { // 长度为1肯定是回文串
			return true;
		} else if (str.length() == 2) { // 长度为2判断两个字符
			return str.charAt(0) == str.charAt(1);
		} else if (str.charAt(0) == str.charAt(str.length() - 1)) {// 首尾相等，去掉首尾字符
			return isPalindrome(str.substring(1, str.length() - 1)); 
		} else {
			return false;
		}
	}

	/**
	 * 获取最长回文字符串,使用备忘录
	 * time:O(n^2)
	 * space:O(n^2)
	 */
	public static String getMaxPalindrome(String str) {
		if (str == null || str.length() == 0 || str.length() == 1)
			return str;

		int start = 0;
		int length = str.length();
		int maxLen = 1;
		int s[][] = new int[length][length]; // 备忘录

		for (int i = 0; i < length; i++) { // 初始化
			s[i][i] = 1;
			if ((i < length - 1) && (str.charAt(i) == str.charAt(i + 1))) { // 相邻两个字符相等
				start = i;
				maxLen = 2;
				s[i][i + 1] = 1;
			}
		}

		for (int len = 3; len <= length; len++) { // 考虑长度至少为3的情况
			for (int i = 0; i <= length - len; i++) { // 字符串从i到j
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

		System.out.println(getMaxPalindrome(word)); // max is cbaabc
		
		System.out.println(isPalindrome(word)); // false
		
		System.out.println(isPalindrome(getMaxPalindrome(word))); // true
	}

}
