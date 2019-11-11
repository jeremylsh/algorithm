package sort;

import java.util.Arrays;

/**
 * @description 归并排序
 * @author Jeremy
 * @date 2019/08/11
 * 
 * 特点：
 * 1. 稳定排序，需要时间复杂度O(nlogn)，同时需要辅助空间O(n)
 * 2. 拆分需要O(logn)，合并需要O(n)
 * 3. 没有最好最坏情况，所有情况都需要O(nlogn)时间
 * 
 * 算法过程：
 * 1. 先把乱序数组以二分法的方式递归分成最小单元，得到多个有序数组
 * 2. 然后再自下而上将合并相邻的两个有序数组，放入辅助数组
 * 
 * 演示过程：
 * 第0趟：2 4 7 5 8 1 3 6
 * 第1趟：[2 4 7 5] [8 1 3 6]
 * 第2趟：[2 4] [7 5] [8 1] [3 6]
 * 第3趟：[2] [4] [7] [5] [8] [1] [3] [6]
 * 第4趟：[2 4] [5 7] [1 8] [3 6]
 * 第5趟：[2 4 5 7] [1 3 6 8]
 * 第6趟：[1 2 3 4 5 6 7 8]
 */
public class MergeSort {

	public static void merge(int[] as, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd) {
		int index = leftStart;
		int size = rightEnd - leftStart + 1;
		// 对比左右两个数组并将较小的数先放到辅助数组
		while (leftStart <= leftEnd && rightStart <= rightEnd) {
			if (as[leftStart] <= as[rightStart]) {
				temp[index++] = as[leftStart++];
			} else {
				temp[index++] = as[rightStart++];
			}
		}
		// 上面的while循环只要有一个数组遍历完了就会停下，这时候还要把左边或者右边剩下的元素补到辅助数组
		// 两个while只会执行其中一个
		while (leftStart <= leftEnd) {
			temp[index++] = as[leftStart++];
		}
		while (rightStart <= rightEnd) {
			temp[index++] = as[rightStart++];
		}
		
		// 把辅助数组复制到原数组
		for (int i = 0; i < size; i++) {
			as[rightEnd] = temp[rightEnd];
			rightEnd--;
		}
	}

	public static void mergeSort(int[] as, int[] temps, int left, int right) {
		if (left < right) {
			// 从中间把乱序数组一分为二
			int mid = (left + right) >> 1;
			mergeSort(as, temps, left, mid);
			mergeSort(as, temps, mid + 1, right);
			// 重新把两边的有序数组合并
			merge(as, temps, left, mid, mid + 1, right);
		}
	}

	public static void main(String[] args) {
		int[] as = new int[] { 2, 4, 7, 5, 8, 1, 3, 6 };
		mergeSort(as, new int[as.length], 0, as.length - 1);
		System.out.println(Arrays.toString(as));
	}

}
