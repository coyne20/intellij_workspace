package com.learning;

public class Multithreading2 implements Runnable{

    private String threadName;
    public Multithreading2(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run(){
        for(int i=0; i<=5; i++){
            System.out.println(threadName+" : "+i);

            try {
                Thread.sleep(1000); // Sleep for a second before printing the next value
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Multithreading2 mt1 = new Multithreading2("Thread 1");
        Multithreading2 mt2 = new Multithreading2("Thread 2");
        Thread t1 = new Thread(mt1);
        Thread t2 = new Thread(mt2);
        t1.start();
        t1.join(); // First complete the current thread execution before starting another
        t2.start();
        t2.join();
    }

}
