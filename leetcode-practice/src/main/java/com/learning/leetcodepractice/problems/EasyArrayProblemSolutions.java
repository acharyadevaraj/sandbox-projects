package com.learning.leetcodepractice.problems;

import java.util.HashMap;
import java.util.Map;
public class EasyArrayProblemSolutions {

    /**
     * Problem Statement: #1 (Missing number in an array)
     * <p>
     * Find the missing number in an array of size `n` containing distinct numbers
     * from 1 to `n+1`, where exactly one number is missing.
     * <p>
     * Approach 1: Sum Formula (Mathematical)
     * - Use the formula for the sum of the first n natural numbers: `sum = n * (n + 1) / 2`
     * - Calculate the actual sum from the array.
     * - The difference between the expected and actual sum gives the missing number.
     * <p>
     * Time Complexity: O(n)
     * <p>
     * Example:
     * Input: [1, 2, 4, 5, 6]
     * Output: 3
     **/
    public int findMissingNumberInArray(int[] arr) {
        int n = arr.length + 1;
        int expectedSum = n * (n + 1) / 2;
        for (int num : arr) {
            expectedSum -= num;
        }
        return expectedSum;
    }

    /**
     * Problem Statement: #2 (Move all zeroes to the end)
     * <p>
     * Given an integer array, move all zeroes to the end while maintaining the
     * relative order of the non-zero elements.
     * <p>
     * Approach:
     * 1. **Two-Pointer Approach**:
     * - Use a pointer `index` to track the next position for a non-zero element.
     * - Move non-zero elements to the `index` position and increment `index`.
     * 2. **Fill Remaining Zeroes**:
     * - After placing all non-zero elements, set the remaining positions to zero.
     * <p>
     * Time Complexity: O(n)
     * <p>
     * Example:
     * Input: [1, 2, 0, 4, 3, 0, 5, 0]
     * Output: [1, 2, 4, 3, 5, 0, 0, 0]
     **/
    public static void moveZeroesToEnd(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }
        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }
    }

    /**
     * Problem Statement: #3 (Find the largest and smallest elements in an array)
     * <p>
     * Given an array of integers, this method identifies and returns the smallest
     * and largest values in the array.
     * <p>
     * Approach:
     * 1. Initialize two variables:
     * - `smallest` with the maximum possible integer value.
     * - `largest` with the minimum possible integer value.
     * 2. Traverse the array:
     * - Compare each element with `smallest` and `largest`.
     * 3. Return the smallest and largest values.
     * <p>
     * Time Complexity: O(n)
     */
    public static void findLargestAndSmallest(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num < smallest) {
                smallest = num;
            }
            if (num > largest) {
                largest = num;
            }
        }
        System.out.println("Smallest Element: " + smallest);
        System.out.println("Largest Element: " + largest);
    }

    /**
     * Two sum
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
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
