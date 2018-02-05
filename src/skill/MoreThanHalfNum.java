package skill;

import standard.QuickSort;

/**
 * 查找数组中出现超过一半的数，最优解时间复杂度O(n)
 */
public class MoreThanHalfNum {

	/**
	 * 通过快速排序找出中位数，时间复杂度:O(nlogn)，次优解
	 */
	public static int moreThanHalfNum(int[] array) {
		if (array == null || array.length == 0)
			return -1; // error
		QuickSort.quickSort(array, 0, array.length - 1); // O(nlogn)
		int mid = array.length / 2; // 中位数下标
		return (checkMoreThanHalf(array[mid], array)) ? array[mid] : -1; // 最差情况: O(n)
	}
	
	/**
	 * 遍历检查中位数是否出现超过总数的一半
	 */
	public static boolean checkMoreThanHalf(int num, int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == num) {
				count++;
			}
		}
		return count > (array.length / 2);
	}

	/**
	 * 时间复杂度: O(n)
	 */
	public static int moreThanHalfNum2(int[] array) {
		// TODO
		return 0;
	}
	
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
//		int[] array = { 1, 2, 3, 2, 2, 2, 5, 4 }; // -1
		
		System.out.println(moreThanHalfNum(array)); // 2
	}

}
