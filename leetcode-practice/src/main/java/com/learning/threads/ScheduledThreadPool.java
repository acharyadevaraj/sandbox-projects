package com.learning.threads;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.concurrent.*;

@AllArgsConstructor
public class ScheduledThreadPool implements Runnable {
    String task = "";

    @Override
    public void run() {
        System.out.println("Thread name : " + task + " Time :" + LocalDateTime.now());
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        Runnable task1 = new ScheduledThreadPool("task1");
        Runnable task2 = new ScheduledThreadPool("task2");
        System.out.println("Current time: " + LocalDateTime.now());

        scheduledThreadPool.schedule(task1, 3, TimeUnit.SECONDS);
        scheduledThreadPool.schedule(task2, 5, TimeUnit.SECONDS);
        scheduledThreadPool.shutdown();
    }
}
