package com.learning.leetcodepractice.runner;

import com.learning.leetcodepractice.problems.EasyStringProblemSolutions;

import java.util.Scanner;

public class StringProblemRunner {

    public static void main(String[] args) {
        EasyStringProblemSolutions problemSolutions = new EasyStringProblemSolutions();
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
            System.out.println("1. Length of Last Word");
            System.out.println("2. Reverse String In-Place");
            System.out.println("3. First Unique Character in a String");
            System.out.println("4. Reverse a String");
            System.out.println("5. Reverse the Order of Words in a Sentence");
            System.out.println("6. Check Palindrome String");
            System.out.println("7. Check Anagram Strings");
            System.out.println("8. Longest Palindromic Substring");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    // Run Length of Last Word problem
                    System.out.print("Enter a string: ");
                    String input1 = scanner.nextLine();
                    System.out.println("Length of last word: " + problemSolutions.lengthOfLastWord(input1));
                    break;
                case 2:
                    // Run Reverse String In-Place problem
                    System.out.print("Enter a string: ");
                    String input2 = scanner.nextLine();
                    char[] charArray = input2.toCharArray();
                    System.out.print("Reversed string (in-place): ");
                    for (char c : problemSolutions.reverseString(charArray)) {
                        System.out.print(c);
                    }
                    break;
                case 3:
                    System.out.print("Enter a string: ");
                    String input3 = scanner.nextLine();
                    int uniqueIndex = problemSolutions.firstUniqueChar(input3);
                    if (uniqueIndex == -1) {
                        System.out.println("No unique character found.");
                    } else {
                        System.out.println("First unique character index: " + uniqueIndex);
                    }
                    break;
                case 4:
                    System.out.print("Enter a string: ");
                    String input4 = scanner.nextLine();
                    System.out.println("Reversed string: " + problemSolutions.reverseWords(input4));
                    break;
                case 5:
                    System.out.print("Enter a sentence: ");
                    String input5 = scanner.nextLine();
                    System.out.println("Sentence with reversed word order: " + problemSolutions.reverseWords(input5));
                    break;
                case 6:
                    System.out.print("Enter a string: ");
                    String input6 = scanner.nextLine();
                    System.out.println("Is Palindrome: " + problemSolutions.isPalindrome(input6));
                    break;
                case 7:
                    System.out.print("Enter the first string: ");
                    String str1 = scanner.nextLine();
                    System.out.print("Enter the second string: ");
                    String str2 = scanner.nextLine();
                    System.out.println("Is anagrams: " + problemSolutions.isAnagram(str1, str2));
                    break;
                case 8:
                    System.out.print("Enter a string: ");
                    String input8 = scanner.nextLine();
                    System.out.println("Longest palindromic substring length: " + problemSolutions.longestPalindrome(input8));
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