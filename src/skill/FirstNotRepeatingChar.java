package skill;

import java.util.LinkedHashMap;

/**
 * 找到第一个只出现一次的字符，输出下标
 */
public class FirstNotRepeatingChar {

	/**
	 * 使用LinkedHashMap，空间换时间，时间复杂度O(n)
	 */
	public static int firstNotRepeatingChar(char[] cs) {
		if (cs == null || cs.length == 0)
			return -1;
		
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < cs.length; i++) {
			if (!map.containsKey(cs[i])) { // O(1)时间判断key是否包含
				map.put(cs[i], 1);
			} else {
				map.put(cs[i], map.get(cs[i]) + 1);
			}
			
		}
		
		for (int i = 0; i < cs.length; i++) {
			if (map.get(cs[i]) == 1)
				return i;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		char[] cs = { 'a', 'b', 'a', 'c', 'c', 'd', 'e', 'f', 'f' }; // 1
		System.out.println(firstNotRepeatingChar(cs));
	}
}
