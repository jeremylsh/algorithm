package skill;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import sort.QuickSort;

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
		return (checkMoreThanHalf(array[mid], array)) ? array[mid] : -1; // 最差情况做一次O(n)扫描
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
	 * 直接基于partition，时间复杂度: O(n)，因为排序本身浪费了性能
	 */
	public static int moreThanHalfNum2(int[] array) {
		if (array == null || array.length == 0)
			return -1; // error
		
		int mid = array.length >> 1;
		int left = 0;
		int right = array.length - 1;
		int index = QuickSort.partition(array, left, right);
		
		while (index != mid) {
			if (index > mid) {
				index = QuickSort.partition(array, left, index - 1);
			} else {
				index = QuickSort.partition(array, index + 1, right);
			}
		}
		int result = array[index];
		return (checkMoreThanHalf(result, array)) ? result : -1;
	}
	
	/**
	 * 基于map统计，空间换时间
	 */
	public static int moreThanHalfNum3(int[] array) {
		if (array == null || array.length == 0)
			return -1; // error
		
		Map<Integer, Integer> map = new HashMap<>();
		int times = (array.length >> 1) + 1;
		int result = -1;
		
		for (int i : array) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() >= times) {
				result = entry.getKey();
				break;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
//		int[] array = { 1, 2, 3, 2, 2, 2, 5, 4 }; // -1
		
		System.out.println(moreThanHalfNum(array)); // 2
		System.out.println(moreThanHalfNum2(array)); // 2
		System.out.println(moreThanHalfNum3(array)); // 2
	}

}
