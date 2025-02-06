package com.learning.leetcodepractice.problems;

import java.util.*;
import java.util.stream.Collectors;

public class StreamProblemSolutions {
    /**
     * Problem Statement #1: (Find the maximum number in a list of integers)
     * <p>
     * Approach:
     * 1. Use the `max` method of the Stream API to get the maximum value.
     * 2. Compare the elements using `Integer::compareTo`.
     * <p>
     * Example:
     * Input: [3, 4, 5, 9, 2, 6]
     * Output: 9
     */
    public void findMax() {
        List<Integer> input = Arrays.asList(3, 4, 5, 9, 2, 6);
        Integer max = input.stream().max(Integer::compareTo).get();
        System.out.println(max);
    }

    /**
     * Problem Statement #2: (Sort a list of strings by their length)
     * <p>
     * Approach:
     * 1. Use the `sorted` method of the Stream API with a comparator to sort strings by length.
     * <p>
     * Example:
     * Input: ["apple", "pear", "banana", "kiwi"]
     * Output: ["kiwi", "pear", "apple", "banana"]
     */
    public void sortStringByLength() {
        List<String> input = Arrays.asList("apple", "pear", "banana", "kiwi");
        List<String> sortedByLength = input.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        System.out.println(sortedByLength);
    }

    /**
     * Problem Statement #3: (Remove duplicates from a list of integers)
     * <p>
     * Approach:
     * 1. Use the `distinct` method of the Stream API to remove duplicate values.
     * <p>
     * Example:
     * Input: [1, 2, 2, 3, 4, 4, 5]
     * Output: [1, 2, 3, 4, 5]
     */
    public void removeDuplicates() {
        List<Integer> input = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> result = input.stream().distinct().toList();
        System.out.println(result);
    }

