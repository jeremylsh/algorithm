package skill;

/**
 * 二维数组中查找：
 * matrix中每一行从左到右顺序排序，从上到下顺序排序，
 * 输入一个整数，判断其在不在数组内
 * 
 * Solution：从左下角出发
 * 
 * { 1, 2, 8, 9 }
 * { 2, 4, 9, 12 }
 * { 4, 7, 10, 13 }
 * { 6, 8, 11, 15 }
 */
public class FindInMatrix {

	public static boolean findInMatrix(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0)
			return false;
		
		int x = 0;
		int y = matrix[0].length - 1;
		int xEnd = matrix.length - 1;
		int yEnd = 0;
		
		while (x <= xEnd && y >= yEnd) {
			if (matrix[x][y] > k) {
				--y;
			} else if (matrix[x][y] < k) {
				++x;
			} else {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int k = 5; // false
//		int k = 7; // true
		int[][] matrix = { { 1, 2, 8, 9 }, 
						   { 2, 4, 9, 12 }, 
						   { 4, 7, 10, 13 }, 
						   { 6, 8, 11, 15 } };
		
		System.out.println(findInMatrix(matrix, k));
	}
	
}
