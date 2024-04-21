package com.resonit.concepts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedListTimeComplexity {

    private static void getTimeDiffToAdd(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000 ; i++) {
            list.add(0, i);   // Add element at first
        }
        long endTime = System.currentTimeMillis();
        System.out.println(list.getClass().getName() + " --> "+ (endTime-startTime) + " ms");
    }
    private static void getTimeDiffToRemove(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000 ; i++) {
            list.remove(0);  // Removing first element
        }
        long endTime = System.currentTimeMillis();
        System.out.println(list.getClass().getName() + " --> "+ (endTime-startTime) + " ms");
    }

    private static int getTimeDiffToGet(List<Integer> list) {
        for (int i = 0; i < 100000 ; i++) {
            list.add(0, i);   // Add element at first
        }
        long startTime = System.nanoTime();
        int element = list.get(50000);
        long endTime = System.nanoTime();
        System.out.println(list.getClass().getName() + " --> "+ (endTime-startTime) + " ns");
        return element;
    }
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkList = new LinkedList<>();
        System.out.println("******************* Adding Element ********************");
        getTimeDiffToAdd(arrayList);
        getTimeDiffToAdd(linkList);
        System.out.println("******************* Removing Element ********************");
        getTimeDiffToRemove(arrayList);
        getTimeDiffToRemove(linkList);
        System.out.println("******************* Get Element ********************");
        System.out.println(getTimeDiffToGet(arrayList));
        System.out.println(getTimeDiffToGet(linkList));
    }
}
