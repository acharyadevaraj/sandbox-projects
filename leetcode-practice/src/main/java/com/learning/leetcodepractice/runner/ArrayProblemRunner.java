package com.learning.leetcodepractice.runner;

import com.learning.leetcodepractice.problems.EasyArrayProblemSolutions;

import java.util.Scanner;

public class ArrayProblemRunner {
    public static void main(String[] args) {
        EasyArrayProblemSolutions problemSolutions = new EasyArrayProblemSolutions();
        Scanner scanner = new Scanner(System.in);

        // Select problem difficulty
        System.out.println("Choose problem difficulty:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.print("Enter difficulty level: ");
        int difficultyLevel = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (difficultyLevel == 1) {
            // Easy problems
            System.out.println();
            System.out.println("Choose an easy problem to run:");
            System.out.println("1. Two Sum");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    // Two Sum Problem
                    System.out.print("Enter the array of integers (comma-separated): ");
                    String[] inputArray = scanner.nextLine().split(",");
                    int[] nums = new int[inputArray.length];
                    for (int i = 0; i < inputArray.length; i++) {
                        nums[i] = Integer.parseInt(inputArray[i].trim());
                    }
                    System.out.print("Enter the target sum: ");
                    int target = scanner.nextInt();
                    int[] result = problemSolutions.twoSum(nums, target);
                    System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
                    break;
                default:
                    System.out.println("Invalid choice! Please select either 1 or 2.");
            }
        } else if (difficultyLevel == 2) {
            System.out.println("No medium problems available yet.");
        } else if (difficultyLevel == 3) {
            System.out.println("No hard problems available yet.");
        } else {
            System.err.println("Invalid difficulty level! Please select either 1, 2, or 3.");
        }
    }
}
