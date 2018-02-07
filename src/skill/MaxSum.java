package skill;

/**
 * 求出整形数组中子数组的最大和
 */
public class MaxSum {

	/**
	 * 利用规则，时间复杂度O(n)
	 * 从左向右遍历，当前元素的左侧子数组肯定大于0，否则可以舍弃
	 */
	public static int getMaxSum(int[] a) {
		if (a == null || a.length == 0)
			return 0;

		int result = 0; // 全局最大和
		int curSum = a[0]; // 左侧子数组之和
		
		for (int i = 0; i < a.length; i++) {
			curSum = (curSum > 0) ? a[i] + curSum : a[i];
			if (curSum > result) {
				result = curSum;
			}
		}
		return result;
	}
	
	/**
	 * DP解法
	 * f(i)为a[0]到a[i]的最大和，
	 * 状态转换方程为f(i)=max(s[i], f(i-1)+s[i]) 
	 */
	public static int getMaxSum2(int[] a) {
		if (a == null || a.length == 0)
			return 0;
		
		int result = Integer.MIN_VALUE;
		int sum = 0; // a[0]到a[i]的和
		for (int i = 0; i < a.length; i++) {
			sum = max(sum, a[i]);
			result = max(result, sum);
		}
		return result;
	}
	
	public static int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	
	public static void main(String[] args) {
		int[] array = { 1, -2, 3, 10, -4, 7, 2, -5 }; // Max = 18 -> { 3, 10, -4, 7, 2 }
		
		System.out.println(getMaxSum(array));
		System.out.println(getMaxSum2(array));
	}
	
}
