# ArrayList    

> A resizable array implementation in java. 
* Backing data structure - an **Dynamic Growable array** of Object class with **no size limit**.
* **Duplicates allowed** – We can add duplicate elements in ArrayList. 
* **Null Insertion Allowed**. 
* **Ordered** – Elements in ArrayList **preserve their ordering** which is by default the order in which they were added to the list. 
* **Index based** (Randomly accessed) – Elements can be **randomly accessed** using **index** positions. Index start with '0'. 
* **Dynamic resizing** – ArrayList grows dynamically when more elements needs to be added than its current size. 
* **Non-synchronized** – ArrayList is not synchronized, by default. Programmer **needs to use synchronized keyword** appropriately or simply use Vector class. 
* Use `Collections.synchronizedList(new ArrayList())` to get synchronized ArrayList.
* The **iterators** returned by this class are **fail-fast** and may throw `ConcurrentModificationException`.
* Implements **RandomAccess**, **Serializable** and **Cloneable** interfaces. 
* We can add, remove, find, sort and replace elements in this list.
* Manipulation is little slower than the LinkedList because a lot of resize/shifting needs in case of insertion/removal item. 
* **Best** Choice: **Random Access** / **Retrival** 
* **Worst** Choice: **Manipulation**, **Insertion/Deletion** 
* Element is added to an ArrayList:
  * It first checks whether the new element has room to fill or it needs to grow the size of the internal array 
  * If capacity has to be increased then the new capacity is calculated which is 50% more than the old capacity and the array is increased by that capacity.

## Internal working of an ArrayList

The array buffer into which the elements of the ArrayList are stored.
```java
transient Object[] elementData;
private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
```
The capacity of the ArrayList is the length of this array buffer. 

```java
private static final int DEFAULT_CAPACITY = 10;

public ArrayList() {
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
}
```
>Any empty ArrayList with elementData == `DEFAULTCAPACITY_EMPTY_ELEMENTDATA` will be expanded to `DEFAULT_CAPACITY` when the **first element is added**.

### Create an ArrayList

```java
static class ArrayList {

  private static final int defaultCapacity = 10;
  Object[] array;
  private int size;
  private int capacity;

  public ArrayList() {
    this(defaultCapacity);
  }

  public ArrayList(int initialCapacity) {
    array = new Object[initialCapacity];
    this.size = 0;
    this.capacity = initialCapacity;
  }
}
```

### Add element in an ArrayList
* ArrayList automatically resizes (grow) itself whenever a number of elements in ArrayList grow beyond a threshold 
* When the array becomes full and if we try to add an item:
  * Creates a bigger-sized memory on heap memory (for example memory of 50% more than current size).
  * Copies the current memory elements to the new memory.
  * New item is added now as there is bigger memory available now.
  * Delete the old memory.

```java
public void add(int element){
    if(size == capacity){
        resize(capacity >> 1); // shift bit to right, 16 => 8
    }
    array[size++] = element;
}

private void resize(int minCapacity) {
    int newCapacity = capacity + minCapacity;

    Object[] temp = new Object[newCapacity];
    for (int i = 0; i < size ; i++) {
        temp[i] = array[i];
    }
    array = temp;
    capacity = newCapacity;
}
```
### Remove element in an ArrayList
* Since an **ArrayList is indexed**, this method takes an integer value which simply **removes** the **element** present at that specific **index**. 
* **After removing** the element, **all the elements are moved to the left** to fill the space and the indices of the objects are updated.
* Automatically **resizes** (shrink) itself whenever a number of elements in ArrayList shrink beyond a threshold (for example memory of 75% less than current size).
* When the array size becomes half of the capacity and if we try to remove an item:
  * Creates a smaller-sized memory on heap memory (for example memory of 50% less than current size).
  * Copies the current memory elements to the new memory.
  * **Delete** the old memory.

```java
public Object remove(Object element){
    for (int i = 0; i < size; i++) {
        if(element.equals(array[i]))
            return removeAtIndex(i);
    }
    return null;
}

public Object removeAtIndex(int index) {
    if (size == 0) {
        throw new RuntimeException("Array is Empty");
    }
    Object data = array[index];
    if (index >= 0 && index <= size - 1) {
        Object[] temp = new Object[size - 1];
        for (int i = 0; i < index; i++) {
            temp[i] = array[i];
        }
        for (int i = index; i < temp.length; i++) {
            temp[i] = array[i + 1];
        }
        array = temp;
    }
    size--;
    if (size == capacity / 2) {
        resize(-(capacity >> 1));
    }
    return data;
}
```

---
[HOME](https://github.com/Piyushresonit/DataStructureAndAlgorithm/blob/master/README.md)