package com.resonit.array;

import java.util.Scanner;

public class SecondLargestValueInArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int arrSize = sc.nextInt();
        int arr[] = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = sc.nextInt();
        }
        int secondMax = secondMaxArrayElement(arr);
        System.out.println("Second Largest Value: "+secondMax);
    }

    private static int secondMaxArrayElement(int[] arr) {
        int maxValue = 0, secondLargest = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                secondLargest = maxValue;
                maxValue = arr[i];
            } else if (arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}