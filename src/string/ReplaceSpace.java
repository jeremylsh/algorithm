package string;

/**
 * 将字符串中所有空格替换为"%20"
 * 
 * 字符串：We are happy.
 * 输出：We%20are%20happy.
 * 
 * 1.先扫一遍数组，统计出空格的个数，从而确认新数组的长度
 * 2.重扫一遍，把就数组复制到新数组，如果是空格则替换成%20
 */
public class ReplaceSpace {

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
		System.out.println(replace2(str));
		System.out.println(replace3(str));
	}
	
}
