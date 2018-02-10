package standard;

/**
 * 从左上角出发到右下角结束，每次只能向右或向下拿礼物，求最大值礼物
 */
public class BestGift {

	/**
	 * 使用备忘录，空间复杂度O(n)，时间复杂度O(n^2)
	 * 因为只是求和不需要知道路径，所以不用二维数组存所有格子的最大值
	 * 对于每一行，只记录上一行每个列的最大值
	 * 计算f(i,j)时只关心up和left，而left最大值肯定是max[0]+f(i,j)
	 */
	public static int bestGift(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[]maxValues = new int[cols]; // 记录
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) { // 扫数组
				int left = 0;
				int up = 0;
				
				if (i > 0)
					up = maxValues[j];
				
				if(j > 0)
					left = maxValues[j - 1];
				
				maxValues[j] = ((left > up) ? left : up) + matrix[i][j];
			}
		}
		return maxValues[cols - 1];
	}
	
	public static void main(String[] args) {
		int[][] matrix = { { 1, 10, 3, 8 }, 
						   { 12, 2, 9, 6 }, 
						   { 5, 7, 4, 11 }, 
						   { 3, 7, 16, 5 } };
		
		System.out.println(bestGift(matrix)); // 53: [0,0]->[1,0]->[2,0]->[2,1]->[3,1]->[3,2]->[3,3]
	}
}
