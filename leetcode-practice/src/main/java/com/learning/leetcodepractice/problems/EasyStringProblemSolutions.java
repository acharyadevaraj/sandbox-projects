package com.learning.leetcodepractice.problems;


import java.util.*;

public class EasyStringProblemSolutions {

    /**
     * Problem Number: #1 (Length of Last Word)
     * <p>
     * Problem Statement:
     * Given a string `s` consisting of words and spaces, return the length of the last word in the string.
     * A word is defined as a sequence of non-space characters.
     * <p>
     * Approach:
     * 2. **Split into Words**: Use `split(" ")` to divide the string into an array of words.
     * 3. **Access the Last Word**: Fetch the last word from the array and return its length.
     * <p>
     * Time Complexity: O(n)
     * <p>
     * Example:
     * Input: "Hello World"
     * Output: 5
     */
    public int lengthOfLastWord(String s) {
        String[] arr = s.split("\\s+");
        return arr[arr.length - 1].length();
    }

    /**
     * Problem Number: #2 (Reverse String)
     * <p>
     * Problem Statement:
     * Given a string as an array of characters `s`, write a function to reverse the string.
     * The reversal must be done in-place with O(1) extra memory.
     * <p>
     * Approach:
     * 1. **Two-Pointer Technique**:
     * - Use two pointers: one at the beginning of the array (`left`) and the other at the end (`right`).
     * - Swap the characters at these pointers, then move `left` forward and `right` backward.
     * - Repeat this until the two pointers meet in the middle.
     * <p>
     * Time Complexity: O(n)
     * <p>
     * Example:
     * Input: ['h', 'e', 'l', 'l', 'o']
     * Output: ['o', 'l', 'l', 'e', 'h']
     */
    public char[] reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
        return s;
    }

    /**
     * Problem Number: #3 (Reverse Only Letters)
     * <p>
     * Problem Statement:
     * Given a string `s`, reverse the string according to the following rules:
     * - All non-English letters remain in the same position.
     * - All English letters (lowercase or uppercase) should be reversed.
     * Return the modified string.
     * <p>
     * Approach:
     * 1. **Two Pointers**:
     * - Use two pointers, `left` starting from the beginning and `right` from the end.
     * 2. **Skip Non-Letters**:
     * - Move the `left` pointer forward if the character is not a letter.
     * - Move the `right` pointer backward if the character is not a letter.
     * 3. **Swap Letters**:
     * - When both pointers are at letters, swap them.
     * - Continue until the pointers cross.
     * <p>
     * Time Complexity: O(n)
     * <p>
     * Example:
     * Input: s = "ab-cd"
     * Output: "dc-ba"
     */
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            // Move left pointer if not a letter
            while (left < right && !Character.isLetter(chars[left])) {
                left++;
            }
            // Move right pointer if not a letter
            while (left < right && !Character.isLetter(chars[right])) {
                right--;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    /**
     * Problem Number: #4 (Reverse String in Chunks of 2k)
     * <p>
     * Problem Statement:
     * Given a string `s` and an integer `k`, reverse the first `k` characters for every 2k characters counting from the start of the string.
     * If there are fewer than `k` characters left, reverse all of them. If there are less than `2k` but greater than or equal to `k` characters, then reverse the first `k` characters and leave the other as original.
     * <p>
     * Approach:
     * 1. **Character Array**:
     * - Convert the string to a character array to modify it in-place.
     * 2. **Iterate in Chunks**:
     * - Process the string in chunks of size `2k`.
     * - Reverse the first `k` characters of each chunk.
     * 3. **Two-Pointer Swap**:
     * <p>
     * Time Complexity: O(n)
     * <p>
     * Example:
     * Input: s = "abcdefg", k = 2
     * Output: "bacdfeg"
     */
    public String reverseStringInChunks(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n; i += 2 * k) {
            // Reverse the first k characters in each 2k chunk
            int left = i;
            int right = Math.min(i + k - 1, n - 1); // Ensure the right pointer does not exceed the string length
            while (left < right) {
                // Swap characters at left and right pointers
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    /**
     * Problem Number: #5 (Reverse Words in a String)
     * <p>
     * Problem Statement:
     * Given an input string `s`, reverse the order of words. A word is defined as a sequence of non-space characters. The reversed string should:
     * - Have words separated by a single space.
     * - Remove leading and trailing spaces.
     * - Remove extra spaces between words.
     * <p>
     * Approach:
     * 1. **Split the Words**:
     * - Use `split("\\s+")` to split the string into words based on one or more spaces.
     * 2. **Reverse the Words**:
     * - Use a `StringBuilder` to append the words in reverse order.
     * - Separate words by a single space.
     * <p>
     * Time Complexity: O(n), where n is the length of the string `s`.
     * <p>
     * Example:
     * Input: s = "  the sky  is blue  "
     * Output: "blue is sky the"
     */
    public String reverseWords(String s) {
        // Split the string into words based on one or more spaces
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();

        // Traverse the array in reverse and append words to the result
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" "); // Add a space between words
            }
        }
        return result.toString().trim();
    }

    /**
     * Problem Number: #6 (Reverse Vowels of a String)
     * <p>
     * Problem Statement:
     * Given a string `s`, reverse only all the vowels in the string and return the result.
     * - Vowels include: 'a', 'e', 'i', 'o', 'u' (both uppercase and lowercase).
     * - Non-vowel characters remain in their original position.
     * <p>
     * Approach:
     * 1. **Two Pointers**:
     * - Use two pointers, `left` starting at the beginning of the string and `right` at the end.
     * 2. **Identify Vowels**:
     * - Move the `left` pointer forward until it points to a vowel.
     * - Move the `right` pointer backward until it points to a vowel.
     * 3. **Swap Vowels**:
     * - If both pointers point to vowels, swap them and move the pointers inward.
     * - Repeat until the pointers cross.
     * <p>
     * Time Complexity: O(n), where n is the length of the string `s`.
     * <p>
     * Example Walkthrough:
     * Input: s = "IceCreAm"
     * Output: "AceCreIm"
     */
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        String vowels = "aeiouAEIOU";

        while (left < right) {
            while (left < right && vowels.indexOf(chars[left]) == -1) {
                left++;
            }
            while (left < right && vowels.indexOf(chars[right]) == -1) {
                right--;
            }
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }


    /**
     * Problem Number: #7 (Duplicate words in string)
     * Given a string `input`, find all duplicate words regardless of case.
     * - Words are separated by whitespace.
     * - Consider duplicates only if a word appears more than once.
     * <p>
     * Approach:
     * 1. **Normalize Case**:
     * - Convert the input string to lowercase and split the string by whitespace.
     * 2. **Count Word Frequencies**:
     * - Use a map to count occurrences of each word.
     * 3. **Collect Duplicates**:
     * - Add words with counts greater than 1 to the result set.
     * <p>
     * Time Complexity: O(n), where n is the number of words in the string.
     * <p>
     * Example:
     * Input: "This is a test This is only a test"
     * Output: ["this", "is", "a", "test"]
     */

    public Set<String> findDuplicateWords(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptySet();
        }

        String[] words = input.toLowerCase().split("\\s+");
        Map<String, Integer> wordCountMap = new HashMap<>();
        Set<String> duplicates = new HashSet<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        return duplicates;
    }

    /**
     * Problem Number: #8 (Finds the first unique character in a string)
     * <p>
     * Example:
     * Input: "leetcode"
     * Output: 0 (The first unique character is 'l')
     *
     * @param s the input string
     * @return the index of the first unique character, or -1 if none exists
     */
    public int firstUniqueChar(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Problem Number: #9 (Checks if a given string is a palindrome)
     * <p>
     * Example:
     * Input: "madam"
     * Output: true
     */
    public boolean isPalindrome(String s) {
        int mid = (s.length() / 2) - 1;
        int last = s.length() - 1;

        for (int i = 0; i <= mid; i++) {
            if (s.charAt(i) != s.charAt(last)) {
                return false;
            }
            last--;
        }
        return true;
    }

    /**
     * Problem Number: #10 (Checks if two strings are anagrams of each other using a HashMap)
     * <p>
     * Example:
     * Input: "listen", "silent"
     * Output: true
     */
    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : s1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (char s : s2.toCharArray()) {
            charCount.put(s, charCount.getOrDefault(s, 0) - 1);
        }

        for (int count : charCount.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Problem Number: #11 (Computes the length of the longest palindromic substring in a given string)
     * <p>
     * Example:
     * Input: "babad"
     * Output: 3 (The longest palindromic substring is "bab" or "aba")
     */
    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String input = s.substring(i, j);
                if (isPalindrome(input) && input.length() > longest.length()) {
                    longest = input;
                }
            }
        }
        return longest;
    }

    /**
     * Problem Number: #12 (Finds the longest common prefix string amongst an array of strings)
     * <p>
     * Example:
     * Input: ["flower", "flow", "flight"]
     * Output: "fl"
     * <p>
     * Input: ["dog", "racecar", "car"]
     * Output: "" (No common prefix)
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.isEmpty()) {
                return "";
            }
        }
        return prefix;
    }

    /**
     * Problem Number: #13 (Rotate String)
     * <p>
     * Problem Statement:
     * Given two strings `s` and `goal`, return true if and only if `s` can become `goal` after some number of shifts on `s`.
     * A shift consists of moving the leftmost character of `s` to the rightmost position.
     * <p>
     * Time Complexity: O(n)
     * <p>
     * Example:
     * Input: s = "abcde", goal = "cdeab"
     * Output: true
     * <p>
     * Input: s = "abcde", goal = "abced"
     * Output: false
     */
    public static boolean rotateString(String s, String goal) {
        // Ensure s and goal are of the same length and non-empty
        if (s.length() != goal.length()) {
            return false;
        }

        // Concatenate s with itself. If goal is a valid rotation, it must be a substring.
        String doubleS = s + s;

        // Check if goal is a valid substring of s + s
        return doubleS.contains(goal);
    }

    /**
     * Problem Number: #14 (Sort Characters by Frequency)
     * <p>
     * Problem Statement:
     * Given a string `s`, sort it in decreasing order based on the frequency of the characters.
     * The frequency of a character is the number of times it appears in the string.
     * <p>
     * Approach:
     * 1. **Frequency Count**:
     * - Use a HashMap to count the frequency of each character in the string.
     * 2. **Sorting**:
     * - Convert the keys of the map to a list and sort them by frequency in descending order.
     * 3. **Building the Result**:
     * - Construct the result string by appending each character based on its frequency.
     * <p>
     * Time Complexity: O(n log n) due to sorting.
     * <p>
     * Example:
     * Input: s = "tree"
     * Output: "eert" or "eetr"
     * <p>
     * Input: s = "cccaaa"
     * Output: "aaaccc" or "cccaaa"
     */
    public static String sortByFrequency(String inputString) {

        Map<Character, Integer> frequencyMap = new HashMap<>();
        StringBuilder resultString = new StringBuilder();

        // Step 1: Create a frequency map for characters
        for (char character : inputString.toCharArray()) {
            frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
        }

        // Step 2: Convert keys to a list and sort based on frequency (in descending order)
        List<Character> sortedCharacters = new ArrayList<>(frequencyMap.keySet());
        sortedCharacters.sort((char1, char2) -> frequencyMap.get(char2) - frequencyMap.get(char1));

        // Step 3: Build the resulting string by appending characters based on their frequencies
        for (char character : sortedCharacters) {
            int frequency = frequencyMap.get(character);
            for (int i = 0; i < frequency; i++) {
                resultString.append(character);
            }
        }
        return resultString.toString();
    }
}