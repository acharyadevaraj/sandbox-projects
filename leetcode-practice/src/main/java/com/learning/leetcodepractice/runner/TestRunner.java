package com.learning.leetcodepractice.runner;

interface A {
    default void test() {
        System.out.println("print A");
    }
}

interface B {
    default void test() {
        System.out.println("print B");
    }
}

public class TestRunner implements A, B {

    public static void main(String[] args) {
        TestRunner runner = new TestRunner();
        runner.callBTest();
    }

    public void callBTest() {
        B.super.test();
    }

    @Override
    public void test() {

    }
}

class C extends TestRunner {

}

