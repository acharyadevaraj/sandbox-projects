package com.learning.leetcodepractice.problems;

import java.util.PriorityQueue;

public class SortingSolutions {
    /**
     * Problem Statement: #1 (Binary Search in a Sorted Array)
     * Given a sorted array and a target value, implement binary search to find the index of the target.
     * If the target is not found, return -1.
     * <p>
     * Approach:
     * 1. Initialize two pointers:
     * - `left` at index 0.
     * - `right` at index `nums.length - 1`.
     * 2. Use binary search:
     * - Compute `mid = left + (right - left) / 2` to avoid overflow.
     * - If `nums[mid] == target`, return `mid`.
     * - If `nums[mid] < target`, search in the right half (`left = mid + 1`).
     * - Otherwise, search in the left half (`right = mid - 1`).
     * 3. If the loop ends, return `-1`, indicating the target is not found.
     * <p>
     * Example:
     * Input: nums = [1, 3, 5, 7, 9, 11, 15], target = 7
     * Output: 3 (index of target)
     * Link: https://leetcode.com/problems/binary-search
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
        return -1;
    }

    /**
     * Problem Statement: #2 (Bubble Sort)
     * Implement Bubble Sort to sort an array in ascending order.
     * <p>
     * Approach:
     * 1. Iterate through the array multiple times.
     * 2. In each pass, compare adjacent elements and swap them if they are in the wrong order.
     * 3. If no swaps occur in a pass, the array is already sorted.
     * <p>
     * Example:
     * Input: [5, 2, 9, 1, 5, 6]
     * Output: [1, 2, 5, 5, 6, 9]
     * <p>
     * Time Complexity: O(n^2) (Worst & Average Case), O(n) (Best Case when already sorted)
     */
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

    /**
     * Problem Statement: #3 (Find Kth Largest Element)
     * Given an array of integers, find the K-th largest element using a min-heap.
     * <p>
     * Approach:
     * 1. Use a min-heap (PriorityQueue) of size `k`.
     * 2. Iterate through the array, adding elements to the heap.
     * 3. If the heap exceeds `k` elements, remove the smallest element.
     * 4. At the end, the root of the heap contains the K-th largest element.
     * <p>
     * Example:
     * Input: nums = [3, 2, 1, 5, 6, 4], k = 2
     * Output: 5
     * <p>
     * Time Complexity: O(n log k) (Heap operations)
     */
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
