# Shallow Copy Vs Deep Copy

>Shallow copy: Fields of primitive data type are copied but objects references are not copied. 

>Deep copy involves the copy of primitive data type as well as object references.


>Shallow copy only copies references, not the actual elements, the modification in the shallow copied array affects the original array.

In case of Primitive type, Shallow copying of integer values creates a new array with copied values, so modifications to the shallow copied array do not affect the original array

|                          | Shallow Copy of Integer Values                                | Shallow Copy of Objects                                        |
|--------------------------|---------------------------------------------------------------|----------------------------------------------------------------|
| Data Type                | Java primitives (e.g., int, float, etc.)                      | Java objects (instances of a class)                            |
| Copying Mechanism        | Values are copied directly                                    | References to objects are copied                               |
| Effect on Original Array | Modifying the copied array does not affect the original array | Modifying the copied array may affect the original array       |
| Reasoning                | Each element is a separate value, not referencing an object   | Both the original and copied arrays reference the same objects |

>Deep Copy: We need to ensure all the member class also implement the Cloneable interface and override the clone() method of the object class.

### Deep Copy of primitive type using array.clone()

```java
private static void deepCopyPrimitive() {
     int[] originalArray = {1, 2, 3, 4, 5};
     // creates deep copy
     int[] shallowCopy = originalArray.clone();
     // Modify the deep copy
     originalArray[1] = 200;
     // Print original and deep copied arrays
     System.out.println("Original array: " + Arrays.toString(originalArray));
     System.out.println("Deep copied array: " + Arrays.toString(shallowCopy));
}
```
#### Output
    Original array: [1, 200, 3, 4, 5]
    Deep copied array: [1, 2, 3, 4, 5]

### Shallow Copy Object type using array.clone()

```java
 private static void shallowCopyObject() {
     Employee[] empArr = new Employee[2];  //Original array

     empArr[0] = new Employee(100, "Lokesh", "Gupta");
     empArr[1] = new Employee(200, "Pankaj", "Kumar");
     //Shallow copied array
     Employee[] clonedArray = empArr.clone();

     empArr[0].setFirstName("Rajesh");

     System.out.println("Original array Employee First name: " + empArr[0].getFirstName());
     System.out.println("Shallow copied array Employee First name: " + clonedArray[0].getFirstName());
}
```
#### Output
    Original array Employee First name: Rajesh
    Shallow copied array Employee First name: Rajesh

### Deep Copy Object type
>Iterating each element of the given original array and copy one element at a time to new array
```java
 private static void deepCopyObject() {
        Employee[] empArr = new Employee[2];  //Original array

        empArr[0] = new Employee(100, "Lokesh", "Gupta");
        empArr[1] = new Employee(200, "Pankaj", "Kumar");
        //Shallow copied array
        Employee[] clonedArray = new Employee[empArr.length];
        for (int i = 0; i < empArr.length; i++) {
            clonedArray[i] = new Employee(empArr[i].getId(),empArr[i].getFirstName(),empArr[i].getLastName());
        }
        empArr[0].setFirstName("Ravi");

        System.out.println("Original array Employee First name: " + empArr[0].getFirstName());
        System.out.println("Shallow copied array Employee First name: " + clonedArray[0].getFirstName());
}
```
#### Output
    Original array Employee First name: Ravi
    Shallow copied array Employee First name: Lokesh
---
[HOME](https://github.com/Piyushresonit/DataStructureAndAlgorithm/blob/master/README.md)
