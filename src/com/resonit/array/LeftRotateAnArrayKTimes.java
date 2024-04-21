package com.resonit.array;

import java.util.Scanner;

public class LeftRotateAnArrayKTimes {

    private static int[] leftRotateAnArrayKTimes(int[] arr, int k) {
        int length = arr.length;
        if (k < 0){
            k = length - k; // handle -ve k scenario
        }
        if(k > length) {
            k = k % length; // k will become less than length
        }
        arr = reverseArray(arr, 0, length - 1);            // reverse entire array
        arr = reverseArray(arr, length - k , length - 1); // reverse last elements after k from modified array
        arr = reverseArray(arr, 0 , (length - 1) - k);   // reverse remaining k elements from modified array
        return arr;
    }

    private static int[] reverseArray(int[] arr, int start, int end) {
        int temp = 0;
        while(start <= end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrSize = sc.nextInt();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        System.out.println("Left Rotated Array: ");
        int[] arr2= leftRotateAnArrayKTimes(arr, k);
        for (int a: arr2) {
            System.out.print(a + " ");
        }
    }
}
