package com.resonit.array;

import com.resonit.array.model.Employee;

import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrSize = sc.nextInt();
        // declaring an array
        int[] arr;
        // initialising an array (giving memory space in heap of int*arrSize)
        arr = new int[arrSize];

        // taking array element from user
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        // print array length
        System.out.println("Length of an array: "+ arr.length);
        // printing the array elements
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Array element at index " + i +" is " + arr[i]);
        }

        int[] arrTemp = arr;
        arrTemp[2] = 200;
        // printing the array elements after changing deep copy
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Old Array element at " + i +" is " + arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("New Array element at " + i +" is " + arrTemp[i]);
        }

        Employee[] arrEmp = new Employee[3];

        arrEmp[0] = new Employee(1,"Piyush", "Chandekar");
        arrEmp[1] = new Employee(2,"Rahul", "Dravid");
        arrEmp[2] = new Employee(3,"Rohit", "Sharma");

        for(Employee emp : arrEmp){
            System.out.println(emp);
        }
    }
}
