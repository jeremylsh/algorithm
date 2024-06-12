package thread;

public class TwoThreadPrinter {

    public static class Sync {
        private final char[] arr;

        public Sync(char[] arr) {
            this.arr = arr;
        }

        public synchronized void printNum() {
            for (int i = 0; i < arr.length; i++) {
                synchronized (this) {
                    // 唤醒下游任务
                    this.notify();

                    // 执行任务
                    System.out.print(i + 1);

                    // 阻塞当前任务
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public synchronized void printChar() {
            for (int i = 0; i < arr.length; i++) {
                synchronized (this) {
                    // 唤醒下游任务
                    this.notify();

                    // 执行任务
                    System.out.print(arr[i]);

                    // 阻塞当前任务
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[] arr = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        Sync sync = new Sync(arr);
        new Thread(() -> sync.printNum()).start();
        new Thread(() -> sync.printChar()).start();
    }

}
