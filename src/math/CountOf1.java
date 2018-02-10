package math;

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
