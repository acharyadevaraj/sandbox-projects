package com.learning.leetcodepractice.problems;

import java.util.List;

public class CollectionProblemSolutions {
    /**
     * Problem Statement #1: (Sort a list of strings by their length)
     * <p>
     * Approach:
     * 1. Use the Bubble Sort algorithm to compare adjacent strings based on their lengths.
     * 2. Swap strings if the length of the current string is greater than the next string.
     * <p>
     * Time Complexity: O(n^2) (Bubble sort for n strings)
     * <p>
     * Example:
     * Input: ["apple", "dog", "banana", "cat"]
     * Output: ["dog", "cat", "apple", "banana"]
     */
    public List<String> sortStringByLength(List<String> input) {
        int length = input.size();
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < (length - i) - 1; j++) {
                if (input.get(j).length() > input.get(j + 1).length()) {
                    String temp = input.get(j);
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temp);
                }
            }
        }
        return input;
    }
}
