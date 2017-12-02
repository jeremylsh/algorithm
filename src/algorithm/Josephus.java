package algorithm;

public class Josephus {
	
	/*
	 * M=5, N=3 -> the circle is 0, 1, 2, 3, 4
	 */
	final static int M = 5;
	final static int N = 3;
	
	/*
	 * @param n    discards the Mst number each time
	 * @param m    total number in the circle
	 * 
	 * f(n,m) starts from 0 is the same as f(n-1,m) starts
	 * from m(m <= n), because the number m-1 is discarded.
	 *  
	 * f(n,m) = [f(n-1,m) + m] % n (m >= 1, n >= 2)
	 * f(1,m) = 1 (m >= 1)
	 */
	public static int getLastNum(int n, int m) {
		if (m < 1 || n < 1)
			return -1;
		int last = 0;
		for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}
		return last;
	}
	
	public static void main(String[] args) {
		System.out.println(getLastNum(M, N)); // the last num is 3
	}
	
}
