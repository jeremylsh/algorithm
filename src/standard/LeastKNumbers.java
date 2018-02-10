package standard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 找出数组中最小的k个数
 */
public class LeastKNumbers {

	/**
	 * 解法一：时间复杂度O(n)，改变数组顺序
	 */
	public static ArrayList<Integer> leastNumbers(int[] a, int k) {
		if (a == null || a.length == 0 || a.length < k || k <= 0)
			return null;
		
		ArrayList<Integer> list = new ArrayList<>();
		int left = 0;
		int right = a.length - 1;
		int index = QuickSort.partition(a, left, right);
		
		while (index != k - 1) { // 基准左边有k-1个数则结束循环
			if (index > k - 1) {
				right = index - 1;
			} else {
				left = index + 1;
			}
			index = QuickSort.partition(a, left, right);
		}
		
		for (int i = 0; i < k; i++) { // 取出最小k个数
			list.add(a[i]);
		}
		
		return list;
	}

	/**
	 * 解法二：使用红黑树容器（小根堆），size固定为k
	 * 时间复杂度O(nlogk)，适合处理海量数据，不修改数组顺序
	 */
	public static ArrayList<Integer> leastNumbers2(int[] a, int k) {
		if (a == null || a.length == 0 || a.length < k || k <= 0)
			return null;
		
		TreeSet<Integer> set = new TreeSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		int len = a.length;
		
		for (int i = 0; i < len; i++) {
			if (set.size() < k) { // 容器没满，直接插入
				set.add(a[i]);
			} else { // 容器满了，比较last元素和要插入的元素
				if (a[i] < set.last()) {
					set.remove(set.last()); // 移除容器内最大元素，保持size最大上限
					set.add(a[i]);
				}
			}
		}
		
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			list.add(it.next());
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		int[] array = { 4, 5, 1, 6, 2, 7, 3, 8 };
		int k = 4;
		
		System.out.println(leastNumbers(array, k)); // 1, 2, 3, 4
		System.out.println(leastNumbers2(array, k)); // 1, 2, 3, 4
	}
}
