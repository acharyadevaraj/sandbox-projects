package com.learning.leetcodepractice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private String gender;
    private int age;
    private String department;

    public static List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee("John", "Male", 28, "IT"),
                new Employee("Jane", "Female", 25, "HR"),
                new Employee("Steve", "Male", 32, "Finance"),
                new Employee("Mary", "Female", 29, "IT"),
                new Employee("Tom", "Male", 39, "HR")
        );
    }
}