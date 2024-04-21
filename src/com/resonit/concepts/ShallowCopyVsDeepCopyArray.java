package com.resonit.concepts;

import com.resonit.array.model.Employee;
import java.util.Arrays;

public class ShallowCopyVsDeepCopyArray {
    public static void main(String[] args) {
        deepCopyPrimitive();
        shallowCopyObject();
        deepCopyObject();
    }

    private static void deepCopyObject() {
        Employee[] empArr = new Employee[2];  //Original array

        empArr[0] = new Employee(100, "Lokesh", "Gupta");
        empArr[1] = new Employee(200, "Pankaj", "Kumar");
        //Shallow copied array
        Employee[] clonedArray = new Employee[empArr.length];
        for (int i = 0; i < empArr.length; i++) {
            clonedArray[i] = new Employee(empArr[i].getId(),empArr[i].getFirstName(),empArr[i].getLastName());
        }
        empArr[0].setFirstName("Ravi");

        System.out.println("Original array Employee First name: " + empArr[0].getFirstName());
        System.out.println("Shallow copied array Employee First name: " + clonedArray[0].getFirstName());

    }

    private static void deepCopyPrimitive() {
        int[] originalArray = {1, 2, 3, 4, 5};
        // creates deep copy
        int[] shallowCopy = originalArray.clone();
        // Modify the deep copy
        originalArray[1] = 200;
        // Print original and deep copied arrays
        System.out.println("Original array: " + Arrays.toString(originalArray));
        System.out.println("Deep copied array: " + Arrays.toString(shallowCopy));
    }

    private static void shallowCopyObject() {
        Employee[] empArr = new Employee[2];  //Original array

        empArr[0] = new Employee(100, "Lokesh", "Gupta");
        empArr[1] = new Employee(200, "Pankaj", "Kumar");
        //Shallow copied array
        Employee[] clonedArray = empArr.clone();

        empArr[0].setFirstName("Rajesh");

        System.out.println("Original array Employee First name: " + empArr[0].getFirstName());
        System.out.println("Shallow copied array Employee First name: " + clonedArray[0].getFirstName());
    }
}
