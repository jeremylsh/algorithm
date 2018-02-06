package skill;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class RemoveDuplicate {

	/**
	 * 使用LinkedHashSet去重，相对位置不改变，
	 * 插入Set只需要O(1)时间，因此时间复杂度O(n)
	 */
	public static Integer[] removeDuplicate(Integer[] array) {
		LinkedHashSet<Integer> set = new LinkedHashSet<>();
		for (int a : array) {
			set.add(a);
		}
		Integer[] is = new Integer[set.size()];
		set.toArray(is);
		return is;
	}

	/**
	 * 将重复元素换到数组尾部，相对位置改变，
	 * 时间复杂度O(n^2)，空间复杂度较小
	 */
	public static Integer[] removeDuplicate2(Integer[] array) {
		int len = array.length;
		int right = len - 1; // 指向最新的重复元素
		
		for (int i = 0; i < right; i++) {
			for (int j = i + 1; j <= right; j++) {
				if (array[j] == array[i]) { 
					array[j] = array[j] ^ array[right];
					array[right] = array[j] ^ array[right];
					array[j] = array[j] ^ array[right--]; // 交换完元素，移动right
					--j; // 如果找到重复，当前loop不改变j位置
				}
			}
		}
		return Arrays.copyOfRange(array, 0, right + 1);
	}

	/**
	 * Integer[]转int[]不太方便，故用Integer[]测试
	 */
	public static void main(String[] args) {
		Integer[] array = { 3, 3, 2, 2, 1, 1};
		System.out.println(Arrays.toString(removeDuplicate(array))); // 3, 2, 1
		System.out.println(Arrays.toString(removeDuplicate2(array))); // 3, 1, 2
	}

}
