package sort;

import java.util.Arrays;

/**
 * @description 快速排序
 * @author Jeremy
 * @date 2019/08/11
 */
public class QuickSort {

	public static int partition(int[]as, int left, int right) {
		// 取第一个数字作为基准
		int x = as[left];
		while (left < right) {
			// 从最右开始，找到第一个比基准小的数，写到左下标的位置
			while (left < right && as[right] >= x) {
				right--;
			}
			as[left] = as[right];
			while (left < right && as[left] <= x) {
				left++;
			}
			as[right] = as[left];
		}
		// 全部换完，把基准补到左下标
		as[left] = x;
		return left;
	}
	
	public static void quickSort(int[]as, int left, int right) {
		if (left < right) {
			// 选举出新基准
			int p = partition(as, left, right);
			quickSort(as, left, p - 1);
			quickSort(as, p + 1, right);
		}
	}
	
	public static void main(String[] args) {
		int[] as = new int[] { 8, 2, 4, 3, 1, 5, 2 };
		quickSort(as, 0, as.length - 1);
		System.out.println(Arrays.toString(as));
	}
	
}
