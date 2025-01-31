package com.learning.leetcodepractice.runner;

import java.util.*;
import java.util.concurrent.*;


public class TestRunner {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 8;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        for (int num : nums){
            queue.add(num);
            if(queue.size() > k){
                queue.poll();
            }
        }
        System.out.println(queue.peek());
    }
}

