package com.learning.threads;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> task = () -> {
            System.out.println("Task is running...");
            return 123;
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(task);
        Integer result = future.get();

        System.out.println("Result from the Callable task: " + result);
        executor.shutdown();
    }
}
