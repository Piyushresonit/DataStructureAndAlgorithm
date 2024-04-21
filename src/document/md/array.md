# Array

* Holds a **fixed number of values** of a **single type** in a **contiguous memory location**.
* Arrays are objects, so we can find the length of the array using '**length**' property .
* Arrays are **ordered** and each have an **index** beginning from '**0**'.
* Arrays can also be **static**, **final** or used as **method arguments**.
* The size of an array must be specified by an int or short value and not long.
* Java arrays are implements **Cloneable** and **Serializable** interfaces.
* The direct **superclass** of an array type is **Object**
* Array can contain **primitives** as well as **object references** of a class.
  * In case of primitive data types, the actual values are stored in **contiguous memory locations**.
  * In case of objects of a class, the actual objects are stored in **heap segment**.

    
Obtaining an array is a two-step process.
* First, you must **declare a variable** of the desired array type. 
* Second, you must **allocate the memory** that will hold the array, using **new**, and assign it to the array variable.
* The elements will automatically be initialized refer **Default array values** in Java
  * **zero** for numeric types
  * **false** for Boolean
  * **null** for reference types
  
Hence, in Java, all arrays are dynamically allocated

## Array Vs ArrayList

| Basis                     | **Array**                                         | **ArrayList**                                                        |
|---------------------------|---------------------------------------------------|----------------------------------------------------------------------|
| Size                      | **Static**                                        | **Dynamic**                                                          |
| Resizable                 | **Fixed-length** data structure                   | **Variable-length** data structure                                   |
| Initialization            | **Mandatory** to provide the **size** of an array | Create an instance of ArrayList without specifying its size          |
| Performance               | **Faster** because of fixed size                  | The **resize** operation in ArrayList **slows down** the performance |
| Primitive/ Generic type   | store both **objects** and **primitives** type    | store objects/Wrapper type                                           |                                                             
| Type-Safety               | Type safe but **Generics not allowed**            | **Allowed Generic/Type**, that's why it is type-safe.                |
| Length                    | **length** variable                               | **size()** method                                                    |
| Adding Elements           | **assignment** operator                           | **add()** method                                                     |
| Single/ Multi-Dimensional | Array can be **multi-dimensional**                | Always a **single-dimensional**                                      |

## Array insert and display elements

```java
// Taking input from commandline
Scanner sc = new Scanner(System.in);
int arrSize = sc.nextInt();

// declaring an array
int[] arr;

// initialising an array (giving memory space in heap of int*arrSize)
arr = new int[arrSize];

// taking array element from user
for (int i = 0; i < arr.length; i++) {
    arr[i] = sc.nextInt();
}

// print array length
System.out.println("Length of an array: "+ arr.length);

// printing the array elements
for (int i = 0; i < arr.length; i++) {
    System.out.println("Array element at index " + i +" is " + arr[i]);
}
```
#### Output
    Length of an array: 5
    Array element at index 0 is 100
    Array element at index 1 is 200
    Array element at index 2 is 300
    Array element at index 3 is 400
    Array element at index 4 is 500

#### Changing the value of the primitive type in array.
```java
int[] arrTemp = arr;
arrTemp[2] = 200;

for (int i = 0; i < arr.length; i++) {
    System.out.println("New Array element at " + i +" is " + arr[i]);
}
for (int i = 0; i < arr.length; i++) {
    System.out.println("New Array element at " + i +" is " + arrTemp[i]);
}
```
#### Output
    
    Old Array element at 0 is 100
    Old Array element at 1 is 200
    Old Array element at 2 is 200*
    Old Array element at 3 is 400
    Old Array element at 4 is 500
    New Array element at 0 is 100
    New Array element at 1 is 200
    New Array element at 2 is 200*
    New Array element at 3 is 400
    New Array element at 4 is 500

#### Array of an object
```java
Employee[] arrEmp = new Employee[3];

arrEmp[0] = new Employee(1,"Piyush", "Chandekar");
arrEmp[1] = new Employee(2,"Rahul", "Dravid");
arrEmp[2] = new Employee(3,"Rohit", "Sharma");

for(Employee emp : arrEmp){
    System.out.println(emp);
}
```
#### Output
    Employee{id=1, firstName='Piyush', lastName='Chandekar'}
    Employee{id=2, firstName='Rahul', lastName='Dravid'}
    Employee{id=3, firstName='Rohit', lastName='Sharma'}

#### Min and Max element in an Array
```java
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
```
#### Output
    Max Element: 500
    Min Element: 100

#### Second Max element in an Array
```java
private static int secondMaxArrayElement(int[] arr) {
    int maxValue = 0, secondLargest = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] > maxValue) {
            secondLargest = maxValue;
            maxValue = arr[i];
        } else if (arr[i] > secondLargest) {
            secondLargest = arr[i];
        }
    }
    return secondLargest;
}
```
#### Output
    Second Largest Element: 400

---
[HOME](C:\StudyMaterial\Java\Codebase\DataStructure\README.md)<br>
[Array LeetCode](C:\StudyMaterial\Java\Codebase\DataStructure\src\document\md\array_leetcode.md)
