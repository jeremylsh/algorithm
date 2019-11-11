package skill;

/**
 * @description 股票最大利润
 * @author Jeremy
 * @date 2019/08/24
 * 
 * 题型一：只允许卖出一次
 * 输入：{9,11,8,5,7,12,16,14} 
 * 输出：11
 * 思路：动态规划，记录s[i]的最低价minValue和最大收益maxSum，那么最大利润s[i]=Max(a[i]-minValue,maxSum)
 * 
 * 题型二：可以多次交易
 * 输入：{9,11,8,5,7,12,16,14} 
 * 输出：13（2+11）
 * 思路：贪心算法，只要次日比当日大，就卖股票
 */
public class StockMaxProfit {

	public static int stockMaxProfit1(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return 0;
		}
		
		int curMin = arr[0];
		int maxProfit = 0;
		
		for (int a : arr) {
			curMin = Math.min(curMin, a);
			maxProfit = Math.max(a-curMin, maxProfit);
		}
		return maxProfit;
	}
	
	public static int stockMaxProfit2(int[] a) {
		if (a == null || a.length <= 1) {
			return 0;
		}
		
		int maxProfit = 0;
		for (int i = 0; i < a.length-1; i++) {
			if (a[i+1]>a[i]) {
				maxProfit+=a[i+1]-a[i];
			}
		}
		
		return maxProfit;
	}

	public static void main(String[] args) {
		System.out.println(stockMaxProfit1(new int[] { 9, 11, 8, 5, 7, 12, 16, 14 }));
		System.out.println(stockMaxProfit2(new int[] { 9, 11, 8, 5, 7, 12, 16, 14 }));
	}

}
