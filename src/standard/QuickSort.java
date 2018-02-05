package standard;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	final static Random random = new Random();
	
	final static int[] a = new int[] { 5, 4, 3, 2, 1, 2, 3, 4, 5 };
	
	public static void main(String[] args) {
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	public static void quickSort(int[] a, int left, int right) {
		if (left < right) {
			int p = RandomizedPartition(a, left, right);
			quickSort(a, left, p - 1);
			quickSort(a, p + 1, right);
		}
	}

	public static int partition(int[] a, int left, int right) {
		int p = a[left];
		
		while (left < right) {
			while (left < right && p <= a[right])
				right--;
			
			a[left] = a[right];
			
			while (left < right && p >= a[left])
				left++;
			
			a[right] = a[left];
		}
		
		a[left] = p;
		return left;
	}
	
	/*
	 * choose one from a[i] to a[j] randomly, then swap with a[i]
	 */
	public static int RandomizedPartition(int[] a, int i, int j) {
		int len = j - i + 1;
		int index = random.nextInt(len) + i;
		
		int temp = a[i];
		a[i] = a[index];
		a[index] = temp;
		
		return partition(a, i, j);
	}
}
