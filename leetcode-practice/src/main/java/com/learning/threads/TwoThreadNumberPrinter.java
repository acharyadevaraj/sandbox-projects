package com.learning.threads;

public class TwoThreadNumberPrinter {
    int currentNumber = 1;
    int limit = 100;

    public synchronized void printEvenNumber() {
        while (currentNumber < limit) {
            if (currentNumber % 2 == 1) {
                try {
                    wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " - " + currentNumber);
            currentNumber++;
            notify();
        }
    }

    public void printOddNumbers() {
        synchronized (this) {
            while (currentNumber < limit) {
                if (currentNumber % 2 == 0) {
                    try {
                        wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " - " + currentNumber);
                currentNumber++;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        TwoThreadNumberPrinter numberPrinter = new TwoThreadNumberPrinter();

        Thread evenThread = new Thread(() -> numberPrinter.printEvenNumber());
        Thread oddThread = new Thread(() -> numberPrinter.printOddNumbers());
        evenThread.start();
        oddThread.start();
    }
}
