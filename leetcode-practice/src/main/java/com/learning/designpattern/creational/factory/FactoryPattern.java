package com.learning.designpattern.creational.factory;

interface Employee {
    public int getSalary();
}

class WebDeveloper implements Employee {

    @Override
    public int getSalary() {
        System.out.println("Getting web developer salary");
        return 10000;
    }
}

class AndroidDeveloper implements Employee {

    @Override
    public int getSalary() {
        System.out.println("Getting android developer salary");
        return 12000;
    }
}

class EmployeeFactory {
    public Employee getEmployee(String type) {
        if (type.equalsIgnoreCase("WEB_DEVELOPER")) {
            return new WebDeveloper();
        } else if (type.equalsIgnoreCase("ANDROID_DEVELOPER")) {
            return new AndroidDeveloper();
        } else {
            return null;
        }
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee employee = employeeFactory.getEmployee("WEB_DEVELOPER");
        System.out.println(employee.getSalary());

        employee = employeeFactory.getEmployee("ANDROID_DEVELOPER");
        System.out.println(employee.getSalary());
    }
}