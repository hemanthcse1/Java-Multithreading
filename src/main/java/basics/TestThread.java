package basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
      /*  ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i< 5; i++){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Running thread using executor ");
                }
            });
        }*/


        System.out.println("\n-------------------------------\n");


        for (int i = 0; i< 10; i++){
            Thread testThread = new Thread(new Task());
            testThread.start();
        }


        System.out.println("\n-------------------------------\n");

        // execute 100 threads using Executor with fixed thread pool size 10
        /*ExecutorService service1 = Executors.newFixedThreadPool(10);
        for (int i = 0; i< 100; i++){
            service1.execute(new Task());
        }*/

        System.out.println("\n-------------------------------\n");

        // Get number of available processors in the system
        int coresCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of cores "+coresCount);

        ExecutorService service1 = Executors.newFixedThreadPool(coresCount);

        System.out.println("\n-------------------------------\n");

        // Types of Thread pools
        // 1. Fixed size thread pool
        ExecutorService fixedThreadService = Executors.newFixedThreadPool(10);

        for (int i = 0; i< 10; i++){
            fixedThreadService.execute(new Task());
        }


        System.out.println("\n-------------------------------\n");

        // 2. cachedThreadPool
        ExecutorService cachedThreadService = Executors.newCachedThreadPool();
        cachedThreadService.execute(new Task());


        System.out.println("\n-------------------------------\n");


        // 3. Scheduled Thread pool
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.schedule(new Task(), 10, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(new Task(),10, 15,TimeUnit.SECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(new Task(),15,15,TimeUnit.SECONDS);



        System.out.println("\n-------------------------------\n");

        // 4. Single Thread pool
        ExecutorService singleThreadService = Executors.newSingleThreadExecutor();

        singleThreadService.execute(new Task());

    }
}
