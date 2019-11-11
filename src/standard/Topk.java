package standard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import sort.QuickSort;

/**
 * Topk问题，找出数组中最小的k个数
 * 
 * 思路
 * 方法一：循环做partition，直到基准刚好落在k的位置，时间复杂度O(n)。副作用是会改变数组本身的顺序。
 * 方法二：最小topk用大根堆，每次跟堆顶比，如果大了直接跳过，小了把堆顶换掉，然后重新调整堆。时间复杂度O(nlogk)，适合处理海量数据，不修改数组顺序。
 * 		面试手写大根堆比较麻烦，可以用TreeSet红黑树的特性替代
 */
public class Topk {

	/**
	 * 方法一：循环做partition
	 */
	public static ArrayList<Integer> topk(int[] a, int k) {
		if (a == null || a.length == 0 || a.length < k || k <= 0)
			return null;
		
		ArrayList<Integer> result = new ArrayList<>();
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
			result.add(a[i]);
		}
		
		return result;
	}

	/**
	 * 解法二：使用红黑树容器（大根堆）
	 */
	public static List<Integer> topk2(int[] a, int k) {
		if (a == null || a.length == 0 || a.length < k || k <= 0)
			return null;

		// 排序顺序为升序
		TreeSet<Integer> set = new TreeSet<>((o1, o2) -> o1 - o2);

		for (int i = 0; i < a.length; i++) {
			// 容器没满，直接插入
			if (set.size() < k) {
				set.add(a[i]);
			}
			// 容器满了，比较last元素和要插入的元素，last相当于容器内最大的数
			// 如果比容器内最大的数都要大，就跳过处理
			else if (a[i] < set.last()) {
				// 把最大的数替换为新元素，红黑树重新调整顺序
				set.remove(set.last());
				set.add(a[i]);
			}
		}
		return set.stream().collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		int[] array = { 4, 5, 1, 6, 2, 7, 3, 8 };
		int k = 5;
		
		System.out.println(topk(array, k)); // 1, 2, 3, 4
		System.out.println(topk2(array, k)); // 1, 2, 3, 4
	}
}
