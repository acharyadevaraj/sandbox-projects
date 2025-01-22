package com.learning.designpattern.creational;

public class SingletonPattern {
    private static SingletonPattern instance;

    private SingletonPattern() {
        // private constructor to prevent instantiation
    }

    public static SingletonPattern getInstance() {
        if (instance == null) {
            instance = new SingletonPattern();
        }
        return instance;
    }
}
