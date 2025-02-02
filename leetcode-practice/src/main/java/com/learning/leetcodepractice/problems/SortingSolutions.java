package com.learning.leetcodepractice.problems;

import java.util.PriorityQueue;

public class SortingSolutions {
    /**
     * Problem Statement: Implement Binary Search on a Sorted Array
     * <p>
     * Approach:
     * 1. Initialize two pointers:
     * - `left` at the beginning of the array (index 0).
     * - `right` at the end of the array (index `nums.length - 1`).
     * 2. While `left` is less than or equal to `right`:
     * - Calculate `mid` as `left + (right - left) / 2` to avoid overflow.
     * - If `nums[mid]` is equal to `target`, return `mid` (index found).
     * - If `nums[mid]` is less than `target`, move `left` to `mid + 1` (search right half).
     * - Otherwise, move `right` to `mid - 1` (search left half).
     * 3. If the loop ends, return `-1`, indicating the target is not found.
     * <p>
     * Example:
     * Input: nums = [1, 3, 5, 7, 9, 11, 15], target = 7
     * Output: 3 (index of target)
     * Link : https://leetcode.com/problems/binary-search
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                left = mid + 1; // Search in right half
            } else {
                right = mid - 1; // Search in left half
            }
        }
        return -1; // Target not found
    }

    public static void bubbleSort(int arr[]) {
        int length = arr.length - 1;

        for (int i = 0; i < length; i++) {
            boolean swapped = false;
            for (int j = 0; j < length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k); // Min-Heap

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) { // Remove smallest element if heap size exceeds k
                minHeap.poll();
            }
        }
        return minHeap.peek(); // Root is the K-th largest element
    }
}
