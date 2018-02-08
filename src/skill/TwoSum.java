package skill;

import java.util.ArrayList;

/**
 * 在递增序列中，查找任意两个数，它们的和为S
 */
public class TwoSum {

	/**
	 * 一首一尾两个指针，时间复杂度O(n)
	 */
	public static ArrayList<Integer> twoSum(int[] a, int s) {
		if (a == null || a.length < 2)
			return null;
		
		ArrayList<Integer> list = new ArrayList<>();
		int left = 0;
		int right = a.length - 1;
		
		while (left < right) {
			if (a[left] + a[right] == s) {
				list.add(a[left]);
				list.add(a[right]);
				break;
			} else if (a[left] + a[right] > s) {
				right--;
			} else {
				left++;
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		int[] array = { 1, 2, 4, 7, 11, 15 };
		int s = 15;
		System.out.println(twoSum(array, s)); // [4, 11]
	}
	
}
