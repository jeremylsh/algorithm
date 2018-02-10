package standard;

/**
 * 查找非递减数组的旋转数组中的最小值
 */
public class MinInRotation {

	/**
	 * 二分法，时间O(logn)
	 * 考虑非递减的极端情况
	 */
	public static int minInRotation(int[] a) {
		if (a == null || a.length == 0)
			return -1;
		
		int left = 0;
		int right = a.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;  
			if (a[mid] > a[right]) { // [left,mid]偏大全部丢弃，
				left = mid + 1;
			} else if (a[mid] == a[right]) { // 优先取靠左元素
				right--;
			} else { // 丢弃偏小，同时a[mid]也可能是最小值需要保留
				right = mid;
			}
		}
        
		return a[left];
	}
	
	public static void main(String[] args) {
		int[] array = { 3, 4, 5, 1, 2 };
//		int[] array = { 1, 0, 1, 1, 1 };
//		int[] array = { 1, 1, 1, 0, 1 };
		
		System.out.println(minInRotation(array));
	}

}
