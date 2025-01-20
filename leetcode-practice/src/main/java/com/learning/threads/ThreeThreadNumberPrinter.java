package com.learning.threads;

public class ThreeThreadNumberPrinter {
    private static final int LIMIT = 100;
    private static final Object LOCK = new Object();
    static int counter = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (counter < LIMIT) {
                    synchronized (LOCK) {
                        if (counter % 3 == 0) {
                            System.out.println("Thread 1: " + counter++);
                        }
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (counter < LIMIT) {
                    synchronized (LOCK) {
                        if (counter % 3 == 1) {
                            System.out.println("Thread 2: " + counter++);
                        }
                    }
                }
            }
        };

        Thread t3 = new Thread() {
            @Override
            public void run() {
                while (counter < LIMIT) {
                    synchronized (LOCK) {
                        if (counter % 3 == 2) {
                            System.out.println("Thread 3: " + counter++);
                        }
                    }
                }
            }
        };
        t1.start();
        t2.start();
        t3.start();
    }
}
