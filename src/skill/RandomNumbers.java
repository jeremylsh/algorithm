package skill;

import java.util.Arrays;
import java.util.Random;

/**
 * 在数组中随机选出n个数
 */
public class RandomNumbers {

	public static int[] randomNumbers(int[] a, int n) {
		if (a == null || a.length < n || n == 0)
			return null;
		
		Random random = new Random();
		int last = a.length - 1;
		
		for (int i = 0; i < n; i++) {
			int r = random.nextInt(last + 1); // 从[0, last]取得随机下标
			
			int temp = a[r]; // 选中的随机数放到数组尾部
			a[r] = a[last];
			a[last] = temp;
			last--;
		}
		return Arrays.copyOfRange(a, last + 1, a.length);
	}
	
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(Arrays.toString(randomNumbers(array, 7)));
	}
	
}
