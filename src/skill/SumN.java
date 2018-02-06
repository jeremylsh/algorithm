package skill;

/**
 * 不用乘除法求1~n的和
 */
public class SumN {

	/**
	 * 短路+递归，从n加到0，在比较中运算
	 */
	public static int sum(int n) {
		int sum = n;
		boolean b = (n > 0) && ((sum += sum(n - 1)) > 0);
		return sum;
	}
	
	public static void main(String[] args) {
		int n = 5;
		System.out.println(sum(n)); // 15
	}
	
}
