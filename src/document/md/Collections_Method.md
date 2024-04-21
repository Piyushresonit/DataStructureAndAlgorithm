## Collections Methods

### Collections.addAll()
>Adds All the specified elements to the specified collection
```java
List<String> list = new ArrayList<>();
list.add("One");
list.add("Two");
list.add("Three");

// Adds All the specified elements to the specified collection
Collections.addAll(list, "Four", "Five");
for (String element : list){
    System.out.print(element + " ");
}
```
#### Output
    One Two Three Four Five

### Collections.max()
>Maximum value of the given collection based on Natural ordering / Comparator
```java
// Maximum value of the given collection based on natural ordering
String maxElement = Collections.max(list);
System.out.println("Max Element: " + maxElement);

// Maximum value of the given collection based on Comparator
String maxElementComparator = Collections.max(list, (s1,s2) -> s1.compareToIgnoreCase(s2));
System.out.println("Max Element using comparartor: " + maxElementComparator);
```
#### Output
    Max Element: Two
    Max Element using comparartor: Five

### Collections.min()
>Minimum value of the given collection based on Natural ordering / Comparator
```java
// Minimum value of the given collection based on Comparator
String minElement = Collections.min(list, (s1, s2) -> s1.compareToIgnoreCase(s2));
System.out.println("Min Element: " + minElement);
```
#### Output
    Min Element: Five

### Collections.sort()
>Sort the elements of specified list of collection in natural/ascending order.
```java
// Sort the elements of specified list of collection in ascending order.
Collections.sort(list);
for (String element : list) {     
    System.out.print(element + " ");
}
```
#### Output
    Five Four One Three Two 
>Sort the elements of specified list of collection in descending order.
```java
// Sort the elements of specified list of collection in descending order.
Collections.sort(list, (s1, s2) -> s2.compareToIgnoreCase(s1));
for (String element : list) {
    System.out.print(element + " ");
}
```
#### Output
    Two Three One Four Five  

### Collections.sort()
>Swap the elements of specified list of collection based on indexes.
```java
// Swap the elements of specified list of collection based on indexes.
Collections.swap(list, 0, 3);
for (String element : list) {
    System.out.print(element + " ");
}
```
#### Output
    Four Three One Two Five 

### Collections.copy(destination, source)
>copy all of the elements from one list into another.

 The destination list must be at least as long as the source list. If it is longer, the remaining elements in the destination list are unaffected.

> IndexOutOfBoundsException, if the destination list is too small to contain the entire source List.
```java
// copy all of the elements from one list into another.
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
```
#### Output
    Ram Laxman Sita Bharat Karn 
---
[HOME](C:\StudyMaterial\Java\Codebase\DataStructure\README.md)
