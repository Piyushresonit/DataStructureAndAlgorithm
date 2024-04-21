package com.resonit.array;

import java.util.Scanner;

public class BarChartOfArrayElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrSize = sc.nextInt();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        barChartOfArrayElements(arr);
    }

    private static void barChartOfArrayElements(int[] arr){
        int max = findMaxElementInArray(arr);
        for (int i = max; i > 0; i--) {             // Loop till max element
            for (int j = 0; j < arr.length; j++) {      // Loop for each element in array
                if (arr[j] >= i) {
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println("");
        }
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