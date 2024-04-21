# LinkedList    

> Doubly linked list implementation which implements List and Deque interfaces. 
> Therefore, it can also be used as a Queue, Deque or Stack.

* **Duplicates allowed** – We can add duplicate elements in LinkedList.
* **Null Insertion Allowed**.
* **Ordered** – Elements in LinkedList **preserve** their ordering which is by default the order in which they were added to the list.
* **Non-synchronized** – If multiple threads access a linked list concurrently, and at least one of the threads modifies the list structurally, it must be synchronized externally.
* Use `Collections.synchronizedList(new LinkedList())` to get synchronized LinkedList. 
* The **iterators** returned by this class are **fail-fast** and may throw `ConcurrentModificationException`.
* Implements **Serializable** and **Cloneable** interfaces.
* **Manipulation** is **faster than** the LinkedList because  **no shifting** needs to occur if any **element is removed** from the linked list.
* **No Random Access**: It accesses elements in sequential order only.
* We can use **ListIterator** to iterate LinkedList elements.
* **Worst** Choice: **Random Access** / **Retrival**
* **Best** Choice: **Manipulation**, **Insertion/Deletion**

## ArrayList Vs LinkedList

| Basis           | **ArrayList**                                                                                                | **LinkedList**                                                                               |
|-----------------|--------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------|
| Data Structure  | **Dynamic Array**                                                                                            | **Doubly LinkedList**                                                                        |
| Manipulation    | **Slow** - If any element is removed from the array, all the bits are shifted in memory, as it uses an array | **Fast** - No bit shifting is required in memory, as it uses doubly linked list              |
| Implementation  | Act as List Only as implements List interface only.                                                          | Act as a **List** and **Queue** both because it **implements List** and **Deque interfaces** |
| Memory Overhead | **Less** - Each index only **holds actual object**                                                           | **More** - Node **holds** both data and address of **next** and **previous node**.           |
| Best Case       | **Storing** and **Randomly accessing data**                                                                  | **Manipulating Data**                                                                        |

### Constructor of a LinkedList
        LinkedList()
        LinkedList(Collection<? extends E> c)

## Methods of LinkedList

| **Method**                                           | **Description**                                                                                                                                                           |
|------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| boolean add(E e)                                     | It is used to append the specified element to the end of a list.                                                                                                          |
| void add(int index, E element)                       | It is used to insert the specified element at the specified position index in a list.                                                                                     |
| boolean addAll(Collection<? extends E> c)            | It is used to append all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator. |
| boolean addAll(Collection<? extends E> c)            | It is used to append all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator. |
| boolean addAll(int index, Collection<? extends E> c) | It is used to append all the elements in the specified collection, starting at the specified position of the list.                                                        |
| void addFirst(E e)                                   | It is used to insert the given element at the beginning of a list.                                                                                                        |
| void addLast(E e)                                    | It is used to append the given element to the end of a list.                                                                                                              |
| void clear()                                         | It is used to remove all the elements from a list.                                                                                                                        |
| Object clone()                                       | It is used to return a shallow copy of an LinkedList.                                                                                                                     |
| boolean contains(Object o)                           | It is used to return true if a list contains a specified element.                                                                                                         |
| Iterator<E> descendingIterator()                     | It is used to return an iterator over the elements in a deque in reverse sequential order.                                                                                |
| E element()                                          | It is used to retrieve the first element of a list.                                                                                                                       |
| E get(int index)                                     | It is used to return the element at the specified position in a list.                                                                                                     |
| E getFirst()                                         | It is used to return the first element in a list.                                                                                                                         |
| E getLast()                                          | It is used to return the last element in a list.                                                                                                                          |
| int indexOf(Object o)                                | It is used to return the index in a list of the first occurrence of the specified element, or -1 if the list does not contain any element.                                |
| int lastIndexOf(Object o)                            | It is used to return the index in a list of the last occurrence of the specified element, or -1 if the list does not contain any element.                                 |
| ListIterator<E> listIterator(int index)              | It is used to return a list-iterator of the elements in proper sequence, starting at the specified position in the list.                                                  |
| boolean offer(E e)                                   | It adds the specified element as the last element of a list.                                                                                                              |
| boolean offerFirst(E e)                              | It inserts the specified element at the front of a list.                                                                                                                  |
| boolean offerLast(E e)                               | It inserts the specified element at the end of a list.                                                                                                                    |
| E peek()                                             | It retrieves the first element of a list                                                                                                                                  |
| E peekFirst()                                        | It retrieves the first element of a list or returns null if a list is empty.                                                                                              |
| E peekLast()                                         | It retrieves the last element of a list or returns null if a list is empty.                                                                                               |
| E poll()                                             | It retrieves and removes the first element of a list.                                                                                                                     |
| E pollFirst()                                        | It retrieves and removes the first element of a list, or returns null if a list is empty.                                                                                 |
| E pollLast()                                         | It retrieves and removes the last element of a list, or returns null if a list is empty.                                                                                  |
| E pop()                                              | It pops an element from the stack represented by a list.                                                                                                                  |
| void push(E e)                                       | It pushes an element onto the stack represented by a list.                                                                                                                |

