package com.learning.threads;

public class InterThreadCommunication {
    double amount = 15000;

    synchronized void withdraw(double withdrawAmount) {
        System.out.println("Starting the withdraw: " + withdrawAmount);
        if (amount < withdrawAmount) {
            System.out.println("Insufficient Balance, waiting for deposit...");
            try {
                wait();  // Release the lock and wait for deposit
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        amount -= withdrawAmount;
        System.out.println("Amount withdrawn successfully, Balance is: " + amount);
    }

    synchronized void deposit(double depositAmount) {
        System.out.println("Starting the deposit: " + depositAmount);
        amount += depositAmount;
        System.out.println("Amount deposited, Balance is: " + amount);
        notify();
    }

    public static void main(String[] args) {
        InterThreadCommunication threadCommunication = new InterThreadCommunication();

        new Thread() {
            public void run() {
                threadCommunication.withdraw(20000);
            }
        }.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread() {
            public void run() {
                threadCommunication.deposit(10000);
            }
        }.start();
    }
}
