package com.resonit.array;

import java.util.Scanner;

// find difference between max and min element of an array
public class SpanOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrSize = sc.nextInt();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int span = spanOfArray(arr);
        System.out.println("Span of an array is: " + span);
    }

    private static int spanOfArray(int[] arr) {
        int max = 0, min = 0, span = 0;
        max = arr[0];
        min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max)
                max = arr[i];
            if(arr[i] < min)
                min = arr[i];
        }
        span = max - min;
        return span;
    }
}
