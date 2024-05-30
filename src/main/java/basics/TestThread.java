package basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread {

    public static void main(String[] args) {


        // using thread class
        MyThread thread = new MyThread();
        thread.run();


        // using runnable
        MyRunnable runnable = new MyRunnable();
        Thread newThread = new Thread(runnable);
        newThread.start();


        // using executor
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i< 5; i++){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Running thread using executor ");
                }
            });
        }

    }
}
