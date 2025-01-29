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
    private double sal;

    public static List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee("John", "Male", 28, "IT", 120000),
                new Employee("Jane", "Female", 25, "HR", 130000),
                new Employee("Steve", "Male", 32, "Finance", 120000),
                new Employee("Mary", "Female", 29, "IT", 150000),
                new Employee("Tom", "Male", 39, "HR", 100000)
        );
    }
}