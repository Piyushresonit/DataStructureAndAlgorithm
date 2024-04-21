package com.resonit.arraylist;

import com.resonit.arraylist.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1,"Piyush", "Chandekar"));
        employeeList.add(new Employee(2,"Rahul", "Dravid"));
        employeeList.add(new Employee(3,"Rohit", "Sharma"));

        for (Employee emp: employeeList) {
            System.out.println(emp);
        }

    }
}
