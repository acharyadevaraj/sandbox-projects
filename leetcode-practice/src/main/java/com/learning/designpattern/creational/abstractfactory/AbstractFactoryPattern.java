package com.learning.designpattern.creational.abstractfactory;

interface Employee {
    public int getSalary();

    public String getName();
}

class WebDeveloper implements Employee {

    @Override
    public int getSalary() {
        System.out.println("Getting web developer salary");
        return 10000;
    }

    @Override
    public String getName() {
        return "Web developer";
    }
}

class AndroidDeveloper implements Employee {

    @Override
    public int getSalary() {
        System.out.println("Getting android developer salary");
        return 12000;
    }

    @Override
    public String getName() {
        return "android developer";
    }
}

class EmployeeFactory {
    public static Employee getEmployee(EmployeeAbstractFactory factory) {
        return factory.createEmployee();
    }
}

abstract class EmployeeAbstractFactory {
    public abstract Employee createEmployee();
}

class WebDevFactory extends EmployeeAbstractFactory {

    @Override
    public Employee createEmployee() {
        return new WebDeveloper();
    }
}

class AndroidDevFactory extends EmployeeAbstractFactory {

    @Override
    public Employee createEmployee() {
        return new AndroidDeveloper();
    }
}

public class AbstractFactoryPattern {
    public static void main(String[] args){
        Employee e1 = EmployeeFactory.getEmployee(new AndroidDevFactory());
        System.out.println(e1.getName());
    }
}