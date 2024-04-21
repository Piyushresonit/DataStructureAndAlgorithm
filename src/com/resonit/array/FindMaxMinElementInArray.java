package com.resonit.array;

import java.util.Scanner;

public class FindMaxMinElementInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrSize = sc.nextInt();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int maxElement = findMaxElementInArray(arr);
        int minElement = findMinElementInArray(arr);
        System.out.println("Max Element: "+ maxElement);
        System.out.println("Min Element: "+ minElement);
    }

    private static int findMinElementInArray(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    private static int findMaxElementInArray(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
