package math;

/**
 * @description 统计十进制数转成二进制后有多少个1
 * @author Jeremy
 * @date 2019/08/17
 * 
 * 思路：循环无符号右移，和1做位运算即可
 */
public class CountOf1 {

    public static int countOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 0x1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
	
	public static void main(String[] args) {
		int n = 9;
		System.out.println(countOf1(n));
	}
}
