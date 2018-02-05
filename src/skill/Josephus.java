package skill;

/**
 * 约瑟夫环
 */
public class Josephus {
	
	private final static int N = 5;
	
	private final static int K = 3;
	
	/**
	 * @param n    圈内有n个数
	 * @param k    每次报数，丢弃第k个数
	 * 
	 * f(n,k)从位置0开始，相当于f(n-1,k)从位置k(k <= n)开始，
	 * 因为前者把位置为k-1的数丢弃之后就变成了后者。如果k+1 == n，
	 * 相当于扔掉最后一个数，下一轮报数恰好又从位置0开始，其他位置同理。
	 *  
	 * f(n, k) = [f(n-1, k) + k] % n (k >= 1, n >= 2)
	 * 
	 * f(1, k) = 1 (k >= 1)
	 */
	public static int getLastNum(int n, int k) {
		if (k < 1 || n < 1)
			return -1;
		int last = 0;
		for (int i = 2; i <= n; i++) {
			last = (last + k) % i;
		}
		return last;
	}
	
	public static void main(String[] args) {
		System.out.println(getLastNum(N, K)); // the last num is 3
	}
	
}
