package skill;

public class Fibonacci {

	public static int fibonacci(int n) {
		return (n <= 2) ? 1 : fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	/**
	 * for loop fibonacci
	 * 
	 * f(3) = f(2) + f(1) -> temp = m1 + m2
	 * f(4) = f(3) + f(2) -> temp' = m1'(temp) + m2'(m1)
	 * ...
	 */
	public static int fibonacci2(int n) {
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
		System.out.println(fibonacci(5)); // 5
		System.out.println(fibonacci2(5)); // 5
	}
	
}
