package dp;

/**
 * @description 斐波那契非递归实现
 * @author Jeremy
 * @date 2019/08/18
 * 
 * 非递归的斐波那契可以用动态规划来实现，避免子问题重复计算
 * 这道题也相当于跳台阶问题：10层楼，每次只能向上跳1层或2层，问一共有多少种方法？
 */
public class Fibonacci {

	public static int fibonacci(int n) {
		return (n <= 2) ? 1 : fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	/**
	 * 通过辅助数组，记录子问题最优解
	 */
	public static int fibonacci2(int n) {
		if (n < 1) return 0;
		if (n == 1 || n == 2) return 1;
		
		int[] temp = new int[n + 1];
		temp[1] = 1;
		temp[2] = 1;
		for (int i = 3; i <= n; i++) {
			temp[i] = temp[i - 1] + temp[i - 2];
		}
		return temp[n];
	}
	
	/**
	 * 通过临时变量
	 * 
	 * f(3) = f(2) + f(1) -> temp = m1 + m2
	 * f(4) = f(3) + f(2) -> temp' = m1'(temp) + m2'(m1)
	 * ...
	 */
	public static int fibonacci3(int n) {
		if (n <= 2)
			return 1;
		
		int m1 = 1, m2 = 1;
		
		for (int i = 3; i < n; i++) {
			int t = m1;
			m1 += m2;
			m2 = t;
		}
		
		return m1 + m2;
	}
	


	public static void main(String[] args) {
		int n = 5;
		System.out.println(fibonacci(n)); // 5
		System.out.println(fibonacci2(n)); // 5
		System.out.println(fibonacci3(n)); // 5
	}
	
}
