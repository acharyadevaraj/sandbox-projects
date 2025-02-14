package com.learning.leetcodepractice.dsa;

import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    private void enqueue(int value) {
        stack1.push(value);
    }

    private int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
