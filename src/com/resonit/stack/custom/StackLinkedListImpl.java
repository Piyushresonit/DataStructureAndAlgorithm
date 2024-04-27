package com.resonit.stack.custom;

public class StackLinkedListImpl {

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

        public boolean empty() {
            boolean result;
            if (size >= 1) {
                result = false;
            } else {
                result = true;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();

        System.out.println("Is stack Empty:" + stack.empty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Is stack Empty:" + stack.empty());
        System.out.println("Peek Element:" + stack.peek());
        stack.display();
        System.out.println("Poped Element:" + stack.pop());
        System.out.println("Peek Element:" + stack.peek());
        stack.display();

    }

}
