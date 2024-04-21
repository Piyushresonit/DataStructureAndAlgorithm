package com.resonit.array;

import java.util.Scanner;

public class FindElementInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrSize = sc.nextInt();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int elementToFind = sc.nextInt();
        int index = findElementInArray(arr, elementToFind);
        if (index == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element "+ elementToFind+" found at index: "+ index);
    }

    private static int findElementInArray(int[] arr, int elementToFind) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elementToFind) {
                index = i;
                break;
            }
        }
        return index ;
    }
}
