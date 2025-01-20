package com.learning.threads;

import lombok.AllArgsConstructor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
public class FixedThreadPool implements Runnable {

    String message = "";

    @Override
    public void run() {
        System.out.println("Starting: " + message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End :" + message);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            Runnable run = new FixedThreadPool(String.valueOf(i));
            executorService.execute(run);
        }
        executorService.shutdown();
    }
}