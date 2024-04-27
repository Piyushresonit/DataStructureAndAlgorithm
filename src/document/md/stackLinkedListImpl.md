# Stack Implementation using LinkedList   

## Create a Custom Stack using LinkedList
```java
static class Node<T> {
    T data;
    Node next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
static class StackLinkedList<T> {
    int size;
    Node head;
    Node tail;

    public T peek() {
        if (size >= 1)
            return (T) head.data;
        else
            throw new RuntimeException("Stack is empty");
    }
    
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
```
```java
public static void main(String[] args) {
    StackLinkedList stack = new StackLinkedList();
}
```

### Push an element in a Stack

    Inserts (Push) an element onto the stack peek (Head of LinkedList).

```java
public void push(T i) {
    Node tempNode = new Node(i);
    if (size == 0) {
        head = tail = tempNode;
    } else {
        tempNode.next = head;
        head = tempNode;
    }
    size++;
}
```
### Pop an element from a Stack 
 	Remove the peek element (from Head of the LinkedList).

```java
public T pop() {
    if (size >= 0) {
        if (size == 1) {
            Node temp = head;
            tail = head = null;
            size--;
            return (T) temp.data;
        } else {
            Node temp;
            temp = head;
            head = head.next;
            size--;
            return (T) temp.data;
        }
    } else {
        throw new RuntimeException("Stack is empty");
    }
}
```
### Empty Stack
    It returns "true" if nothing is on the top of the stack

```java
 // check if stack is empty
public boolean empty() {
    if(size >= 1)
        return false;
    else 
        return true;
}
```
---
[HOME](https://github.com/Piyushresonit/DataStructureAndAlgorithm/blob/master/README.md)