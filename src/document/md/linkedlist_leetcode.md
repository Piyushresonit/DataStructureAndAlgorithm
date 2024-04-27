# LinkedList    

### Reverse a LinkedList Data Iterative
      Reverse a linked list using left and right variable by swaping the node data.
```java
public void reverseListDataIterative() {
     
    int left = 0;
    int right = size - 1;

    while (left < right) {
        Node leftNode = getNodeAt(left);
        Node rightNode = getNodeAt(right);

        T temp = (T) rightNode.data;
        rightNode.data = leftNode.data;
        leftNode.data = temp;

        left++;
        right--;
    }
}
```
### Reverse a LinkedList Pointer Iterative
 	Inserts a new node at the end.
```java
public void reverseListPointerIterative() {
    Node prev = null;
    Node curr = head;

    while (curr != null) {
        // Store the next node temporarily
        Node temp = curr.next;
        // Reverse the pointer of current node to point to the previous node
        curr.next = prev;
        // Move prev and curr pointers one step forward
        prev = curr;
        curr = temp;
    }
    // After the loop, prev will be pointing to the last node of the original list
    // So, it becomes the new head
    tail = head; // Now the former tail becomes the new head
    head = prev; // The last node (prev) becomes the new tail
}
```

---
[HOME](https://github.com/Piyushresonit/DataStructureAndAlgorithm/blob/master/README.md)