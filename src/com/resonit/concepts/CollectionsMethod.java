package com.resonit.concepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsMethod {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        // Adds All the specified elements to the specified collection
        Collections.addAll(list, "Four", "Five");

        System.out.println("********* elements **********");
        for (String element : list) {
            System.out.print(element + " ");
        }

        // Maximum value of the given collection based on natural ordering
        String maxElement = Collections.max(list);
        System.out.println("\nMax Element: " + maxElement);

        // Maximum value of the given collection based on Comparator
        String maxElementComparator = Collections.max(list, (s1,s2) -> s1.compareToIgnoreCase(s2));
        System.out.println("Max Element using comparartor: " + maxElementComparator);

        // Minimum value of the given collection based on Comparator
        String minElement = Collections.min(list, (s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println("Min Element: " + minElement);

        System.out.println("********* Before Sorting elements **********");
        for (String element : list) {
            System.out.print(element + " ");
        }

        // Sort the elements of specified list of collection in ascending order.
        Collections.sort(list);
        System.out.println("\n********* After Sorting elements **********");
        for (String element : list) {
            System.out.print(element + " ");
        }

        // Sort the elements of specified list of collection in descending order.
        Collections.sort(list, (s1, s2) -> s2.compareToIgnoreCase(s1));
        System.out.println("\n********* After Descending Sort elements **********");
        for (String element : list) {
            System.out.print(element + " ");
        }

        // Swap the elements of specified list of collection based on indexes.
        Collections.swap(list, 0, 3);
        System.out.println("\n********* Swaping elements **********");
        for (String element : list) {
            System.out.print(element + " ");
        }

        List<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Ram");
        arrayList1.add("Laxman");
        arrayList1.add("Sita");
        arrayList1.add("Bharat");
        arrayList1.add("Karn");
        //arrayList1.add("Krishna");  IndexOutOfBoundsException: Source does not fit in dest

        System.out.println("\n********* Copying elements **********");
        Collections.copy(list,arrayList1);
        for (String element : list) {
            System.out.print(element + " ");
        }

    }
}
