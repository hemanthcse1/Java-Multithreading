package basics;

public class Task implements Runnable{

    public void run(){
        System.out.println("Run this task "+Thread.currentThread().getName());
    }
}