    /**
     * Problem Statement #4: (Group integers into even and odd)
     * <p>
     * Approach:
     * 1. Use the `groupingBy` method of the Stream API to group integers based on their parity (even/odd).
     * <p>
     * Example:
     * Input: [1, 2, 3, 4, 5, 6, 7, 8]
     * Output: {odd=[1, 3, 5, 7], even=[2, 4, 6, 8]}
     */
    public void groupByEvenOdd() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Map<String, List<Integer>> result = input.stream()
                .collect(Collectors.groupingBy(num -> num % 2 == 0 ? "even" : "odd"));
        System.out.println(result);
    }

    /**
     * Problem Statement #5: (Count frequency of words in a list)
     * <p>
     * Approach:
     * 1. Use the `groupingBy` method of the Stream API with `Collectors.counting` to count the occurrences of each word.
     * <p>
     * Time Complexity: O(n) (Stream traversal for grouping and counting)
     * <p>
     * Example:
     * Input: ["apple", "banana", "apple", "orange", "banana", "apple"]
     * Output: {apple=3, banana=2, orange=1}
     */
    public void countWordFrequency() {
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> result = input.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println(result);
    }

    /**
     * Problem Statement #6: (Find the second largest number in a list)
     * <p>
     * Approach:
     * 1. Sort the list in reverse order.
     * 2. Skip the first element and get the next element.
     * <p>
     * Example:
     * Input: [3, 1, 6, 1, 5, 9]
     * Output: 6
     */
    public void findSecondLargest() {
        List<Integer> input = Arrays.asList(3, 1, 6, 1, 5, 9);
        Integer result = input.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println(result);
    }

    /**
     * Problem Statement #7: (Check if all numbers are even)
     * <p>
     * Approach:
     * 1. Use the `allMatch` method of the Stream API to check if all numbers satisfy the condition of being even.
     * <p>
     * Example:
     * Input: [2, 4, 6, 8, 7]
     * Output: false
     */
    public void allEven() {
        List<Integer> input = Arrays.asList(2, 4, 6, 8, 7);
        Boolean allEven = input.stream().allMatch(num -> num % 2 == 0);
        System.out.println(allEven);
    }

    /**
     * Problem Statement #8: (Filter even numbers from a list)
     * <p>
     * Approach:
     * 1. Use the `filter` method of the Stream API to check if a number is even.
     * <p>
     * Example:
     * Input: [10, 15, 8, 49, 25, 98, 32]
     * Output: [10, 8, 98, 32]
     */
    public void filterEvenNumbers() {
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        List<Integer> result = list.stream()
                .filter(num -> num % 2 == 0)
                .toList();
        System.out.println(result);
    }

    /**
     * Problem Statement #9: (Find numbers starting with 1)
     * <p>
     * Approach:
     * 1. Convert each number to a string using `map`.
     * 2. Use `filter` to select strings that start with '1'.
     * <p>
     * Example:
     * Input: [10, 15, 8, 49, 25, 98, 32]
     * Output: [10, 15]
     */
    public void findNumbersStartingWithOne() {
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        List<String> result = list.stream()
                .map(num -> num.toString())
                .filter(num -> num.startsWith("1"))
                .toList();
        System.out.println(result);
    }

    /**
     * Problem Statement #10: (Find duplicate elements in a list)
     * <p>
     * Approach:
     * 1. Use a `Set` to track seen elements.
     * 2. Use `filter` to identify elements that have already been added to the set.
     * <p>
     * Example:
     * Input: [10, 15, 8, 49, 25, 98, 98, 32, 15]
     * Output: [15, 98]
     */
    public void findDuplicateElements() {
        Set<Integer> set = new HashSet<>();
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        List<Integer> result = myList.stream()
                .filter(num -> !set.add(num))
                .toList();
        System.out.println(result);
    }

    /**
     * Problem Statement #11: (Count the total number of elements in a list)
     * <p>
     * Approach:
     * 1. Use the `count` method of the Stream API.
     * <p>
     * Example:
     * Input: [10, 15, 8, 49, 25, 98, 98, 32, 15]
     * Output: 9
     */
    public void countElementsInList() {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        long count = myList.stream().count();
        System.out.println(count);
    }

    /**
     * Problem Statement #13: (Find the first non-repeated character in a string)
     * <p>
     * Approach:
     * 1. Convert the string into a character stream.
     * 2. Use `filter` to find the first character that is unique.
     * <p>
     * Example:
     * Input: "Java Articles are Awesome"
     * Output: 'J'
     */
    public void findFirstNonRepeatedCharacter() {
        String input = "Java Articles are Awesome";
        Character result = input.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> input.indexOf(ch) == input.lastIndexOf(ch))
                .findFirst().orElse(null);
        System.out.println(result);
    }

    /**
     * Problem Statement #14: (Find the first repeated character in a string)
     * <p>
     * Approach:
     * 1. Convert the string into a character stream.
     * 2. Use `filter` to find the first character that repeats.
     * <p>
     * Example:
     * Input: "Java Articles are Awesome"
     * Output: 'a'
     */
    public void findFirstRepeatedCharacter() {
        String input = "Java Articles are Awesome";
        Character result = input.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> input.indexOf(ch) != input.lastIndexOf(ch))
                .findFirst().orElse(null);
        System.out.println(result);
    }

    /**
     * Problem Statement #15: (Sort a list of integers in ascending order)
     * <p>
     * Approach:
     * 1. Use the `sorted` method of the Stream API.
     * <p>
     * Example:
     * Input: [10, 15, 8, 49, 25, 98, 98, 32, 15]
     * Output: [8, 10, 15, 15, 25, 32, 49, 98, 98]
     */
    public void sortNumbersInAscendingOrder() {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        List<Integer> result = myList.stream()
                .sorted()
                .toList();
        System.out.println(result);
    }

    /**
     * Problem Statement #16: (Sort a list of integers in descending order)
     * <p>
     * Approach:
     * 1. Use the `sorted` method with `Collections.reverseOrder()`.
     * <p>
     * Example:
     * Input: [10, 15, 8, 49, 25, 98, 98, 32, 15]
     * Output: [98, 98, 49, 32, 25, 15, 15, 10, 8]
     */
    public void sortNumbersInDescendingOrder() {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        List<Integer> result = myList.stream()
                .sorted(Collections.reverseOrder())
                .toList();
        System.out.println(result);
    }

    /**
     * Problem Statement #17: (Check if an array contains duplicate numbers)
     * <p>
     * Approach:
     * 1. Convert the array to a stream.
     * 2. Use a `HashSet` to track already seen numbers.
     * 3. Use `anyMatch` to check if a number is already in the set.
     * <p>
     * Example:
     * Input: [1, 2, 3, 1]
     * Output: true
     */
    public boolean hasDuplicateNumbers(int[] input) {
        Set<Integer> uniqueElements = new HashSet<>();
        return Arrays.stream(input).anyMatch(num -> !uniqueElements.add(num));
    }

    /**
     * Problem Statement #18: (Find duplicate strings and their counts in a list)
     * <p>
     * Approach:
     * 1. Use `groupingBy` to count occurrences of each string.
     * 2. Filter entries with a count greater than 1.
     * 3. Collect the results into a map.
     * <p>
     * Example:
     * Input: ["AA", "BB", "AA", "CC"]
     * Output: {AA=2}
     */
    public Map<String, Long> findDuplicateStringCounts(List<String> names) {
        return names.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * Problem Statement #19: (Count occurrences of each character in a string, excluding spaces)
     * <p>
     * Approach:
     * 1. Split the string into characters.
     * 2. Convert all characters to uppercase.
     * 3. Use `groupingBy` to count occurrences of each character.
     * 4. Exclude spaces from the count.
     * <p>
     * Example:
     * Input: "Java Articles"
     * Output: {J=1, A=4, V=1, R=1, T=1, I=1, C=1, L=1, E=1, S=1}
     */
    public Map<String, Long> countCharacterOccurrences(String input) {
        return Arrays.stream(input.split(""))
                .map(String::toUpperCase)
                .filter(s -> !s.equals(" "))
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
    }

    /**
     * Problem Statement #19: (Count occurrences of specific words in a string, ignoring case sensitivity)
     * <p>
     * Example:
     * Input:
     * String input = "There are many ARE s in this sentence and I
     * request you to identify how many ARE s or arE s or are s in this.";
     * List<String> list = Arrays.asList("if", "are", "you");
     * Output: {are=3, you=1}
     */
    public Map<String, Long> countWordOccurrences(String input, List<String> targetWords) {
        return Arrays.stream(input.split("\\s+"))
                .map(String::toLowerCase)
                .filter(word -> targetWords.contains(word))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }

    /**
     * Problem Statement #20: (Split full names into individual words using flatMap)
     * <p>
     * Example:
     * Input:
     * List<String> names = List.of("John Doe", "Alice Bob", "Charlie Brown");
     * <p>
     * Output:
     * ["John", "Doe", "Alice", "Bob", "Charlie", "Brown"]
     */
    public static void getWordsFromNames() {
        List<String> names = List.of("John Doe", "Alice Bob", "Charlie Brown");
        List<String> words = names.stream()
                .flatMap(name -> Arrays.stream(name.split(" ")))
                .collect(Collectors.toList());

        System.out.println(words);
    }
}
