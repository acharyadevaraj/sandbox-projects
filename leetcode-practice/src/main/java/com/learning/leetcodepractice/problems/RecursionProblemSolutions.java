package com.learning.leetcodepractice.problems;

public class RecursionProblemSolutions {
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return (n * (factorial(n - 1)));
    }

    public static void main(String[] args) {
        int fact = 5;
        System.out.println(factorial(fact));
    }
}
