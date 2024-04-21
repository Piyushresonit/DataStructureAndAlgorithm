package com.resonit.array;

import java.util.Scanner;

public class ReverseArrayWithoutNewArray {

    private static void reverseArray(int[] arr, int start, int end) {
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrSize = sc.nextInt();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        reverseArray(arr, 0, arrSize - 1);
        for (int a: arr) {
            System.out.println(a);
        }
    }
}
