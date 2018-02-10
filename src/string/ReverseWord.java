package string;

public class ReverseWord {

	/**
	 * 用split分割 
	 */
	public static String reverse(String str) {
		if (str == null || "".equals(str.trim()))
			return str;

		StringBuffer sb = new StringBuffer();
		String[] ss = str.split(" ");
		
		for (int i = ss.length - 1; i >= 0; i--) {
			sb.append(ss[i]).append(" ");
		}
		
		return sb.toString().substring(0, sb.length() - 1);
	}
	
	/**
	 * 先反转整个字符串，再反转所有单词
	 */
	public static String reverse2(String str) {
		return null; // TODO
	}
	
	public static void main(String[] args) {
		String word = "I am a liar.";
		System.out.println(reverse(word));
	}
	
}
