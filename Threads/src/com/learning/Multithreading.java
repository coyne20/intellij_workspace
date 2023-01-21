package com.learning;

public class Multithreading extends Thread{

    private String threadName;
    public Multithreading(String threadName){
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

    public static void main(String args[]){
        Multithreading mt1 = new Multithreading("Thread 1");
        Multithreading mt2 = new Multithreading("Thread 2");
        mt1.start();
        mt2.start();
    }

}
