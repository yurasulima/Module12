import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzzProgram {


    static class FizzThread implements Runnable {
        private int n;
        private BlockingQueue<String> queue;

        public FizzThread(int n, BlockingQueue<String> queue) {
            this.n = n;
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 != 0) {
                    try {
                        queue.put("fizz");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class BuzzThread implements Runnable {
        private int n;
        private BlockingQueue<String> queue;

        public BuzzThread(int n, BlockingQueue<String> queue) {
            this.n = n;
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 1; i <= n; i++) {
                if (i % 3 != 0 && i % 5 == 0) {
                    try {
                        queue.put("buzz");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class FizzBuzzThread implements Runnable {
        private int n;
        private BlockingQueue<String> queue;

        public FizzBuzzThread(int n, BlockingQueue<String> queue) {
            this.n = n;
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    try {
                        queue.put("fizzbuzz");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class NumberThread implements Runnable {
        private int n;
        private BlockingQueue<String> queue;

        public NumberThread(int n, BlockingQueue<String> queue) {
            this.n = n;
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 1; i <= n; i++) {
                try {
                    String value = queue.take();
                    System.out.println(value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
