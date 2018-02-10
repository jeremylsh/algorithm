package standard;

/**
 * 长度为n的绳子剪成m段，求k[0],k[1]...k[m]的最大值(n>1,m>1)
 */
public class MaxCut {

	/**
	 * 动态规划，时间O(n^2)，空间O(n)
	 * 状态转换f(n)=max(f(i) * f(n-i))
	 */
	public static int maxCut(int n) {
		if (n < 2)
			return 0;
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;
		
		int[] maxs = new int[n + 1]; // 存储长度为n时的最大值，从0到n有n+1个数，maxs[0]没用
		maxs[1] = 1;
		maxs[2] = 2;
		maxs[3] = 3;
		
		for (int i = 4; i <= n; i++) {
			int max = 0;
			for (int j = 1; j <= i / 2; j++) { // 剪成长度为j和i-j两段
				int curMax = maxs[j] * maxs[i - j];
				if(curMax > max)
					max = curMax;
				maxs[i] = max;
			}
		}
		return maxs[n];
	}
	
	/**
	 * 贪心算法，时间O(1)，空间O(1)
	 * 尽可能多的剪出长度为3的段，如果长度是4拆成2*2
	 */
	public static int maxCut2(int n) {
		if (n < 2)
			return 0;
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;
		
		int times3 = n / 3; // 最多出现3的次数
		if (n - times3 * 3 == 1) // 余下一段为1，补成4，拆成2*2
			times3--;
		int times2 = (n - times3 * 3) >> 1;
		return (int) (Math.pow(3, times3)) * (int) (Math.pow(2, times2));
	}
	
	public static void main(String[] args) {
		int n = 8;
		System.out.println(maxCut(n));
		System.out.println(maxCut2(n));
	}
}
