import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        Thread helloThread = new Thread(() -> {
            int time = 0;
            while (time < 100) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                time += 1;
                System.out.println("Running time: "+ time + " second");
            }
        });
        helloThread.start();



        int n = 125;

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Thread threadA = new Thread(new FizzBuzzProgram.FizzThread(n, queue));
        Thread threadB = new Thread(new FizzBuzzProgram.BuzzThread(n, queue));
        Thread threadC = new Thread(new FizzBuzzProgram.FizzBuzzThread(n, queue));
        Thread threadD = new Thread(new FizzBuzzProgram.NumberThread(n, queue));

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}
