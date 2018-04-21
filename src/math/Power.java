package math;

/**
 * 数值的整数次方，时间复杂度为O(n)
 * 
 * 1. a^n = a^(n/2) * a^(n/2), n为偶数
 * 2. a^n = a^[(n-1)/2] * a^[(n-1)/2] * a, n为奇数
 * 
 * @author Jeremy
 */
public class Power {

	public static double power(double num, int exponent) {
		int absExp = exponent < 0 ? -exponent : exponent;
		if (absExp == 0)
			return 1;
		else if (absExp == 1)
			return num;
		else {
			double result = power(num, absExp >> 1);
			result *= result;
			if ((absExp & 0x1) == 1) // 奇数多乘一次
				result *= num;
			if (exponent < 0) // 负次方取倒数
				result = 1 / result;
			return result;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(power(2, 3));
		System.out.println(power(0.5, 3));
		System.out.println(power(-2, 3));
		System.out.println(power(2, -3));
	}
	
}
