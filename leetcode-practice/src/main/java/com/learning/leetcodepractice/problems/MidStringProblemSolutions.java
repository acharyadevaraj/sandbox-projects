package com.learning.leetcodepractice.problems;

import java.util.HashSet;
import java.util.Set;

public class MidStringProblemSolutions {
    /**
     * Problem Number: #1 (Longest Substring Without Repeating Characters)
     * <p>
     * Problem Statement:
     * Given a string `s`, find the length of the longest substring without repeating characters.
     * Approach:
     * 1. Use a sliding window with two pointers (`left` and `right`) to represent the current substring.
     * 2. Use a `HashSet` to track unique characters in the window.
     * 3. Move the `right` pointer to expand the window and add characters to the set.
     * 4. If a repeating character is found, move the `left` pointer to shrink the window and remove characters from the set.
     * 5. Track the maximum length of the window during the process.
     * <p>
     * Time Complexity: O(n), where n is the length of the string.
     * <p>
     * Example:
     * Input: "abcabcbb"
     * Output: 3
     * Link : https://leetcode.com/problems/longest-substring-without-repeating-characters
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0; // Left pointer of the sliding window
        int maxLength = 0; // Result: length of the longest substring
        Set<Character> set = new HashSet<>(); // Set to track unique characters in the current window
        // int startIndex = 0; // To store the starting index of the longest substring (if needed)

        for (int right = 0; right < s.length(); right++) {
            // If the current character is already in the set, move the left pointer
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left)); // Remove the character at the left pointer
                left++; // Move the left pointer to the right
            }
            // Add the current character to the set
            set.add(s.charAt(right));

            // Update the maximum length
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                // startIndex = left; // (Optional) Record the starting index if you need the substring itself
            }
        }
        return maxLength;
        // return s.substring(startIndex, startIndex + maxLength); // (Optional) Return the longest substring itself if required
    }
}
