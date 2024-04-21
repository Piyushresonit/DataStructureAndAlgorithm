package com.resonit.array;

import java.util.Scanner;

public class SumOfArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr1Size = sc.nextInt();
        int[] arr1 = new int[arr1Size];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        int arr2Size = sc.nextInt();
        int[] arr2 = new int[arr2Size];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.println("first array");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println("\nsecond array");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

        int[] sumOfArray = sumOfArrays(arr1, arr2);
        System.out.println("\nSum of an Array: ");

        for (int i = 0; i < arr2.length; i++) {
            System.out.print(sumOfArray[i] + " ");
        }

        int number = convertArrayIntoNumber(sumOfArray);
        System.out.println(number);
    }

    private static int convertArrayIntoNumber(int[] arr) {
        int result = 0;
        int k = arr.length - 1;
        while (k >= 0) {
            result = result * 10;
            result += arr[k];

            k--;
        }
        return result;
    }

    private static int[] sumOfArrays(int[] arr1, int[] arr2) {
        // length of new array
        int[] sumArr = new int[arr1.length >= arr2.length ? arr1.length : arr2.length];

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = sumArr.length - 1;
        int carry = 0;

        while (k >= 0) {
            int digit = carry;
            if (i >= 0)
                digit += arr1[i];
            if (j >= 0)
                digit += arr2[j];

            carry = digit / 10;
            digit = digit % 10;

            sumArr[k] = digit;
            i--;
            j--;
            k--;

            if (k <= 0 && carry != 0)
                sumArr[sumArr.length - 1] = sumArr[sumArr.length - 1] + 10;
        }
        return sumArr;
    }
}
