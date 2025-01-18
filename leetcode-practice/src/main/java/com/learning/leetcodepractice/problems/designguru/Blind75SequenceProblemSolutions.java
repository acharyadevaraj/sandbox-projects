package com.learning.leetcodepractice.problems.designguru;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Blind75SequenceProblemSolutions {

    /**
     * Problem #1: Two Sum
     * <p>
     * Finds the indices of two numbers in the array that add up to the given target.
     * <p>
     * Approach:
     * - Use a HashMap to store numbers and their indices as we iterate through the array.
     * - For each number, calculate its complement (target - current number).
     * - Check if the complement exists in the map:
     * - If yes, return the indices of the current number and its complement.
     * - Otherwise, add the current number to the map and continue.
     * <p>
     * Time Complexity: O(n), Space Complexity: O(n)
     * <p>
     * Example:
     * Input: nums = [3, 2, 4], target = 6
     * Output: [1, 2]
     * Explanation: nums[1] + nums[2] = 2 + 4 = 6
     *
     * @param nums   the input array of integers
     * @param target the target sum
     * @return an array of two indices that satisfy the condition
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i]; // Calculate the required complement for the current number

            if (map.containsKey(diff)) { // Check if the complement exists in the map
                return new int[]{map.get(diff), i}; // Return the indices of the numbers
            }
            map.put(nums[i], i); // Store the current number with its index in the map
        }
        return new int[]{}; // Return an empty array if no solution is found
    }

    /**
     * Problem #2: Contains Duplicate
     * <p>
     * Checks if the array contains any duplicate values.
     * <p>
     * Approach:
     * - Use a HashSet to store elements as we iterate through the array.
     * - For each number, check if it already exists in the set:
     * - If yes, return true as a duplicate is found.
     * - Otherwise, add the number to the set.
     * - If the loop completes without finding a duplicate, return false.
     * <p>
     * Time Complexity: O(n), Space Complexity: O(n)
     * <p>
     * Example:
     * Input: nums = [1, 2, 3, 4]
     * Output: false
     * Explanation: There are no duplicates in the given array.
     *
     * @param nums the input array of integers
     * @return true if any value appears at least twice, otherwise false
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>(); // To store unique numbers
        for (int num : nums) {
            if (seen.contains(num)) { // If the number already exists, it's a duplicate
                return true;
            }
            seen.add(num); // Add the number to the set
        }
        return false; // No duplicates found
    }

    /**
     * Problem #3: Best Time to Buy and Sell Stock
     * <p>
     * Finds the maximum profit that can be achieved by buying and selling a stock on different days.
     * <p>
     * Approach:
     * - Track the minimum price seen so far.
     * - For each price, calculate the potential profit if sold on that day.
     * - Update the maximum profit if the current profit is greater.
     * - Return the maximum profit at the end.
     * - If no profit is possible, the result will be 0.
     * <p>
     * Time Complexity: O(n), Space Complexity: O(1)
     * <p>
     * Example:
     * Input: prices = [3, 2, 6, 5, 0, 3]
     * Output: 4
     * Explanation: Buy the stock on day 2 (price = 2) and sell it on day 3 (price = 6). Profit = 6 - 2 = 4.
     *
     * @param prices the array of stock prices
     * @return the maximum profit, or 0 if no profit is possible
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Initialize with the largest possible value
        int maxProfit = 0; // Initialize the maximum profit

        for (int price : prices) {
            if (price < minPrice) { // Update the minimum price
                minPrice = price;
            } else if (price - minPrice > maxProfit) { // Calculate and update the maximum profit
                maxProfit = price - minPrice;
            }
        }
        return maxProfit; // Return the maximum profit
    }

    /**
     * Problem #4: Valid Anagram
     * <p>
     * Checks if two strings are anagrams of each other using a HashMap.
     * <p>
     * Approach:
     * - Use a HashMap to store the character count for the first string.
     * - Iterate through the second string:
     * - Decrease the character count for each character.
     * - If any character's count becomes negative, the strings are not anagrams.
     * - Finally, check that all character counts in the map are zero.
     * <p>
     * Time Complexity: O(n), Space Complexity: O(n)
     * <p>
     * Example:
     * Input: "listen", "silent"
     * Output: true
     *
     * @param s1 the first string
     * @param s2 the second string
     * @return true if the strings are anagrams, false otherwise
     */
    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) { // If lengths differ, they cannot be anagrams
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        // Count characters in the first string
        for (char c : s1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Decrease the count for characters in the second string
        for (char c : s2.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) - 1);
        }

        // Verify that all counts are zero
        for (int count : charCount.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Problem #5: Valid Parentheses
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

    /**
     * Problem Number: #6 Maximum Subarray
     * <p>
     * Finds the maximum sum of any contiguous subarray of size 'k' using the sliding window technique.
     * <p>
     * Approach:
     * - Use a sliding window of size 'k' to calculate the sum of the subarray in O(1) time for each shift.
     * - Maintain a running sum of the current window and update the maximum sum as you slide the window.
     * <p>
     * Example:
     * Input: arr = [2, 1, 5, 1, 3, 2], k = 3
     * Output: 9
     * Explanation: The subarray with the maximum sum is [5, 1, 3].
     * <p>
     * Example Walkthrough:
     * - Initial window sum: 2 + 1 + 5 = 8 → maxSum = 8
     * - Slide window:
     * - Add arr[3] = 1, subtract arr[0] = 2: 8 + 1 - 2 = 7
     * - Add arr[4] = 3, subtract arr[1] = 1: 7 + 3 - 1 = 9 → maxSum = 9
     * - Add arr[5] = 2, subtract arr[2] = 5: 9 + 2 - 5 = 6
     * - Final result: maxSum = 9
     *
     * @param arr the input array of positive integers
     * @param k   the size of the subarray
     * @return the maximum sum of any contiguous subarray of size 'k'
     */
    public int maxSubarraySum(int[] arr, int k) {
        int maxSum = 0;
        int windowSum = 0;

        // Calculate the sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // Slide the window across the array
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k]; // Add next element, remove first element of the previous window
            maxSum = Math.max(maxSum, windowSum); // Update maxSum if the new windowSum is greater
        }
        return maxSum;
    }

    /**
     * Problem Number: #7 (Group Anagrams)
     * <p>
     * Groups anagrams together from a list of strings.
     * <p>
     * Approach:
     * Use a HashMap where:
     * - Key: The sorted string (unique for each group of anagrams).
     * - Value: A list of strings that are anagrams of the key.
     * - Iterate through each string in the input array:
     * - Sort the string to get the key.
     * - Add the string to the list corresponding to that key in the map.
     * - At the end, return all the lists in the map as the result.
     * <p>
     * Example:
     * Input: ["dog", "god", "hello"]
     * Output: [["dog", "god"], ["hello"]]
     * <p>
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to hold sorted word as key and list of words as value
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] characters = str.toCharArray();
            Arrays.sort(characters);
            String sorted = new String(characters);
            // If the sorted word is not already a key in the map, add it with a new list as its value
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            // Add the original word to the list of values for the sorted word key
            map.get(sorted).add(str);
        }
        // Return the values of the map as a list of lists
        return new ArrayList<>(map.values());
    }
}