package com.resonit.linkedlist.custom;


public class LinkedListImpl {

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

    // 2. Create Linked list
    static class CustomLinkedList<T extends Comparable<T>> {
        Node head;  // head of list
        Node tail;  // tail of list
        int size;

        public void addFirst(T data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            if (size == 0) {
                tail = newNode;
            }
            size++;
        }

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

        /* Removes a first node */
        public void removeFirst() {
            if (size > 0) {
                if (size == 1) {
                    head = null;
                    tail = null;
                } else {
                    head = head.next;
                }
                size--;
            } else {
                throw new IllegalArgumentException("LinkedList is empty");
            }
        }

        /* Removes a Last node */
        public void removeLast() {
            if (size > 0) {
                if (size == 1) {
                    head = null;
                    tail = null;
                } else {
                    Node temp = head;
                    for (int i = 0; i < size - 2; i++) {
                        temp = temp.next;
                    }
                    temp.next = null;
                    tail = temp;
                }
                size--;
            } else {
                throw new IllegalArgumentException("LinkedList is empty");
            }
        }

        /* Removes a node at index given */
        public void removeAt(int index) {
            if (index >= 0 || index < size) {
                if (index == 0) {
                    removeFirst();
                }
                if (index == size - 1) {
                    removeLast();
                } else {
                    Node temp = head;
                    for (int i = 0; i < index - 1; i++) {
                        temp = temp.next;
                    }
                    temp.next = temp.next.next;
                    size--;
                }
            } else {
                throw new IllegalArgumentException("invalid argument or list is empty");
            }
        }

        public T getFirst() {
            if (size > 0) {
                return (T) head.data;
            } else {
                throw new IllegalArgumentException("LinkedList is empty");
            }
        }

        public T getLast() {
            if (size > 0) {
                return (T) tail.data;
            } else {
                throw new IllegalArgumentException("LinkedList is empty");
            }
        }

        public int getAt(int index) {
            if (index > 0 && index <= size) {
                Node node = head;
                for (int i = 0; i < index; i++) {
                    node = node.next;
                }
                return (int) node.data;
            } else {
                System.out.println("invalid Index or list is empty");
                return -1;
            }
        }

        private Node getNodeAt(int index) {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }

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

        public void reverseListPointerIterative() {
            Node prev = null;
            Node curr = head;

            while (curr != null) {
                Node temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            Node t = head;
            head = tail;
            tail = t;
        }

        /* This function prints contents of linked list starting from the given node */
        public void displayList() {
            Node node = head;
            while (node != null) {
                System.out.print(node.data + " --> ");
                node = node.next;
            }
            System.out.print("null\n");
        }

        public int getSize() {
            return size;
        }
    }

    /* Driver program */
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.addLast(6);
        list.addFirst("Piyush");
        list.addFirst(5);
        list.addAt(2, 7);
        // list.reverseListDataIterative();
        // list.reverseListPointerIterative();
        System.out.println("Created Linked list is: ");
        list.displayList();
        System.out.println("Total size of Linked list: " + list.getSize());

        list.removeAt(1);
        System.out.println("Created Linked list is: ");
        list.displayList();
        System.out.println("Total size of Linked list: " + list.getSize());
    }
}