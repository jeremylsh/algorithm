package string;

/**
 * 将字符串中所有空格替换为"%20"
 */
public class ReplaceSpace {

	/**
	 * 作弊 
	 */
	public static String replace(String oldStr) {
		if (oldStr == null)
			return null;
		return oldStr.replace(" ", "20%");
	}
	
	/**
	 * 使用StringBuffer
	 */
	public static String replace2(String oldStr) {
		if (oldStr == null)
			return null;
		
		int len = oldStr.length();
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < len; i++) {
			if (oldStr.charAt(i) == ' ') {
				sb.append("%20");
			} else {
				sb.append(oldStr.charAt(i));
			}
		}
		return sb.toString();
	}
	
	/**
	 * 使用数组
	 */
	public static String replace3(String oldStr) {
		int blankNum = 0;
		int len = oldStr.length();
		
		for (int i = 0; i < len; i++) { // 先统计空格数，O(n)
			if (oldStr.charAt(i) == ' ')
				++blankNum;
		}
		
		int newLen = len + (blankNum << 1);
		char[] cs = new char[newLen];
		
		for (int i = 0, j = 0; i < len; i++, j++) {
			if (oldStr.charAt(i) == ' ') {
				cs[j++] = '%';
				cs[j++] = '2';
				cs[j] = '0';
			} else {
				cs[j] = oldStr.charAt(i);
			}
		}
		
		return new String(cs);
	}
	
	public static void main(String[] args) {
		String str = "We are happy.";
		System.out.println(replace(str)); // We20%are20%happy.
		System.out.println(replace2(str));
		System.out.println(replace3(str));
	}
	
}
