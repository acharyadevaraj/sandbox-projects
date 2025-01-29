package com.learning.leetcodepractice.problems;

import java.util.List;
import java.util.Stack;

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

    /**
     * Problem #2: Valid Parentheses
     * <p>
     * Determines if a string containing only '(', ')', '{', '}', '[' and ']' is valid.
     * <p>
     * Approach:
     * - Use a Stack to track unmatched opening brackets.
     * - For each character in the string:
     * - Push opening brackets onto the stack.
     * - For closing brackets, check if the stack is empty or if the top of the stack matches.
     * - If no match is found, return false immediately.
     * - Finally, check if the stack is empty (all brackets matched).
     * <p>
     * Time Complexity: O(n), Space Complexity: O(n)
     * <p>
     * Examples:
     * Input: "(]"
     * Output: false
     * Explanation: '(' is not closed by its corresponding ')'.
     *
     * @param s the input string containing only '(', ')', '{', '}', '[' and ']'
     * @return true if the string is valid, false otherwise
     */
    public boolean isValidParentheses(String s) {
        // Stack to track opening brackets
        Stack<Character> stack = new Stack<>();

        // Iterate through the string
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If it's a closing bracket, check the stack
            else {
                // If the stack is empty or doesn't match, return false
                if (stack.isEmpty() ||
                        (c == ')' && stack.peek() != '(') ||
                        (c == '}' && stack.peek() != '{') ||
                        (c == ']' && stack.peek() != '[')) {
                    return false;
                }
                // Pop the matched opening bracket
                stack.pop();
            }
        }
        // Check if the stack is empty (all brackets matched)
        return stack.isEmpty();
    }
}
