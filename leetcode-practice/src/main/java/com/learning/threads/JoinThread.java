package com.learning.threads;

public class JoinThread extends Thread {
    @Override
    public void run() {
        for (int i =1; i< 4; i++ ){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread name : " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinThread joinThread1 = new JoinThread();
        JoinThread joinThread2 = new JoinThread();
        JoinThread joinThread3 = new JoinThread();

        joinThread1.start();
        joinThread1.join();
        joinThread2.start();
        joinThread3.start();
    }
}