# Internal working of an LinkedList

LinkedList class extends AbstractSequentialList class and implements List and Deque interfaces.
```java
public class LinkedList<E> extends AbstractSequentialList<E>
        implements List<E>, Deque<E>, Cloneable, java.io.Serializable
{
    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;
}
```
## Create a LinkedList Node
LinkedList is made up of Nodes where each Node consist of data and reference of next node. 

```java
// 1. Create Linked list Node
static class Node<T extends Comparable<T>> {
  private T data;
  private Node next; // this is why LL needs more memory

  // Node constructor, Add the data, node next is null.
  public Node(T data) {
    this.data = data;
    next = null;
  }
}
```
## Create a LinkedList
LinkedList has Head Node, Tail Node and size instance variable which consist of size of LinkedList

```java
// 2. Create Linked list
static class CustomLinkedList<T extends Comparable<T>> {
  Node head;  // head of list
  Node tail;  // tail of list
  int size;
}
```

## Add an element in a LinkedList

### AddFirst in a LinkedList
    Inserts a new Node at front of the list.
  1. Allocate the newNode and Add the data
  2. Make next of newNode as head
  3. Make head to point to newNode
  4. If the Linked List is empty, 
     1. Make tail to point to newNode
  5. Increase size by 1

```java
public void addFirst(T data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
    if (size == 0) {
        tail = newNode;
    }
    size++;
}
```
### AddLast in a LinkedList 
 	Inserts a new node at the end.
1. Allocate the Node and Add the data
2. If the Linked List is empty, 
   1. Make head and tail to point to newNode 
3. If the Linked List is not empty, 
   1. Make next of tail as newNode 
   2. Make tail to point to newNode 
4. Increase size by 1

```java
public void addLast(T data) {
    Node newNode = new Node(data);
    if (size == 0) {
        head = newNode;
        tail = newNode;
    } else {
        tail.next = newNode;
        tail = newNode;
    }
    size++;
}
```
### AddAt in a LinkedList
    Add a new node after the given index.
1. Allocate the Node and Add the data
2. If the index is between 0 to Size, 
   1. If index is equal to 0 
      1. addFirst(data)
   2. else If index is equal to size 
      1. addLast(data)
   3. else 
      1. Make a temp node using head. 
      2. Iterate till index 
         1. make temp = temp.next; 
      3. Make next of newNode as next of temp 
      4. Make next of temp as newNode 
      5. increase size by 1 
3. else invalid index

```java
public void addAt(int index, T newData) {
    Node newNode = new Node(newData);
    if (index >= 0 && index <= size) {
        if (index == 0) {
            addFirst(newData);
        } else if (index == size) {
            addLast(newData);
        } else {
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    } else {
        throw new IllegalArgumentException("Invalid Index provided");
    }
}
```
## Remove element from a LinkedList


---
[HOME](https://github.com/Piyushresonit/DataStructureAndAlgorithm/blob/master/README.md)