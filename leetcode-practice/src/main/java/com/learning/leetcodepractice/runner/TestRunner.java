package com.learning.leetcodepractice.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestRunner {

    public static void main(String[] args) {
        List<List<List<Integer>>> nestedList = Arrays.asList(
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(4, 5)
                ),
                Arrays.asList(
                        Arrays.asList(6, 7),
                        Arrays.asList(8, 9, 10)
                )
        );

       List<Integer> result =  nestedList.stream().flatMap(num -> num.stream().flatMap(num1 -> num1.stream())).toList();
        System.out.println(result);
    }

    public static int sumOfUniqueCharacters(String s) {
        int n = s.length();
        int sum = 0;

        // Generate all substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                sum += countUniqueCharacters(sub);
            }
        }
        return sum;
    }

    private static int countUniqueCharacters(String sub) {
        return (int) sub.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .filter(map -> map.getValue() == 1)
                .count();
    }
}

