package thread;

/**
 * @description TODO
 * @author Jeremy
 * @date 2019/09/18
 */
public class PrintNumber {
	
	public synchronized void print(int num) {
		notify();
		System.out.print(num + " ");
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
	
	public static void main(String[] args) {
		PrintNumber printNumber = new PrintNumber();
		new Thread(() -> {
			for (int i = 1; i <= 99; i += 2) {
				printNumber.print(i);
			}
		}).start();
		new Thread(() -> {
			for (int i = 2; i <= 100; i += 2) {
				printNumber.print(i);
			}
		}).start();
	}
	
}
