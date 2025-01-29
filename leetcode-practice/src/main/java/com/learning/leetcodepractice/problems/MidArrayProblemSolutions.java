package com.learning.leetcodepractice.problems;

public class MidArrayProblemSolutions {

    /**
     * Problem Number: #1 (Remove Duplicates from Sorted Array II)
     * <p>
     * Problem Statement:
     * Given a sorted array `nums`, remove duplicates in-place such that each element
     * appears at most twice. Return the length of the modified array.
     * <p>
     * Approach:
     * 1. Use an index `i` to track the position of the next unique element.
     * 2. Iterate through the array.
     * 3. Add an element to the result if it's within the first two positions or not a duplicate of `nums[i-2]`.
     * 4. Update the array and increment `i` as needed.
     * 5. Return `i` as the length of the modified array.
     * <p>
     * Time Complexity: O(n), where n is the length of the array.
     * <p>
     * Example:
     * Input: nums = [1, 1, 1, 2, 2, 3]
     * Output: 5 (Modified array: [1, 1, 2, 2, 3])
     * <p>
     * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
     * YouTube: https://www.youtube.com/watch?v=BLFvXsBf5uM&t=472s
     */
    public int removeDuplicatesArray2(int[] nums) {
        int i = 0; // Pointer to track the next unique position
        for (int num : nums) {
            if (i < 2 || num != nums[i - 2]) {
                nums[i++] = num; // Add the element if conditions are met
            }
        }
        return i; // Return the new length of the array
    }
}
