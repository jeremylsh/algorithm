package thread;

/**
 * 三个线程，依次打印：
 * 1.数字
 * 2.大写字母
 * 3.小写字母
 *
 */
public class ThreeThreadPrinter {

    public static class Sync {
        private final char[] arr;
        private final Object numLock;
        private final Object lowercaseLock;
        private final Object uppercaseLock;

        public Sync(char[] arr, Object numLock, Object lowercaseLock, Object uppercaseLock) {
            this.arr = arr;
            this.numLock = numLock;
            this.lowercaseLock = lowercaseLock;
            this.uppercaseLock = uppercaseLock;
        }

        public void printNums() {
            for (int i = 0; i < arr.length; i++) {
                // 等上游任务完成
                synchronized (lowercaseLock) {
                    synchronized (this.numLock) {
                        // 执行任务
                        System.out.print(i+1);

                        // 执行完成，释放下游任务的锁
                        numLock.notify();
                    }

                    // 执行后阻塞
                    try {
                        lowercaseLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void printUpperChars() {
            for (int i = 0; i < arr.length; i++) {
                // 等上游任务完成
                synchronized (numLock) {
                    synchronized (this.uppercaseLock) {
                        // 执行任务
                        System.out.print(arr[i]);

                        // 执行完成，释放下游任务的锁
                        uppercaseLock.notify();
                    }

                    // 执行后阻塞
                    try {
                        numLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void printLowerChars() {
            for (int i = 0; i < arr.length; i++) {
                // 等上游任务完成
                synchronized (uppercaseLock) {
                    synchronized (this.lowercaseLock) {
                        // 执行任务
                        System.out.print(String.valueOf(arr[i]).toLowerCase());

                        // 执行完成，释放下游任务的锁
                        lowercaseLock.notify();
                    }

                    // 执行后阻塞
                    try {
                        uppercaseLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[] arr = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        Sync sync = new Sync(arr, new Object(), new Object(), new Object());
        new Thread(() -> sync.printNums()).start();
        new Thread(() -> sync.printUpperChars()).start();
        new Thread(() -> sync.printLowerChars()).start();
    }

}
