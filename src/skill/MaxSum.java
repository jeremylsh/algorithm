package skill;

/**
 * 求出整形数组中子数组的最大和
 */
public class MaxSum {

	/**
	 * 利用规则，时间复杂度O(n)
	 * 从左向右遍历，当前元素的左侧子数组肯定大于0，否则可以舍弃
	 * 
	 * 用DP的思路
	 * f(i)为s[0]到s[i]的最大和，
	 * 状态转换方程为f(i)=max(s[i], f(i-1)+s[i]) 
	 * 
	 * 二者最后的实现一样
	 */
	public static int getMaxSum(int[] a) {
		if (a == null || a.length == 0)
			return 0;

		int result = Integer.MIN_VALUE; // 全局最大和
		int curSum = 0; // 左侧子数组之和
		
		for (int i = 0; i < a.length; i++) {
			curSum = (curSum > 0) ? a[i] + curSum : a[i];
			if (curSum > result) {
				result = curSum;
			}
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		int[] array = { 1, -2, 3, 10, -4, 7, 2, -5 }; // Max = 18 -> { 3, 10, -4, 7, 2 }
		System.out.println(getMaxSum(array));
	}
	
}
