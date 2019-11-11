package dp;

/**
 * 从左上角出发到右下角结束，每次只能向右或向下拿礼物，求最大值礼物
 * 
 * 比如数组
 * { 1, 10, 3, 8 }
 * { 12, 2, 9, 6 }
 * { 5, 7, 4, 11 }
 * { 3, 7, 16, 5 }
 * 
 * 最佳路线：
 * a[0][0]->a[1][0]->a[2][0]->a[2][1]->a[3][1]->a[3][2]->a[3][3]
 * 最大值：1+12+5+7+7+16+5
 * 
 * 输出:53
 * 
 * 思路：
 * 1.使用备忘录，时间复杂度O(n^2)，因为只是求和不需要知道具体路径，空间复杂度O(n)
 * 2.当前位置的最大值，和它左边和上边的最大值有关，用max[j]记录当前列的最大值
 * 3.如果左边大，max[j]=max[j-1]
 * 4.如果上边大，max[j]=max[j]+f(i,j)
 */
public class BestGift {

	public static int bestGift(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;

		int rows = matrix.length;
		int cols = matrix[0].length;
		// 记录上一行每一列的最大值
		int[] max = new int[cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int left = (j > 0) ? max[j - 1] : 0;
				int up = (i > 0) ? max[j] : 0;
				max[j] = ((left > up) ? left : up) + matrix[i][j];
			}
		}
		return max[cols - 1];
	}
	
	public static void main(String[] args) {
		int[][] matrix = { { 1, 10, 3, 8 }, 
						   { 12, 2, 9, 6 }, 
						   { 5, 7, 4, 11 }, 
						   { 3, 7, 16, 5 } };
		
		System.out.println(bestGift(matrix)); // 53
	}
}
