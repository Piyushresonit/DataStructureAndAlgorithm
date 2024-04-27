package com.resonit.stack.custom;

class CustomStack {
    private static final int initialCapacity = 5;
    private static int capacity = initialCapacity;
    private Object[] arrStack;    // Array to hold the stack elements
    private int peek;                // Index of the top element in the stack

    public CustomStack() {
        this.arrStack = new Object[initialCapacity];
        this.peek = -1;              // Stack is initially empty
    }

    public int size() {
        return arrStack.length;
    }

    // Push an element onto the stack
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

    // Resize the stack based on new Capacity
    private void resizeStack(int newCapacity) {
        Object[] tempArr = new Object[newCapacity];
        for (int i = 0; i < peek; i++) {
            tempArr[i] = arrStack[i];
        }
        arrStack = tempArr;
        capacity = newCapacity;
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

    // Remove the peek element
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

    // check if stack is empty
    public boolean empty() {
        return peek < 0;
    }


    public int search(Object element) {
        int distance = -1;
        for (int i = 0; i <= peek; i++) {
            if(arrStack[i].equals(element))
                return distance = peek - i;
        }
        return distance;
    }
}

public class StackArrayImpl {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        System.out.println(stack.empty());
        System.out.println(stack.size());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println(stack.empty());
        System.out.println(stack.size());
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);
        System.out.println(stack.size());
        stack.push(100);
        stack.push(110);
        stack.push(120);
        System.out.println("Search: "+stack.search(150));
        System.out.println(stack.size());
        stack.peek();
        stack.display();
        System.out.println("\nPoped element: " + stack.pop());
        stack.display();
        System.out.println();
        stack.peek();
        System.out.println(stack.size());
        System.out.println("\nPoped element: " + stack.pop());
        stack.display();
        System.out.println();
        stack.peek();
        System.out.println(stack.size());
        System.out.println("\nPoped element: " + stack.pop());
        stack.display();
        System.out.println();
        stack.peek();
        System.out.println(stack.size());
        System.out.println("\nPoped element: " + stack.pop());
        stack.display();
        System.out.println();
        stack.peek();
        System.out.println(stack.size());
        System.out.println("\nPoped element: " + stack.pop());
        stack.display();
        System.out.println();
        stack.peek();
        System.out.println(stack.size());
        System.out.println("\nPoped element: " + stack.pop());
        stack.display();
        System.out.println();
        stack.peek();
        System.out.println(stack.size());
        System.out.println("\nPoped element: " + stack.pop());
        stack.display();
        System.out.println();
        stack.peek();
        System.out.println(stack.size());
        System.out.println("\nPoped element: " + stack.pop());
        stack.display();
        System.out.println();
        stack.peek();
        System.out.println(stack.size());
        System.out.println("\nPoped element: " + stack.pop());
        stack.display();
        System.out.println();
        stack.peek();
        System.out.println(stack.size());
        System.out.println("\nPoped element: " + stack.pop());
        stack.display();
        System.out.println();
        stack.peek();
        System.out.println(stack.size());
        System.out.println("\nPoped element: " + stack.pop());
        stack.display();
        System.out.println();
        stack.peek();
        System.out.println(stack.size());
        System.out.println("\nPoped element: " + stack.pop());
        stack.display();
        System.out.println();
        stack.peek();
        System.out.println(stack.size());

    }
}

