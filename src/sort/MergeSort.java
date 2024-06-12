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

	public void merge(int[] nums, int[] temps, int leftStart, int leftEnd, int rightStart, int rightEnd) {
		// 记住开始的位置
		int start = leftStart;

		// 辅助数组的下标
		int index = leftStart;

		// 对比左右两个数组并将较小的数先放到辅助数组
		while (leftStart <= leftEnd && rightStart <= rightEnd) {
			if (nums[leftStart] <= nums[rightStart]) {
				temps[index] = nums[leftStart];
				leftStart++;
				index++;
			} else {
				temps[index] = nums[rightStart];
				rightStart++;
				index++;
			}
		}

		// 上面的while循环只要有一个数组遍历完了就会停下，这时候还要把左边或者右边剩下的元素补到辅助数组
		// 下面的两个while只会执行其中一个
		while (leftStart <= leftEnd) {
			temps[index] = nums[leftStart];
			leftStart++;
			index++;
		}
		while (rightStart <= rightEnd) {
			temps[index] = nums[rightStart];
			rightStart++;
			index++;
		}

		// 把辅助数组区间内的值copy到原始数组上
		for (; start <= rightEnd; start++) {
			nums[start] = temps[start];
		}
	}

	private void mergeSort(int[] as, int[] temps, int left, int right) {
		if (left < right) {
			// 从中间把乱序数组一分为二
			int mid = (left + right) >> 1;
			// 对半切割，不断切割成有序数组，直到不可再分
			mergeSort(as, temps, left, mid);
			mergeSort(as, temps, mid + 1, right);

			// 重新把两边的有序数组合并，先写到辅助数组，然后根据下标的左右区间刷到原始数组
			merge(as, temps, left, mid, mid + 1, right);
		}
	}

	public static void main(String[] args) {
		int[] as = new int[] { 2, 4, 7, 5, 8, 1, 3, 6 };
		new MergeSort().mergeSort(as, new int[as.length], 0, as.length - 1);
		System.out.println(Arrays.toString(as));
	}

}
