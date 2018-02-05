package standard;

public class BinarySearch {

	/**
	 * recursive
	 */
	public static int binarySearch(int left, int right, int[] a, int value) {
		if (left <= right) {
			int mid = (left + right) / 2;
			if (a[mid] == value)
				return mid;
			else if (value < a[mid])
				return binarySearch(0, mid - 1, a, value);
			else
				return binarySearch(mid + 1, right, a, value);
		}
		return -1; // error index
	}

	/**
	 * non-recursive
	 */
	public static int binarySearch2(int left, int right, int[] a, int value) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (value == a[mid])
				return mid;
			else if (value < a[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1; // error index
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 9 };
		System.out.println(binarySearch(0, a.length - 1, a, 9)); // 7
		System.out.println(binarySearch2(0, a.length - 1, a, 9)); // 7
		System.out.println(binarySearch(0, a.length - 1, a, 8)); // -1
		System.out.println(binarySearch2(0, a.length - 1, a, 8)); // -1
	}

}
