package algorithm;

import java.util.ArrayList;
import java.util.List;

/*
 * 1   2   3   4
 * 5   6   7   8
 * 9   10  11  12
 * 13  14  15  16
 */
public class PrintCircle {

	public static void main(String[] args) {
		int matrix[][] = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		// used to print
		List<Integer> list = new ArrayList<>();
		printCircle(matrix, list);
		for (int num : list) {
			System.out.print(num + " ");
		}
	}

	/*
	 * starts from top left
	 */
	public static void printCircle(int[][] a, List<Integer> list) {
		int row = a.length;
		int col = a[0].length;
		int start = 0;
		while ((start << 1) < row && (start << 1) < col) {
			circle(a, list, start++, row, col);
		}
	}

	public static void circle(int a[][], List<Integer> list, int start, int row, int col) {
		int endX = col - start - 1;
		int endY = row - start - 1;

		// left to right
		for (int i = start; i <= endX; i++) {
			list.add(a[start][i]);
		}

		// top to bottom, at least 2 rows
		if (endY - start >= 1) {
			for (int i = start + 1; i <= endY; i++) {
				list.add(a[i][endX]);
			}
		}

		// right to left, at least 2 rows & 2 cols
		if (endX - start >= 1 && endY - start >= 1) {
			for (int i = endX - 1; i >= start; i--) {
				list.add(a[endY][i]);
			}
		}

		// bottom to top, at least 3 rows & 2 cols
		if (endX - start >= 1 && endY - start >= 2) {
			for (int i = endY - 1; i > start; i--) {
				list.add(a[i][start]);
			}
		}
	}
}
