package skill;

import java.util.Arrays;

/**
 * 把数组的所有奇数移到偶数前面
 */
public class ReorderOddEven {

	/**
	 * 改变相对顺序，时间复杂度O(n) 
	 */
	public static void reorderOddEven(int[] a) {
		if (a == null || a.length == 0)
			return;
		
		int left = 0;
		int right = a.length - 1;
		
		while (left < right) {
			while (left < right && (a[left] & 0x1) != 0) // left一直移动，直到找到奇数
				left++;
			
			while (left < right && (a[right] & 0x1) == 0)
				right--;
			
			if (left < right) {
				int temp = a[left];
				a[left] = a[right];
				a[right] = temp;
			}
		}
	}
	
	/**
	 * 相对顺序不变，使用冒泡交换相邻的数，时间复杂度O(n^2)
	 */
	public static void reorderOddEven2(int[] a) {
		if (a == null || a.length == 0)
			return;
		
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j + i < a.length - 1; j++) {
				if ((a[j] & 0x1) == 0 && (a[j + 1] & 0x1) == 1) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
	
	/**
	 * 相对顺序不变，空间换时间，扫一次数组，时间复杂度O(n)
	 */
	public static void reorderOddEven3(int[] a) {
		if (a == null || a.length == 0)
			return;
		
		int[] newArray = new int[a.length];
		int index = 0;
		
		for (int i = 0; i < a.length; i++) {
			if ((a[i] & 0x1) == 1) {
				newArray[index++] = a[i];
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			if ((a[i] & 0x1) == 0) {
				newArray[index++] = a[i];
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			a[i] = newArray[i];
		}
	}
		
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		
//		reorderOddEven(array);
//		reorderOddEven2(array);
		reorderOddEven3(array);
		System.out.println(Arrays.toString(array));
	}
}
