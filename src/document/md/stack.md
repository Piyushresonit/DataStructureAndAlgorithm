# Stack    

> last-in-first-out (LIFO) stack of objects.

* It extends class Vector with five operations (push, pop, peek, search, empty)
* Implements Interfaces: Serializable, Cloneable, Iterable<E>, Collection<E>, List<E>, RandomAccess

### Constructor of a Stack
    Default Constructor - Stack()

## Methods of Stack

| **Method**             | **Description**                                                                                                                                 |
|------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------|
| empty()                | It returns **true** if **nothing is on the top of the stack**. Else, returns false.                                                             |
| peek()                 | **Returns** the element on the **top of the stack**, but **does not remove** it.                                                                |
| pop()                  | **Removes and returns** the **top element** of the stack. An `EmptyStackException` is thrown if we call pop() when the invoking stack is empty. |
| push(Object element)   | **Pushes (insert)** an element on the **top** of the stack.                                                                                     |
| search(Object element) | **Returns the position** of the element **from the top** of the stack. Else, it returns **-1**.                                                 |

> The Stack class is a **thread-safe** class and hence involves overhead when we do not need thread safety. 
 
> It is recommended to use **ArrayDeque** for stack implementation as it is more efficient in a single-threaded environment
A more complete and consistent set of LIFO stack operations is provided by the Deque interface and its implementations, which should be used in preference to this class.

```java 
Deque<Integer> stack = new ArrayDeque<Integer>();
```

# Internal working of a Stack

```java
public class Stack<E> extends Vector<E> {
   // Creates an empty Stack 
   public Stack() {
   }
}
```
## Create a Custom Stack

```java
// 1. Create Linked list Node
class CustomStack {
   private static final int initialCapacity = 5;
   private static int capacity = initialCapacity;
   private Object[] arrStack;    // Array to hold the stack elements
   private int peek;              // Index of the top element in the stack

   public CustomStack() {
      this.arrStack = new Object[initialCapacity];
      this.peek = -1;              // Stack is initially empty
   }

   public int size() {
      return arrStack.length;
   }

   // Top of the stack
   public void peek() {
      if (peek >= 0) {
         System.out.println(arrStack[peek]);
      } else {
         throw new ArrayIndexOutOfBoundsException("Array is empty");
      }
   }

   public void display() {
      System.out.print("[ ");
      for (int i = peek; i >= 0; i--) {
         System.out.print(arrStack[i] + " ");
      }
      System.out.print("]");
   }
}
```
```java
public static void main(String[] args) {
    CustomStack stack = new CustomStack();
}
```
* Stack has peek(top) index on which new element will be pushed.
* Vector class is a resizable array hence Automatically resizes (grow) itself whenever a number of elements in Stack grow beyond a threshold 
* When the array becomes full and if we try to add an item:
  * Creates a bigger-sized memory on heap memory (for example memory of 50% more than current size).
  * Copies the current memory elements to the new memory.
  * New item is added now as there is bigger memory available now.
  * Delete the old memory.

### Push an element in a Stack

    Inserts (Push) an element onto the stack peek.

  1. Increase peek size by 1
  2. If peek is smaller than array length, 
     1. add element at peek
  3. else increase array size by
     1. calling resize method with increased capacity
     2. add element at peek

```java
public void push(Object element) {
    peek++;
    if (peek < size()) {
        arrStack[peek] = element;
    } else {
        capacity = capacity + (capacity >> 1);
        resizeStack(capacity);
        arrStack[peek] = element;
    }
}
```
#### Resize method
1. Create a tempArr fo size newCapacity
2. for loop until peek element
   1. add arrStack element to tempArr
3. assign tempArr to arrStack
4. update capacity of arrStack with new capacity
   
```java
// Resize the stack based on new Capacity
private void resizeStack(int newCapacity) {
    Object[] tempArr = new Object[newCapacity];
    for (int i = 0; i < peek; i++) {
        tempArr[i] = arrStack[i];
    }
    arrStack = tempArr;
    capacity = newCapacity;
}
```
### Pop an element from a Stack 
 	Remove the peek element.

* Pop removes the element present at peek(top) index. 
* Decease peek index.
* Stack class is a resizable array hence Automatically resizes (shrink) itself. When we try to remove an item:
  * Creates a smaller-sized memory on heap memory.
  * Copies the current memory elements to the new memory.
  * Delete the old memory.

1. Allocate the Node and Add the data
2. If the Linked List is empty, 
   1. Make head and tail to point to newNode 
3. If the Linked List is not empty, 
   1. Make next of tail as newNode 
   2. Make tail to point to newNode 
4. Increase size by 1

```java
public Object pop() {
    if (peek > initialCapacity && peek < (capacity / 2)) {
        resizeStack(capacity/2); // Halve the size of the array
    }
    if (peek > -1) {
        Object pop = arrStack[peek];
        peek--;
        return pop;
    } else {
        throw new ArrayIndexOutOfBoundsException("Stack is empty");
    }
}
```
### Empty Stack
    It returns "true" if nothing is on the top of the stack

```java
 // check if stack is empty
public boolean empty() {
    return peek < 0;
}
```
### Search element in a Stack 
      Returns the position of the element from the Peek(top) of the stack. Else, it returns -1.

```java
public int search(Object element) {
    int distance = -1;
    for (int i = 0; i <= peek; i++) {
        if(arrStack[i].equals(element))
            return distance = peek - i;
    }
    return distance;
}
```

---
[HOME](https://github.com/Piyushresonit/DataStructureAndAlgorithm/blob/master/README.md)<br>
[Stack Implementation Using LinkedList](stackLinkedListImpl.md)