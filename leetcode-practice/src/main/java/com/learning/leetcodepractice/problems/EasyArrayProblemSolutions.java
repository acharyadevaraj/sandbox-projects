package com.learning.leetcodepractice.problems;

import java.util.HashSet;
import java.util.Set;

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
     * Problem Statement: #4 (Find the second largest element in an array without sorting)
     * <p>
     * Approach:
     * 1. Initialize `largest` and `secondLargest` to the smallest possible integer.
     * 2. Loop through the array:
     * - If an element is larger than `largest`, update `secondLargest` to `largest` and set `largest` to the element.
     * - If the element is between `largest` and `secondLargest`, update `secondLargest`.
     * 3. After the loop, return `secondLargest` or `-1` if there is no second largest element.
     * <p>
     * Time Complexity: O(n) – We traverse the array once.
     * <p>
     * Example:
     * Input: [10, 5, 20, 20, 4]
     * Output: 10
     */
    public int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }

    /**
     * Problem Statement: #5 (Check if an array is sorted and rotated)
     * <p>
     * An array is considered sorted and rotated if:
     * 1. It is sorted in ascending order.
     * 2. After sorting, it has been rotated from some pivot index.
     * <p>
     * Approach:
     * 1. Count the number of "order breaks".
     * 2. The array is sorted and rotated if:
     * - The number of order breaks is at most one.
     * - The last element is less than or equal to the first element (rotation condition).
     * <p>
     * Time Complexity: O(n) – The array is traversed once.
     * <p>
     * Example:
     * Input: [3, 4, 5, 1, 2]
     * Output: true (sorted and rotated)
     */
    public static boolean isSortedAndRotated(int[] arr) {
        int n = arr.length;
        int count = 0;

        // Count the number of order breaks
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[(i + 1) % n]) {
                count++;
            }
        }
        // The array is sorted and rotated if there's at most one order break
        return count <= 1;
    }

    /**
     * Problem Statement: #6 (Remove Duplicates from Sorted Array)
     * <p>
     * Approach:
     * 1. Use two pointers:
     * - `i` to track the position of the last unique element.
     * - `j` to traverse the array.
     * 2. Compare the current element (`nums[j]`) with the last unique element (`nums[i]`).
     * 3. If they are different, move `i` forward and update `nums[i]` with `nums[j]`.
     * 4. Return `i + 1`, which is the count of unique elements.
     * <p>
     * Example:
     * Input: [1, 1, 2, 2, 3, 4, 4, 5]
     * Output: 5 (Modified array: [1, 2, 3, 4, 5])
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0; // Handle edge case

        int i = 0; // Pointer for the last unique element

        for (int j = 0; j < nums.length; j++) {
            // Check if current element is different from the last unique one
            if (nums[j] != nums[j + 1]) {
                i++; // Move the unique pointer forward
                nums[i] = nums[j + 1]; // Update the position with the current unique element
            }
        }
        return i + 1; // Length of the unique elements
    }

    /**
     * Problem Statement: #7 (Find Common Elements in Two Arrays)
     * Given two integer arrays, return an array containing the common elements.
     * <p>
     * Example:
     * Input: nums1 = [1, 2, 3, 4], nums2 = [3, 4, 5, 6]
     * Output: [3, 4]
     * <p>
     * Time Complexity: O(m + n) (HashSet operations are O(1))
     * Space Complexity: O(min(m, n)) (For storing common elements)
     */
    public int[] findCommonElements(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        // Add all elements of nums1 to the set
        for (int num : nums1) {
            set.add(num);
        }

        // Check nums2 elements in set
        for (int num : nums2) {
            if (set.contains(num)) {
                resultSet.add(num);
            }
        }
        // Convert Set to array
        return resultSet.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Problem Statement: #8 ( Reverse an Array In-Place)
     * <p>
     * Approach:
     * 1. Initialize two pointers:
     * - `start` at the beginning of the array (index 0).
     * - `end` at the end of the array (index `array.length - 1`).
     * 2. Swap the elements at the `start` and `end` pointers.
     * 3. Move the `start` pointer forward and the `end` pointer backward.
     * 4. Repeat the process until the `start` pointer is greater than or equal to the `end` pointer.
     * 5. This results in the array being reversed in-place without using extra space (other than a temporary variable).
     * <p>
     * Example:
     * Input: [1, 2, 3, 4, 5]
     * Output: [5, 4, 3, 2, 1]
     */
    public static void reverseArrayInPlace(int[] array) {
        int start = 0;
        int end = array.length - 1;

        // Loop to swap elements from the start and end
        while (start < end) {
            // Swap elements at start and end
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            // Move pointers towards the center
            start++;
            end--;
        }
    }

    /**
     * Problem Statement: #9 (find the third digit from the left)
     * Given an integer `num`, find the third digit from the left without converting it into a string.
     * If the number has less than 3 digits, do not print anything.
     * <p>
     * Approach:
     * 1. Reduce `num` by continuously dividing by 10 until only the first three digits remain.
     * 2. Extract the third digit using modulo operation (`num % 10`).
     * <p>
     * Example:
     * Input: 67433
     * Output: 4
     */
    public static void findThirdDigit(int num) {
        if (num < 100) {
            return; // Don't print anything for numbers with less than 3 digits
        }

        while (num >= 1000) { // Remove extra digits until 3 digits remain
            num /= 10;
        }

        int thirdDigit = num % 10; // Extract the third digit
        System.out.println(thirdDigit);
    }

    /**
     * Problem Statement: #10 (Find Maximum in Bitonic Array)
     * Given a bitonic array (first increasing, then decreasing), find the maximum element.
     * The solution should have O(log n) time complexity.
     * <p>
     * Approach:
     * 1. Use binary search to locate the maximum element.
     * 2. If `arr[mid] > arr[mid + 1]`, the maximum is at `mid` or the left half.
     * 3. Otherwise, the maximum is on the right half.
     * <p>
     * Example:
     * Input: [2, 5, 7, 9, 11, 15, 21, 30, 17, 3, -2, -5]
     * Output: 30
     */
    public static int findMaxInBitonic(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // Decreasing part, max is at mid or left side
                right = mid;
            } else {
                // Increasing part, max is on right side
                left = mid + 1;
            }
        }
        return arr[left]; // 'left' will point to the max element
    }

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int[] mergedArray = new int[m + n];
        int i = 0, j = 0, k = 0;

        // Merge arrays by comparing elements
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }
        // Copy remaining elements of arr1 (if any)
        while (i < m) {
            mergedArray[k++] = arr1[i++];
        }
        // Copy remaining elements of arr2 (if any)
        while (j < n) {
            mergedArray[k++] = arr2[j++];
        }
        return mergedArray;
    }
}
