package sort;

import java.util.Arrays;

/**
 * @description 冒泡排序
 * @author Jeremy
 * @date 2019/08/11
 */
public class BubbleSort {

	public static void bubbleSort(int[] as) {
		// 外循环代表排序回合数，每一次都把最大的数字沉底到最右边
		for (int i = 0; i < as.length - 1; i++) {
			// 每轮比较，下标都要从最左边开始，和它后一个数字比较
			for (int j = 0; j + i < as.length - 1; j++) {
				if (as[j] >= as[j + 1]) {
					int temp = as[j];
					as[j] = as[j + 1];
					as[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] as = new int[] { 8, 2, 4, 3, 1, 5, 2 };
		bubbleSort(as);
		System.out.println(Arrays.toString(as));
	}
	
}
