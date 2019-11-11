package dp;

/**
 * @description 最长公共子序列/子串
 * @author Jeremy
 * @date 2019/08/18
 * 
 * LCS即Longest Common Subsequence/Substring，有两种题型
 * 
 * 1.最长公共子序列
 * A序列[abcdef]，B序列[cdf]，输出3（cdf）
 * 
 * 思路：
 * 用dp[i][j]表示A[0...i]和B[0...j]的最大公共子序列，找到状态转换方程
 * if (a[i] == b[j]) dp[i+1][j+1]=dp[i][j]+1
 * if (a[i] != b[j])dp[i+1][j+1]=max(dp[i][j+1],dp[i+1][j])
 * dp[i][j]即最终要求的最大值
 * 
 * 2.最长公共子串
 * 
 */
public class LCS {

	/**
	 * 最长公共子序列
	 */
	public static int lcs1(char[] a, char[] b) {
		if (a == null || b == null || a.length == 0 || b.length == 0) {
			return 0;
		}

		int[][] dp = new int[a.length + 1][b.length + 1];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				dp[i + 1][j + 1] = a[i] == b[j] ? dp[i][j] + 1 : Math.max(dp[i + 1][j], dp[i][j + 1]);
			}
		}

		return dp[a.length][b.length];
	}
	
	/**
	 * 最长公共子串
	 */
	public static String lcs2(String s) {
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(lcs1(new char[] { 'a', 'b', 'c', 'd', 'e', 'f' }, new char[] { 'c', 'd', 'f' }));
	}
	
}
