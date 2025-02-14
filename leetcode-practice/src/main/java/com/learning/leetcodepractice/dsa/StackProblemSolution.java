package com.learning.leetcodepractice.dsa;

import java.util.Stack;

public class StackProblemSolution {
    public static void sortStack(Stack<Integer> originalStack) {
        Stack<Integer> sortedStack = new Stack<>();
        while (!originalStack.isEmpty()) {
            int temp = originalStack.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek() > temp) {
                originalStack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }

        while (!sortedStack.isEmpty()) {
            originalStack.push(sortedStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack (Ascending Order): " + stack);
    }
}
