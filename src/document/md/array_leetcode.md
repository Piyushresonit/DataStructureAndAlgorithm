# Array Leetcode

#### Span of an Array
Find difference between max and min element of an array
```java
int arr[] = {100,200,300,400,500}; 
```
```java
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
```
#### Output
    400

#### Find element in an array
```java
private static int findElementInArray(int[] arr, int elementToFind) {
    int index = -1;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == elementToFind) {
            index = i;
            break;
        }
    }
    return index ;
}
```
#### Output
    200
    Element 200 found at index: 1

#### Bar chart of the Array elements
* find max
* outer loop till max item
  * inner loop for each item in array
    * if array of inner index elememt >= outer index
      * print *
    * else
      * left tab
      
```java
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
```
#### Output
    3
    6
    2
    4
        *
        *
        *       *    
    *   *	    *	
    *   *	*   *	
    *   *	*   *

#### Sum of the element of two arrays
```java
private static int[] sumOfArrays(int[] arr1, int[] arr2) {
    // length of new array
    int[] sumArr = new int[arr1.length >= arr2.length ? arr1.length : arr2.length];

    int i = arr1.length - 1;
    int j = arr2.length - 1;
    int k = sumArr.length - 1;
    int carry = 0;

    // for sumArr length
    while (k >= 0) {
        int digit = carry;
        // element in first array
        if (i >= 0)
            digit += arr1[i];
        // element in second array
        if (j >= 0)
            digit += arr2[j];

        carry = digit / 10;
        digit = digit % 10;

        sumArr[k] = digit;
        i--;
        j--;
        k--;

        // only carry left 
        if (k <= 0 && carry != 0)
            sumArr[sumArr.length - 1] = sumArr[sumArr.length - 1] + 10;
        }
    return sumArr;
}
// Converting array into number
private static int convertArrayIntoNumber(int[] arr) {
    int result = 0;
    int k = arr.length - 1;
    while (k >= 0) {
        result = result * 10;
        result += arr[k];
        k--;
    }
    return result;
}
```
#### Output
    first array
    2 5 7
    second array
    6 4 5
    New Sum Array:
    9 0 12
    Sum of an Array:
    1209

#### Swap element in an array
```java
private static void swapArrayWithoutUsingTempArray(int[] arr, int firstIndex, int secondIndex) {
    int temp = arr[firstIndex];
    arr[firstIndex] = arr[secondIndex];
    arr[secondIndex] = temp;
}
```

#### Reverse element in an array
```java
private static void reverseArray(int[] arr, int start, int end) {
    while(start < end){
        
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        start++;
        end--;
    }
}
```
#### Output
    Original array
    2 5 7
    Reverse array
    7 5 2

#### Rotate element in an array (Left Rotate K times)

Reverse all -> Reverse last after k -> Reverse first k

1. Handle -ve and >array.length scenario
2. Reverse entire array
3. Reverse last elements after k from modified array 
4. Reverse remaining first k elements from modified array

```java
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
```
#### Output
    Original array
    1 2 3 4 5
    k = 2
    Left Rotated Array:
    3 4 5 1 2

#### Rotate element in an array (Right Rotate K times)

Reverse all -> Reverse first k -> Reverse last after k

1. Handle -ve and >array.length scenario 
2. Reverse entire array
3. Reverse first k elements from modified array
4. Reverse remaining last elements after k from modified array

```java
private static int[] leftRotateAnArrayKTimes(int[] arr, int k) {
    int length = arr.length;
    if (k < 0){
        k = length - k; // handle -ve k scenario
    }
    if(k > length) {
        k = k % length; // k will become less than length
    }
    arr = reverseArray(arr, 0, length - 1);          // reverse entire array
    arr = reverseArray(arr, 0 , k-1);               // reverse first k elements from modified array
    arr = reverseArray(arr, k , length - 1);       // reverse last elements after k from modified array

    return arr;
}
```
#### Output
    Original array
    1 2 3 4 5
    k = 2
    Right Rotated Array:
    4 5 1 2 3

---
[HOME](C:\StudyMaterial\Java\Codebase\DataStructure\README.md)<br>