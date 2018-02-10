package string;

/**
 * 把字符串最左边k个字符移动到尾部
 */
public class LeftRotateString {

	/**
	 * 分别翻转A和B两部分，最后整体一起翻转
	 */
	public static String leftRotateString(String str, int k) {
		if (str == null || str.length() == 0)
			return null;
		
		char[] cs = str.toCharArray();
		int len = str.length();
		
		reverse(cs, 0, k - 1);
		reverse(cs, k, len - 1);
		reverse(cs, 0, len - 1);
		
		return new String(cs);
	}
	
	public static void reverse(char[] cs, int left, int right) {
		while (left < right) {
			char c = cs[left];
			cs[left++] = cs[right];
			cs[right--] = c;
		}
	}
	
	public static void main(String[] args) {
		String str = "abcdefg";
		int k = 2;
		System.out.println(leftRotateString(str, k));
	}
}
