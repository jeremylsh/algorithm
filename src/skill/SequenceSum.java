package skill;

import java.util.ArrayList;

/**
 * 打印所有和为S的连续正数序列		
 */
public class SequenceSum {

	/**
	 * 从最左侧开始，left，right两个指针一直向右扩展，left先动，right后动，如偏大就把最左端的舍弃
	 * left肯定在1到mid的范围内移动
	 */
	public static ArrayList<ArrayList<Integer>> sequenceSum(int s) {
		if (s < 3)
			return null;
		
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		
		int left = 1;
		int right = 2;
		int mid = (s + 1) >> 1; // 从1到s的中间数（偶数个取偏小）
		int curSum = left + right; // 当前序列和
		
		while (left < mid) {
			if (curSum == s) {
				ArrayList<Integer> list = new ArrayList<>();
				for (int i = left; i <= right; i++) {
					list.add(i);
				}
				lists.add(list);
			}
			
			while (curSum > s && left < mid) { // 偏大，舍弃最左边的数
				curSum -= left;
				left++;
					
				if (curSum == s) {
					ArrayList<Integer> list = new ArrayList<>();
					for (int i = left; i <= right; i++) {
						list.add(i);
					}
					lists.add(list);
				}
			}
			
			right++; // 向右边扩展
			curSum += right;
		}
		return lists;
	}
	
	public static void main(String[] args) {
		int s = 15;
		ArrayList<ArrayList<Integer>> lists = sequenceSum(s);
		if (lists != null) {
			for (ArrayList<Integer> list : lists) {
				System.out.println(list);
			}
		}
	}
	
}
