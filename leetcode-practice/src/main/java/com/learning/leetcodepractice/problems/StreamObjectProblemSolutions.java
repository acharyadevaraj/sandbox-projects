package com.learning.leetcodepractice.problems;

import com.learning.leetcodepractice.entity.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class StreamObjectProblemSolutions {
    /**
     * Problem Statement #1: (Find the count of employees by gender)
     * <p>
     * Approach:
     * 1. Fetch the list of employees.
     * 2. Group employees by their gender using `Collectors.groupingBy`.
     * 3. Count the number of employees in each gender group.
     * <p>
     * Example:
     * Input: List of employees with gender Male and Female.
     * Output: {Male=3, Female=2}
     */
    public void findEmployeeCountByGender(List<Employee> employees) {
        Map<String, Long> genderCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        genderCount.forEach((gender, count) ->
                System.out.println("Gender: " + gender + ", Count: " + count));
    }

    /**
     * Problem Statement #2: (Find distinct departments in the organization)
     * <p>
     * Approach:
     * 1. Fetch the list of employees.
     * 2. Extract distinct department names using `distinct`.
     * <p>
     * Example:
     * Input: List of employees with departments IT, HR, and Finance.
     * Output: [IT, HR, Finance]
     */
    public void findDistinctDepartments(List<Employee> employees) {
        List<String> distinctDepartments = employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .toList();

        System.out.println("Distinct Departments: " + distinctDepartments);
    }

    /**
     * Problem Statement #3: (Find the average age of employees by gender)
     * <p>
     * Approach:
     * 1. Fetch the list of employees.
     * 2. Group employees by their gender using `Collectors.groupingBy`.
     * 3. Calculate the average age of employees in each gender group.
     * <p>
     * Example:
     * Input: List of employees with gender Male and Female and their ages.
     * Output: {Male=31.0, Female=27.0}
     */
    public void findAverageAgeByGender(List<Employee> employees) {
        Map<String, Double> averageAgeByGender = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

        averageAgeByGender.forEach((gender, averageAge) ->
                System.out.println("Gender: " + gender + ", Average Age: " + averageAge));
    }

    /**
     * Problem Statement #4: (Find the oldest employee in the organization)
     * <p>
     * Approach:
     * 1. Fetch the list of employees.
     * 2. Use `max` with a comparator on the age field to find the oldest employee.
     * <p>
     * Example:
     * Input: List of employees with ages.
     * Output: Oldest Employee's Name, Age, and Department.
     */
    public void findOldestEmployee(List<Employee> employees) {
        Employee oldestEmployee = employees.stream()
                .max(Comparator.comparing(Employee::getAge))
                .orElseThrow(() -> new NoSuchElementException("No employees found"));

        System.out.println("Oldest Employee:");
        System.out.println("Name: " + oldestEmployee.getName());
        System.out.println("Age: " + oldestEmployee.getAge());
        System.out.println("Department: " + oldestEmployee.getDepartment());
    }
}
